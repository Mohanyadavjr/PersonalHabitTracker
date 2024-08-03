package services;

import models.Habit;
import models.HabitEntry;
import java.util.LinkedList;
import java.util.HashMap;
import java.time.LocalDate;

public class HabitService {
    private LinkedList<Habit> habits;
    private HashMap<Habit, LinkedList<HabitEntry>> habitEntries;

    public HabitService() {
        habits = new LinkedList<>();
        habitEntries = new HashMap<>();
    }

    public void addHabit(Habit habit) {
        habits.add(habit);
        habitEntries.put(habit, new LinkedList<>());
    }

    public void removeHabit(Habit habit) {
        habits.remove(habit);
        habitEntries.remove(habit);
    }

    public void displayHabits() {
        for (Habit habit : habits) {
            System.out.println(habit.getName() + ": " + habit.getDescription());
        }
    }

    public void markHabitCompleted(Habit habit, LocalDate date) {
        HabitEntry entry = new HabitEntry(habit, date, true);
        habitEntries.get(habit).add(entry);
    }

    public void markHabitIncomplete(Habit habit, LocalDate date) {
        HabitEntry entry = new HabitEntry(habit, date, false);
        habitEntries.get(habit).add(entry);
    }

    public int calculateLongestStreak(Habit habit) {
        LinkedList<HabitEntry> entries = habitEntries.get(habit);
        int longestStreak = 0, currentStreak = 0;
        LocalDate previousDate = null;

        for (HabitEntry entry : entries) {
            if (entry.isCompleted()) {
                if (previousDate != null && entry.getDate().equals(previousDate.plusDays(1))) {
                    currentStreak++;
                } else {
                    currentStreak = 1;
                }
                previousDate = entry.getDate();
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
