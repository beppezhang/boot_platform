package com.beppe.test;

public class Demo2 {
    //数组


    public static void main(String[] args) {
        // 遍历   debug
//        int[] arr={1,4,2,6,8,10};
//        int length = arr.length;// length =6
//        for (int i = 0; i < length; i++) {  // i=4 的时候结束
//            int aa = arr[i];  // aa   arr[0]=1   arr[1]=4   arr[2]=2  arr[3]=6
//            System.out.println("aa的值："+aa);
//            System.out.println("i的值:"+i);
//        }

        //  把数组  平方放入到另外一个数组，求和   3：  1   平方   2  另外一个数组   3求和
        int[] arr={1,4,2,6,8,10};
        int[] arrNew=new int[arr.length];
        int length=arr.length;  // 数组的长度
        int cc=0;
        for (int i = 0; i < length; i++) {  // i=4 的时候结束
            int aa = arr[i];  // aa   arr[0]=1   arr[1]=4   arr[2]=2  arr[3]=6
            int bb =  aa*aa;            //平方 i=0 1   i=1  16  i=2  4   1+16=17  17+4=21  21+36=57
            cc=cc+bb;
            System.out.println("i的值:"+i);
            System.out.println("aa的值："+aa);
            System.out.println("平方的值："+bb);
            arrNew[i]=bb;   // {1,16,4,36,64,100}
            System.out.println("新数组：" +arrNew);
            System.out.println("cc的值：" +cc);


        }
    }
}
