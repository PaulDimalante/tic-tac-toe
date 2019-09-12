package tictactoe;

import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private Board board;
    private Player player;

    public Game() {
        super();
        this.scanner = new Scanner(System.in);
        this.board = new Board();
        this.player = new Player();
    }

    public void play() {
        player.displayCurrentPlayer();
        board.displayBoard();
        while (! board.isGameOver()) {
            board.promptMove(scanner, player);
            player.displayCurrentPlayer();
            board.displayBoard();
        }
        board.displayWinner();
    }
}
