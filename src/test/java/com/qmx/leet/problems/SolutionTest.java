package com.qmx.leet.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        assertArrayEquals(solution.twoSum(nums, target), expected);
    }

    @Test
    public void addTwoNumbers() {
        ListNode node1 = new ListNode(2).setNext(new ListNode(4).setNext(new ListNode(3)));
        ListNode node2 = new ListNode(5).setNext(new ListNode(6).setNext(new ListNode(4)));
        ListNode nodeExpected = new ListNode(7).setNext(new ListNode(0).setNext(new ListNode(8)));
        assertEquals(nodeExpected, solution.addTwoNumbers(node1, node2));
    }

    @Test
    public void lengthOfLongestSubstring() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));

    }

    @Test
    public void test() {
        System.out.println("abcde".indexOf('c',2));
    }
}