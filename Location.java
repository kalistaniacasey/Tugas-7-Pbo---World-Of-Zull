import java.util.HashMap;

public class Location {
    private String description;
    private HashMap<String, Location> exits;

    public Location(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Location location) {
        exits.put(direction, location);
    }

    public String getDescription() {
        return description;
    }

    public void displayExits() {
        System.out.print("Available directions: ");
        for (String exit : exits.keySet()) {
            System.out.print(exit + " ");
        }
        System.out.println();
    }

    public Location getExit(String direction) {
        return exits.get(direction);
    }
}
