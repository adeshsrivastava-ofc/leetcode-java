package com.adeshsrivastava.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3 - LongestSubstringWithoutRepeatingCharacters
 * <p>
 * Difficulty: Medium
 * Pattern: String, Hash Table, Sliding Window
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * <p>
 * Description:
 * Given a string s, find the length of the longest substring without duplicate characters.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols, and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static String solve(String s) {
        return String.valueOf(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;

        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // If a character is already seen inside the window
            if (lastSeen.containsKey(current) && lastSeen.get(current) >= left) {
                left = lastSeen.get(current) + 1;
            }

            // Update last seen index
            lastSeen.put(current, right);

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}











