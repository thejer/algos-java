package javaSolutions.src.old.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    Map<Character, Integer> charToCount = new HashMap<>();

    for (int i = 0; i < pattern.length(); i++) {
      char letter = pattern.charAt(i);
      charToCount.put(letter, charToCount.getOrDefault(letter, 0) + 1);
      System.out.println(charToCount);
    }
    Map<Character, Integer> tempMap = new HashMap<>(charToCount);

    for (int j = 0; j < str.length(); j++) {
      char currentChar = str.charAt(j);
      if(tempMap.containsKey(currentChar)) {
        tempMap.put(currentChar, tempMap.get(currentChar) - 1);
        if (tempMap.get(currentChar) == 0) tempMap.remove(currentChar);
        if (tempMap.isEmpty()) return true;
      } else {
        tempMap.putAll(charToCount);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(findPermutation("bcdxabcdy", "bcdyabcdx"));
  }
}