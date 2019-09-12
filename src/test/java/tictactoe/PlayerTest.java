package tictactoe;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    @Before
    public void before() {}

    @Test
    public void initalPlayerShouldBeX() {
        Player player = new Player();
        assert("X" == player.move());
    }

    @Test
    public void playerShouldBeOafterXmoves() {
        Player player = new Player();
        player.move();
        assert("O" == player.move());
    }
}
