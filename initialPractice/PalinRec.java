package javaSolutions.initialPractice;

public class PalinRec {
    public static void main(String[] args) {
        System.out.println(recPalin("hannnah"));
    }

    static boolean recPalin(String string) {
        string = string.trim();
        if (string.length() <= 1) return true;
        if (string.charAt(0) != string.charAt(string.length() - 1)) {
            return false;
        }
        char[] sArray = string.toCharArray();
        sArray[0] = ' ';
        sArray[string.length() - 1] = ' ';
        string = String.valueOf(sArray);
        System.out.println(string);
        return recPalin(string);
    }
}
