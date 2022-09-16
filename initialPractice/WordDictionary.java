package javaSolutions.initialPractice;

import java.util.HashMap;
import java.util.Map;
//
//class WordDictionary {
//
//    Set<String> dict;
//
//    public WordDictionary() {
//        dict = new HashSet<>();
//    }
//
//    public static void main(String[] args) {
//        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//        System.out.println(wordDictionary.dict);
//        System.out.println(wordDictionary.search("p.."));
//    }
//
//    public void addWord(String word) {
//        dict.add(word);
//    }
//
//    public boolean search(String word) {
//        boolean found = false;
//        int wordSize = word.length();
//        Set<String> sameSizes = new HashSet<>();
//        for (String item : dict) if (item.length() == wordSize) sameSizes.add(item);
//        for (String item : sameSizes) {
//            for (int i = 0; i < wordSize; i++) {
//                if (word.charAt(i) == '.') {
//                    found = true;
//                } else if (word.charAt(i) == item.charAt(i)) {
//                    found = true;
//                } else {
//                    found = false;
//                    break;
//                }
//                if (i == wordSize - 1) return found;
//            }
//        }
//        return found;
//    }
//}

class WordDictionary {

    Trie root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }

    public void insert(String str) {
        Trie next = root;
        for(Character ch: str.toCharArray()) {
            next = next.children.computeIfAbsent(ch, x -> new Trie());
        }
        next.isWord = true;
    }

    public boolean search(Trie node, String str, int index) {
        if(str.length() == index)
            return node.isWord;
        char ch = str.charAt(index);
        if(ch == '.') {
            for(Character c : node.children.keySet()) {
                if(search(node.children.get(c), str, index+1)) {
                    return true;
                }
            }
        } else if(node.children.containsKey(ch)){
            return search(node.children.get(ch), str, index+1);
        }
        return false;
    }

    public void addWord(String word) {
        insert(word);
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    public class Trie {
        Map<Character, Trie> children = new HashMap<>();
        boolean isWord = false;
    }

        public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("p.."));
    }
}