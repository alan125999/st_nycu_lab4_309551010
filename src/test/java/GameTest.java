import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();


    private static Stream<Arguments> judgeArgProvider() {
        return Stream.of(
                // Player 1 win
                Arguments.of(new String[]{"scissors", "paper"}, 1, "Player 1 win"),
                Arguments.of(new String[]{"paper", "rock"}, 1, "Player 1 win"),
                Arguments.of(new String[]{"rock", "scissors"}, 1, "Player 1 win"),

                // Player 2 win
                Arguments.of(new String[]{"paper", "scissors"}, -1, "Player 2 win"),
                Arguments.of(new String[]{"rock", "paper"}, -1, "Player 2 win"),
                Arguments.of(new String[]{"scissors", "rock"}, -1, "Player 2 win"),

                // Draw
                Arguments.of(new String[]{"rock", "rock"}, 0, "Draw"),
                Arguments.of(new String[]{"paper", "paper"}, 0, "Draw"),
                Arguments.of(new String[]{"scissors", "scissors"}, 0, "Draw")
        );
    }
    @ParameterizedTest(name = "Test #{index} - Test {2} with Argument = {0}")
    @MethodSource("judgeArgProvider")
    void judgeTest(String [] players, int expectedResult, String _comment) {
        for(int i = 1; i <= 2; i++) game.setPlayer(i, players[i - 1]);
        assertEquals(game.judge(), expectedResult);
    }

    private static Stream<Arguments> validateArgProvider() {
        return Stream.of(
                // Normal Gesture
                Arguments.of("rock", 1, true),
                Arguments.of("paper", 1, true),
                Arguments.of("scissors", 1, true),
                Arguments.of("rock", 2, true),
                Arguments.of("paper", 2, true),
                Arguments.of("scissors", 2, true),

                // Invalid Gesture
                Arguments.of("stone", 1, false),
                Arguments.of("papers", 2, false),
                Arguments.of("", 1, false),
                Arguments.of(" scissors ", 2, false),

                // Invalid Player
                Arguments.of("rock", 0, false),
                Arguments.of("paper", -1, false),
                Arguments.of("scissors", 3, false)
        );
    }
    @ParameterizedTest(name = "Test #{index} - Test Player {1} with Argument = {0}")
    @MethodSource("validateArgProvider")
    void validateTest(String gesture, int player, boolean expectedResult) {
        if(expectedResult) assertDoesNotThrow(() -> game.setPlayer(player, gesture));
        else assertThrows(IllegalArgumentException.class, () -> game.setPlayer(player, gesture));
    }
}