package com.sxh.interview.base;

import org.junit.Test;

import java.util.Arrays;

/**
 * 值传递证明
 * 注：Java中只有值传递
 * @author sxh
 * @date 2022/3/31
 * @link {https://javaguide.cn/java/basis/why-there-only-value-passing-in-java.html#%E6%A1%88%E4%BE%8B2-%E4%BC%A0%E9%80%92%E5%BC%95%E7%94%A8%E7%B1%BB%E5%9E%8B%E5%8F%82%E6%95%B01}
 */
public class _Value_Transfer {
    // 1.传递基本类型参数
    @Test
    public void fun() {
        int num = 10;
        valueTransfer(num);
        // num的值不会发生变化
        System.out.println("out of valueTransfer(): " + num);
    }
    // 方法中定义的num是形参，相当于传递过来的实参的副本，修改这个num对原实参并无影响
    private void valueTransfer(int num) {
        num = 100;
        System.out.println("in valueTransfer(): " + num);
    }

    // 2.传递引用类型参数1(修改引用参数的属性)
    @Test
    public void fun2() {
        int[] arr = {1,2,3,4,5};
        valueTransfer(arr);
        System.out.println("out of valueTransfer(): " + arr[0]);
    }
    // 这里仍然是值传递，arr接收的是原实参的地址
    private void valueTransfer(int[] arr) {
        arr[0] = 0;
        // 这里的修改会直接修改地址指向的堆中数据，因此原实参的属性也会一起变化
        System.out.println("in valueTransfer(): " + arr[0]);
    }

    // 3.传递引用类型参数2(修改引用参数的地址)
    @Test
    public void fun3() {
        String[] str = {"1", "2", "3"};
        valueTransfer(str);
        // 打印实参str的地址，虽然形参重新指向了新的地址，但是对实参并无影响
        System.out.println("out of valueTransfer(): " + str);
        Arrays.stream(str).forEach(System.out::println);
    }
    public void valueTransfer(String[] str) {
        // 这里直接将str指向了新的地址，那么这里的str已经与原实参毫无关系了。
        str = new String[]{"4", "5", "6"};
        // 打印形参str的地址
        System.out.println("in valueTransfer(): " + str);
        Arrays.stream(str).forEach(System.out::println);
    }
}
