package com.sxh.interview.base;

import org.junit.Test;

/**
 * @author sxh
 * @date 2022/3/31
 */
public class _Integer {
    // valueOf()返回的是包装类型Integer
    // 若valueOf()传入的参数是String类型，会首先调用parseInt
    @Test
    public void valueOf() {
        Integer int1 = Integer.valueOf("200");
        Integer int2 = Integer.valueOf("200");
        // i不在-128~127之间，valueOf()会返回新的对象，因此下面返回false
        System.out.println(int1 == int2);

        Integer int3 = Integer.valueOf("100");
        Integer int4 = Integer.valueOf("100");
        // i在-128~127之间，valueOf()会直接拿缓存池中的对象，因此下面返回true
        System.out.println(int3 == int4);
    }

    // parseInt()返回的是基本类型int
    @Test
    public void parseInt() {
        int a = Integer.parseInt("200");
        int b = Integer.parseInt("200");
        // parseInt返回的是基本类型，因此不管i多大，返回的都是true
        System.out.println(a == b);
    }

    // 自动拆装箱
    @Test
    public void boxing() {
        // 下面的代码会自动装箱，等价于 Integer int5 = Integer.valueOf(500)
        Integer int5 = 500;
        Integer int6 = 500;
        // 返回false，i的范围超过了-128~127，会新建一个对象
        System.out.println(int5 == int6);

        // 下面的代码会自动拆箱，等价于 int int7 = int5.intValue()
        int int7 = int5;
        int int8 = int6;
        System.out.println(int7 == int8);
    }
}
