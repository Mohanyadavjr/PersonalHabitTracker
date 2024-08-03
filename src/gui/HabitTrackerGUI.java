package gui;

import models.Habit;
import services.HabitService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HabitTrackerGUI {
    private HabitService habitService;

    public HabitTrackerGUI(HabitService habitService) {
        this.habitService = habitService;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Personal Habit Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel habitLabel = new JLabel("Enter Habit:");
        JTextField habitField = new JTextField(20);
        JButton addButton = new JButton("Add Habit");
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String habitName = habitField.getText();
                if (!habitName.isEmpty()) {
                    Habit newHabit = new Habit(habitName, "Habit description");
                    habitService.addHabit(newHabit);
                    habitField.setText("");
                    JOptionPane.showMessageDialog(frame, "Habit added!");
                }
            }
        });

        frame.add(habitLabel);
        frame.add(habitField);
        frame.add(addButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        HabitService habitService = new HabitService();
        new HabitTrackerGUI(habitService);
    }
}
