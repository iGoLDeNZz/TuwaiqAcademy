import java.util.*;

public class Main {
    static Set<Integer> playedMoves = new HashSet<Integer>();
    static boolean isFinished = false;
    static boolean isWinner = false;
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


            //Check if game finished
        }

        // Show winner
    }

    static void playerMove(){
        //take move
        System.out.println("Where would you like to play? (1-9)");
        move = scanner.nextInt() - 1;// To fix the index difference (0-8) and (1-9) between player and code.

        if (isValidMove(move)){
            playedMoves.add(move);
            makeMove(move);
        } else
            System.out.println("Invalid move please make a move from (1-9) and not in an already played spot.");

    }

    static void computerMove(){

        Random random = new Random();
        boolean isValidMove = false;
        int randomMove = -1;
        while (!isValidMove){
            randomMove = 0 + random.nextInt(8 - 0 + 1);
            if(!playedMoves.contains(randomMove))
                isValidMove = true;
        }
        playedMoves.add(randomMove);
        makeMove(randomMove);
    }

    static void makeMove(int place){
        isValidMove(place);

    }

    static boolean isValidMove(int place){
        if((place >= 0 && place <= 8) && !playedMoves.contains(place))
            return true;
        return false;
    }

    static void displayBoard(){
        for (char[] row: board){
            for (char character : row)
                System.out.print(character);
            System.out.println();
        }
    }
}