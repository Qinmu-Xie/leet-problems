package com.qmx.leet.problems;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode l = l1;
        ListNode r = l2;
        ListNode current = res;
        int carry = 0;
        while (l != null || r != null) {
            int x = (l == null) ? 0 : l.val;
            int y = (r == null) ? 0 : r.val;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l = (l != null) ? l.next : null;
            r = (r != null) ? r.next : null;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return res.next;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0)
            return 0;
        int[] lengths = new int[chars.length];
        for (int i = 0, lastCharAt = 0; i < chars.length; i++) {
            int charAt = s.indexOf(chars[i], lastCharAt);
            if (i > charAt) {
                lastCharAt = charAt + 1;
            }
            for (int k = lastCharAt; k <= i; k++) {
                lengths[k] += 1;
            }
        }
        Arrays.sort(lengths);
        return lengths[chars.length - 1];
    }

}
