public class AdventureGame {
    private Location currentLocation;
    private InputParser parser;
    private boolean isGameRunning;

    public AdventureGame() {
        initializeLocations();
        parser = new InputParser();
        isGameRunning = true;
    }

    private void initializeLocations() {
        Location field = new Location("in an open field outside the school");
        Location hall = new Location("in the main hall of the school");
        field.setExit("north", hall);
        hall.setExit("south", field);
        currentLocation = field;
    }

    public void startGame() {
        System.out.println("Welcome to the adventure game!");
        System.out.println("This is a simple text-based game.");
        System.out.println("Type 'info' for assistance.");
        play();
    }

    private void play() {
        while (isGameRunning) {
            System.out.println(currentLocation.getDescription());
            currentLocation.displayExits();
            PlayerCommand command = parser.fetchCommand();
            isGameRunning = executeCommand(command);
        }
        System.out.println("Thanks for playing! Goodbye.");
    }

    private boolean executeCommand(PlayerCommand command) {
        if (command.isUnknownCommand()) {
            System.out.println("Invalid command!");
            return true;
        }
        String mainCommand = command.getMainCommand();
        if (mainCommand.equals("info")) {
            parser.showHelp();
        } else if (mainCommand.equals("move")) {
            movePlayer(command);
        } else if (mainCommand.equals("exit")) {
            return false;
        }
        return true;
    }

    private void movePlayer(PlayerCommand command) {
        if (!command.hasAdditionalWord()) {
            System.out.println("Where do you want to move?");
            return;
        }
        String direction = command.getAdditionalWord();
        Location nextLocation = currentLocation.getExit(direction);
        if (nextLocation == null) {
            System.out.println("You can't move in that direction!");
        } else {
            currentLocation = nextLocation;
        }
    }
}
