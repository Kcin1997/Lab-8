package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sudoku.Sudoku;

public class SudokuTest{
	@Test
	public void checkGetSquare(){
	String builder = " 6 29  4 ";
	builder +=" 9 8    1";
	builder +="2   43 6 ";
	builder +="1293  6  ";
	builder +="  5 6 4  ";
	builder +="  6  7512";
	builder +=" 4 73   6";
	builder +="7    5 9 ";
	builder +=" 5  19 7 ";
	Sudoku test = new Sudoku(builder);
	
	assertEquals("Square should contain 9.",'9',test.getSquare(3,2) );
	assertEquals("Square should contain 7.",'7',test.getSquare(5,6) );
	assertEquals("Square should contain ' '.",' ',test.getSquare(0,7) );
	}//end checkGetSquare
}//End SudokuTest
