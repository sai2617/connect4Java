// This class is designed for printing the board required to play connect 4

public class PrintBoard{

  public char[][] board;
  // PrintBoard();
  
  public void printBoard(){
    board = new char[6][7];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
      //   if (boar
          System.out.print("|   ");
      //   }
      }
      System.out.println("|");
    }
    System.out.println("  1   2   3   4   5   6   7");
  }
}
  
