import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String player1, player2;
        var scanner = new Scanner(System.in);
        var game = new Game();

        try {
            // Welcome Message
            System.out.println("=== Welcome to Rock-Paper-Scissors game ===");

            // Player 1
            System.out.println("Enter Player 1 choice (rock, paper, or scissors)");
            player1 = scanner.nextLine().split(" ")[0];
            game.setPlayer(1, player1);

            // Player 2
            System.out.println("Enter Player 2 choice (rock, paper, or scissors)");
            player2 = scanner.nextLine().split(" ")[0];
            game.setPlayer(2, player2);

        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }

        int result = game.judge();
        switch (result) {
            case(1):
                System.out.println("Player 1 win!");
                break;
            case(-1):
                System.out.println("Player 2 win!");
                break;
            default:
                System.out.println("Draw!");
        }

        scanner.close();
    }
}
