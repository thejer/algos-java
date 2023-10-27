package javaSolutions.src.old.initialPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        Map<Character, Integer> s1Map = new HashMap<>();
        for (int i = 0; i < s1Length; i++) {
            char c = s1.charAt(i);
            s1Map.put(c, s1Map.getOrDefault(c,0) + 1);
        }

        Map<Character, Integer> temp = new HashMap<>(s1Map);

        for (int i = 0; i <= s2.length() - s1Length; i++) {
            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                int count = temp.getOrDefault(c, 0);
                if (count == 0) {
                    temp = new HashMap<>(s1Map);
                    break;
                }
                else if (count > 0) {
                    temp.put(c, count-1);
                    if (j == (i+s1Length-1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkInclusionOptimizes(String s1, String s2) {
        int n1=s1.length(),n2=s2.length();
        int[] a=new int[26];
        for(int i=0;i<n1;i++){
            a[(int)s1.charAt(i)-97]++;
        }
        System.out.println("s1 Array:"+Arrays.toString(a));
        int[] b=new int[26];
        int j=0,i=0;
        for(;j<n1;j++){
            b[(int)s2.charAt(j)-97]++;
        }
        System.out.println("s2 Array in steps:");
        System.out.println(Arrays.toString(b));
        if(Arrays.equals(a,b)) return true;
        for(;j<n2;j++){
            b[(int)s2.charAt(i++)-97]--;
            b[(int)s2.charAt(j)-97]++;
            System.out.println(Arrays.toString(b));
            if(Arrays.equals(a,b)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusionOptimizes("hello", "ooolleoooleh"));
    }
}
