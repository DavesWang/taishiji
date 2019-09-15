package com.wangxcit.filesystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestString {
    @Test
    public void Testa(){
        String a = "wang.aaa";
        System.out.println(a.length());
        System.out.println(Arrays.toString(a.split("\\.")));
        System.out.println(a.lastIndexOf('.'));
        System.out.println(a.substring(0));

    }
}
