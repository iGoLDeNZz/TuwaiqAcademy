import java.util.*;

public class Main {
    static Set<Integer> playedMoves = new HashSet<Integer>();
    static boolean isFinished = false;
    static boolean isWinner = false;
    static String winner = "none";
    static String currentPlayer = "player";
    static int move = -1;
    static Scanner scanner = new Scanner(System.in);

    static char[][] board = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
    };
    public static void main(String[] args) {

        displayBoard();

        while(!isFinished){

            //Take move
            if (currentPlayer.equals("player"))
                playerMove();
            else
                computerMove();

            checkWinner();
            isGameFinished();
        }

        // Show winner
    }

    static void playerMove(){
        //take move
        System.out.println("Where would you like to play? (1-9)");
        move = scanner.nextInt() - 1;// To fix the index difference (0-8) and (1-9) between player and code.

        if (isValidMove(move)){
            playedMoves.add(move);
            makeMove(move, 'X');
        } else
            System.out.println("Invalid move please make a move from (1-9) and not in an already played spot.");

    }

    static void computerMove(){

        Random random = new Random();
        boolean isValidMove = false;
        int randomMove = -1;
        while (!isValidMove){
            randomMove = 0 + random.nextInt(8 - 0 + 1);
            isValidMove = isValidMove(randomMove);
        }
        playedMoves.add(randomMove);
        System.out.println("The computer move index is: "+ randomMove);
        makeMove(randomMove, 'O');
    }

    static void makeMove(int place, char sympol){

        updateBoard(place, sympol);
        displayBoard();

        currentPlayer = currentPlayer == "player" ? "computer" : "player";
    }

    static boolean isValidMove(int place){
        if((place >= 0 && place <= 8) && !playedMoves.contains(place))
            return true;
        return false;
    }

    static void checkWinner(){
        if (checkWinnerIfAny() == "player") {
            System.out.println("You win!");
            isFinished = true;
            isWinner = true;
            winner = "player";
        }
        else if (checkWinnerIfAny() == "computer") {
            System.out.println("Computer wins!");
            isFinished = true;
            isWinner = true;
            winner = "computer";
        }
    }

    static void isGameFinished(){
        if (playedMoves.size() == 9){
            isFinished = true;
        }
    }

    static void displayBoard(){
        for (char[] row: board){
            for (char character : row)
                System.out.print(character);
            System.out.println();
        }
    }

    static void updateBoard(int place, char symbol){

        switch (place){
            case 0:
                board[0][0] = symbol;
                break;
            case 1:
                board[0][2] = symbol;
                break;
            case 2:
                board[0][4] = symbol;
                break;
            case 3:
                board[2][0] = symbol;
                break;
            case 4:
                board[2][2] = symbol;
                break;
            case 5:
                board[2][4] = symbol;
                break;
            case 6:
                board[4][0] = symbol;
                break;
            case 7:
                board[4][2] = symbol;
                break;
            case 8:
                board[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    static String checkWinnerIfAny(){

        for (int i = 0; i < 8; i++) {
            String lineSympols = "";
            switch (i){
                case 0:
                    lineSympols = board[0][0] +""+ board[0][2] +""+ board[0][4];
                    break;
                case 1:
                    lineSympols = board[2][0] +""+ board[2][2] +""+ board[2][4];
                    break;
                case 2:
                    lineSympols = board[4][0] +""+ board[4][2] +""+ board[4][4];
                    break;
                case 3:
                    lineSympols = board[0][0] +""+ board[2][0] +""+ board[4][0];
                    break;
                case 4:
                    lineSympols = board[0][2] +""+ board[2][2] +""+ board[4][2];
                    break;
                case 5:
                    lineSympols = board[0][4] +""+ board[2][4] +""+ board[4][4];
                    break;
                case 6:
                    //Diagonal 1
                    lineSympols = board[0][0] +""+ board[2][2] +""+ board[4][4];
                    break;
                case 7:
                    //Diagonal 2
                    lineSympols = board[0][4] +""+ board[2][2] +""+ board[4][0];
                    break;
            }
            if (lineSympols.equals("XXX"))
                return "player";
            else if (lineSympols.equals("OOO"))
                return "computer";
        }
        return "none";
    }
}