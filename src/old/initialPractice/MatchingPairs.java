package javaSolutions.src.old.initialPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MatchingPairs {
    static int matchingPairs(String s, String t) {
        // Write your code here

        Map<Character, Character> map = new HashMap<>();
        if(Objects.equals(s, t)) return s.length()-2;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sChar != tChar) {
                map.put(sChar, tChar);
            } else {
                count++;
            }
        }

        for (char c: map.keySet()) {
            if (map.containsKey(map.get(c)))
                return count +2;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(matchingPairs("abcd", "abcd"));
    }
}
