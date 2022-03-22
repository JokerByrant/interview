package com.sxh.interview.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 分治算法，利用递归求解
 * @author sxh
 * @date 2022/3/22
 */
public class _241_biao_da_shi_you_xian_ji {
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (ch) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.parseInt(expression));
        }
        return list;
    }

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        List<Integer> list = diffWaysToCompute(expression);
        System.out.println(list);
    }
}
