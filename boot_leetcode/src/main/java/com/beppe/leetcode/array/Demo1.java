package com.beppe.leetcode.array;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    @Test
    public void test1() {
        //  数组 n-> m 之和
        int[] arr = {3, 6, 9, 10, 4, 5, 7, 8};
        int i = nsum1(arr, 2, 4);
        System.out.println("结果：" + i);
    }



    private int sumNum(int[] arr, int n, int m) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i >= n && i <= m) {
                sum += arr[i];
            }
        }
        return sum;
    }

    private int nsum1(int[] arr, int n, int m) {
        int[] newArr = new int[arr.length + 1];
        getPreSum(arr, newArr);
        int res = newArr[m + 1] - newArr[n];
        System.out.println("res:" + res);
        return res;
    }

    // 获取前缀之和
    private void getPreSum(int[] arr, int[] preArr) {
        preArr[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            preArr[i + 1] = preArr[i] + arr[i];
        }
    }

    @Test
    public void test3() {
//        int x1=1,y1=1,x2=2,y2=2;
//        int[][] preSum= {{1,2,6,8}, {3,4,5,6},{7,4,3,5}};
//        NumMatrix nM = new NumMatrix(preSum);
//        int[][] preSum1 = nM.getPreSum();
//        int pre=preSum1[x2+1][y2+1]-preSum1[x1][y1+1]-preSum1[x1+1][y1]+preSum1[x1][y1];
//        System.out.println("pre:"+pre);
//        System.out.println("preSum:"+preSum);
        int[] arr = {1, 2, 5, 7, 9};
//        int sumk = findSumk(arr, 14);
//        System.out.println("sumk:"+sumk);
        int[][] aa = {{1, 2, 3}, {2, 3, 4}, {3, 4, -2}};
        for (int i = 0; i < aa.length; i++) {
            int[] ints = aa[i];
            arr = diffArr(arr, ints[0], ints[1], ints[2]);
        }

    }

    // 找到和为k 的子串
    private int findSumk(int[] arr, int k) {
        // 构建前缀数组
        int res = 0;
        int[] preArr = getPreArr(arr);
        // 遍历前缀数组 获取子串之和
        for (int i = 0; i < preArr.length; i++) {
            for (int j = i + 1; j < preArr.length; j++) {
                if ((k + preArr[i]) == preArr[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    private int[] getPreArr(int[] arr) {
        int length = arr.length;
        int[] preArr = new int[length + 1];
        // 遍历原数组每个元素
        for (int i = 0; i < length; i++) {
            preArr[i + 1] = preArr[i] + arr[i];
        }
        return preArr;
    }

    // 差分数组  数组 arr  [i,j]  全部加上 k
    private int[] diffArr(int[] arr, int i, int j, int k) {
        // 方式1  遍历数组  i-j  元素+k
//        for (int l = 0; l < arr.length; l++) {
//            if(i<=l && l<=j){
//                arr[l]+=k;
//            }
//        }

        // 方式二  构建差分数组
//        int[] diff=buildDiff(arr);
//        // 还原数组  i-j  元素加 K
//        diff[i]+=3;
//        if(j<arr.length-1){
//            diff[j+1]-=3;
//        }
//        // 还原数组
//        int[] ints = new int[arr.length];
//        ints[0]=diff[0];
//        for (int l = 1; l < diff.length; l++) {
//            ints[l] =ints[l-1]+diff[l];
//        }
        // 构建差分数组
        Difference difference = new Difference(arr);
        difference.addK(i, j, k);
        int[] arr1 = difference.getArr();
        return arr1;
    }

    private int[] buildDiff(int[] arr) {
        int[] diff = new int[arr.length];
        diff[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            diff[i] = arr[i] - arr[i - 1];
        }
        return diff;
    }

    @Test
    public void test2() {
        // 有序数组去重
        int[] arr = {1, 0, 0, 3, 3};
//        int reduction = getReduction(arr);
//        System.out.println("reduction:"+reduction);
        removeZero(arr);
    }

    // 有序数组去重
    private int getReduction(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            if (arr[slow] == arr[fast]) {
                fast++;
            } else {
                slow++;
                arr[slow] = arr[fast];
                fast++;
            }
        }
        return slow + 1;
    }

    private int removeElement(int[] arr, int k) {
        // 删除元素 [2,2,3,3]
        int slow = 0, fast = 0;
        while (fast < arr.length) {
            if (arr[fast] != k) {
                // 值不等
                arr[slow] = arr[fast];
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        return slow;
    }

    private void removeZero(int[] arr) {
        // 将0 的元素删除  返回长度
        int index = removeElement(arr, 0);
        for (int i = index; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    @Test
    public void test4() {
        int[] arr = {1, 4, 6, 7, 9, 10, 11};
//        int i = binarySearch(arr, 4);
//        System.out.println("index:"+i);
//        int[][] res = numSum(arr,10);
//        System.out.println("int[][]:"+res);
        reverse(arr);
    }

    // 二分查找 [1,4,6,7,9,10]  4
    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;

    }

    // 两数之和  返回数组索引
    private int[][] numSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if ((arr[left] + arr[right]) == target) {
                return new int[left][right];
            } else if ((arr[left] + arr[right]) < target) {
                // 增大两数
                left++;
            } else if ((arr[left] + arr[right]) > target) {
                // 减小两数
                right--;
            }
        }
        return new int[-1][-1];
    }

    // 反转数组
    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }

    @Test
    public void test5(){
//        longestPalindrome("aabbaa");
    }

    // 判断是否回文串
    private boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if(chars[left]!=chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 最长回文串
    private String longestPalindrome(String str) {
        String res="";
        for (int i = 0; i < str.length(); i++) {
            // 以 i 为中心
            String str1 = getSubStr(str, i, i);
            String str2 = getSubStr(str,i,i+1);
            res = str1.length()>res.length()?str1:res;
            res =str2.length()>res.length()?str2:res;
        }
        return res;
    }

    // 获取以 l 和 r 为中心的最长子串
    private String getSubStr(String str,int l,int r){
        while (l>=0 && r< str.length() && str.charAt(l)==str.charAt(r)){
            l--;r++;
        }
        return str.substring(l+1,r);
    }

    @Test
    public void test6(){
        int[] arr={4};
        adjustArr(arr,2);
    }

    private void adjustArr(int[] arr,int amount){
        // 元素累计和
        int numSum=0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            // 累计和 >amount  取 amount
            numSum+=arr[i];
            if(numSum>=amount){
                // 调整索引为i的元素
                list.add(amount-(numSum-arr[i]));
                break;
            }
            list.add(arr[i]);
        }
    }




}
