package javaSolutions;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        char[] sChars = s.toCharArray();
        int max = 0;

        for (int i = 0; i < sChars.length; i++) {
            Set<Character> set = new HashSet<>();
            set.add(sChars[i]);
            int count = 1;
            for (int j = i+1; j < sChars.length; j++) {
                set.add(sChars[j]);
                count ++;
                if (set.size() != count) {
                    break;
                }
            }
            max = Math.max(set.size(), max);
        }
        return max;
    }

    public int lengthOfLongestSubstringOptimized(String s) {
        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left ++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
