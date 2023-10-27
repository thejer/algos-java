package javaSolutions.src.old.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

class CharacterReplacement {

  // aabccbb  k= 2
  public static int findLength(String str, int k) {

    int left = 0, maxLength = 0, maxRepeating = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
      char currentChar = str.charAt(i);
      map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
      maxRepeating = Math.max(maxRepeating, map.get(currentChar));

      if (i - left + 1 - maxRepeating > k) {
        char leftChar = str.charAt(left);
        map.put(leftChar, map.get(leftChar) - 1);
        left++;
      }
      maxLength = Math.max(maxLength, i - left + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(CharacterReplacement.findLength("aabccbb", 2));
    System.out.println(CharacterReplacement.findLength("abbcb", 1));
    System.out.println(CharacterReplacement.findLength("abccde", 1));
  }
}