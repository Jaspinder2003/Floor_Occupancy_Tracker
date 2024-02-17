/**
 * CPSC 233 W24 Assignment 1 Starter to use to make Board.java
 * @author Jonathan Hudson
 * @email jwhudson@ucalgary.ca
 * @version 1.0
 */
public class Starter {

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
    public static int[][] createBoard(int r, int c)
    {
        int[][] BoardMatrix = new int[r-1][c-1];
        for(int i = 0; i<=(r-1); i++)
        {
            for (int j=0;j<=(c-1);j++)
            {
                BoardMatrix[i][j]=0;
            }
        }
        return BoardMatrix;
    }
    /**
     * in this function i have created a board of r no. of rows and c no. of columns with every element of the 
     * board as 0 by default
     */
    
    public static int rowCount(int[][] b)
    {
        return b.length();
    }
    /**
     * simple method to find no. of rows and columns
     */
    
    public static int columnCount(int[][] b)
    {
        return b[0].length;
    }
    
    public static boolean valid(int[][] b, int row, int col)
    {
        boolean x,y;
        if (row>=0 && row<=rowCount(b))
        {
            x = true;
        }
        else
        {
            x= false;
        }
    
        if (col>=0 && col<=columnCount(b))
        {
            y = true;
        }
        else
        {
            y = false;
        }
    
        return x && y;
    }
    /**
     * this is alsoa very simple function used to check if the column added and the row added as inputs
     * are even possible in the created board. I use if and else loops to determine this and using conjuction in the end to find the final answer
     */
    public static boolean canPlay(int[][] b,int col)
    {
        boolean a;
        if (b[0][col]=0)
        {
            a= true;
        }
        return a;
    }
    /**
     * if the first element of the board is 0 then ofcourse there is still space to play and if it is not 0 then that means none of the values are 0 in the 
     * whole column
     */
    public static int play(int[][] b,int col, int piece)
    {
        int a;
        int c;
        for(int i = 0;i<b.length;i++)
        {while(c!=1){
            if(b[i][col]!=0)
            {
                if(i==1){a = i;}
                else{a=i-1;}
                c=1;
            }
        }}
        return a;
    
    }
    /**
     * here I have used c to stop the loop once the available position is found in the loop
     * if first element is not 0 then it returns -1 and if it is 0 it returns the position of the last 0 in the column.
     */
    public static int removeLastPlay(int[][] b, int col)
    {
        int a;
        int C=0;
        for(int i = 0;i<b.length;i++)
        while(C==0){
        {
            if(b[i][col]!=0){
                b[i][col]=0
                C=1;
                a=i;
            }
            else {
                a=-1;
            }
        }}
        return a;
    }
    /**
     * here also i use c to stop the loop and to find the position of the last played step
     */
    public static boolean full(int[][] b)
    {   int a=0;
        for(int i =0; i< b[0].length; i++)
        {
            if (b[0][i] == 0)
            {
                a++;
            }
        }
        /**
         * this functionn is used to check just the first row of the board and if
         * the first row has space then the board still has space.
         */
        boolean x;
        if(a!=0)
        {
            x = false;
        }
        else{
            x= true;
        }
        return x;
    }
    
    public static boolean winInRow(int[][] board,int row, int piece,int len){
        int lengthkeeper=0;
        boolean res=false;
        boolean stop=true;
        for(int i=0;i<=board[0].length-len && stop;i++){
            for(int j=0;j<len;j++){
                if(board[row][i+j]==piece){
                    lengthkeeper++;
                }
                else{
                    lengthkeeper=0;
                }
                /**
                 * this loop is used to iterate through the whole row and it checks only till the lengtrh specified
                 * lengthkeeper keeps track of the length achieved.
                 */
            
            }
            /**
             * i loop is used to iterate through all of the row(till where we can get true value for the funvtion) and to enable j loop to check the length
             */
        if(lengthkeeper>=len){
    
            if(valid(board,row+1,i)){
            if(board[row+1][i]==piece){
                res=true;
                stop=false;
            }}
    
            if(valid(board,row-1,i)){
            if (board[row-1][i]==piece){
                res=true;
                stop=false;
            }}
    
            if(valid(board,row+1,i+len-1)){
            if (board[row+1][i+len-1]==piece){
                res=true;
                stop=false;
            }}
    
            if(valid(board,row-1,i+len-1)){
            if (board[row-1][i+len-1]==piece){
                
                    res=true;
                    stop=false;
                }
                    
            }
            /**
             * this is used to check for the L shape once lengthkeeper has the same value as the length.
             * and valid function is being used to check if an l shape is even possible at the location of checking.
             */
        }
        }
        return res;
    }
    
