package com.demo.gyw.java.base_data_type;
/**
* @Description:    Long 负数情况
* @Author:         gyw
* @CreateDate:     2019/11/6 15:12
* @Version:        1.0
*/
public class LongNegative {

    public static void main(String[] args) {
        Long negative = -1L;
        System.out.println(negative);
        if (negative > 0) {
            System.out.println(negative + ">0");
        }else{
            System.out.println(negative + "<0");
        }
    }
}
