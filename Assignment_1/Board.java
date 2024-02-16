
import java.util.Arrays;

public class Board {

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
            else{
                canPlaybool = false;
            }
        }   
        return canPlaybool;}



    public static int play(int[][] board, int column, int piece){
        int playIndex = 0;
        if (canPlay(board, column) == false){ playIndex = -1;}
        else{for (int i = board.length - 1; i >= 0; i--) {if (board[i][column] == 0) {playIndex = i; }}}
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
                if (row !=0 && row != board[0].length -1){
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
                    if ((board[j][column+1] == piece || board[j][column+1]  == piece) ){
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
                                    if((indexKeeper[0][1] - j) +1 > length || (j - indexKeeper[1][1])+1 >=length){ System.out.println("ooo ");
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
                                   if((indexKeeper[0][1] - i) +1 > length || (i -indexKeeper[1][1])+1 >=length){
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
    
        }}
     
        return isAwin;
    }
    
   


     
}











