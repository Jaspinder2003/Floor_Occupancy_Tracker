import java.util.Arrays;

/**
 * CPSC 233 W24 Assignment 1 Starter to use to make Board.java
 * @author Jonathan Hudson
 * @email jwhudson@ucalgary.ca
 * @version 1.0
 */
public class Board {

    /**
     * No piece in board (empty)
     */
    public static final int EMP = Game.EMP;
    /**
     * Connect-L Red Piece
     */
    public static final int RED = Game.RED;
    /**
     * Connect-L Blue Piece
     */
    public static final int BLU = Game.BLU;

    //Students should enter their functions below here
   

        public static int[][] createBoard(int row, int column) {
            int[][] boardArray = new int[row][column];
            for(int i = 0; i< row; i++){
                for(int j = 0; j< column; j++){ boardArray[i][j] = 0;}}
            return boardArray;}
    
        public static int rowCount(int [][] board){
            int arrayLen =0;
    
            for(int i = 1; i<=board.length; i++){arrayLen =  i;}
         
            return arrayLen;}
    
    
        public static int columnCount(int [][] board){
            int colLen = 0;
    
            for(int i = 1; i<=board[0].length; i++){colLen =  i;}
            return colLen;}
    
        public static boolean valid(int [][] board, int row, int column){
            int rowLen =  board.length;
            int colLen = board[0].length;
    
            boolean validity;
    
            if((row >= 0 && column >= 0) && (row < rowLen && column < colLen) ){ validity = true;}else{validity = false;}
            return validity;}
    
        
        public static boolean canPlay(int[][] board, int column){
            boolean canPlaybool = false;
            boolean [] isPlayavail = new boolean [board.length];
            for(int i =0; i< board.length; i++){
                if(board[i][column] == 0){
                    isPlayavail[i] = true;
                }
            }
            for (boolean element : isPlayavail) {
                if (element == true) {
                    canPlaybool = true;
                }
                
            }   
       
            return canPlaybool;}
    
    
    
        public static int play(int[][] board, int column, int piece){
            int playIndex = 0;
            boolean stopbool =true;
            if (canPlay(board, column) == false){ playIndex = -1;}
            else{for (int i = board.length - 1; i >= 0 && stopbool; i--) 
                {if (board[i][column] == 0) {
                    playIndex = i;
                    board[i][column]=piece;
                    stopbool=false;

                 }
                }
            }
            
            return playIndex;
        }
    
        public static int removeLastPlay(int[][] board, int column){
            int playIndex = 0;
            for(int i = 0; i<board.length; i++){
                if(board[i][column]== 1 || board[i][column] == 2){playIndex = i;}else{ playIndex = -1;}}
               
            return playIndex;
        }
    
        public static boolean full(int[][] board){
            boolean isFull = true; 
            for(int i = 0; i<board.length; i++){for(int j = 0; j<board[i].length; j++){
                    if(board[i][j]==0){
                        isFull = false;
                        break;
                    }}}
                
            return isFull;
        }
    
