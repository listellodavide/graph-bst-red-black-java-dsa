package com.hello.world.leet;

import java.util.Arrays;

public class Solution27 {

    public int removeElement(int[] nums, int val) {
        int count = 0;
        int[] nums2 = new int[nums.length];
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums2[j++] = val;
            }
            else count++;
        }
        nums = nums2;
        return nums.length - count;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,2,3};

        int find = 3;

        Solution27 s = new Solution27();

        System.out.println(s.removeElement(nums, find));

        System.out.println(Arrays.toString(nums));
    }
}
