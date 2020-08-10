import java.util.Arrays;
import java.util.Scanner;
public class TicTacToe {
    static String[] board;
     static char turn;
    static String player1;
    static String player2;

    public static void main(String[] args) {
        Scanner ob= new Scanner(System.in);
        board = new String[9];
        String winner = null;
        CreateEmptyBoard();
        System.out.println("Welcome to this two Player Tic Tac Toe Game \n \t \t \t \t Designed by:-Vatsal Gupta  ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hope you enjoy");
        System.out.println("********************************************");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Please enter you names :");
        System.out.print("player 1: ");
        player1 = ob.nextLine();
        System.out.print("player 2: ");
        player2 = ob.nextLine();
        PrintBoard();
        turn = player1.charAt(0);
        System.out.println("hey it's "+player1+"'s turn so choose a slot to fill your mark");
        while (winner == null) //this while loop is implemented till the time  winner is fixed in the string or the match comes to a draw
        {
            int numInput;
            numInput = ob.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Sorry, you have entered a wrong number kindly enter a number in the range of 1-9");
                    continue;
                }
            if (board[numInput-1].equals(String.valueOf(numInput))) {   // this checks that the number is there on the board or not if it is replaced by the character of either of the first character of the players then it will not go through this loop
                board[numInput-1] = String.valueOf(turn);
                if (turn==(player1.charAt(0))) turn = player2.charAt(0);
                else turn = player1.charAt(0);
                PrintBoard();
                winner = checkWinner();
            } else {
                System.out.println("Hey, Sorry but the slot's already taken!, please reenter the slot a with a number on it:");
                continue;
            }
        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("Hey, it's a win-in or a loose-loose (It's a draw)! Please be a sport and run this program again to find the real winner.");
        } else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
    }

    static String checkWinner() { // this method adds the characters diagonally vertically and horizontally for each iteration and checks wether a line of same character is formed or not
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return player1;
            } else if (line.equals("OOO")) {
                return player2;
            }
        }

        for (int a = 0; a < 9; a++) { // this for loop first uses collection api to implement  array as a list to check that all the boxes are filled or not. If a is keep on being iterated it's end value will be 8 hich shows all the boxes are filled and winner is still not decided hence draw
            if (Arrays.asList(board).contains(String.valueOf(a+1))) {
                break;
            }
            else if (a == 8) return "draw";
        }
        if(turn==player1.charAt(0))  System.out.println("it's "+player1 + "'s turn enter a slot number to place " + turn + " in:");
        if(turn==player2.charAt(0))  System.out.println("it's "+player2 + "'s turn enter a slot number to place " + turn + " in:");
        return null;
    }

    static void PrintBoard() {  // this is just a normal visualization of the board
        System.out.println("/---|---|---\\");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("/---|---|---\\");
    }

    static void CreateEmptyBoard() {  // this method creates an emptyboard
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a+1);
        }
    }
}