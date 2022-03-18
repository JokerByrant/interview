package com.sxh.interview.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sxh
 * @date 2022/3/15
 */
public class _Batch {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 999; i++) {
            list.add(i);
        }
        int i = 0;
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> subList = null;
        while (true) {
            subList = list.subList(i * 200, Math.min((i + 1) * 200, list.size()));
            listList.add(subList);
            if (list.size() <= (i + 1) * 200) {
                break;
            }
            i++;
        }

        System.out.println(listList);
    }
}
