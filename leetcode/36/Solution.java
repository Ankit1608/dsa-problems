// https://leetcode.com/problems/valid-sudoku/description/

import java.util.HashSet;
import java.util.Set;

public interface Solution {
    public boolean isValidSudoku(char[][] board) {
            Set<String> boardSet = new HashSet<>();
            
            for(int i =0; i<board.length; i++){
                for(int j =0; j<board[0].length; j++){
                    if(board[i][j]!='.')
                        if(
                            !boardSet.add(board[i][j]+" Number in"+ i +" row") ||
                            !boardSet.add(board[i][j]+" Number in"+ j +" column") ||
                            !boardSet.add(board[i][j]+" Number in"+ i/3+j/3 +" row")
                            ){
                            return false;
                        }
                }
            }
            return true;
       }
}

// Explanation
// 1. hashSets for each row
// 2. hasSets for each column

//3. hashSets for each 3x3 square . and we generate key using integer division. 

// also we can use a single HashSet since all the keys for above 3 cases are unique!!