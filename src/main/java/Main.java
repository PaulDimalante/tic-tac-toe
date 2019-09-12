import tictactoe.Board;
import tictactoe.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Player player = new Player();
        player.displayCurrentPlayer();
        board.displayBoard();
        while (! board.isGameOver()) {
            board.promptMove(scanner, player);
            player.displayCurrentPlayer();
            board.displayBoard();
        }
    }
}
