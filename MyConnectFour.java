// This class is created for main connect 4 game to be played

import java.io.BufferedReader;
import java.io.InputStreamReader;
// import java.util.Random;

public class MyConnectFour {
  // Random comp = new Random();
  private BufferedReader input;
  private char[][] board;

  // This constructor is used for calling

  public MyConnectFour() {
    board = new char[6][7];
    input = new BufferedReader(new InputStreamReader(System.in));
    playGame();
  }
  // This is function which is created to play the game and it is main function of
  // entire game and the tokens are given as red for human player and yellow for
  // computer player

  private void playGame() {
    System.out.println("Welcome to Connect 4");
    System.out.println("There are 2 players red and yellow");
    System.out.println("Player 1 is Red, Player 2 is Yellow");
    System.out.println("To play the game type in the number of the column you want to drop you counter in");
    System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
    System.out.println("");
    // Here from Printboard class the printBoard function is called for printing the
    // board
    PrintBoard printboard = new PrintBoard();
    printboard.printBoard();
    // printBoard();
    boolean win = false;
    while (!win) {
      // player 1
      // Here human player is giving values and placing the value in board with the
      // help of place counter function
      // player 1 is human and player 2 is computer

      String userInput = getUserInput();
      int move = Integer.parseInt(userInput);
      placeCounter('r', move);
      printBoard();
      // printboard.printBoard();
      // Here all the values are being checked by the boolean functions which created
      // and the random object is called from computer player class
      boolean player = CheckHorizantal('r');
      boolean player2 = CheckVertical('r');
      boolean player4 = TopRightDiagonal('r');
      boolean player6 = TopLeftDiagonal('r');
      if (player || player2 || player4 || player6) {
        win = true;
        System.out.println("Player 1 has won");
      } else {
        ComputerPlayer playeObj = new ComputerPlayer();
        int rand1 = playeObj.getRand();
        // String userInput1 = getUserInput();
        // int rand1 = Integer.parseInt(userInput1);
        placeCounter('y', rand1);
        printBoard();
        // PrintBoard printboard= new PrintBoard();
        // printboard.printBoard();
        boolean player1 = CheckHorizantal('y');
        boolean player3 = CheckVertical('y');
        boolean player5 = TopRightDiagonal('y');
        boolean player7 = TopLeftDiagonal('y');
        if (player1 || player3 || player5 || player7) {
          win = true;
          System.out.println("Player 2 has won");
        }
      }
    }
  }

  // These function is created checking horizantal for a player who won
  public boolean CheckHorizantal(char player) {
    // int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length - 3; j++) {
        if (board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player
            && board[i][j + 3] == player) {

          return true;

        }
      }
    }
    return false;
  }

  // These function is created checking vertical for a player who won
  public boolean CheckVertical(char player) {
    // int count = 0;
    for (int i = 0; i < board.length - 3; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player
            && board[i + 3][j] == player) {
          // count = count + 1;
          // if (count >= 4) {
          return true;
        }
      }

    }
    return false;
  }

  // These function is created checking Top Right to Left Diagonal for a player
  // who won
  public boolean TopRightDiagonal(char player) {
    for (int i = 0; i < board.length - 3; i++) {
      for (int j = 0; j < board[i].length - 3; j++) {
        if (board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player
            && board[i + 3][j + 3] == player) {
          // System.out.println("Dia1 Won");
          return true;
        }

      }
    }
    return false;
  }

  // These function is created checking Top Left to Right Diagonal for a player
  // who won
  public boolean TopLeftDiagonal(char player) {
    for (int i = 0; i < board.length - 3; i++) {
      for (int j = 3; j < board[i].length; j++) {
        if (board[i][j] == player && board[i + 1][j - 1] == player && board[i + 2][j - 2] == player
            && board[i + 3][j - 3] == player) {
          // System.out.println("Dia2 Won");
          return true;
        }

      }
    }
    return false;
  }

  // System.out.println("You Have Won!!!");
  // This is created for getting user input from the human player
  private String getUserInput() {
    String toReturn = null;
    try {
      toReturn = input.readLine();
    } catch (Exception e) {

    }
    return toReturn;
  }

  // This is for printing board for the player when he placed the token
  private void printBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'r') {
          System.out.print("| r ");
        } else if (board[i][j] == 'y') {
          System.out.print("| y ");
        } else {
          System.out.print("|   ");
        }
      }
      System.out.println("|");
    }
    System.out.println("  1   2   3   4   5   6   7");
  }

  // This function helps in placing the chars according to player input of numbers

  private void placeCounter(char player, int position) {
    boolean placed = false;
    if (player == 'r') {
      for (int i = board.length - 1; i >= 0; i--) {
        if (!placed) {
          if (board[i][position - 1] == 'y') {
            // skip

          } else if (board[i][position - 1] != 'r') {
            board[i][position - 1] = 'r';
            placed = true;
          }
        }
      }
    } else {
      for (int i = board.length - 1; i >= 0; i--) {
        if (!placed) {
          if (board[i][position - 1] == 'r') {
            // skip
          } else if (board[i][position - 1] != 'y') {
            board[i][position - 1] = 'y';
            placed = true;
          }
        }
      }
    }
  }
}
