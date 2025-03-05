package com.hello.world.leet;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class QuestionImplementBufferedFileWriter {

    void readWriteBuffered(String inputFilename, String outputFilename) throws IOException {
        byte[] readBuffer = new byte[8192];

        InputStream is = new FileInputStream(new File(inputFilename));

        OutputStream os = new FileOutputStream(new File(outputFilename));

        int numBytes = -1;
        while ((numBytes = is.read(readBuffer)) != -1) {
            os.write(readBuffer);
        }

        os.close();
        is.close();
    }


    public static void main(String[] args) throws IOException {

        Path currentDirectoryPath = FileSystems.getDefault().getPath("");
        String absolutePathFileInput = currentDirectoryPath.toAbsolutePath().toString() + "/r2.bin";
        String absolutePathFileOutput = currentDirectoryPath.toAbsolutePath().toString() + "/r4.bin";

        System.out.println(absolutePathFileInput);

        QuestionImplementBufferedFileWriter question = new QuestionImplementBufferedFileWriter();

        long startTime = System.currentTimeMillis();

        question.readWriteBuffered(absolutePathFileInput, absolutePathFileOutput);

        long durationInMillis = System.currentTimeMillis() - startTime;

        long millis = durationInMillis % 1000;
        long second = (durationInMillis / 1000) % 60;
        long minute = (durationInMillis / (1000 * 60)) % 60;
        long hour = (durationInMillis / (1000 * 60 * 60)) % 24;

        String time = String.format("%02dh:%02dm:%02ds.%d\"", hour, minute, second, millis);

        System.out.println("transfer the file took: " + time);
    }
}
