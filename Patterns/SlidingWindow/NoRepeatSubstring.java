package javaSolutions.Patterns.SlidingWindow;

import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0, right = 0, max = 0;

    while (right < str.length()) {
      if (map.containsKey(str.charAt(right))) {
        left = Math.max(map.get(str.charAt(right)) + 1, left);
      }
      map.put(str.charAt(right), right);
      max = Math.max(right - left + 1, max);
      right ++;
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(findLength("abbbb"));
  }
}