    public static boolean winInColumn(int[][] board,int column,int piece, int len){
        int lengthkeeper=0;
        boolean res =false;
        boolean stop =true;
        for(int i=0;i<=board.length-len && stop;i++){
            for(int j=0;j<len;j++){
                if(board[i+j][column]==piece){
                    lengthkeeper++;
                }
                else{
                    lengthkeeper=0;
                }
                /**
                 * this loop is used to iterate through the column and it checks only till the length specified
                 * lengthkeeper keeps track of the length achieved.
                 */
            
            }
            /**
             * i loop is used to iterate through all of the column(till where we can get true value for the funvtion) and to enable j loop to check the length
             */
        if(lengthkeeper>=len){
    
            if(valid(board,i,column+1)){
            if(board[i][column+1]==piece){
                res=true;
                stop=false;
            }}
    
            if(valid(board,i,column-1)){
            if (board[i][column-1]==piece){
                res=true;
               stop=false;
            }}
    
            if(valid(board,i+len-1,column+1)){
            if (board[i+len-1][column+1]==piece){
                res=true;
                stop=false;
            }}
    
            if(valid(board,i+len-1,column-1)){
            if (board[i+len-1][column-1]==piece){
               
                    res=true;
                    stop=false;
            }}
            /**
             * this is used to check for the L shape once lengthkeeper has the same value as the length.
             * and valid function is being used to check if an l shape is even possible at the location of checking.
             */
        }
    }
    return res;}
    
    
    /**public static boolean winInColumn(int[][] b; int column;int piece;int len)
            {
                int a=0;
                int d=0;
                int e=0;
                boolean c;
                boolean stop;
                for (int i=d;i<=(b.length)-len+1&&!stop;i++){
                    while(a<(len)){
                        if(b[i][column]==b[i+1][column]&&b[i][column]==piece){
                            a++;
                            d=i;
                        }
                        else{
                            a=0;
                        }
                    while(a>=len){
                        if(b[i][column]==b[i+1][column]&&b[i][column]==piece){
                            a++;
                            e=i;
                        }
                    }
                    }
                   
                }
                
                if(a==len){
                    if(b[d][column-1]==piece){
                        c=true;}
                    else if(b[d][column+1]==piece){
                        c=true;
                    }
                    else if(b[d-(len-1)][column-1]==piece){
                        c=true;
                    }
                    else if(b[d-(len-1)][column+1]==piece){
                        c=true;
                    }
                }
                else if(a> len){
                
                    for(int x = 0; x <= a; x--&&!stop){
                        if (b[(e-x)][column-1]==piece){
                            c=true;
                        }
                        else if(b[(e-x)][column+1]==piece){
                            c=true;
                        }
                        else{
                            stop=true;
                        }
                        }
                    }   
                    return c;
                }*/
    /**
     * the concept for wininColumn is the same as wininRow
     */
    /**public static int num(int[][] b,int row;int piece){
        boolean stop;
        int x=0;
        for(int i=0;i<b[row].length&&!stop;i++){
            if(b[row][i]==piece){
                x++;
                stop=true;
            }
        }
        return x;
    }
    public static int Coord(int[][] b,int row;int piece){
        boolean stop;
        int x=0;
        for(int i=0;i<b[row].length&&!stop;i++){
            if(b[row][i]==piece){
                int a=i;
                stop=true;
            }
        }
        return x;
    }*/
    /**
     *these two functions are used in the diagonal function, num giving the len of the array and Coord 
     giving the column number for the same coloured piece in the next row 
     */            
                
    
    /**public static boolean winInDiagonalBackslash(int[][] b;int piece;int len){
        int a=0;
        int y=0;
        int z=0;
        int x;
        boolean lennum;
        boolean res;
        for (int i=0;i<b.length;i++){
            a=num(int[][] b,i,piece)
        }
        int[] x= new int[a+1];
        for (int j=0;j<b.length;j++){
            x[j]=Coord(int[][] b,j,piece);
        }
        for(int k=0;k<=x.length-1;k++){
            while(y<len){
            if(x[k+1]-x[k]==1){
                lennum=true;
                y++;
            }
            else{
            y=0;
            lennum=false;
            }
                    }
            while(y>=len){
                lennum=true;
                if(x[k+1]-x[k]==1){
                    y++;
                    z=k;
                }
    
            }
        }
        if(y<len||lennum==false){
    res=false;
        }
        else{
            if()
        }
    }
    
    public static int[] hint(int[][] b, int piece,int len){
        for(int i=0;i<b[0].length;i++){
            if (canPlay(b,i)==true){
                    play(b,i,piece);
                    if(winInAnyColumn(b,i,piece)==true||winInAnyRow==true)
            }
        }
    }
    
    public static winInAnyRow(int[][] board,int row, int,piece,int len){
        int lengthkeeper=0;
        boolean res=false;
        for(int i=0;i<board[0].length-len;i++){
            for(int j=0;j<len;j++){
                if(board[row][i+j]==piece){
                    lengthkeeper++;
                }
                else{
                    lengthkeeper=0;
                }
            
            }
        if(lengthkeeper>=len){
            if(board[row+1][i]==piece){
                res=true;
            }
            else if (board[row-1][i]==piece){
                if(row>0){
                res=true;}
                else{false;}
            }
            else if (board[row+1][i+len-1]==piece){
                res=true;
            }
            else if (board[row-1][i+len-1]==piece){
                if(row>0){
                    res=true;}
                    else{false;}
            }
        }
    }*/
    
