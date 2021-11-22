package src;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.io.*;



/**
 * The daily planner class creates interactive interface
 * used to create, edit, and view events in planner
 * @author Jamel Clarke
 * @author Xavier Jones
 * @author Brianna Soto
 */
public class DailyPlanner extends JFrame implements ActionListener {

    /** Width of Frame */
    public static final int WIDTH = 400;

    /** Length of Frame */
    public static final int LENGTH = 150;

    /** Label to prompt user for the date */
    private JLabel lblGetDate = new JLabel("\t\tEnter Date: (MM/DD/YYYY)");

    /** Text field that holds requested date */
    private JTextField txtGetDate = new JTextField();

    /** Create event button */
    private JButton btnCreateEvent = new JButton("Create Event");

    /** Edit event button */
    private JButton btnEditEvent = new JButton("Edit Event");

    /** View event button */
    private JButton btnViewEvent = new JButton("View Event");

    /** Exit program button */
    private JButton btnExit = new JButton("Exit");

    ///** PrintWriter to putput events in a new file */
    private static PrintWriter write;

    /** Scanner to read through file */
    private static Scanner outputScnr;

    /** File input name */
    public static String filename;

    /** The substring's start interval for the first digit of the day in the date substring */
    public static final int DAY_START = 3;

    /** The substring's end interval for the second digit of the day in the date substring */
    public static final int DAY_END = 5;

    /** The substring's start interval for the first digit of the year in the date substring */
    public static final int YEAR_START = 6;

    /** The substring's end interval for the last digit of the year in the date substring */
    public static final int YEAR_END = 10;



    /**
     * Creates backround and buttons
     *
     */
    public DailyPlanner() throws FileNotFoundException {
        //Iniitializes JFrame with title "Daily Planner"
        super("Daily Planner");

        //Sets up print PrintWriter
        write = new PrintWriter("Updated_Plannner.txt");
        //Sets up frame size
        setSize(WIDTH,LENGTH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Need to create container in order to add components
        Container c = getContentPane();
        //Adds style and pizzaz
        c.setBackground(Color.pink);
        c.setForeground(Color.white);
        //Add a grid layout with 2 rows and 2 columns for 4 components
        c.setLayout(new GridLayout(3,2));
        //Changes fonts and colors of components
        lblGetDate.setForeground(Color.white);
        txtGetDate.setForeground(Color.pink);
        btnCreateEvent.setForeground(Color.pink);
        btnEditEvent.setForeground(Color.pink);
        btnViewEvent.setForeground(Color.pink);
        btnExit.setForeground(Color.pink);

        //Adds action listener to componenets
        btnCreateEvent.addActionListener(this);
        btnEditEvent.addActionListener(this);
        btnViewEvent.addActionListener(this);
        btnExit.addActionListener(this);

        //Adds components to frame\
        c.add(lblGetDate);
        c.add(txtGetDate);
        c.add(btnCreateEvent);
        c.add(btnEditEvent);
        c.add(btnViewEvent);
        c.add(btnExit);
        setVisible(true);
    }

    //Need to add this method in order to implement ActionListemer
    /**
     * Implements actionPerformed for buttons in the program
     * @param event the action performed when picking a button
     */
    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == btnExit) {
            System.exit(0);
        }

        if (Event.checkDateString(txtGetDate.getText())) {
            if (event.getSource() == btnCreateEvent) {
                if(Event.findDate(txtGetDate.getText()) == null){
                    CreateEventFrame createView = new CreateEventFrame(txtGetDate.getText());
                } else {
                    JOptionPane.showMessageDialog(null,
                                                "You already have an event scheduled on that day");
                }

            }
            if (event.getSource() == btnEditEvent) {
                Event selectedEvent = Event.findDate(txtGetDate.getText());
                if (selectedEvent != null) {
                    CreateEventFrame createView = new CreateEventFrame(selectedEvent);
                } else {
                    JOptionPane.showMessageDialog(null, "There are no events on this day");
                }
            }
            if (event.getSource() == btnViewEvent) {
                Event selectedEvent = Event.findDate(txtGetDate.getText());
                if (selectedEvent != null) {
                    ViewEventFrame viewEvent = new ViewEventFrame(selectedEvent);
                } else {
                    JOptionPane.showMessageDialog(null, "There are no events on this day");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Your date format is incorrect");
        }
    }

    /**
     * Creates the main display frame
     * @param args holds command line arguments
     */
    public static void main(String[]args) throws FileNotFoundException{
        //printing to the doc w/ new
            filename = "files/events.txt";
            outputScnr = new Scanner (new FileInputStream(filename));
            printEvents();
            DailyPlanner plannerFrame = new DailyPlanner();
        }

        

    /*
     * Reads through the inputted file and creates events based off of each line. Then is outputs
     * all of the original events and the new events into a new file.
     */
    public static void printEvents() throws FileNotFoundException{
        // turning the stuff from the file into events
        while (outputScnr.hasNextLine()) {
            //all day (denoted by an a at the beginning of the line)
            char allDayCheck = outputScnr.next().charAt(0);
            if (allDayCheck == 'a') {
                String fileDate = outputScnr.next();
                String fileDesc = outputScnr.nextLine();
                Event e = new Event(fileDate, fileDesc);
            } else {
                String fileDate = outputScnr.next();
                String fileStartTime = outputScnr.next();
                String fileEndTime = outputScnr.next();
                String fileDesc = outputScnr.nextLine();
                Event e = new Event(fileDate, fileStartTime, fileEndTime, fileDesc);
            }

        }

        //the literal output
        write = new PrintWriter(new FileOutputStream("files/UpdatedEvents.txt"));

        //For loop works weird w Arraylist so i jus swiched to a for each
        for(Event event : Event.events) {
            String date = event.getDate();
            if(event.getStartTime() != null) {
                write.print(("s " + event.getDate() + " " + event.getStartTime() +
                            " " + event.getEndTime() + " " +
                            event.getDescription() + "\n"));
            } else {
                write.print("a " + event.getDate() + " " + event.getDescription() + "\n");
            }
        }
        write.close();
        /*
        for(int i = 0; i < Event.events.length; i++) {
            String date = Event.events[i].getDate();
            if (Event.events[i] == null) write.print("");
            else{
                if (!(Event.events[i].getStartTime.equals(null))) {
                    write.print(date.substring(0,2) + "   " + date.substring(DAY_START,DAY_END) +
                                "   " + date.substring(YEAR_START,YEAR_END) + " " +
                                Event.events[i].getStartTime() + "\n" +
                                Event.events[i].getDescription() + "\n");
                }
                else {
                    write.print(date.substring(0,2) + "   " + date.substring(DAY_START,DAY_END) +
                                "   " +  date.substring(YEAR_START,YEAR_END) + "\n" +
                                Event.events[i].getDescription() + "\n");
                }
            }
        }
        */
    }

}
