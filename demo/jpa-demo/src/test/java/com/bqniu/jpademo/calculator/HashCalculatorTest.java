package com.bqniu.jpademo.calculator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class HashCalculatorTest {

    @Test
    public void hashTest() {
//        ArrayList<String> obj = new ArrayList<String>(
//                Arrays.asList("db1:table1:key1", "db1:table1:abc", "db1:table1:def","db1:table1:ghi","db1:table1:jklmn","db1:table1:opq"));
//
//        obj.forEach(x-> System.out.println(HashCalculator.apHash(x)+"    "+HashCalculator.normalHash(x)));

//        int hash= HashCalculator.rotatingHash("i know you",7);

        for(int i=0;i<16461145;i++){
            for(int j=i+1;j<16461145;j++){
                if(i*j==707829217){
                    if(isPrime(i)&&isPrime(j)){
                        System.out.println(i+" "+j);
                    }
                }
            }
        }
    }

    public static boolean isPrime(int num) {
        //两个较小数另外处理
        if(num==2 || num==3) {
            return true;
        }

        //不在6的倍数两侧的一定不是素数
        if(num%6!=1 && num%6!=5) {
            return false;
        }

        int tmp = (int) Math.sqrt(num);//获取平方根
        //在6的倍数两侧的也可能不是素数
        for(int i=5; i<=tmp; i+=6) {
            if(num%i==0 || num%(i+2)==0) {
                return false;
            }
        }

        return true;
    }
}