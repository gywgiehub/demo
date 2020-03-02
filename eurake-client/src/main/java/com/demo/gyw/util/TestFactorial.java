package com.demo.gyw.util;
 
 class Factorial {
    //递归函数
    int fact(int n){
        if(n==1){
            return 1;
        }else{
            System.out.println(n);
            return fact(n-1)*n;
        }
    }
}
public class TestFactorial{
    public static void main(String[] args) {
        Factorial factorial= new Factorial();
        System.out.println("factorial(10)="+factorial.fact(10));
    }
}