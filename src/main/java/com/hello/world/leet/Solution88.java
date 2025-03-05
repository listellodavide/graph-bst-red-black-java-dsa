package com.hello.world.leet;

import java.util.Arrays;

public class Solution88 {

    public void mergeWrong(int[] nums1, int m, int[] nums2, int n) {
        int len = n + m;
        int k = len - 1;
        int maxp1 = m - 1;
        int maxp2 = n - 1;
        while(len > 0) {
            if(maxp1 > 0 && nums2[maxp2] > nums1[maxp1]) {
                nums1[k--] = nums2[maxp2];
                maxp2--;
            }
            else if(maxp1 > 0 && nums1[maxp1] > nums2[maxp2]) {
                swap(nums1, k, maxp1);
                k--;
                maxp1--;
            }
            len--;
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // Pointer for nums1 (actual elements)
        int j = n - 1;       // Pointer for nums2
        int k = m + n - 1;   // Pointer for placing elements in nums1

        while (j >= 0) { // Merge until nums2 is exhausted
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public void swap(int[] nums, int j, int k) {
        int tmp = nums[j];
        nums[j] = nums[k];
        nums[k] = tmp;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1,2,3,0,0,0 };
        int m = 3;
        int[] nums2 = { 2,5,6 };
        int n = 3;
        Solution88 s = new Solution88();
        s.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
