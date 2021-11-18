package src;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.*;

//TODO - Add JAVADOC (srry)
public class CreateEventFrame extends JFrame {

    //Enter Title:
    private JLabel lblEventTitlePrompt = new JLabel("\t\tEnter Event Title: ");
    private JTextField txtEventTitle = new JTextField();
    //Enter Date
    private JLabel lblEventDatePrompt = new JLabel("\t\tEnter Date: (MM/DD/YYYY)");
    private JTextField txtEventDate = new JTextField();
    //All day?
    private JLabel lblALlDayCheck = new JLabel("\t\tAll day");
    private JCheckBox checkAllDay = new JCheckBox();
    //Enter Start Time
    private JLabel lblStartTimePrompt = new JLabel("\t\tEnter Start Time (Ex: 15:00): ");
    private JTextField txtStartTime = new JTextField();
    //Enter End Time
    private JLabel lblEndTimePrompt = new JLabel("\t\tEnter End Time (Ex: 15:00): ");
    private JTextField txtEndTime = new JTextField();

    //Submit Button
    private JButton btnSubmit = new JButton("Submit");
    private JButton btnExit = new JButton("Exit");
    private JButton btnDelete = new JButton("Delete Event");

    //TODO - Add Action LIsteneres to the Frame Submit Buttons
    //TODO - Add Action Liseners to the checkbox to disable start/end time text fields when checked
    public CreateEventFrame() {
        // Creates JFrame with title "Create Event"
        super("Create Event");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,300);
        setResizable(false);
        Container c = getContentPane();
        c.setBackground(Color.pink);
        c.setForeground(Color.white);

        //5 Rows, 2 columns, 10px hor. space gap, 10px ver. space gap
        c.setLayout(new GridLayout(6,2,10,10));

        //Add components to container
        c.add(lblEventTitlePrompt);
        c.add(txtEventTitle);
        lblEventTitlePrompt.setForeground(Color.white);
        txtEventTitle.setForeground(Color.pink);

        c.add(lblEventDatePrompt);
        c.add(txtEventDate);
        lblEventDatePrompt.setForeground(Color.white);
        txtEventDate.setForeground(Color.pink);

        c.add(lblALlDayCheck);
        c.add(checkAllDay);
        lblALlDayCheck.setForeground(Color.white);

        c.add(lblStartTimePrompt);
        c.add(txtStartTime);
        lblStartTimePrompt.setForeground(Color.white);
        txtStartTime.setForeground(Color.pink);

        c.add(lblEndTimePrompt);
        c.add(txtEndTime);
        lblEndTimePrompt.setForeground(Color.white);
        txtEndTime.setForeground(Color.pink);

        c.add(btnSubmit);
        c.add(btnExit);
        btnExit.setForeground(Color.pink);
        btnSubmit.setForeground(Color.PINK);

        setVisible(true);
    }
    //Sets up an event to be edited
    public CreateEventFrame(Event event) {
        // Creates JFrame with title "Edit Event"
        super("Edit Event");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,300);
        setResizable(false);
        Container c = getContentPane();
        c.setBackground(Color.pink);
        c.setForeground(Color.white);

        //5 Rows, 2 columns, 10px hor. space gap, 10px ver. space gap
        c.setLayout(new GridLayout(6,2,10,10));

        //Add components to container
        c.add(lblEventTitlePrompt);
        c.add(txtEventTitle);
        lblEventTitlePrompt.setForeground(Color.white);
        txtEventTitle.setText(event.getDescription());
        txtEventTitle.setForeground(Color.pink);

        c.add(lblALlDayCheck);
        c.add(checkAllDay);
        lblALlDayCheck.setForeground(Color.white);
        checkAllDay.setSelected(event.startTime == null);
        
        c.add(lblStartTimePrompt);
        c.add(txtStartTime);
        lblStartTimePrompt.setForeground(Color.white);
        txtStartTime.setForeground(Color.pink);
        txtStartTime.setText(event.startTime);

        c.add(lblEndTimePrompt);
        c.add(txtEndTime);
        lblEndTimePrompt.setForeground(Color.white);
        txtEndTime.setForeground(Color.pink);
        txtEndTime.setText(event.endTime);
        c.add(btnSubmit);
        c.add(btnDelete);
        c.add(btnExit);
        btnSubmit.setForeground(Color.PINK);
        btnDelete.setForeground(Color.pink);
        btnExit.setForeground(Color.pink);

        setVisible(true);
    }

    public static void main(String[] args) {
       // CreateEventFrame frame = new CreateEventFrame();
        CreateEventFrame editFrame = new CreateEventFrame(new Event("05/20/2003","Xavier's Birthday"));
    }
}