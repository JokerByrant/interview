package com.sxh.interview.base;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * String、StringBuffer、StringBuilder的使用
 *
 * @author sxh
 * @date 2022/3/7
 */
public class _String {
    public static StringBuffer sbf = new StringBuffer();
    public static String name = "Peter";

    /**
     * String对象应用场景
     */
    @Test
    public void _string() throws InterruptedException {
        StringBuilder sb = new StringBuilder("I'm a Dog!");
        System.out.println(sb.append("My name is ").append(name));

        String str = "I'm a Dog!";
        System.out.println(str + "My name is " + name);
    }

    /**
     * StringBuffer对象应用场景
     */
    public void _stringBuffer() {
        // 全局变量的定义和操作，可能涉及线程安全的操作
        sbf.append("this is safety.");
        System.out.println(sbf);
    }

    /**
     * StringBuilder对象应用场景
     */
    @Test
    public void _stringBuilder() {
        // 局部变量的定义和操作，循环中操作字符串，不会存在线程安全问题
        List<String> list = new LinkedList<>();
        StringBuilder sbd = new StringBuilder(64);
        for (int i = 0; i < 100; i++) {
            list.add(sbd.append(i).toString());
            sbd.setLength(0);
        }
        System.out.println(list);
    }

    /**
     * StringBuffer 和 StringBuilder的区别
     */
    public void _diff_buffer_builder() {}

}
