import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    public void randomRowColumnSize () {
        int[][] expected = new int[6][7];
        assertArrayEquals(expected, Board.createBoard(6, 7));
    
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

