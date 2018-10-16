package com.osikov.stas.unittests;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.osikov.stas.unittests.ShortStringMatcher.isShortString;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MainActivityTest {

    @Test
    public void onCreate() {
        String s1 = new String("123");
        String s2 = new String("123");
//        assertSame(s1, s2);
        assertNotSame(s1, s2);
    }

    @Test
    public void onCreateTest() {
        List<String> list = Arrays.asList("one", "two", "three", "four", "five");
        assertThat(list, hasItems("two", "one", "two"));
    }

    @Test
    public void onCreateTestStas() {
        String s = "1234";
        assertThat(s, both(startsWith("1")).and(endsWith("4")));
    }

    @Test
    public void firstCustomTest(){
        String s = "1234";
        assertThat(s, isShortString(5));
    }
}