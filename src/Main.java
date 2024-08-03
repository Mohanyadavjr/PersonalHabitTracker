import gui.HabitTrackerGUI;
import services.HabitService;

public class Main {
    public static void main(String[] args) {
        HabitService habitService = new HabitService();
        new HabitTrackerGUI(habitService);
    }
}
