package com.hello.world.leet;

public class Solution36 {

    // Solution is O(N^2)
    public boolean isValidSudoku(char[][] board) {
        // check corner case, matrix should be 9x9, index start by 0
        if (board.length != 9) return false;
        if (board[0].length != 9) return false;

        // convert char to int
        int[][] arr = new int[10][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    arr[i][j] = 0;
                } else arr[i][j] = Character.getNumericValue(board[i][j]);
                // System.out.println("board:"+board[i][j]+" => arr: "+arr[i][j]);
            }
        }

        // each row must contain the digits 1-9 without repetition
        // each column must contain the digits 1-9 without repetition
        boolean firstCheck = checkRowsValid(arr);
        if(!firstCheck) return false;

        // System.out.println("firstCheck:"+firstCheck);
        boolean secondCheck = true;
        for (int j = 0; j < arr[0].length; j++) {
            secondCheck = checkColumnValid(arr, j);
            // System.out.println("checkColumn secondCheck:"+secondCheck);
            // printMatrix(arr);
            if (!secondCheck) {
                return false;
            }
        }

        // check 3x3 squares
        boolean thirdCheck = true;
        for (int k = 0; k < board.length; k += 3) {
            for (int p = 0; p < board[0].length; p += 3) {
                thirdCheck = subMatrixValid(arr, k, p);
                // System.out.println("subMatrix k:"+k+" p:"+p+" thirdCheck:"+thirdCheck);
                // printMatrix(arr);
                if (!thirdCheck) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRowsValid(int[][] arr) {
        // each row must contain the digits 1-9 without repetition
        for (int i = 0; i < arr.length; i++) {
            boolean checkRow = checkRowValid(arr, i);
            if(!checkRow) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRowValid(int[][] arr, int row) {
        int[] rows = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int value = arr[row][i];
            rows[value]++;
        }
        for (int k = 1; k < 10; k++) {
            if (rows[k] != 1 && rows[k] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumnValid(int[][] arr, int col) {
        int[] columns = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i][col];
            columns[value]++;
        }
        for (int k = 1; k < 10; k++) {
            if (columns[k] != 1 && columns[k] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean subMatrixValid(int[][] arr, int offRow, int offColumn) {
        int[] square = new int[10];
        for (int i = offRow; i < offRow + 3; i++) {
            for (int j = offColumn; j < offColumn + 3; j++) {
                int value = arr[i][j];
                square[value]++;
            }
        }
        // printGuard(square);
        for (int k = 1; k < 10; k++) {
            if (square[k] != 1 && square[k] != 0) {
                //System.out.println("======>" + square[k]);
                return false;
            }
        }
        return true;
    }

    public void printMatrix(int[][] arr) {
        for(int i = 0; i < 9; i++) {
            System.out.print("[");
            for(int j = 0; j < 9; j++) {
                System.out.print("{"+arr[i][j]+"}");
            }
            System.out.println("],");
        }
    }

    public void printGuard(int[] guard) {
        System.out.print("[");
        for(int i = 0; i < 10; i++) {
            System.out.print("{"+guard[i]+"},");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        char[][] board1 =
               {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, // Should return TRUE !
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board2 =
               {{'8','3','.','.','7','.','.','.','.'}, // two 8 in the left 3x3 corner & two 8 first column ! Should return FALSE !
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};


        Solution36 s = new Solution36();

        System.out.println(s.isValidSudoku(board1));
        System.out.println(s.isValidSudoku(board2));

    }
}
