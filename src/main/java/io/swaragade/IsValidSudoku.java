package io.swaragade;

// cmd + option + L : format code

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsValidSudoku {
    //https://leetcode.com/problems/valid-sudoku/

    public boolean isValidSudoku(char[][] board) {
        // initiate
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> sqr = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            col.put(i, new HashSet<Character>());
            row.put(i, new HashSet<Character>());
            sqr.put(i, new HashSet<Character>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                if (col.get(j).contains(board[i][j]) ||
                        row.get(i).contains(board[i][j]) ||
                        sqr.get(((i/3) * 3) + (j/3)).contains(board[i][j])) {
                    return false;
                }
                col.get(j).add(board[i][j]);
                row.get(i).add(board[i][j]);
                sqr.get(((i/3) * 3) + (j/3)).add(board[i][j]);
            }
        }
        return true;
    }
}
