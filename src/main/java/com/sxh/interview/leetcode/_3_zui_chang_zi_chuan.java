package com.sxh.interview.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sxh
 * @date 2022/3/17
 */
public class _3_zui_chang_zi_chuan {
    public static int lengthOfLongestSubstring(String s) {
        int mark = 0;
        int count = 0;
        // 未重复的字符起点，第n个字符
        int overflow = 0;
        Integer value = null;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            value = map.get(ch);
            if (value != null) {
                mark = Math.max(count - overflow, mark);
                // 重置未重复的字符起点：上一个重复字符位置 + 1
                overflow = Math.max(value + 1, overflow);
            }
            // key: 字符，value：字符所在位置
            map.put(ch, count++);
        }
        mark = Math.max(count - overflow, mark);
        return mark;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

}
