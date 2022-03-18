package com.sxh.interview.leetcode;

/**
 * @author sxh
 * @date 2022/3/16
 */
public class _2_liang_shu_xiang_jia {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode(0);
        ListNode curNode = preNode;
        int tenDigit = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = x + y + tenDigit;
            tenDigit = sum / 10;
            sum = sum % 10;
            curNode.next = new ListNode(sum);
            curNode = curNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (tenDigit > 0) {
            curNode.next = new ListNode(tenDigit);
        }
        return preNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
