import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean team1 = team1(input);
    boolean team2 = team2(team1);

    boolean turn1;

    String[] board = new String[9];

    int fullBoard;
    boolean x = true;
    while (x) {
      fullBoard = 0;
      turn1 = true;
      int place1 = placement1(input);
      printBoard(turn1, board, place1, team1);

      boolean winner = winner(board);

      if (place1 > 9 || place1 < 1) {
        System.out.println("invalid");
        x = false;
      }
      if (winner == false) {
        boolean replay = replay(input);
        if (replay == false) {
          break;
        } else {
          resetBoard(board);
          continue;
        }
      }
      turn1 = false;
      place1 = placement1(input);

      for (int j = 0; j < board.length; j++) {
        if (!(board[j].equals("[ ]")) && winner == false) {
          fullBoard += 1;
          System.out.print("fullboard value: " + fullBoard);
        }
        if (fullBoard == 9) {
          System.out.println("board is full, no winner, its a draw!");
          boolean replay = replay(input);
          if (replay == false) {
            break;
          } else {
            fullBoard = 0;
            resetBoard(board);
            continue;
          }
        }
      }
      printBoard(turn1, board, place1, team1);

    }

  }

  public static void printBoard(boolean turn1, String board[], int place, boolean team1) {
    for (int i = 0; i < board.length; i++) {
      if (i % 3 == 0 && i != 0) {
        System.out.println();
      }

      if (turn1 == true) {
        if (team1 == false) {
          board[place - 1] = "[O]";
        } else {
          board[place - 1] = "[X]";
        }
      }

      else {
        if (team1 == false) {
          board[place - 1] = "[X]";
        } else {
          board[place - 1] = "[O]";
        }
      }

      if (board[i] == null) {
        board[i] = "[ ]";
      }

      System.out.print(board[i]);
    }
    System.out.println();
  }

  public static boolean team1(Scanner input) {
    System.out.print("is player 1 X or O? ");
    String userTeam = input.next();
    if (userTeam.toLowerCase().equals("x")) {
      return true;
    } else if (userTeam.toLowerCase().equals("o")) {
      return false;
    } else {
      System.out.println("invalid team, player 1 is now O");
      return false;
    }
  }

  public static boolean team2(boolean team1) {
    if (team1 == false) {
      System.out.println("player 2 is X");
      return true;
    } else {
      System.out.println("player 2 is O");
      return false;
    }
  }

  public static int placement1(Scanner input) {
    System.out.print("where do you want to place? (1-9) ");
    int pos = input.nextInt();
    return pos;
  }

  public static boolean winner(String[] board) {
    if (board[0].equals(board[1]) && board[0].equals(board[2]) && board[0] != "[ ]") {
      System.out.println("player wins! top across");
      return false;
    } else if (board[3].equals(board[4]) && board[3].equals(board[5]) && board[3] != "[ ]") {
      System.out.println("player wins! middle across");
      return false;
    } else if (board[6].equals(board[7]) && board[6].equals(board[8]) && board[6] != "[ ]") {
      System.out.println("player wins! bottom across");
      return false;
    } else if (board[0].equals(board[3]) && board[3].equals(board[6]) && board[0] != "[ ]") {
      System.out.println("player wins! left down");
      return false;
    } else if (board[0].equals(board[4]) && board[0].equals(board[8]) && board[0] != "[ ]") {
      System.out.println("player wins! \\ diagonal");
      return false;
    } else if (board[1].equals(board[4]) && board[1].equals(board[7]) && board[1] != "[ ]") {
      System.out.println("player wins! middle down");
      return false;
    } else if (board[2].equals(board[5]) && board[5].equals(board[8]) && board[5] != "[ ]") {
      System.out.println("player wins! right down");
      return false;
    } else if (board[2].equals(board[4]) && board[2].equals(board[6]) && board[2] != "[ ]") {
      System.out.println("player wins! // diagonal");
      return false;
    } else {
      return true;
    }

  }

  public static boolean replay(Scanner input) {
    System.out.print("do you want to play again? ");
    String answer = input.next();
    if (answer.contains("y") || answer.contains("Y")) {
      System.out.println("gotchu");
      return true;
    } else if (answer.contains("n") || answer.contains("N")) {
      System.out.println("cool, bye!");
      return false;
    } else {
      System.out.println("invalid, assuming false, bye!");
      return false;
    }
  }

  public static void resetBoard(String[] board) {
    for (int i = 0; i < board.length; i++) {
      board[i] = null;
    }
  }
}