public class PlayerCommand {
    private String mainCommand;
    private String additionalWord;

    public PlayerCommand(String mainCommand, String additionalWord) {
        this.mainCommand = mainCommand;
        this.additionalWord = additionalWord;
    }

    public boolean isUnknownCommand() {
        return mainCommand == null || mainCommand.isEmpty();
    }

    public String getMainCommand() {
        return mainCommand;
    }

    public String getAdditionalWord() {
        return additionalWord;
    }

    public boolean hasAdditionalWord() {
        return additionalWord != null && !additionalWord.isEmpty();
    }
}
