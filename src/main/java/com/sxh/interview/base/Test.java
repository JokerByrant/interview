package com.sxh.interview.base;

/**
 * @author sxh
 * @date 2022/3/15
 */
public class Test {
    public void fun() {
        String a = "Hello ";
        String b = "World";
        // 编译器优化后：String c = new StringBuilder().append(a).append(b);
        String c = a + b;
        System.out.println(c);
    }

    public void fun1() {
        String a = "";
        // 循环中拼接字符，会导致创建多个StringBuilder对象
        for (int i = 0; i < 10; i++) {
            a += i;
        }
        System.out.println(a);
    }
}
