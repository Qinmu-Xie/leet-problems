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
    public void findMedianSortedArrays() {
        int[] num1 = {1, 3};
        int[] num2 = {2};
        int[] num3 = {1, 2};
        int[] num4 = {3, 4};
        int[] num5 = {3};
        int[] num6 = {-2, -1};
        assertEquals(2.0, solution.findMedianSortedArrays(num1, num2), 0.00005);
        assertEquals(2.5, solution.findMedianSortedArrays(num3, num4), 0.00005);
        assertEquals(-1.0, solution.findMedianSortedArrays(num5, num6), 0.00005);
    }

    @Test
    public void longestPalindrome() {
        assertEquals("sfeefs", solution.expandByCenter1("dsfeefsfss", 3, 4));
        assertEquals(6, solution.expandByCenter("dsfeefsfss", 3, 4));
        assertEquals("sfeefs", solution.expandByCenter1("dsfeefsfss", 3, 4));
        assertEquals(6, solution.expandByCenter("dsfeefsfss", 3, 4));
        assertEquals("d", solution.expandByCenter1("dssdfeefdssfss", 3, 3));
//        assertEquals("bab", solution.longestPalindrome("babad"));
        assertEquals("bb", solution.longestPalindrome("cbbd"));
        assertEquals("b", solution.longestPalindrome("b"));
        assertEquals("ranynar", solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    @Test
    public void convert() {
        assertEquals("PAHNAPLSIIGYIR",solution.convert("PAYPALISHIRING",3));
        assertEquals("PINALSIGYAHRPI",solution.convert("PAYPALISHIRING",4));
    }
}