package javaSolutions;

public class BinaryGap {

    private static int solution(int N) {
        int max_val = Integer.MIN_VALUE;
        String binNumber = numberToBin(N);
        int value = 0;
        char[] bins = binNumber.toCharArray();
        for (char c : bins) {
            if (c == '0') value+=1;
            else if (c == '1' && value > max_val){
                max_val = value;
                value = 0;
            } else {
                value = 0;
            }
        }
        return max_val;
    }

    private static String numberToBin(int N) {
        if (N == 0) return "O";
        StringBuilder bin = new StringBuilder();
        while (N > 0) {
            String digit = ((N & 1) == 1) ? "1" : "0";
            bin.insert(0, digit);
            N = Math.floorDiv(N, 2);
        }
        return bin.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(6291457));
    }
}
