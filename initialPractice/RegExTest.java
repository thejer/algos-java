package javaSolutions.initialPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {

    public static void main(String[] args) {
        System.out.println(newList(new String[]{"a B 2 1 3", "e f 3 2 3"}));
    }

    public static String newList( String[] students ) {
        //Insert your code here
        String nameRegEx = "\\w+\\s{1}\\w+";
        Pattern numberPattern = Pattern.compile("(\\d+)");
        Pattern p = Pattern.compile(nameRegEx);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i <students.length; i++) {
            String s = students[i];
            Matcher numberMatcher = numberPattern.matcher(s);
            java.util.regex.Matcher m = p.matcher(s);
            int total = 0;
            int count = 0;
            int avg = 0;
            while (numberMatcher.find()) {
                int n = Integer.parseInt(numberMatcher.group(0));
                if (n <= 10) {
                    total += n;
                    count ++;
                }
                avg = total/count;
            }
            String name = "";
            if (m.find()) {
                name = m.group(0);
            }
            output.append(name).append("-").append(avg);
            if (i != students.length-1) output.append(";");
        }
        return output.toString();
    }

}