    public static boolean winInDiagonalBackslash(int[][] board,int piece,int len){
        int lengthkeeper = 0;
        boolean stop = true;
        boolean res = false;
    for(int row=0;row<=board.length-len && stop;row++){
        for(int i=0;i<board[0].length-len && stop;i++){
            for(int j=0;j<len;j++){
                if(board[row+j][row+i+j]==piece){
                    lengthkeeper++;
                }
                else{lengthkeeper=0;}
                /**
                 * row loop keeps the row fixed, i loop iterates through the row and j loop iterates through the diagonal only till the length that is specified
                 * and lengthkeeper keeps the track of length achieved
                 */
            }
        if(lengthkeeper==len){
            if(valid(board,row-1,i+1)){
                if(board[row-1][i+1]==piece){
                    res=true;
                    stop=false;
                }}
            if(valid(board,row+1,i-1)){
                if(board[row+1][i-1]==piece){
                    res=true;
                    stop=false;
                }}
            if(valid(board,row+len,i+len-1)){ if(board[row+len][i+len-1]){
                res=true;
                stop=false;
            }}
            if(valid(board,row+len-2,i+len+1)){
                if(board[row+len-2][i+len+1]){
                    res=true;
                    stop=false;
                }
            }
           /**
            * this is used to check for the L-shape and if an L shape is even possible at the specified location
            */
        } 
        }
        
    }
    return res;}
    
    public static boolean winInDiagonalForwardSlash(int[][] board,int piece, int len){
        int lengthkeeper=0;
        boolean res=false;
        boolean stop=true;
    
        for(int row=0;row<=board.length-len && stop;row++){
            for(int i=board[0].length-1 ;i>len-1 && stop;i--){
                for(int j=0;j<=len;j++){
                    if(board[row+j][row+i-j]){
                        lengthkeeper++;
                    }
                    else{
                        lengthkeeper=0;
                    }
                    /**
                     * again row loop keeps the row fixed and i loop ioterates through the row but in reverse and j loop iterates through the diagonal only till thhe length specified
                     * and lengthkeeper keeps the track of the length achieved
                     */
                }
                if(lengthkeeper==len){
                    if(valid(board,row-1,i-1)){
                        if(board[row-1][i-1]==piece){
                            res=true;
                            stop=false;
                        }}
                    if(valid(board,row+1,i-1)){
                        if(board[row+1][i+1]==piece){
                            res=true;
                            stop=false;
                        }}
                    if(valid(board,row+len,i+len+1)){ if(board[row+len][i+len+1]){
                        res=true;
                        stop=false;
                    }}
                    if(valid(board,row+len-2,i+len-1)){
                        if(board[row+len-2][i+len-1]){
                            res=true;
                            stop=false;
                        }
                    }
                   
                } 
                /**
                 * this is used to check for L shape and if an L shape is even possiblke at the specified location.
                 */
            }
        }
    return res;
    }
    
    public static int[] hint(int[][] board,int piece,int len){
        int[] Arr=new int[2];
        for(int col=0;col<board[0].length;col++){
            if(canPlay(board,col)==true){
            play(board,col,piece);
            if(won(board,piece,len)==true){
                Arr[0]=removeLastPlay(board,col);
                board[Arr[0]][col]=0;
                Arr[1]=col;
            }
            else{
                Arr[0]=removeLastPlay(board,col);
                board[Arr[0]][col]=0;
            }}
            else{
                Arr[0]=-1;
                Arr[1]=-1;
            }
        }
        return Arr;
    }


    //Students should enter their functions above here
    /**
     * Is there a win in given board in any row of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any row
     * @return True if there is length in any row, False otherwise
     */
    }

