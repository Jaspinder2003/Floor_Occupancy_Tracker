/* import java.util.Arrays;

public class testingBoard {
    public static void main(String[] args) {
        // Create a sample game board
        int[][] board = {
            {0, 0, 1, 1, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 0, 1, 1, 1}
        };

        // Define parameters for the test
        int row = 5; // Row to check
        int piece = 1; // Piece to check for
        int length = 3; // Length required for a win

        // Call the winInRow method
        boolean result = winInRow(board, row, piece, length);

        // Print the result
        System.out.println("Is there a win in row " + row + "? " + result);
    }

    // Paste the winInRow method here
    public static boolean winInRow(int[][] board, int row, int piece, int length) {
        boolean isAwin=false;
        int lengthKeeper = 0;
        int[] indexKeeper = new int[length]; 

        for (int i = 0; i < board[row].length; i++) {      
            if (board[row][i] == piece) {
                indexKeeper[lengthKeeper] = i;
                lengthKeeper = lengthKeeper + 1;
                
            }
        }
    

        if (lengthKeeper == length) {
            boolean me = false;
            Arrays.sort(indexKeeper);

            for (int i = 0; i < indexKeeper.length; i++) {
                if (i + 1 < indexKeeper.length) {
                    System.out.println(indexKeeper[i] + "  " + indexKeeper[i + 1] );
                    if (indexKeeper[i] +1 == indexKeeper[i + 1]) {
                        me = true;
                      
                    } else {
                        me = false;
                       
                    }
                }
            }
          

            if (me == true) {
             
                if (row != 0) {
                    if (board[row + 1][indexKeeper[0]] == piece || 
                        board[row + 1][indexKeeper[indexKeeper.length - 1]] == piece ||
                        board[row - 1][indexKeeper[0]] == piece || 
                        board[row - 1][indexKeeper[indexKeeper.length - 1]] == piece) {
                        isAwin = true;
                    } else {
                        isAwin = false;
                    }
                } else {
                    if (board[row + 1][indexKeeper[0]] == piece || 
                        board[row + 1][indexKeeper[indexKeeper.length - 1]] == piece) {
                        isAwin = true;
                    } else {
                        isAwin = false;
                    }
                }
            }
        }
        return isAwin; 
    }
}

*/




