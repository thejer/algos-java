package javaSolutions.initialPractice;

class MyAtoi {
    public int myAtoi(String s) {
        int index = 0;
        int result = 0;
        int sign = 1;
        s = s.trim();
        int n = s.length();
        if (n == 0) return 0;

        if (s.charAt(index) == '-'){
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            if ((result > Integer.MAX_VALUE/10) 
                || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = 10 * result + digit;
            
            index++;
        }
        
        return result * sign;
    }
}