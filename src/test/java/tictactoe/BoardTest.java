package tictactoe;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    @Before
    public void before() {}

    @Test
    public void initalBoardShouldBe3by3FilledWithDots() {
        Board board = new Board();
        assert("........." == board.toString());
    }
}