        public static boolean winInRow(int[][] board, int row, int piece, int length) {
            boolean isAwin = false;
            int lengthKeeper = 0;
            int[] indexKeeper = new int[2];
        
            for (int i = 0; i < board[row].length; i++) {
                if (board[row][i] == piece) {
                    lengthKeeper = lengthKeeper + 1;
                    if(lengthKeeper >= length){
                        indexKeeper[1]=i;
                        indexKeeper[0]= (i+1) - lengthKeeper;
                    }
        
                }
        
                else{
                    lengthKeeper = 0;
                }
            }
        
            if((indexKeeper[1] - indexKeeper[0]) +1 >= length){
                for(int j = indexKeeper[0] ; j <= indexKeeper[1] ; j++){
                    if (row !=0 && row != board.length -1){
                     
                  

                        if ((board[row + 1][j] == piece || board[row - 1][j] == piece) ){
                            if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                                isAwin = true;
                            }}}
                   if (row == 0){
                    if((board[row + 1][j] == piece)){
                        if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                            isAwin = true;
                        }
                    }}
                   if(row == board[0].length -1){
                    if((board[row + 1][j] == piece)){
                        if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                            isAwin = true;
                        }
                    }
        
                }}
        
            }return isAwin;}
        
        public static boolean winInColumn(int[][] board, int column, int piece, int length){
            boolean isAwin = false;
            int lengthKeeper = 0;
            int[] indexKeeper = new int[2];
            for(int i = 0; i < board.length; i++){
                if(board[i][column] == piece){
                    lengthKeeper = lengthKeeper + 1;
                    if(lengthKeeper >= length){
                        indexKeeper[1]=i;
                        indexKeeper[0]= (i+1) - lengthKeeper;
                    }
                }
                else{
                    lengthKeeper = 0;
                }
            }
            
        
            if((indexKeeper[1] - indexKeeper[0]) +1 >= length){
                boolean boolstop = true;
                for(int j = indexKeeper[0] ; j <= indexKeeper[1] && boolstop; j++){
                    System.out.println(j+ " jj is ");
                    if (column !=0 && column != board[0].length -1){
                        if ((board[j][column+1] == piece || board[j][column-1]  == piece) ){
                            if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                                isAwin = true;
                                boolstop= false;
                            }}}
                    if (column == 0){
                        if( (board[j][column + 1] == piece)){
                            if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                                isAwin = true;
                                boolstop= false;
                            }
                        }}
                    if(column == board[0].length -1){
                        if((board[j][column -1] == piece)){
                           
                            if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                                isAwin = true; boolstop= false;
                            }
                        }}
        
                }
        
            }
            return isAwin;
        }
        
        public static boolean winInDiagonalForwardSlash(int[][] board, int piece, int length) {
         
            int rows = board.length;
            int cols = board[0].length;
          
            int[][] indexKeeper = new int[2][2];
            int lengthkeeper = 0;
            int[] lKeeper = new int[2];
            
            boolean isAwin = false;
        
           
            for (int start = cols - 1; start >= 0; start--) {
                for (int col = start, row = 0; col >= 0 && row < rows; col--, row++) {
                   
               
                    
                    if(board[row][col] == piece){
                        lengthkeeper++;
                        if(lengthkeeper >= length){
                    
                        indexKeeper[0][0] = row - (lengthkeeper - 1);
                        indexKeeper[0][1] = col + (lengthkeeper - 1);
                        indexKeeper[1][0] = row;
                        indexKeeper[1][1] = col;
                        int startRow = row - (lengthkeeper - 1);
                        int startCol = col + (lengthkeeper - 1);
                        int endRow =  row;
                        int endCol =col;
                   
                        for (int i = startRow, j = startCol; i <= endRow && j >= endCol; i++, j--) {
                             
                                  if(i != 0  && j != 0 && ( board[i-1][j-1] == piece)){
                                      lKeeper[0]= i-1;
                                      lKeeper[1]= j-1;
                                        if((indexKeeper[0][1] - j) +1 > length || (j - indexKeeper[1][1])+1 >=length){ //System.out.println("ooo ");
                                     isAwin = true;}
                                 
                                      
                                  }
                                  else if(i != board.length-1  && j != board[0].length-1  && ( board[i+1][j+1] == piece)){
                                    lKeeper[0]= i+1;
                                    lKeeper[1]= j+1;
                                       if((indexKeeper[0][1] - i) +1 > length || (i -indexKeeper[1][1])+1 >=length){
                                     isAwin = true;}
                                  
                                  }
                                }
                                    
                                       
                        }
                    }
                    else{
                        lengthkeeper = 0;
                    }
                }
               lengthkeeper = 0;
            }
        
             lengthkeeper = 0;
    
            if (!isAwin) {
            for (int start = 1; start < rows; start++) {
                for (int row = start, col = cols - 1; row < rows && col >= 0; row++, col--) {
                    
                  
                     if(board[row][col] == piece){
                        lengthkeeper++;
                        if(lengthkeeper >= length){
                    
                        indexKeeper[1][0] = row; 
                        indexKeeper[1][1] = col;
                        indexKeeper[0][0] = row - (lengthkeeper - 1); 
                        indexKeeper[0][1] = col + (lengthkeeper - 1);
                        int startRow = row - (lengthkeeper - 1);
                        int startCol = col + (lengthkeeper - 1);
                        int endRow =  row;
                        int endCol =col;
               
                        for (int i = startRow, j = startCol; i <= endRow && j >= endCol; i++, j--) {
                             
                                  if(i != 0  && j != 0 && ( board[i-1][j-1] == piece)){
                                      lKeeper[0]= i-1;
                                      lKeeper[1]= j-1;
                                       if((indexKeeper[0][1] - j) +1 > length || (j -indexKeeper[1][1])+1 >=length){
                                     isAwin = true;}   
                                      
                                  }
                                  else if(i != board.length-1  && j != board[0].length-1  && ( board[i+1][j+1] == piece)){
                                    lKeeper[0]= i+1;
                                    lKeeper[1]= j+1;
                                    if((indexKeeper[0][1] - j) +1 > length || (j -indexKeeper[1][1])+1 >=length){
                                     isAwin = true;}
                              
                                  }
                                }
                                       
                        }
                    }
                    else{
                        lengthkeeper = 0;
                    }
                }
      
                 lengthkeeper = 0;
        
            }}
         
            return isAwin;
        }
    
        public static boolean winInDiagonalBackslash(int[][] board, int piece, int length){
            int rows = board.length;
            int cols = board[0].length;
          
            int[][] indexKeeper = new int[2][2];
            int lengthkeeper = 0;
     
            
            boolean isAwin = false;
       
            for (int start = 0; start < cols; start++) {
                for (int row = start, col = 0; col < cols && row < rows; row++, col++) {
                  //  System.out.print(row +"  "+col);
                   //System.out.print(board[row][col] + " ");
                    if(board[row][col] == piece){
                        lengthkeeper++;
                        
                        if(lengthkeeper >= length){
                        
                        indexKeeper[1][0] = row; 
                        indexKeeper[1][1] = col;
                        indexKeeper[0][0] = row - (lengthkeeper - 1); 
                        indexKeeper[0][1] = col - (lengthkeeper - 1);
                        int startRow = row - (lengthkeeper - 1);
                        int startCol = col - (lengthkeeper - 1);
                        int endRow =  row;
                        int endCol =col;
                      
                       // System.out.println(startRow +"  "+startCol +" " + endRow +" "+endCol);
                        for (int i = startRow, j = startCol; i <= endRow && j <= endCol; i++, j++) {
                           // System.out.println(i +"  "+j);
                            if(i != 0  && j != 0 &&i != board.length-1  && j != board[0].length-1&& (board[i-1][j+1] == piece)){
                               
                                 if((i - indexKeeper[0][1] ) +1 > length || (i - indexKeeper[1][1])+1 >=length){
                               isAwin = true;}
                
                            }
                            else if(i != 0  && j != 0 && i != board.length-1  && j != board[0].length-1  && ( board[i+1][j-1] == piece)){
                              if((indexKeeper[0][1] - i) +1 > length || (i -indexKeeper[1][1])+1 >=length){
                               isAwin = true;}
                         
                            }
                          }
                    }}
    
                    else{
                            lengthkeeper = 0; 
                        }
    
                }
                //System.out.println();
                lengthkeeper = 0; 
            }
    
    
            if (!isAwin) {
                for (int start = 1; start < cols; start++) {
                    for (int col = start, row = 0; row < rows && col < board[0].length; row++, col++) {
                         
                    
                         if(board[row][col] == piece){
                            lengthkeeper++;
                            if(lengthkeeper >= length){
                        
                            indexKeeper[1][0] = row; 
                            indexKeeper[1][1] = col;
                            indexKeeper[0][0] = row - (lengthkeeper - 1); 
                            indexKeeper[0][1] = col + (lengthkeeper - 1);
                            
                            
                            int startRow = row - (lengthkeeper - 1);
                            int startCol = col - (lengthkeeper - 1);
                            int endRow =  row;
                            int endCol =col;
                   
                            for (int i = startRow, j = startCol; i <= endRow && j >= endCol; i++, j--) {  
                                 
                                      if(i != 0  && j != 0 && i != board.length-1  && j != board[0].length-1 && ( board[i-1][j+1] == piece)){
                                       
                                           if((indexKeeper[0][1] - j) +1 > length || (j -indexKeeper[1][1])+1 >=length){
                                         isAwin = true;}   
                                          
                                      }
                                  
                                      else if(i != 0  && j != 0 && i != board.length-1  && j != board[0].length-1 && ( board[i+1][j-1] == piece)){
                                     
                                        if((indexKeeper[0][1] - j) +1 > length || (j -indexKeeper[1][1])+1 >=length){
                                         isAwin = true;}
                                  
                                      }
                                    }
                                           
                            }
                        }
                        else{
                            lengthkeeper = 0;
                        }
                    }
                 
                     lengthkeeper = 0;
            
                }}
               
            return isAwin;
    
        }
        public static int[] hint(int[][] board,int piece,int len){
            return null;
         
            }
         
    

    //Students should enter their functions above here
    /**
     * Is there a win in given board in any row of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any row
     * @return True if there is length in any row, False otherwise
     */
    private static boolean winInAnyRow(int[][] board, int piece, int length) {
        for (int row = 0; row < board.length; row++) {
            if (winInRow(board, row, piece, length)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Is there a win in given board in any column of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any column
     * @return True if there is length in any column, False otherwise
     */
    private static boolean winInAnyColumn(int[][] board, int piece, int length) {
        for (int col = 0; col < board[0].length; col++) {
            if (winInColumn(board, col, piece, length)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Is there a win in given board in any diagonal of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any diagonal
     * @return True if there is length in any diagonal /\, False otherwise
     */
    private static boolean winInAnyDiagonal(int[][] board, int piece, int length) {
        return winInDiagonalBackslash(board, piece, length) || winInDiagonalForwardSlash(board, piece, length);
    }

    /**
     * Has the given piece won the board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to check for a win
     * @return True if piece has won
     */
    public static boolean won(int[][] board, int piece, int length) {
        return winInAnyRow(board, piece, length) || winInAnyColumn(board, piece, length) || winInAnyDiagonal(board, piece, length);
    }

    /**
     * This function determines if the game is complete due to a win or tie by either player
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @return True if game is complete, False otherwise
     */
    public static boolean isGameOver(int[][] board, int length) {
        return full(board) || won(board, RED, length) || won(board, BLU, length);
    }
}
