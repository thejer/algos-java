package javaSolutions.Patterns.SlidingWindow;

import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {

    // "cbbebi" 3

    Map<Character, Integer> map = new HashMap<>();
    int start = 0, end = 0, maxLength = 0;

    while (true) {
      int size = map.size();  // 2
      char letter = str.charAt(end); // 1
      if (size > k) {
        char startChar = str.charAt(start); // c
        map.put(startChar, map.get(startChar) - 1); // (c,0) (b,2) (e,1)
        if (map.get(startChar) == 0) {
          map.remove(startChar); // (b,2) (e,1)
        }
        start ++; // 1
        maxLength = Math.max(maxLength, end - start); // 3
      } else {
        map.put(letter, map.getOrDefault(letter, 0) + 1); // (b,3) (e,1) (i,1)
        end ++; // 6
        if (end == str.length()) return Math.max(maxLength, end - start - 1); // f
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(findLength("cbbebi", 2));
  }
}