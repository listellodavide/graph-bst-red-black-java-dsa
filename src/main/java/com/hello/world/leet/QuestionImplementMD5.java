package com.hello.world.leet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class QuestionImplementMD5 {

    private static final char[] hexArray = "0123456789abcdef".toCharArray();

    public String generateHash(String name) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest digester = MessageDigest.getInstance("MD5");
        digester.update(name.getBytes());
        byte[] md5Bytes = digester.digest();
        String md5Text = null;

        md5Text = bytesToHex(md5Bytes);

        return md5Text;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String getMD5Checksum(File file) throws IOException, NoSuchAlgorithmException {
        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Use FileInputStream to read input file
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[8192];
            int bytesRead;

            // read block of file by block of file in chucks on buffer size and update digest
            while ((bytesRead = fis.read(buffer)) != -1) {
                md.update(buffer, 0, bytesRead);
            }
        }

        // Convert the final hash result in a HEX String
        byte[] md5Bytes = md.digest();
        StringBuilder sb = new StringBuilder();

        String md5Text = bytesToHex(md5Bytes);

        return md5Text;
    }

    public static void main(String[] args) {
        try {
            Path currentDirectoryPath = FileSystems.getDefault().getPath("");
            String absolutePathFileInput = currentDirectoryPath.toAbsolutePath().toString() + "/r2.bin";
            String checksum = getMD5Checksum(new File(absolutePathFileInput));
            System.out.println("Checksum MD5 (same as Unix md5sum): " + checksum);
        } catch (IOException | NoSuchAlgorithmException e) {
            System.err.println("Error while calculating the MD5 digest hash: " + e.getMessage());
        }
    }
}
