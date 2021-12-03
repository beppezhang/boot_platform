package com.beppe.leetcode.binary;

import org.testng.annotations.Test;

public class Demo1 {

    @Test
    public void test1() {
        int[] arr = new int[]{1, 3, 4, 5,5,5, 7, 8, 12, 15};
        int target = 5;
        int i = leftBound(arr, target);
        System.out.println("目标索引：" + i);
    }

    // 二分查找  找到值
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 结束条件
        while (left <= right) {
            int mid = (left + right) / 2;
            // 找到目标值
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }


    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 结束条件
        while (left <= right) {
            int mid = (left + right) / 2;
            // 找到目标值  往左缩
            if (nums[mid] == target) {
                right=mid-1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if(left>=nums.length || nums[left]!=target){
            return -1;
        }
        return left;
    }
}
