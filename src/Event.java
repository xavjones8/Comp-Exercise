package src;
import java.util.*;

/**
* The event class creates an event object that holds the name, date and time for an event.
* @author Jamel Clarke
* @author Xavier Jones
* @author Brianna Soto
* @version 1.0
*/
public class Event {

    //Class Constants
    /** Most days a month can have */
    public static final int LONGEST_MONTH_DATE = 31;

    /** Days in April */
    public static final int MID_MONTH_LENGTH = 30;

    /** Least amount of days a month can have */
    public static final int SHORTEST_MONTH_LENGTH = 28;

    /** Number of minutes in an hour */
    public static final int SIXTY_MINS = 60;

    /** Index of semicolon in a time string */
    public static final int TIME_SEMICOLON_INDEX = 2;

    /** The index of the beginning of the minute integer */
    public static final int MINUTE_START_INDEX = 3;

    /** The index of the end of the minute integer */
    public static final int MINUTE_END_INDEX = 5;

    /** Length of a time string */
    public static final int LENGTH_OF_TIME_STRING = 5;

    /** The index for a slash in the date substring */
    public static final int SLASH_INDEX = 5;

    /** The substring's start interval for the first digit of the day in the date substring */
    public static final int DAY_START = 3;

    /** The substring's end interval for the second digit of the day in the date substring */
    public static final int DAY_END = 5;

    /** The substring's start interval for the first digit of the year in the date substring */
    public static final int YEAR_START = 6;

    /** The substring's end interval for the last digit of the year in the date substring */
    public static final int YEAR_END = 10;

    /** The maximuim length of the date substring */
    public static final int DATE_LENGTH_MAX = 10;

    /** Date of event */
    String date;

    /** Start time for event */
    String startTime = null;

    /** End time for event */
    String endTime = null;

    /** eventDescription of event */
    String eventDescription;

    /** Whether the user has plans for that day or not */
    boolean noPlans;

    /** Whether the user has overlapping plans for that day or not */
    boolean isOverlapping;

    /** Holds all events in the program */
    public static Event[] events = new Event[20];



    /**
     * Constructs an event object using an inputted date, start time, end time, and eventDescription.
     * @param date is the date entered by user
     * @param startTime the beginning time to the event entered by user
     * @param endTime the end timeof the event entered by user
     * @param eventDescription the eventDescription of the event entered by user
     * @throws IllegalArgumentException if date, start or end times are formatted incorrectly.
     */
    public Event(String date, String startTime, String endTime, String eventDescription) {
        //Test fidelity of date string XX/XX/XXXX
        if(date.length() != DATE_LENGTH_MAX ) throw new IllegalArgumentException("Invalid Date");
        if((date.charAt(2) != '/') || (date.charAt(SLASH_INDEX) != '/')){
            throw new IllegalArgumentException("Invalid Date");
        }
        try {
            Integer.parseInt(date.substring(0,2));
            Integer.parseInt(date.substring(DAY_START,DAY_END));
            Integer.parseInt(date.substring(YEAR_START,YEAR_END));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid Date");
        }
        this.date = date;

        //Tests fidelity of startTime
        if(startTime.length() != LENGTH_OF_TIME_STRING) {
            throw new IllegalArgumentException("Invalid Start Time");
        }
        if(startTime.charAt(TIME_SEMICOLON_INDEX) != ':') {
            throw new IllegalArgumentException("Invalid Start Time");
        }
        try {
            int hours = Integer.parseInt(startTime.substring(0,2));
            int minutes = Integer.parseInt(startTime.substring(MINUTE_START_INDEX, MINUTE_END_INDEX));
            //if((hours))
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid Start Time");
        }
        this.startTime = startTime;

        //Tests fidelity of endTime string
        if(endTime.length() != LENGTH_OF_TIME_STRING) {
            throw new IllegalArgumentException("Invalid End Time");
        }
        if(endTime.charAt(TIME_SEMICOLON_INDEX) != ':') {
            throw new IllegalArgumentException("Invalid End Time");
        }
        try {
            Integer.parseInt(endTime.substring(0,2));
            Integer.parseInt(endTime.substring(MINUTE_START_INDEX, MINUTE_END_INDEX));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid End Time");
        }
        this.endTime = endTime;

        this.eventDescription = eventDescription;
        for(int i = 0; i < events.length; i++) {
            if(events[i] == null) {
                events[i] = this;
                break;
            }
        }
    }

