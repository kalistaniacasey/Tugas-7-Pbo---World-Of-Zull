import java.util.Scanner;

public class InputParser {
    private Scanner scanner;

    public InputParser() {
        scanner = new Scanner(System.in);
    }

    public PlayerCommand fetchCommand() {
        System.out.print("> ");
        String input = scanner.nextLine().toLowerCase().trim();
        String[] words = input.split(" ");
        String mainCommand = words[0];
        String additionalWord = (words.length > 1) ? words[1] : null;
        return new PlayerCommand(mainCommand, additionalWord);
    }

    public void showHelp() {
        System.out.println("You can move around using directional commands.");
        System.out.println("Your available commands are: move, exit, info");
    }
}
