package javaSolutions.initialPractice;

public class RotationalCipher {

    static String rotationalCipher(String input, int rotationFactor) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int rot = (int) c - 48 + rotationFactor;
                rot = rot%10;
                result.append(rot);
            } else if (Character.isLetter(c)) {
                char a;
                if (Character.isUpperCase(c)) a = 'A';
                else a = 'a';
                char r = (char) (((c - a + rotationFactor) % 26) + a);
                result.append (r);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39));
    }
}