    /**
     * Constructs an all-day event object using an inputted date and eventDescription.
     * @param date is the date entered by user
     * @param eventDescription the eventDescription of the event entered by user
     * @throws IllegalArgumentException if the date is not formatted correctly.
     */
    public Event(String date, String eventDescription) {
        //Test fidelity of date string XX/XX/XXXX
        if(date.length() != DATE_LENGTH_MAX ) throw new IllegalArgumentException("Invalid Date");

        if((date.charAt(2) != '/') || (date.charAt(SLASH_INDEX) != '/')) {
            throw new IllegalArgumentException("Invalid Date");
        }

        try {
            Integer.parseInt(date.substring(0,2));
            Integer.parseInt(date.substring(DAY_START,DAY_END));
            Integer.parseInt(date.substring(YEAR_START,YEAR_END));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid Date");
        }
        this.date = date;
        this.eventDescription = eventDescription;
        for(int i = 0; i < events.length; i++) {
            if(events[i] == null) {
                events[i] = this;
                break;
            }
        }
    }

    /**
     * Gets the date of an event
     * @return date of event
     */
    public String getDate() {
        return this.date;
    }

    /**
    * Gets the start time for an event
    * @return start time of event
    */
    public String getStartTime() {
        return this.startTime;
    }

    /**
     * Gets the end time for an event
     * @return end time of event
     */
    public String getEndTime() {
        return this.endTime;
    }

    /**
    * Gets the hour of a time string.
    * @param time is the time entered by user
    * @return hour of the day.
    * @throws IllegalArgumentException if entered time has an index other than 5
    */
    public int getHour(String time) {
        //No idea if that works but it's a rough idea
        //10:30
        //01234
        if(time.length() != LENGTH_OF_TIME_STRING) throw new
            IllegalArgumentException("Invalid time string format");
        int hour = Integer.parseInt(time.substring(0,2));
        return hour;
    }

    /**
     * Gets the minutes for a time string
     * @param time is time entered by user
     * @return Minutes of the hour
     * @throws IllegalArgumentException if entered time has an index other than 5
     */
    public int getMinute(String time) {
        //No idea if that works but it's a rough idea
        if(time.length() != LENGTH_OF_TIME_STRING) throw new
            IllegalArgumentException("Invalid time string format");
        int minute = Integer.parseInt(time.substring(MINUTE_START_INDEX,MINUTE_END_INDEX));
        return minute;
    }

    /**
    * Gets the eventDescription for an event
    * @return the eventDescription for an event
    */
    public String getDescription() {
        return this.eventDescription;
    }

    /**
    * Gets whether there aren anY events on a specified date or not
    * @param date the date the user wants to create an event for or view
    * @return Whether there are no plans on a date.
    */
    public boolean noPlans(String date) {
        boolean noPlans = true;
        for (int i = 0; i < events.length; i++) {
            if (events[i].getDate().equals(date)) {
                noPlans = false;
                return noPlans;
            }
        }
        return noPlans;
    }

    /**
     * Gets whether or not 2 events are overlapping
     * @param event holds an event to compare to this instance.
     * @return whether 2 events are overlapping.
     */
    public boolean isOverlapping(Event event) {
        //Returns false if either event is an all-day event
        if((this.startTime == null) || (event.startTime == null)) return false;
        if(this.date != event.getDate()) return false;
        //LOGIC
        //Event 1 has start time 10 and end time 2
        //Event 2 has start time 11 and end time 3
        //(Event 2 start time is between and 2 )
        //It may be easier to convert the hours and minutes to a single number (in minutes)
        int event1StartTime = getHour(this.startTime) * SIXTY_MINS + getMinute(this.startTime);
        int event1EndTime = getHour(this.endTime) * SIXTY_MINS + getMinute(this.endTime);

        int event2StartTime = getHour(event.getStartTime()) * SIXTY_MINS +
            getMinute(event.getStartTime());
        int event2EndTime = getHour(event.getEndTime()) * SIXTY_MINS +
            getMinute(event.getEndTime());

        if((event2StartTime >= event1StartTime) && (event2EndTime <= event1EndTime)) return true;
        //Not sure uf that works the other way around so i'll add another check
        if((event1StartTime >= event2StartTime) && (event1EndTime <= event2StartTime)) return true;

        return false;
    }

    /**
     * Finds events that have the same date value
     * @param date is the date of the event entered by the user.
     * @return string containing info of those dates.
     */
    public static String findDate(String date) {
        //Goal here is to go in order and find any events that may have the same date.
        //If the element is null in events, then break, as events are assigned in order.
        String message = "";
        for(int i = 0; i < events.length; i++) {
            if(events[i] == null) break;
            if(events[i].getDate().equals(date)) message += (events[i].toString() + "\n");
        }
        return message;
    }

    /**
     * Creates string to be printed
     */
    @Override
    public String toString() {
        //TODO this may have unexpected results when a date has multiple events
        String message = "";
        message += this.date + "\n";
        message += this.eventDescription + " ";
        message += this.startTime + " - " + this.endTime;
        return message;
    }

    public static void main(String args[]){
        String date = "12/20/2021";
        Event event = new Event("11/30/2020", "10:40", "2:40", "hi");
        System.out.println((Event.findDate(date) == "") ? false : true);
    }

}
