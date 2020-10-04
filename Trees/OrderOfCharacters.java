package javaSolutions.Trees;

import java.util.HashSet;
import java.util.Set;


public class OrderOfCharacters
{
    // This function fidns and prints order
    // of characer from a sorted array of words.
    // alpha is number of possible alphabets
    // starting from 'a'. For simplicity, this
    // function is written in a way that only
    // first 'alpha' characters can be there
    // in words array. For example if alpha
    //  is 7, then words[] should contain words
    // having only 'a', 'b','c' 'd', 'e', 'f', 'g'
    private static void printOrder(String[] words)
    {
        StringBuilder wordsString = new StringBuilder();
        for (String word : words) {
            wordsString.append(word);
        }
        char[] chars = wordsString.toString().toLowerCase().toCharArray();
        Set<Character> letters = new HashSet<>();
        for (char c :
                chars) {
            letters.add(c);
        }
        // Create a graph with 'aplha' edges
        Graph graph = new Graph(letters.size());

        for (int i = 0; i < words.length - 1; i++)
        {
            // Take the current two words and find the first mismatching
            // character
            String word1 = words[i];
            String word2 = words[i+1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++)
            {
                // If we find a mismatching character, then add an edge
                // from character of word1 to that of word2
                if (word1.charAt(j) != word2.charAt(j))
                {
                    graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j)- 'a');
                    break;
                }
            }
        }

        // Print topological sort of the above created graph
        graph.topologicalSort();
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {

        String[] words = {"ccda", "ccb", "cb", "a", "ab", "d"};
        printOrder(words);
    }
}