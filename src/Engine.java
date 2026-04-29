import java.util.*;
import java.io.*;

public class Engine {
    private Map<String, Room> World = new HashMap<>();
    private Room currentRoom;

    public void loadGame(String fileName) throws Exception {
        Scanner fileScanner = new Scanner(new File(fileName));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (line.startsWith("ROOM:")) {
                String name = line.split(":")[1];
                String desc = fileScanner.nextLine();
                Room room = new Room(name, desc);

                // Διάβασε τις εξόδους (π.χ. north:kitchen)
                String exitsLine = fileScanner.nextLine();
                String[] parts = exitsLine.split(",");
                for (String p : parts) {
                    String[] exit = p.split(":");
                    room.exits.put(exit[0], exit[1]);
                }
                World.put(name, room);
            }
        }
        currentRoom = World.values().iterator().next();
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + currentRoom.name);
            System.out.println(currentRoom.description);
            System.out.print("> ");
            String command = input.nextLine();

            if (command.startsWith("go ")) {
                String dir = command.substring(3);
                if (currentRoom.exits.containsKey(dir)) {
                    currentRoom = World.get(currentRoom.exits.get(dir));
                } else {
                    System.out.println("Δεν μπορείς να πας εκεί.");
                }
            } else if (command.equals("quit")) {
                break;}

              else if (command.equals("look")) {
                  System.out.println(currentRoom.description);
                }
             else {
                System.out.println("Άγνωστη εντολή.");
            }
        }
    }
}