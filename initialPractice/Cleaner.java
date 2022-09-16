package javaSolutions.initialPractice;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Cleaner {

    public static void main(String[] args) {
        String text = readSkillsFile();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        String[] skills = text.split(",");
        System.out.println(skills.length);
        System.out.println("=================================================");
        Set<String> skillsSet = new HashSet<>(Arrays.asList(skills));
        System.out.println(skillsSet.size());
        System.out.println("=================================================");
        writeToOutput(skillsSet);
    }

    private static String readSkillsFile() {
        String filepath = "/Users/compton/Downloads/skills.txt";
        StringBuilder textBuilder = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(filepath);
             Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                textBuilder.append(line);
                 System.out.println(line);
                System.out.println("=================================================");
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textBuilder.toString();
    }

    private static void writeToOutput(Set<String> skills) {
        String filepath = "/Users/compton/Downloads/skills_unique.csv";
        PrintWriter writer;
        try {
            writer = new PrintWriter(filepath, "UTF-8");
            int size = skills.size();
            String[] skillsArray = skills.toArray(new String[size]);
            for (int i = 0; i < size; i++) {
                String skill = skillsArray[i];
                writer.print(i+1 + ",");
                writer.print(skill);
                writer.println();
            }
            writer.close();
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
