package services;

import java.util.PriorityQueue;
import java.util.Comparator;

public class ReminderService {
    private PriorityQueue<String> reminders;

    public ReminderService() {
        reminders = new PriorityQueue<>(Comparator.comparing(String::length));
    }

    public void addReminder(String reminder) {
        reminders.add(reminder);
    }

    public String getNextReminder() {
        return reminders.poll();
    }

    public void removeReminder(String reminder) {
        reminders.remove(reminder);
    }
}
