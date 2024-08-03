package utilities;

import models.Habit;
import models.HabitEntry;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.LinkedList;

public class AnalyticsUtils {
    public static double calculateCompletionRate(Habit habit, HashMap<Habit, LinkedList<HabitEntry>> habitEntries, LocalDate startDate, LocalDate endDate) {
        LinkedList<HabitEntry> entries = habitEntries.get(habit);
        int totalDays = 0, completedDays = 0;

        for (HabitEntry entry : entries) {
            if (!entry.getDate().isBefore(startDate) && !entry.getDate().isAfter(endDate)) {
                totalDays++;
                if (entry.isCompleted()) {
                    completedDays++;
                }
            }
        }

        return totalDays == 0 ? 0 : (double) completedDays / totalDays;
    }
}
