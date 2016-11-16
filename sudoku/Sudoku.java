package sudoku;
import java.util.ArrayList;
import java.util.Random;


public class Sudoku{
  public char[][] grid;

  public Sudoku(){
    grid = new char[9][9];
    String board = "";
        board +="  31 6   /n";
        board +="5 7   416/n";
        board +="68       /n";
        board +="37    8 9/n";
        board +="81 392 46/n";
        board +="9 6    25/n";
        board +="       97/n";
        board +=" 547  2 8/n";
        board +="   2 84  /n";
    createBoard(board);
  }//End constructor
  public Sudoku(String board){
    grid = new char[9][9];
    createBoard(board);
  }//end constructor string

  public char getSquare(int row, int col){return grid[row][col];}



  public boolean isValid(){
	int i;
    char[] test = new char[9];
    for(char[] row : grid){
      if(!checkArray(row) ) return false;
    }// end for row
    if(checkCol() != -1)
		return false;
    for(int x=0;x<=6;x+=3){
      for(int y=0;y<=6;y+=3){
		i=0;
        for(int r=x;r<x+3;r++){
          for(int c=y;c<y+3;c++){
            test[i]=grid[r][c];
            i++;
          }//end for c
        }//End for r
		if(!checkArray(test) )return false;
      }//end for y
    }//end for x
    return true;
  }//End isValid

  public boolean isSolved(){
      for(int r=0;r<9;r++){
        for(int c=0;c<9;c++){
             if(grid[r][c] == ' ')
                return false;
        }//end for c
      }//end for r
      return isValid();
  }//End isSolved

/*  //Takes several hours to generate a game board.
  private void createBoard(){
    char[] pull  = {'1','2','3','4','5','6','7','8','9'};
    for (int r=0; r<9;r++){
      pull = shuffleArray(pull);
      for(int c=0;c<9;c++){
        grid[r][c] = pull[c];
      }//end for c
    }//end for r
	for(int i=0; i<12; i++){ //Loop to make sure it doesn't get stuck replacing for an extreemly long time
		int row = checkCol();
		if(row == -1){
			return;
		}else{
			System.out.println("<"+row+">");
			pull = shuffleArray(pull);
			for(int col=0;col<9;col++){
				grid[row][col] = pull[col];
			}//end for c
		}//End else
	}//end for
	System.out.println("<X>");
  }//end createBoard
*/
    private void createBoard(String in){
      int i = 0;
      for (int row=0;row<9;row++){
          for (int col=0;col<9;col++){
            if(in.charAt(i) == '\n'){
              i++;
              System.out.println("==>"+i);
            }
            grid[row][col] = in.charAt(i);
            System.out.print(in.charAt(i));
            i++;

          }//end for col
        }//end for row
    }//end createBoard

  public boolean checkArray(char[] test){
    for(int i=0; i<9;i++){
      for(int j=i+1;j<9;j++){
        if(test[i] == test[j] && test[i] != ' ')
          return false;
      }//end for j
    }//end for i
    return true;
  }//end checkArray

  private char[] shuffleArray(char[] in){
    int index;
    char temp;
    Random rand = new Random();
    for (int i = in.length -1; i >= 0; i--){
        index = rand.nextInt(i + 1);
        temp = in[index];
        in[index] = in[i];
        in[i] = temp;
    }//end for i
    return in;
  } //end shuffleArray

	public void printBoard(){
		System.out.println();
		for(int r = 0;r<9;r++){
			for(int c = 0;c<9;c++){
			System.out.print(grid[r][c]);
			}//End for c
			System.out.println();
		}//End for r
	}//End printBoard

	private void addBlanks(){
		Random rand = new Random();
		int r,c;
		for(int i = 0; i<52;i++){
			r=rand.nextInt();
			c=rand.nextInt();
			if(grid[r][c] == ' ')
				i--;
			else
				grid[r][c] = ' ';
		}//End for
	}//End addBlanks

	public int checkCol(){
		for (int c=0; c<9;c++){
		  for(int r=0;r<8;r++){
		    if(grid[r][c] == grid[r+1][c])
				return r+1;
		  }//end for r
		}//end for col
		return -1;
	}//End checkColums
} //End class
