package com.qmx.leet.problems;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

class Memoizer<T, U> {

    private final Map<T, U> cache = new ConcurrentHashMap<>();

    private Memoizer() {
    }

    private Function<T, U> doMemoize(final Function<T, U> function) {
        return input -> cache.computeIfAbsent(input, function::apply);
    }

    public static <T, U> Function<T, U> memoize(final Function<T, U> function) {
        return new Memoizer<T, U>().doMemoize(function);
    }
}

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

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
            System.out.println("i: " + i + " j: " + j + " j-i: " + (j - i));
            set.forEach(System.out::println);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int[] takes = new int[(total / 2) + 1];
        for (int i = 0, j = 0, cnt = 0; cnt < takes.length; cnt++) {
            if (i >= nums1.length) {
                takes[cnt] = nums2[j++];
            } else if (j >= nums2.length) {
                takes[cnt] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                takes[cnt] = nums1[i++];
            } else {
                takes[cnt] = nums2[j++];
            }
        }
        if (total % 2 == 0) {
            return (takes[takes.length - 1] + takes[takes.length - 2]) / 2.0;
        } else {
            return takes[takes.length - 1];
        }
    }

    public String longestPalindromeLongTime(String s) {
        if (Objects.isNull(s) || "".equals(s) || s.length() == 1) {
            return s;
        }
        String res = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; i < j + 1; j--) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

//    Function<String, Boolean> IsPalindromeCached = Memoizer.memoize(this::isPalindrome);

    public String longestPalindrome2(String s) {
        int windowLength = s.length();
        while (windowLength > 0) {
            for (int i = 0; i < s.length() - windowLength + 1; i++) {
                if (isPalindrome(s, i, i + windowLength - 1)) {
                    return s.substring(i, i + windowLength);
                }
            }
            windowLength--;
        }
        return "";
    }

    Boolean isPalindrome(String s, int i, int j) {
        if (i == j) {
            return true;
        }
        if (j == i + 1) {
            return s.charAt(i) == s.charAt(j);
        }
        return s.charAt(i) == s.charAt(j)
                && isPalindrome(s, i + 1, j - 1);
    }

    public String expandByCenter1(String s, int i, int j) {
        int n = s.length();
        while (i >= 0 && j <= n - 1 && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expandByCenter(s, i, i);
            int len2 = expandByCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);
    }


    public int expandByCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int j = 0, mod = 0;
            while (j + i < s.length()) {
                int step = (mod % 2 == 0) ? 2 * (numRows - i - 1) : 2 * i;
                if (step != 0) {
                    sb.append(s.charAt(i + j));
                    j += step;
                }
                mod++;
            }
        }
        return sb.toString();
    }

    public int reverse(int x) {
        int ans = 0;
        String numberPart = (x >= 0) ? String.valueOf(x) : String.valueOf(x).substring(1);
        String numberPartStr = new StringBuilder(numberPart).reverse().toString();
        try {
            ans = x >= 0 ? Integer.valueOf(numberPartStr) : Integer.valueOf("-" + numberPartStr);
        } catch (NumberFormatException e) {

        }
        return ans;
    }

    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        int reversed = 0;
        try {
            reversed = Integer.valueOf(
                    new StringBuilder(String.valueOf(x)).reverse().toString());
        } catch (NumberFormatException e) {

        }
        return x == reversed;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }

    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }

    public int maxArea2(int[] height) {

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public int maxArea(int[] height) {
        int maxArea = 0, start = 0, end = height.length - 1;
        while (start < end) {
            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }

    public String longestCommonPrefixUgly(String[] strs) {

        String shortest = Arrays.stream(strs)
                .sorted(Comparator.comparingInt(String::length))
                .findFirst().orElse("");

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < shortest.length(); i++) {
            int tempi = i;
            if (Arrays.stream(strs).allMatch(s -> shortest.charAt(tempi) == s.charAt(tempi))) {
                prefix.append(shortest.charAt(i));
            } else {
                break;
            }
        }
        return prefix.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) return "";
            }
        }
        return prefix;
    }
}
