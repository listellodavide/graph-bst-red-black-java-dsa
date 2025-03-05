package com.hello.world.leet;

public class Solution42 {

    private static final int MAX_DEEP = 40;

    public int trapWrong(int[] height) {
        int w = 0;
        int inc = 0;
        for(int d = 1; d < height.length-1; d++) {
            while( d - inc > 0 && d + inc < height.length) {
                int left = height[d - 1 - inc];
                int right = height[d + 1 + inc];
                int min = Math.min(left, right);
                int width = min * (d+1) - (d-1) - 1; // should always be 1 for this initial version

                w += width;

                inc++;
            }
        }
        return w;
    }

    public void printMatrix(boolean[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]?0+",":1+",");
            }
            System.out.println("]");
        }

    }

    public int trap(int[] height) {
        boolean[][] matrix = trapMatrix(height);

        int totalWater = 0;
        for(int i = 0; i < MAX_DEEP; i++) {
            totalWater += calcSlices(matrix, i);
        }

        return totalWater;
    }

    public int calcSlices(boolean[][]matrix, int col) {
        int countWater = 0;
        for(int i = 1; i < matrix.length-1; i++) {
            //System.out.println(matrix[i][col]);
            System.out.print(matrix[i][col]?0+",":1+",");
            if(matrix[i-1][col] == false && matrix[i+1][col] == false) {
                System.out.println("POS["+i+":"+col+"]");
                countWater++;
            }
        }
        return countWater;
    }

    public boolean[][] trapMatrix(int[] height) {

        boolean[][] matrix = new boolean[height.length][MAX_DEEP];

        for(int i = 0; i < height.length; i++) {
            for(int j = 0; j < MAX_DEEP; j++) {
                if(height[i] <= j) {
                    matrix[i][j] = true;
                }
            }
        }
        // check if it looks good
        printMatrix(matrix);

        return matrix;
    }

    public int drill(int[] vec, int p, int d, int w) {
        int fW = 0;
        while( p - d >= 0 && p + d < vec.length) {
            int min = Math.min(vec[p - d], vec[p + d]);

            int cW = min * ( (p+d) - (p-d) - 1);


            /*
            int remove = 0;
            for(int j = p-d+1; j <= p+d-1; j++) {
                remove += vec[j];
            }
             */

            //cW = cW - remove;

            fW += cW + drill (vec, p, ++d, cW);
        }
        return fW;
    }

    public static void main(String[] args) {

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        Solution42 s = new Solution42();

        // System.out.println(s.trap(height));
        System.out.println(s.trap(height));
    }
}
