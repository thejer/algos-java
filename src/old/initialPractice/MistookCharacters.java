package javaSolutions.src.old.initialPractice;

import java.util.Scanner;

public class MistookCharacters {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Initial text: ");
        String initialText = scanner.nextLine();
        System.out.println("Final text: ");
        String finalText = scanner.nextLine();
        System.out.println(getMistookCharacters(initialText.toLowerCase(), finalText.toLowerCase()));
    }

    public static int getMistookCharacters(String initialText, String finalText) {
        if (initialText.isBlank() && finalText.isBlank()) return 0;
        int initialTextLength = initialText.length();
        int finalTextLength = finalText.length();
        int messageSize = Math.min(initialTextLength, finalTextLength);
        int mistookCharacters = 0;
        for (int i = 0; i < messageSize; i++) {
            if (initialText.toCharArray()[i] != finalText.toCharArray()[i])
                mistookCharacters++;
        }
        mistookCharacters += Math.abs(initialTextLength - finalTextLength);
        return mistookCharacters;
    }
}
