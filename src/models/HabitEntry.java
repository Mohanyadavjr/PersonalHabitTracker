package models;

import java.time.LocalDate;

public class HabitEntry {
    private Habit habit;
    private LocalDate date;
    private boolean isCompleted;

    public HabitEntry(Habit habit, LocalDate date, boolean isCompleted) {
        this.habit = habit;
        this.date = date;
        this.isCompleted = isCompleted;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
