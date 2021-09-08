package com.beppe.test;

import com.beppe.utils.IdUtil;
import com.beppe.utils.JDKVersion8HashOfLong;
import org.testng.annotations.Test;

import java.text.NumberFormat;

public class IdGenerateTest {

    @Test
    public void test1(){
        NumberFormat memberIdFormatter = NumberFormat.getNumberInstance();
        memberIdFormatter.setMinimumIntegerDigits(3);
        memberIdFormatter.setMaximumIntegerDigits(3);
        memberIdFormatter.setGroupingUsed(false);

        NumberFormat seqFormatter = NumberFormat.getNumberInstance();
        seqFormatter.setMinimumIntegerDigits(10);
        seqFormatter.setMaximumIntegerDigits(10);
        seqFormatter.setGroupingUsed(false);
        // memberid  customerId=105   获取最后三位
        String memberStr=memberIdFormatter.format(Math.abs(JDKVersion8HashOfLong.hashCodeV8(10089432)));
        System.out.println("memberStr:"+memberStr);
        long newseq=IdUtil.nextId("order"+Integer.valueOf(memberStr))%10000000000L;
        System.out.println("newseq:"+newseq);
        newseq = Math.abs(newseq);
        String seqPart=seqFormatter.format(newseq);
        String mixed = mixSeqPart(seqPart);
        System.out.println("seqPart:"+mixed);
        String idStr = String.format("120%s%s", memberStr, mixed);
        System.out.println("idStr:"+idStr);

    }

    private String mixSeqPart(String seqPart) {
        int len = seqPart.length();
        String lastFive = seqPart.substring(len - 5, len);
        String pre = seqPart.substring(0,len - 5);
        char []mix=new char[len];
        char[] lastFiveChars = lastFive.toCharArray();
        char[] preChars = pre.toCharArray();
        //3 7 6 2 9
        int []dateReservePos=new int[]{2,6,5,1,8};
        int datePos=0;
        for (int dateReservePo : dateReservePos) {
            mix[dateReservePo]=lastFiveChars[datePos++];
        }
        int seqPos=0;
        for (int i=0;i<mix.length;i++){
            boolean skip=false;
            for (int dateReservePo : dateReservePos) {
                if(i==dateReservePo) skip=true;
            }
            if (skip){
                continue;
            }
            mix[i]=preChars[seqPos++];
        }
        return String.valueOf(mix);
    }
}
