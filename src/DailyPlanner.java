package src;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* The event class creates an event object that holds the name, date and time for an event.
* @author Jamel Clarke
* @author Xavier Jones
* @author Brianna Soto
*/
public class DailyPlanner extends JFrame{
  
  private JButton btnCreateEvent = new JButton("Create Event");
  private JButton btnEditEvent = new JButton("Edit Event");
  private JButton btnViewEvent = new JButton("View Event");
  private JButton btnExit = new JButton("Exit");

  //TODO - Add Action Listeners for buttons
  public DailyPlanner(){
    super("Daily Planner");
    setSize(300,150);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setBackground(Color.pink);
    c.setForeground(Color.white);
    c.setLayout(new GridLayout(2,2));
    btnCreateEvent.setForeground(Color.pink);
    btnEditEvent.setForeground(Color.pink);
    btnViewEvent.setForeground(Color.pink);
    btnExit.setForeground(Color.pink);

    c.add(btnCreateEvent);
    c.add(btnEditEvent);
    c.add(btnViewEvent);
    c.add(btnExit);
    setVisible(true);
  }
  /*
  //Main Screen Components
  private JLabel lblAppTitle = new JLabel("Daily Planner");
  private JButton btnCreateEvent  = new JButton("Create an Event");
  private JButton btnEditEvent = new JButton("Edit an Event");
  private JButton btnViewEvent = new JButton("View an Event");
  private JButton btnExitPlanner = new JButton("Exit");

  //Create/ Edit Screen Components
  private JLabel lblCreateHeader = new JLabel("Create an Event");
  private JLabel lblEditHeader = new JLabel("Edit an Event");
  private JLabel lblViewHeader = new JLabel("View an Event");
  //Enter Title:
  private JLabel lblEventTitlePrompt = new JLabel("Enter Event Title: ");
  private JTextField txtEventTitle = new JTextField("Event title",20);
  //Enter Date
  private JLabel lblEventDatePrompt = new JLabel("Enter Date: (MM/DD/YYYY)");
  private JTextField txtEvenDate = new JTextField(10);
  //All day?
  private JLabel lblALlDayCheck = new JLabel("All day");
  private JCheckBox checkAllDay = new JCheckBox();
  //Enter Start Time
  private JLabel lblStartTimePrompt = new JLabel("Enter Start Time (Ex: 15:00): ");
  private JTextField txtStartTime = new JTextField(5);
  //Enter End Time
  private JLabel lblEndTimePrompt = new JLabel("Enter End Time (Ex: 15:00): ");
  private JTextField txtEndTime = new JTextField(5);
  
  //View Screen Componenets
  private JLabel lblViewEventTitle = new JLabel();
  private JLabel lblViewEventDate = new JLabel();
  private JLabel lblViewEventStartTime = new JLabel();
  private JLabel lblViewEventEndTime = new JLabel();

  //JFrames
  private JFrame 
  */
  public static void main(String[]args){
    DailyPlanner plannerFrame = new DailyPlanner();
    /*
    Scanner scnr = new Scanner(System.in);
    boolean executedOnce = false;

    System.out.println("Daily Planner - Please choose an option\n\nCreate New Event (Enter C)\n" +
                       "View Event (Enter V)\nExit (Enter E)\n\nOption: ");
    String option = scnr.next();

    if (!(option.equals("C") || option.equals("c") || option.equals("V")
    || option.equals("v") || option.equals("E") || option.equals("e"))){
      System.out.println("Invalid option\n");
    }

    while (!(option.equals("E") || option.equals("e"))){
     if (executedOnce){
         System.out.println("Daily Planner - Please choose an option\n\nCreate New Event (Enter C)\n" +
                            "View Event (Enter V)\nExit (Enter E)\n\nOption: ");
       option = scnr.nextLine();

       if (!(option.equals("C") || option.equals("c") || option.equals("V")
       || option.equals("v") || option.equals("E") || option.equals("e"))){
         System.out.println("Invalid option\n");
         scnr.nextLine();
         executedOnce = true;
         continue;

       }
      }

    }
    if (option.equals("C") || option.equals("c")){
      String event;
      int date;

      System.out.print("Enter event Title: ");
      event = scnr.nextLine();
      scnr.nextLine();


      try {
        System.out.print("Enter Date (MM/DD/YYYY): ");
        date = scnr.nextInt();
      }

      catch (InputMismatchException e) {
          System.out.println("Invalid date");
          System.out.println();
          scnr.nextLine();
          executedOnce = true;
          continue;
      }

      scnr.nextLine();

      System.out.print("All Day? (Y/N)");
      allDay = scnr.next();

      if (allDay.equals("n") || allDay.equals("N")){

      }
 */





    }








}
