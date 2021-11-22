package src;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This program creates the event Jframe
 *
 * @author Jamel Clarke
 * @author Xavier Jones
 * @author Brianna Soto
 *
 * @version 1.0
 */

public class CreateEventFrame extends JFrame implements ActionListener {

    /** Holds event that may be edited */
    private Event editedEvent;

    /** 'Enter Title' label */
    private JLabel lblEventTitlePrompt = new JLabel("\t\tEnter Event Title: ");

    /** 'Enter Title' text field */
    private JTextField txtEventTitle = new JTextField();

    /** 'Enter Date' label */
    private JLabel lblEventDatePrompt = new JLabel("\t\tEnter Date: (MM/DD/YYYY)");

    /** 'Enter Date' text field */
    private JTextField txtEventDate = new JTextField();

    /** 'All day?' label */
    private JLabel lblALlDayCheck = new JLabel("\t\tAll day");

    /** 'All day?' text field */
    private JCheckBox checkAllDay = new JCheckBox();

    /** 'Enter Start Time' label */
    private JLabel lblStartTimePrompt = new JLabel("\t\tEnter Start Time (Ex: 15:00): ");

    /** 'Enter Start Time' text field */
    private JTextField txtStartTime = new JTextField();

    /** 'Enter End Time' label */
    private JLabel lblEndTimePrompt = new JLabel("\t\tEnter End Time (Ex: 15:00): ");

    /** 'Enter End Time' text field */
    private JTextField txtEndTime = new JTextField();

    /** Submit button */
    private JButton btnSubmit = new JButton("Submit");

    /** Exit button */
    private JButton btnExit = new JButton("Exit");

    /** Delete event button */
    private JButton btnDelete = new JButton("Delete Event");

    /** Width of Frame */
    public static final int WIDTH = 500;

    /** Length of Frame */
    public static final int LENGTH = 300;

    /** Number of display grid rows */
    public static final int DISPLAY_ROWS = 6;

    /** Margin size */
    public static final int MARGIN_SIZE = 10;

    /**
     * Creates the create Event frame
     * @param date holds the date to create an event with
     */
    public CreateEventFrame(String date) {
        // Creates JFrame with title "Create Event"
        super("Create Event");
        System.out.println("Done");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH,LENGTH);
        setResizable(false);
        Container c = getContentPane();
        c.setBackground(Color.pink);
        c.setForeground(Color.white);

        //5 Rows, 2 columns, 10px hor. space gap, 10px ver. space gap
        c.setLayout(new GridLayout(DISPLAY_ROWS,2,MARGIN_SIZE,MARGIN_SIZE));

        //Add Action listeners to buttons
        btnSubmit.addActionListener(this);
        btnExit.addActionListener(this);
        checkAllDay.addActionListener(this);
        //Add components to container
        c.add(lblEventTitlePrompt);
        c.add(txtEventTitle);
        lblEventTitlePrompt.setForeground(Color.white);
        txtEventTitle.setForeground(Color.pink);

        c.add(lblEventDatePrompt);
        c.add(txtEventDate);
        lblEventDatePrompt.setForeground(Color.white);
        txtEventDate.setForeground(Color.pink);
        txtEventDate.setText(date);

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

    /**
     * Creates an create Event frame will the details of an inputted Event
     * @param event the Event that will have its details entered into the create Event frame
     */
    public CreateEventFrame(Event event) {

        // Creates JFrame with title "Edit Event"
        super("Edit Event");
        this.editedEvent = event;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH ,LENGTH);
        setResizable(false);
        Container c = getContentPane();
        c.setBackground(Color.pink);
        c.setForeground(Color.white);

        //5 Rows, 2 columns, 10px hor. space gap, 10px ver. space gap
        c.setLayout(new GridLayout(DISPLAY_ROWS,2,MARGIN_SIZE,MARGIN_SIZE));

        //Add Action listeners to buttons
        btnSubmit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnExit.addActionListener(this);
        checkAllDay.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == btnSubmit) {
            if (editedEvent == null) {
                if (!Event.checkDateString(txtEventDate.getText())) {
                    JOptionPane.showMessageDialog(null, "Your date is formatted incorrectly");
                } 
            }
            if (!checkAllDay.isSelected()) {
                if (!Event.checkTimeString(txtStartTime.getText())) {
                    JOptionPane.showMessageDialog(null, "Your start time is formatted incorrectly");
                } else if (!Event.checkTimeString(txtEndTime.getText())) {
                    JOptionPane.showMessageDialog(null, "Your end time is formatted incorrectly");
                } else {
                    if (editedEvent == null) {
                        Event newEvent = new Event(txtEventDate.getText(), 
                                        txtStartTime.getText(),
                                        txtEndTime.getText(),
                                        txtEventTitle.getText());
                    } else {
                        Event newEvent = new Event(editedEvent.getDate(), 
                                        txtStartTime.getText(),
                                        txtEndTime.getText(),
                                        txtEventTitle.getText());
                        Event.events.remove(editedEvent);
                    }
                    this.setVisible(false);
                    System.out.println(Event.events.toString());
                }
            } else {
                if (editedEvent == null) {
                    Event newEvent = new Event(txtEventDate.getText(), 
                                        txtEventTitle.getText());
                } else {
                    Event newEvent = new Event(editedEvent.getDate(), 
                                        txtEventTitle.getText());
                    Event.events.remove(editedEvent);
                }
                this.setVisible(false);
                System.out.println(Event.events.toString());
            }
        }
        if (event.getSource() == btnExit) {
            System.exit(0);
        }
        if (event.getSource() == btnDelete) {
            Event.events.remove(editedEvent);
            this.setVisible(false);
        }
        if (event.getSource() == checkAllDay) {
            if (checkAllDay.isSelected()) {
                System.out.println("Checked");
                txtStartTime.setEnabled(false);
                txtStartTime.setText("");
                txtEndTime.setEnabled(false);
                txtEndTime.setText("");
            } else {
                System.out.println("Unchecked");
                txtStartTime.setEnabled(true);
                txtEndTime.setEnabled(true);
            }
        }

        
    }

 

}
