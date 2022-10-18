package javaSolutions.Patterns.SlidingWindow;

import java.util.*;

class WordConcatenation {

  // "catcatfoxfoxcat",  { "cat", "fox" }

  public static List<Integer> findWordConcatenation(String str, String[] words) {
    Map<String, Integer> wordFrequencyMap = new HashMap<>();
    for (String word : words)
      wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1); // cat: 1, fox: 1

    List<Integer> resultIndices = new ArrayList<>();
    int wordsCount = words.length, wordLength = words[0].length(); // 2  3
//                                            6
    for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) { // i = 0
      Map<String, Integer> wordsSeen = new HashMap<>();
      for (int j = 0; j < wordsCount; j++) { // j = 1
        int nextWordIndex = i + j * wordLength; // 3
        // get the next word from the string
        String word = str.substring(nextWordIndex, nextWordIndex + wordLength); // sub(3, 3+3) = "cat"
        if (!wordFrequencyMap.containsKey(word)) // break if we don't need this word
          break;

        wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1); // add the word to the 'wordsSeen' map. cat: 1

        // no need to process further if the word has higher frequency than required 
        if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0))
          break;

        if (j + 1 == wordsCount) // store index if we have found all the words
          resultIndices.add(i);
      }
    }

    return resultIndices;
  }

  public static void main(String[] args) {
    List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
    System.out.println(result);
    result = WordConcatenation.findWordConcatenation("catcatfoxfoxcat", new String[] { "cat", "fox" });
    System.out.println(result);
  }
}
