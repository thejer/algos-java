package javaSolutions;

public class NumberToWords {
    public static String numberToWords(int num) {
        StringBuilder resultBuilder = new StringBuilder();
        if (num < 10){
            return numToStrOnes(num);
        }

        int rnum = num;
        int counter = 0;
        while (rnum >= 10) {
            counter ++;
            rnum = rnum/10;
        }

        System.out.println(counter);
        System.out.println(rnum);
        return resultBuilder.toString();
    }

    public static String numToStrOnes(int num) {
        switch (num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 0: return "Zero";
            default: return "";
        }
    }
    public static String numToStrTens(int num) {
        switch (num) {
            case 1: return "Ten";
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
            case 0: return "Zero";
            default: return "";
        }
    }

    public static void main(String[] args) {
        numberToWords(20000);
        System.out.println();
    }
}
