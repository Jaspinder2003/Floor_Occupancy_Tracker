import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * CPSC 233 W24 Assignment 1 BoardTest Starter File
 * Holds a helper deep copy and example tests of deep copy
 * @author Jonathan Hudson
 * @email jwhudson@ucalgary.ca
 * @version 1.0
 */
public class BoardTest {
     
    @Test
    public void minimumBoardSizeTest () {
        int[][] expected = new int[4][4];
        assertArrayEquals(expected, Board.createBoard(4, 4));
    }

    @Test
    public void MaximumBoardSizeTest () {
        int[][] expected = new int[8][8];
        assertArrayEquals(expected, Board.createBoard(8, 8));
    }

    @Test
    public void minimumRowMaximumColumnTest (){
        int[][] expected = new int[4][8];
        assertArrayEquals(expected, Board.createBoard(4, 8));
    }

    @Test
    public void minimumColumnMaximumRowTest () {
        int[][] expected = new int[8][4];
        assertArrayEquals(expected, Board.createBoard(8, 4));
    }

    @Test
    public void randomRowColumnSizeTest () {
        int[][] expected = new int[6][7];
        assertArrayEquals(expected, Board.createBoard(6, 7));
    } 

  

    @Test
    public void squareBoardRowCountTest() {
        int[][] testBoard = new int[6][6];
        int rowCount = Board.rowCount(testBoard);
        assertEquals(6, rowCount);
    }

    @Test
    public void rectangularBoardRowCountTest() {
        int[][] testBoard = new int[4][8];
        int rowCount = Board.rowCount(testBoard);
        assertEquals(4, rowCount);
    }

    @Test
    public void randomSizedRowCountTest() {
        int[][] testBoard = new int[4][7];
        int rowCount = Board.rowCount(testBoard);
        assertEquals(4, rowCount);
    }

    @Test
    public void smallBoardRowCountTest() {
        int[][] testBoard = new int[2][1];
        int rowCount = Board.rowCount(testBoard);
        assertEquals(2, rowCount);
    }

    @Test
    public void largeBoardRowCountTest() {
        int[][] testBoard = new int[100][1];
        int rowCount = Board.rowCount(testBoard);
        assertEquals(100, rowCount);
    }


    @Test
    public void squareBoardColumnCountTest() {
        int[][] testBoard = new int[6][6];
        int colCount = Board.columnCount(testBoard);
        assertEquals(6, colCount);
    }

    @Test
    public void rectangularBoardColumnCountTest() {
        int[][] testBoard = new int[4][8];
        int colCount = Board.columnCount(testBoard);
        assertEquals(8, colCount);
    }

    @Test
    public void randomSizedColumnCountTest() {
        int[][] testBoard = new int[4][7];
        int colCount = Board.columnCount(testBoard);
        assertEquals(7, colCount);
    }

    @Test
    public void smallBoardColumnCountTest() {
        int[][] testBoard = new int[2][1];
        int colCount = Board.columnCount(testBoard);
        assertEquals(1, colCount);
    }

    @Test
    public void largeBoardColumnCountTest() {
        int[][] testBoard = new int[4][100];
        int colCount = Board.columnCount(testBoard);
        assertEquals(100, colCount);
    }

    ////////////////////

    @Test
    public void EmptyColumnTest() {
        int[][] testBoard =
       {{0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}};
        boolean ifValid = Board.canPlay(testBoard,2);
        assertTrue(ifValid);
    }

    @Test
    public void FullColumnTest() {
        int[][] testBoard =
        {{0, 1, 0, 0},
         {0, 1, 0, 0},
         {0, 1, 0, 0},
         {0, 1, 0, 0},
         {0, 1, 0, 0}};

        boolean ifValid = Board.canPlay(testBoard, 1);
        assertFalse(ifValid);
    }

    @Test
    public void PartiallyFilledColumnTest() {
        int[][] testBoard =
        {{0, 0, 0, 0},
         {0, 0, 0, 0},
         {0, 1, 0, 0},
         {0, 1, 0, 0},
         {0, 1, 0, 0},
         {0, 1, 0, 0}};
        boolean ifValid = Board.canPlay(testBoard, 1);
        assertTrue(ifValid);
    }

    @Test
    public void EdgeCaseLastColumnTest() {
        int[][] testBoard =
        {{0, 0, 0, 0},
         {0, 0, 0, 0},
         {0, 0, 0, 1},
         {0, 0, 0, 1},
         {0, 0, 0, 1},
         {0, 0, 0, 1}};
        boolean ifValid = Board.canPlay(testBoard, 3);
        assertTrue(ifValid);
    }

    @Test
    public void EdgeCaseFirstColumnTest() {
        int[][] testBoard =
       {{0, 0, 0, 0},
        {1, 0, 0, 0},
        {1, 0, 0, 0},
        {1, 0, 0, 0},
        {1, 0, 0, 0},
        {1, 0, 0, 0}};
        boolean ifValid = Board.canPlay(testBoard, 0);
        assertTrue(ifValid);
    }


    /////////////////////////////////////

    @Test
    public void ValidIndicesWithinBoardDimensionsTest() {
        int[][] testBoard = new int[4][7];
        boolean ifValid = Board.valid(testBoard, 3, 5);
        assertTrue(ifValid);
    }

    @Test
    public void InvalidRowIndexTest() {
        int[][] testBoard = new int[7][8];
        boolean ifValid = Board.valid(testBoard, 7, 5);
        assertFalse(ifValid);
    }

    @Test
    public void InvalidColumnIndexTest() {
        int[][] testBoard = new int[4][6];
        boolean ifValid = Board.valid(testBoard, 3, 6);
        assertFalse(ifValid);
    }

    @Test
    public void BothIndicesOutsideBoardDimensionsTest() {
        int[][] testBoard = new int[4][5];
        boolean ifValid = Board.valid(testBoard, 5, 6);
        assertFalse(ifValid);
    }

    @Test
    public void ValidIndicesOnBoardEdgeTest() {
        int[][] testBoard = new int[5][6];
        boolean ifValid = Board.valid(testBoard, 4, 5);
        assertTrue(ifValid);
    }
 

 




     

    /**
     * Used to make a copy of board before functions run, so that verify a function was non-destructive on board is easy
     * @param board The board to make deep copy of
     * @return A deep copy of given board
     */
    public int[][] deepCopy(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return copy;
    }

    @Test
    public void deepCopyTestWithoutDeepEquals() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        assertEquals(expected[0][0], actual[0][0]);
        assertEquals(expected[0][1], actual[0][1]);
    }


    @Test
    public void deepCopyTestNoChange() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void deepCopyTestChangeEntryIn2D() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        actual[0][0] = 99;
        assertTrue(!Arrays.deepEquals(expected, actual));
    }

    @Test
    public void deepCopyTestSet1DRefToDiffButIdenticalArray() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        actual[0] = new int[]{0,1};
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void deepCopyTestSet1DRefToDiffArray() {
        int[][] expected = new int[][]{{0, 1}};
        int[][] actual = deepCopy(expected);
        actual[0] = new int[]{0,99};
        assertTrue(!Arrays.deepEquals(expected, actual));
    }

}

