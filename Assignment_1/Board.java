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
   

        /**
         * Creates a new empty game board with the specified number of rows and columns.
         * 
         * @param row The number of rows in the board.
         * @param column The number of columns in the board.
         * @return A 2D integer array representing the game board.
         */
        public static int[][] createBoard(int row, int column) {
            int[][] boardArray = new int[row][column];
            for(int i = 0; i< row; i++){
                for(int j = 0; j< column; j++){ boardArray[i][j] = 0;}}
            return boardArray;}
    
        /**
         * Returns the number of rows in the given board.
         * 
         * @param board The 2D integer array representing the game board.
         * @return The number of rows in the board.
         */
        public static int rowCount(int [][] board){
            int arrayLen =0;
    
            for(int i = 1; i<=board.length; i++){arrayLen =  i;}
         
            return arrayLen;}
    
        /**
         * Returns the number of columns in the given board.
         * 
         * @param board The 2D integer array representing the game board.
         * @return The number of columns in the board.
         */
        public static int columnCount(int [][] board){
            int colLen = 0;
    
            for(int i = 1; i<=board[0].length; i++){colLen =  i;}
            return colLen;}
    
        /**
         * Checks if the specified row and column indices are valid for the given board.
         * 
         * @param board The 2D integer array representing the game board.
         * @param row The row index to check.
         * @param column The column index to check.
         * @return True if the indices are valid, false otherwise.
         */
        public static boolean valid(int [][] board, int row, int column){
            int rowLen =  board.length;
            int colLen = board[0].length;
    
            boolean validity;
    
            if((row >= 0 && column >= 0) && (row < rowLen && column < colLen) ){ validity = true;}else{validity = false;}
            return validity;}
    
        /**
         * Checks if a piece can be played in the specified column of the board.
         * 
         * @param board The 2D integer array representing the game board.
         * @param column The column index where the piece will be played.
         * @return True if a piece can be played in the column, false otherwise.
         */
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
    
        /**
         * Places a piece on the board in the specified column.
         * 
         * @param board The 2D integer array representing the game board.
         * @param column The column index where the piece will be placed.
         * @param piece The piece to be placed (RED==1/BLU==2).
         * @return The row index where the piece was placed, or -1 if the column is full.
         */
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
    
        /**
         * Removes the last piece played in the specified column.
         * 
         * @param board The 2D integer array representing the game board.
         * @param column The column index from which to remove the last piece.
         * @return The row index where the piece was removed, or -1 if the column is empty.
         */
        public static int removeLastPlay(int[][] board, int column){
            int playIndex = 0;
            boolean stopbool = true;
            for(int i = 0; i<board.length&& stopbool; i++){
                if(board[i][column]== 1 || board[i][column] == 2){
                playIndex = i;
                board[i][column]= EMP;
                stopbool = false;
               }
                else{
                 playIndex = -1;}
                }
               
            return playIndex;
        }
    
        /**
         * Checks if the board is full (no empty spaces left).
         * 
         * @param board The 2D integer array representing the game board.
         * @return True if the board is full, false otherwise.
         */
        public static boolean full(int[][] board){
            boolean isFull = true; 
            for(int i = 0; i<board.length; i++){for(int j = 0; j<board[i].length; j++){
                    if(board[i][j]==0){
                        isFull = false;
                        break;
                    }}}
                
            return isFull;
        }
    
        
    
         /**
         * Checks if there is a win in the specified row for the given piece and length.
         * 
         * @param board The 2D integer array representing the game board.
         * @param row The row index to check for a win.
         * @param piece The piece to check for a win (RED==1/BLU==2).
         * @param length The length of the sequence required for a win.
         * @return True if a win is achieved in the row, false otherwise.
         */
        public static boolean winInRow(int[][] board, int row, int piece, int length) {
            boolean isAwin = false;
            int lengthKeeper = 0;
            int[] indexKeeper = new int[2];
        
            for (int i = 0; i < board[row].length; i++) {
                if (board[row][i] == piece) {
                    lengthKeeper = lengthKeeper + 1; // Increment the length keeper when piece matches
                    if(lengthKeeper >= length){ // Check if the length is equal to or greater than the required length for a win
                        indexKeeper[1]=i; // Store the end index of the winning sequence
                        indexKeeper[0]= (i+1) - lengthKeeper; // Store the start index of the winning sequence
                    }
        
                }
        
                else{
                    lengthKeeper = 0; // Reset the length keeper if there's no match
                }
            }
        
            if((indexKeeper[1] - indexKeeper[0]) +1 >= length){ // Check if the length of the winning sequence is equal to or greater than the required length
                for(int j = indexKeeper[0] ; j <= indexKeeper[1] ; j++){
                    if (row !=0 && row != board.length -1){
                        if ((board[row + 1][j] == piece || board[row - 1][j] == piece) ){
                            if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                                isAwin = true;
                            }
                        }
                    }
                    if (row == 0){
                        if((board[row + 1][j] == piece)){
                            if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                                isAwin = true;
                            }
                        }
                    }
                    if(row == board[0].length -1){
                        if((board[row - 1][j] == piece)){
                            if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                                isAwin = true;
                            }
                        }
                    }
                }
            }
            return isAwin;
        }

      /**
         * Checks if there is a win in the specified column for the given piece and length.
         * 
         * @param board The 2D integer array representing the game board.
         * @param column The column index to check for a win.
         * @param piece The piece to check for a win (RED==1/BLU==2).
         * @param length The length of the sequence required for a win.
         * @return True if a win is achieved in the column, false otherwise.
         */
        public static boolean winInColumn(int[][] board, int column, int piece, int length){
            boolean isAwin = false;
            int lengthKeeper = 0;
            int[] indexKeeper = new int[2];
            for(int i = 0; i < board.length; i++){
                if(board[i][column] == piece){
                    lengthKeeper = lengthKeeper + 1; // Increment the length keeper when piece matches
                    if(lengthKeeper >= length){ // Check if the length is equal to or greater than the required length for a win
                        indexKeeper[1]=i; // Store the end index of the winning sequence
                        indexKeeper[0]= (i+1) - lengthKeeper; // Store the start index of the winning sequence
                    }
                }
                else{
                    lengthKeeper = 0; // Reset the length keeper if there's no match
                }
            }
            
        
            if((indexKeeper[1] - indexKeeper[0]) +1 >= length){ // Check if the length of the winning sequence is equal to or greater than the required length
                boolean boolstop = true;
                for(int j = indexKeeper[0] ; j <= indexKeeper[1] && boolstop; j++){
                    System.out.println(j+ " jj is ");
                    if (column !=0 && column != board[0].length -1){
                        if ((board[j][column+1] == piece || board[j][column-1]  == piece) ){ // Check adjacent pieces
                            if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                                isAwin = true;
                                boolstop= false;
                            }}}
                    if (column == 0){
                        if( (board[j][column + 1] == piece)){ // Check the right adjacent piece
                            if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                                isAwin = true;
                                boolstop= false;
                            }
                        }}
                    if(column == board[0].length -1){
                        if((board[j][column -1] == piece)){ // Check the left adjacent piece
                           
                            if((j - indexKeeper[0]) +1 >= length || ( indexKeeper[1] - j) +1 >= length){
                                isAwin = true; boolstop= false;
                            }
                        }}
        
                }
        
            }
            return isAwin;
        }
        
                /**
         * Checks if there is a win in the diagonal (/) direction for the given piece and length.
         * 
         * @param board The 2D integer array representing the game board.
         * @param piece The piece to check for a win (RED==1/BLU==2).
         * @param length The length of the sequence required for a win.
         * @return True if a win is achieved diagonally (/), false otherwise.
         */

        public static boolean winInDiagonalForwardSlash(int[][] board, int piece, int length) {
            int rows = board.length;
            int cols = board[0].length;

            // 2D array to store the indices of the winning sequence
            int[][] indexKeeper = new int[2][2];
            int lengthkeeper = 0; // Keeps track of the length of consecutive pieces
            int[] lKeeper = new int[2]; // Stores the index of the last checked piece in the diagonal

            boolean isAwin = false; // Flag to indicate if a win is achieved

            // Iterating diagonally from top right to bottom left
            for (int start = cols - 1; start >= 0; start--) {
                for (int col = start, row = 0; col >= 0 && row < rows; col--, row++) {
                    if (board[row][col] == piece) {
                        lengthkeeper++;
                        if (lengthkeeper >= length) { // Check if the length is equal to or greater than the required length for a win
                            // Store the indices of the winning sequence
                            indexKeeper[0][0] = row - (lengthkeeper - 1);
                            indexKeeper[0][1] = col + (lengthkeeper - 1);
                            indexKeeper[1][0] = row;
                            indexKeeper[1][1] = col;
                            int startRow = row - (lengthkeeper - 1);
                            int startCol = col + (lengthkeeper - 1);
                            int endRow = row;
                            int endCol = col;

                            // Check if there's a continuous sequence of pieces in the diagonal
                            for (int i = startRow, j = startCol; i <= endRow && j >= endCol; i++, j--) {
                                if (i != 0 && j != 0 && (board[i - 1][j - 1] == piece)) {
                                    lKeeper[0] = i - 1;
                                    lKeeper[1] = j - 1;
                                    if ((indexKeeper[0][1] - j) + 1 > length || (j - indexKeeper[1][1]) + 1 >= length) {
                                        isAwin = true;
                                    }
                                } else if (i != rows - 1 && j != cols - 1 && (board[i + 1][j + 1] == piece)) {
                                    lKeeper[0] = i + 1;
                                    lKeeper[1] = j + 1;
                                    if ((indexKeeper[0][1] - j) + 1 > length || (j - indexKeeper[1][1]) + 1 >= length) {
                                        isAwin = true;
                                    }
                                }
                            }
                        }
                    } else {
                        lengthkeeper = 0; // Reset the length keeper if there's no match
                    }
                }
                lengthkeeper = 0; // Reset the length keeper for the next iteration
            }

            lengthkeeper = 0; // Reset the length keeper for the next loop

            // If a win is not achieved in the backward diagonal, check in the opposite direction (bottom left to top right)
            if (!isAwin) {
                for (int start = 1; start < rows; start++) {
                    for (int row = start, col = cols - 1; row < rows && col >= 0; row++, col--) {
                        if (board[row][col] == piece) {
                            lengthkeeper++;
                            if (lengthkeeper >= length) { // Check if the length is equal to or greater than the required length for a win
                                // Store the indices of the winning sequence
                                indexKeeper[1][0] = row;
                                indexKeeper[1][1] = col;
                                indexKeeper[0][0] = row - (lengthkeeper - 1);
                                indexKeeper[0][1] = col + (lengthkeeper - 1);
                                int startRow = row - (lengthkeeper - 1);
                                int startCol = col + (lengthkeeper - 1);
                                int endRow = row;
                                int endCol = col;

                                // Check if there's a continuous sequence of pieces in the diagonal
                                for (int i = startRow, j = startCol; i <= endRow && j >= endCol; i++, j--) {
                                    if (i != 0 && j != 0 && (board[i - 1][j - 1] == piece)) {
                                        lKeeper[0] = i - 1;
                                        lKeeper[1] = j - 1;
                                        if ((indexKeeper[0][1] - j) + 1 > length || (j - indexKeeper[1][1]) + 1 >= length) {
                                            isAwin = true;
                                        }
                                    } else if (i != rows - 1 && j != cols - 1 && (board[i + 1][j + 1] == piece)) {
                                        lKeeper[0] = i + 1;
                                        lKeeper[1] = j + 1;
                                        if ((indexKeeper[0][1] - j) + 1 > length || (j - indexKeeper[1][1]) + 1 >= length) {
                                            isAwin = true;
                                        }
                                    }
                                }
                            }
                        } else {
                            lengthkeeper = 0; // Reset the length keeper if there's no match
                        }
                    }
                    lengthkeeper = 0; // Reset the length keeper for the next iteration
                }
            }

            return isAwin;
        }

                /**
         * Checks if there is a win in the diagonal (/) direction for the given piece and length.
         * 
         * @param board The 2D integer array representing the game board.
         * @param piece The piece to check for a win (RED==1/BLU==2).
         * @param length The length of the sequence required for a win.
         * @return True if a win is achieved diagonally (/), false otherwise.
         */
        public static boolean winInDiagonalBackslash(int[][] board, int piece, int length){
            int rows = board.length;
            int cols = board[0].length;
        
            // 2D array to store the indices of the winning sequence
            int[][] indexKeeper = new int[2][2];
            int lengthkeeper = 0; // Keeps track of the length of consecutive pieces
            
            boolean isAwin = false; // Flag to indicate if a win is achieved
            
            // Iterating diagonally from top left to bottom right
            for (int start = 0; start < cols; start++) {
                for (int row = start, col = 0; col < cols && row < rows; row++, col++) {
                    if(board[row][col] == piece){
                        lengthkeeper++;
                        if(lengthkeeper >= length){
                            // Store the indices of the winning sequence
                            indexKeeper[1][0] = row; 
                            indexKeeper[1][1] = col;
                            indexKeeper[0][0] = row - (lengthkeeper - 1); 
                            indexKeeper[0][1] = col - (lengthkeeper - 1);

                            // Check if there's a continuous sequence of pieces in the diagonal
                            int startRow = row - (lengthkeeper - 1);
                            int startCol = col - (lengthkeeper - 1);
                            int endRow =  row;
                            int endCol = col;
                        
                            for (int i = startRow, j = startCol; i <= endRow && j <= endCol; i++, j++) {
                                if(i != 0  && j != 0 &&i != rows - 1  && j != cols - 1&& (board[i-1][j+1] == piece)){
                                    if((j - indexKeeper[0][1] ) +1 > length || (indexKeeper[1][1]-j)+1 >=length){
                                        isAwin = true;
                                    }
                                } else if(i != 0  && j != 0 && i != rows - 1  && j != cols - 1&& (board[i+1][j-1] == piece)){
                                    if((j-indexKeeper[0][1] ) +1 > length || (indexKeeper[1][1]-j)+1 >=length){
                                        isAwin = true;
                                    }
                                }
                            }
                        }
                    } else {
                        lengthkeeper = 0; // Reset the length keeper if there's no match
                    }
                }
                lengthkeeper = 0; // Reset the length keeper for the next iteration
            }

            // If a win is not achieved in the forward diagonal, check in the opposite direction (bottom left to top right)
            if (!isAwin) {
                for (int start = 1; start < cols; start++) {
                    for (int col = start, row = 0; row < rows && col < board[0].length; row++, col++) {
                        if(board[row][col] == piece){
                            lengthkeeper++;
                            if(lengthkeeper >= length){
                                // Store the indices of the winning sequence
                                indexKeeper[1][0] = row; 
                                indexKeeper[1][1] = col;
                                indexKeeper[0][0] = row - (lengthkeeper - 1); 
                                indexKeeper[0][1] = col + (lengthkeeper - 1);

                                // Check if there's a continuous sequence of pieces in the diagonal
                                int startRow = row - (lengthkeeper - 1);
                                int startCol = col - (lengthkeeper - 1);
                                int endRow =  row;
                                int endCol = col;
                            
                                for (int i = startRow, j = startCol; i <= endRow && j >= endCol; i++, j--) {
                                    if(i != 0  && j != 0 &&i != rows - 1  && j != cols - 1 && (board[i-1][j+1] == piece)){
                                        if((indexKeeper[0][1] - j) +1 > length || (j -indexKeeper[1][1])+1 >=length){
                                            isAwin = true;
                                        }
                                    } else if(i != 0  && j != 0 &&i != rows - 1  && j != cols - 1 && (board[i+1][j-1] == piece)){
                                        if((indexKeeper[0][1] - j) +1 > length || (j -indexKeeper[1][1])+1 >=length){
                                            isAwin = true;
                                        }
                                    }
                                }
                            }
                        } else {
                            lengthkeeper = 0; // Reset the length keeper if there's no match
                        }
                    }
                    lengthkeeper = 0; // Reset the length keeper for the next iteration
                }
            }
            return isAwin;
        }

       
            /**
         * Provides a hint for the next move that could lead to a win for the specified player.
         *
         * @param Matrix         The game board represented as a 2D array.
         * @param piece          The player's piece (e.g., 1 for Player 1, 2 for Player 2).
         * @param winningLength  The number of consecutive pieces required to win.
         * @return An array containing the row and column indices of the potential winning move.
         *         If no winning move is found, default values of {-1, -1} are returned.
         */
        public static int[] hint(int[][] board, int piece, int winningLength) {
            // Initialize array to keep track of winning indices
            int[] winIndexKeeper = new int[2];
            // Default values indicating no winning move found
            winIndexKeeper[0] = -1;
            winIndexKeeper[1] = -1;
            // Flag to control loop execution
            boolean boolStop = true;
            
            // Iterate through columns to find potential winning move
            for (int column = 0; column < board[0].length && boolStop; column++) {
                // Check if the column is playable
                if (canPlay(board, column)) {
                    // Simulate playing in the current column
                    play(board, column, piece);
                    // Check if the simulated move results in a win
                    if (won(board, piece, winningLength)) {
                        // If win is detected, finalize the winning move
                        removeLastPlay(board, column);
                        winIndexKeeper[0] = removeLastPlay(board, column);
                        board[winIndexKeeper[0]][column] = 0;
                        winIndexKeeper[1] = column;
                        // Exit the loop as a winning move is found
                        boolStop = false;
                    } else {
                        // If no win, undo the simulated move
                        winIndexKeeper[0] = removeLastPlay(board, column);
                    }
                }
            }
            // Return the winning indices (or default values if no winning move found)
            return winIndexKeeper;
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