//Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

// Players take turns placing characters into empty squares ' '.
// The first player A always places 'X' characters, while the second player B always places 'O' characters.
// 'X' and 'O' characters are always placed into empty squares, never on filled ones.
// The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
// The game also ends if all squares are non-empty.
// No more moves can be played if the game is over.
// Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

// You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.

 

// Example 1:


// Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
// Output: "A"
// Explanation: A wins, they always play first.



// Solution 1

class Solution {
    
    private int[][] board;
    private int n = 3;
    public String tictactoe(int[][] moves) {
        board = new int[n][n];
        int player = 1;
       for(int[] move: moves){
           int row = move[0];
           int col = move[1];
           board[row][col] = player;
           
           if(checkRow(row,player) || checkCol(col,player) || 
             (row==col && checkDia(player)) ||
             (row+col == n-1 && checkAnti(player))){
             
              return player == 1 ? "A" : "B";
           }
           player *= -1;
           
       }
        return moves.length == n*n ? "Draw":"Pending";
    } 
   
    private boolean checkRow(int row, int player){
        for(int col = 0; col<3; col++){
          if(board[row][col] != player) return false;
        }
        return true;
    }
    
    private boolean checkCol(int col, int player){
        for(int row = 0; row<3; row++){
          if(board[row][col] != player) return false;
        }
        return true;
    }
    
    private boolean checkDia(int player){
        for(int row = 0; row<3; row++){
          if(board[row][row] != player) return false;
        }
        return true;
    }
    
    private boolean checkAnti(int player){
        for(int row = 0; row<3; row++){
          if(board[row][n-1-row] != player) return false;
        }
        return true;
    }
    
    
    
    
}




//Solution2


class Solution2 {
    
    private int n = 3;
    
    public String tictactoe(int[][] moves) {
       
        
        int[] rows = new int[n];
        int[] cols = new int[n];
        
        int dia = 0;
        int anti = 0;
        int player = 1;
        
        
        for(int[] move: moves){
            int row = move[0];
            int col = move[1];
        
            rows[row] += player;
            cols[col] += player;
            
            if(row==col){
                dia += player;
            }
            if(row+col == n-1){
                anti+=player;
            }
            
            if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
              Math.abs(dia) == n || Math.abs(anti) == n){
                return player == 1 ? "A":"B";
            }
            
            player *= -1;
            
        }
        
return moves.length == n*n ? "Draw":"Pending";    
    }    
    
}