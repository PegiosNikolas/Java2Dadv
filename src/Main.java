public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        try {
            engine.loadGame("World.txt");
            engine.start();
        } catch (Exception e) {
            System.out.println("Σφάλμα κατά τη φόρτωση: " + e.getMessage());
        }
    }
}