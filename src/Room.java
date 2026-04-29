import java.util.HashMap;

public class Room {
    public String name;
    public String description;
    public HashMap<String, String> exits = new HashMap<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
}