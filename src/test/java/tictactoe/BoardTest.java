package tictactoe;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    @Before
    public void before() {}

    @Test
    public void initalBoardShouldBeFilledWithDots() {
        Board board = new Board();
        String b = board.toString();
        assert(".........".equals(b));
    }

    @Test
    public void boardShouldBeUpdatedWhenPlayerMoves() {
        Board board = new Board();
        Player player = new Player();
        board.move(player,1,1);
        assert("X........".equals(board.toString()));
        board.move(player,2,2);
        assert("X...O....".equals(board.toString()));
    }

    @Test
    public void boardShouldReturnTrueWhenValidMove() {
        Board board = new Board();
        Player player = new Player();
        boolean validMove = board.move(player,1,1);
        assert(validMove == true);
    }

    @Test
    public void boardShouldReturnFalseWhenInvalidMove() {
        Board board = new Board();
        Player player = new Player();
        board.move(player,1,1);
        boolean validMove = board.move(player,1,1);
        assert(validMove == false);
    }

    @Test
    public void invalidMoveShouldNotChangeState() {
        Board board = new Board();
        Player player = new Player();

        board.move(player,1,1);
        String oldBoard = board.toString();
        String oldPlayer = player.getPlayer();
        board.move(player,1,1);
        String newBoard = board.toString();
        String newPlayer = player.getPlayer();
        assert(oldBoard.equals(newBoard));
        assert(oldPlayer.equals(newPlayer));
    }

    @Test
    public void gameOverShouldBeTrueWhen9MovesMade() {
        Board board = new Board();
        Player player = new Player();

        board.move(player,1,1);
        assert(board.isGameOver()==false);
        board.move(player,1,2);
        assert(board.isGameOver()==false);
        board.move(player,1,3);
        assert(board.isGameOver()==false);
        board.move(player,2,1);
        assert(board.isGameOver()==false);
        board.move(player,2,2);
        assert(board.isGameOver()==false);
        board.move(player,2,3);
        assert(board.isGameOver()==false);
        board.move(player,3,1);
        assert(board.isGameOver()==false);
        board.move(player,3,2);
        assert(board.isGameOver()==false);
        board.move(player,3,3);
        assert(board.isGameOver()==true);
    }

}
