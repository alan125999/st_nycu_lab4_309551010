import java.util.Arrays;

public class Game {
    private int player1 = -1, player2 = -1;

    private static int getGestureValue(String input) {
        switch (input) {
            case "rock": return 0;
            case "paper": return 1;
            case "scissors": return 2;
        }
        return -1;
    }

    public void setPlayer (int player, String input) throws IllegalArgumentException {
        int gesture = getGestureValue(input);
        if(gesture < 0) throw new IllegalArgumentException("Bad Choice!");

        switch (player) {
            case(1):
                player1 = gesture;
                break;
            case(2):
                player2 = gesture;
                break;
            default:
                throw new IllegalArgumentException("Bad Player!");
        }
    }

    public int judge () {
        int diff = player1 - player2;
        if(diff == 0) return 0;
        if(diff == 1 || diff == -2) return 1;
        return -1;
    }
}
