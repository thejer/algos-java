package javaSolutions.src.old.trie;

import kotlin.Pair;
import java.util.*;

class WordSearchI {
    public static boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        Set<Pair<Integer, Integer>> path = new HashSet<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (dfs(i, j, 0, board, path, word.toCharArray())){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int r, int c, int i, char[][] board, Set<Pair<Integer, Integer>> path, char[] word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        if (i == word.length) return false;
        Pair<Integer, Integer> pair = new Pair<>(r, c);
        if (c < 0 || r < 0 || r >= ROWS || c >= COLS || word[i] != board[r][c] || path.contains(pair)) {
            return false;
        }

        path.add(pair);
        boolean result = (
                dfs(r + 1, c, i + 1, board, path, word) ||
                dfs(r - 1, c, i + 1, board, path, word) ||
                dfs(r, c + 1, i + 1, board, path, word) ||
                dfs(r, c - 1, i + 1, board, path, word));
        path.remove(pair);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
    }
}