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
    public void boardShouldBeUpdatedWhenXtakesSquareR1C1() {
        Board board = new Board();
        Player player = new Player();
        board.move(player,1,1);
        String b = board.toString();
        assert("X........".equals(b));
    }

}
