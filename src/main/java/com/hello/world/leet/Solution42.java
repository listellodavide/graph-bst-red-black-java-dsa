package com.hello.world.leet;

public class Solution42 {

    public int trap(int[] height) {
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

        System.out.println(s.trap(height));

    }
}
