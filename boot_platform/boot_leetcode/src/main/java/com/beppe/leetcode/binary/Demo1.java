package com.beppe.leetcode.binary;

import org.testng.annotations.Test;

public class Demo1 {

    @Test
    public void test1() {
        int[] arr = new int[]{1,3,3,3,5,5};
        int target = 3;
        int i = rightBound(arr, target);
        System.out.println("目标索引：" + i);
    }

    // 二分查找  找到目标值索引
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

    public int rightBound(int[] nums, int target) {  //1,3,3,3,5,5
        int left = 0;
        int right = nums.length - 1;
        // 结束条件
        while (left <= right) {
            int mid = (left + right) / 2;
            // 找到目标值  往右缩
            if (nums[mid] == target) {
                left=mid+1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if(right<0 || nums[right]!=target){
            return -1;
        }
        return right;
    }

    @Test
    public void test2(){
        int[] piles={3,6,7,11};
        minEatingSpeed(piles,8);
    }

    // 吃香蕉的最小速度  H 小时吃完
    private int minEatingSpeed(int[] piles,int H){
        int left=1;
        int right=100000;
        while (right>=left) {
            // 中间
            int mid=(left+right)/2;
            int f = f(piles, mid);
            //找到目标
            if(f==H){
                right=mid-1;
            }
            else if(f<H){
                right=mid-1;
            }
            else if (f>H){
                left=mid+1;
            }
        }
        return left;
    }

    // 速度为x 时 返回吃完的时间
    private int f(int[] piles,int x){
        int hours=0;
        for (int i = 0; i < piles.length; i++) {
            hours+=piles[i]/x;
            if(piles[i]%x>0){
                hours++;
            }
        }
        return hours;
    }

    @Test
    public void test3(){
        int[] arr={1,2,3,4,5};
        int i = f11(arr, 9);
    }

    private int shipInDays(int[] arr,int D){
        // 速度 最大 数组元素之和  最小 数组最大元素
        int right=0;
        int left=0;
        for (int i = 0; i < arr.length; i++) {
            right+=arr[i];
            left=Math.max(left,arr[i]);
        }
        // 二分查找
        while (right>=left){
            // mid 为速度
            int mid=(left+right)/2;
            // 速度是 mid 时需要的天数
            int f = f11(arr, mid);
            if(f==D){
                // 缩小范围
                right=mid-1;
            }
            else if(f<D){
                // 缩小范围
                right=mid-1;
            }
            else if(f>D){
                // 增加范围
                left=mid+1;
            }
        }
        return left;

    }

    // 运力为 x 返回的天数
    private int f11(int[] wights,int x){
        int days=0;
        int i=0;
        int cap=x;
        while (i<wights.length){
            if(cap>wights[i]){
                cap-=wights[i];
                i++;
                if(i==wights.length){
                    days++;
                }
            }else if(cap==wights[i]){
                cap=x;
                days++;
                i++;
            }else {
                cap=x;
                days++;
            }
        }
        return days;
    }
}
