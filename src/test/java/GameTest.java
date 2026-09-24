import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    public void shouldWinFirstPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Алексей", 100);
        Player player2 = new Player(2, "Иван", 50);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Алексей", "Иван");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Алексей", 50);
        Player player2 = new Player(2, "Иван", 100);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Алексей", "Иван");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Алексей", 100);
        Player player2 = new Player(2, "Иван", 100);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Алексей", "Иван");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWhenFirstPlayerNotRegistered() {
        Game game = new Game();
        Player player2 = new Player(2, "Иван", 100);

        game.register(player2);

        assertThrows(
                NotRegisteredException.class,
                () -> game.round("Алексей", "Иван")
        );
    }

    @Test
    public void shouldThrowExceptionWhenSecondPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Алексей", 100);

        game.register(player1);

        assertThrows(
                NotRegisteredException.class,
                () -> game.round("Алексей", "Иван")
        );
    }
}