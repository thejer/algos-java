package javaSolutions.src.old.Patterns.SlidingWindow;

import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {

    int start = 0, maximumLength = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int end = 0; end < arr.length; end++) {
      char endChar = arr[end];
      map.put(endChar, map.getOrDefault(endChar, 0) + 1);
      while (map.size() > 2) {
        char startChar = arr[start];
        map.put(startChar, map.get(startChar) - 1);
        if (map.get(startChar) == 0) map.remove(startChar);
        start ++;
      }
      maximumLength = Math.max(maximumLength, end - start + 1);
    }
    return maximumLength;
  }

  public static void main(String[] args) {
    System.out.println(findLength(new char[]{'a', 'b', 'c', 'a', 'c'}));
  }
}