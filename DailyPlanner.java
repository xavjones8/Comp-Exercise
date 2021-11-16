import java.util.*;

/**
* The event class creates an event object that holds the name, date and time for an event.
* @author Jamel Clarke
* @author Xavier Jones
* @author Brianna Soto
*/
public class DailyPlanner {

  public static void main(String[]args){
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






    }








}