import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class testingBoard{
    public static int[][] createBoard(int row, int column) {
        int[][] boardArray = new int[row][column];
        for(int i = 0; i< row; i++){
            for(int j = 0; j< column; j++){ boardArray[i][j] = 0;}}
        return boardArray;}

    public static int rowCount(int [][] board){
        int arrayLen =0;

        for(int i = 1; i<=board.length; i++){arrayLen =  i;}
     
        return arrayLen;}


    public static int colCount(int [][] board){
        int colLen = 0;

        for(int i = 1; i<=board[0].length; i++){colLen =  i;}
        return colLen;}

    public static boolean valid(int [][] board, int row, int column){
        int rowLen = rowCount(board);
        int colLen = colCount(board);

        boolean validity;

        if((row >= 0 && column >= 0) && (row < rowLen && column < colLen) ){ validity = true;}else{validity = false;}
        return validity;}

    
    public static boolean canPlay(int[][] board, int column){
        boolean canPlaybool = true;
        boolean [] isPlayavail = new boolean [board.length];
        for(int i =0; i< board.length; i++){
            if(board[i][column] == 0){
                isPlayavail[i] = true;
            }
        }
        System.out.println(Arrays.toString(isPlayavail));
        for (boolean element : isPlayavail) {
            if (element == true) {
                canPlaybool = true;
            }
            else{
                canPlaybool = false;
            }
        }
            
        return canPlaybool;}

/* 
    public static int play(int[][] board, int column, int piece){
            int playIndex = -1;
            
            
            if (canPlay(board, column) == false){
                playIndex = -1;
            }
            else{
                for (int i = board.length - 1; i >= 0; i--) {
                    if (board[i][column] == 0) {
                        playIndex = i; 
                    }
                }
                 
            }

            
            return playIndex;
        }
        */
        public static int removeLastPlay(int[][] board, int column){
            int playIndex = 0;
            for(int i = 0; i<board.length; i++){
                if(board[i][column]== 1 || board[i][column] == 2){
                         playIndex = i;
                }
                else{
                    playIndex = -1;
                }
             
                     
                       }
                   
                
               
           
        
            return playIndex;
        }

    public static int play(int[][] board, int column, int piece){
        int playIndex = 0;
        if (canPlay(board, column) == false){ playIndex = -1;}
        else{for (int i = board.length - 1; i >= 0; i--) {if (board[i][column] == 0) {playIndex = i; }}}
        return playIndex;
    }
    public static boolean full(int[][] board){
        boolean isFull = true; 
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j]==0){
                    isFull = false;
                    break;
                
            }}}
            
        return isFull;
    }

 
    public static boolean winInRow(int[][] board, int row, int piece, int length) {
        boolean isAwin = false;
        int lengthKeeper = 0;
        int[] indexKeeper = new int[length]; 
    
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] == piece) {
                indexKeeper[lengthKeeper] = i;
                lengthKeeper = lengthKeeper + 1;
            }
        }
        // Assuming indexKeeper array is already sorted
        Arrays.sort(indexKeeper);

        // Count consecutive elements
        int isConsecutive = 1;
        for (int i = 0; i < indexKeeper.length - 1; i++) {
            if (indexKeeper[i] + 1 == indexKeeper[i + 1]) {
                isConsecutive++;
            }
        }

        // Create a new array to hold consecutive elements
        int[] organizedIndexKeeper = new int[isConsecutive];

        // Populate organizedIndexKeeper array with consecutive elements
        int currentIndex = 0;
        for (int j = 0; j < indexKeeper.length - 1; j++) {
            if (indexKeeper[j] + 1 == indexKeeper[j + 1]) {
                organizedIndexKeeper[currentIndex++] = indexKeeper[j];
            }
        }

        // Append the last element if it is consecutive with the second-to-last element
        if (indexKeeper[indexKeeper.length - 1] == organizedIndexKeeper[currentIndex - 1] + 1) {
            organizedIndexKeeper[currentIndex] = indexKeeper[indexKeeper.length - 1];
        }


        

    
        if (organizedIndexKeeper.length == length) {
            Arrays.sort(indexKeeper);
            System.out.println(Arrays.toString(organizedIndexKeeper));
    

            if (row != 0) {
                if (board[row + 1][indexKeeper[0]] == piece || 
                    board[row + 1][indexKeeper[indexKeeper.length - 1]] == piece ||
                    board[row - 1][indexKeeper[0]] == piece || 
                    board[row - 1][indexKeeper[indexKeeper.length - 1]] == piece) {
                    isAwin = true;
                } else {
                    isAwin = false;
                }
            }
            else if(row == board.length - 1){
                if (board[row - 1][indexKeeper[0]] == piece || 
                    board[row - 1][indexKeeper[indexKeeper.length - 1]] == piece) {
                    isAwin = true;
            }   else {
                isAwin = false;
            }
            }
            
            else {
                if (board[row + 1][indexKeeper[0]] == piece || 
                    board[row + 1][indexKeeper[indexKeeper.length - 1]] == piece) {
                    isAwin = true;
                } else {
                    isAwin = false;
                }
            }
        }
       
        return isAwin; 
    }

    public static boolean winInColumn(int[][] board, int column, int piece, int length){
        boolean isAwin = true; 
        int lengthKeeper = 0;
        int[] indexKeeper = new int[board[0].length]; 
        for(int i = 0; i <board.length; i++){
            if(board[i][column] == piece){
                indexKeeper[lengthKeeper] = i;
                lengthKeeper = lengthKeeper +1;}}

        Arrays.sort(indexKeeper);
        System.out.println(Arrays.toString(indexKeeper));

        int isConsecutive = 1; // Initialize the count with 1, assuming at least one element is consecutive

        for (int i = 0; i < indexKeeper.length - 1; i++) {
            if (indexKeeper[i] + 1 == indexKeeper[i + 1]) {
                isConsecutive++; // Increment the count for each consecutive pair of elements
                if (isConsecutive >= length) {
                    // If there are at least 3 consecutive numbers, you can break out of the loop
                    break;
                }
            } else {
                isConsecutive = 1; // Reset the count if the current pair is not consecutive
            }
        }
        System.out.println("is consectuive " + isConsecutive);
    
        if(isConsecutive==length) {//check the length, consecute condition if there is out of bound error
        // Create a new array to hold consecutive elements
        int[] organizedIndexKeeper = new int[isConsecutive];

        // Populate organizedIndexKeeper array with consecutive elements
        int currentIndex = 0;
        for (int j = 0; j < indexKeeper.length - 1; j++) {
            if (indexKeeper[j] + 1 == indexKeeper[j + 1]) {
                organizedIndexKeeper[currentIndex++] = indexKeeper[j];
            }
        }

        // Append the last element if it is consecutive with the second-to-last element
        if (indexKeeper[indexKeeper.length - 1] == organizedIndexKeeper[currentIndex - 1] + 1) {
            organizedIndexKeeper[currentIndex] = indexKeeper[indexKeeper.length - 1];
        }
       



        if(column != 0  &&  column!= board[0].length -1){
            
            if(board[organizedIndexKeeper[0]][column-1] == piece  || board[organizedIndexKeeper[organizedIndexKeeper.length-1]][column-1] == piece || board[organizedIndexKeeper[0]][column+1] == piece  || board[organizedIndexKeeper[organizedIndexKeeper.length-1]][column+1] == piece ){
                isAwin = true;  
                
            }
            else{
                
                isAwin = false;
            }

        }
        else if(column == 0){
            if(board[organizedIndexKeeper[0]][column+1] == piece  || board[organizedIndexKeeper[organizedIndexKeeper.length-1]][column+1] == piece){

                isAwin = true;  
            }
            else{
                isAwin = false;
            }
        }
        else if(column== board[0].length -1){
            if(board[organizedIndexKeeper[0]][column-1] == piece  || board[organizedIndexKeeper[organizedIndexKeeper.length-1]][column-1] == piece){
                isAwin = true;  
            }
            else{
                isAwin = false;
            }

        }
            
        }else{
            isAwin = false;
        }
        
        return isAwin;
    }

    public static boolean winInDiagonalBackslash(int[][] board, int piece, int length){
        int rowLen = rowCount(board);
        int colLen = colCount(board);

        int l;
        int[] pieceIndex = {100};

       // int[] newArray = Arrays.copyOf(existingArray, existingLength + 1);
             /* 
        0-1
        1-2 
        2-3
        3-4
        4-5
        5-6
        maximum lenght of diagonal is the lenght of board[board.length-1], if board[board.length-1] > number of rows left above it then max diagonal lenght will cap out the rows available above
        */
        
        for(int i = board.length -1; i >= 0; i--){
            System.out.println(Arrays.toString(board[i]));
            for(int j = board[i].length-1; j >= 0; j--){
               
                if (board[i][j] == piece) {
                    int k = i-1;
                   // System.out.println("******************************" + " i is " + i + " j is "+ j);
                    if(j+1 > i){
                        l = i-1;
                    }
                    else{
                        l = j-1;
                    }
                    for(;l>=0;l--){
                   //   System.out.println("*********" + " k is " + k + " l is "+ l);
                     System.out.println(board[k][l]); 
                     if(board[k][l] == piece){

                       
                     }
                  
                      k--;};
                       

                    }
                   

                    
                }

            }

                 
        return false;
    
    }

        

            
    public static void main(String[] args){
        int[][] board = {
            {0, 0, 1, 1, 1},
            {0, 0, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 0, 1, 1, 1}
        };
  

        //

      // System.out.println(testingBoard.canPlay(testingBoard.createBoard(4, 8), 1));
       //System.out.println(testingBoard.play(testingBoard.createBoard(4, 8), 3, 1));
       //System.out.println(testingBoard.removeLastPlay(testingBoard.createBoard(4, 8), 3));
       //System.out.println(testingBoard.full(testingBoard.createBoard(4, 8)));
       //System.out.println(testingBoard.winInRow(board, 3,1,3));
      // System.out.println(testingBoard.winInColumn(board, 2,1,2));
       System.out.println(testingBoard.winInDiagonalBackslash(board, 1,3));
  
    }
}


