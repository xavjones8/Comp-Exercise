package src;

import java.util.*;

/**
* The event class creates an event object that holds the name, date and time for an event.
* @author Jamel Clarke
* @author Xavier Jones
* @author Brianna Soto
* @version 1.0
*/

/* Only checkstyle warnings
[WARN] /Users/xavierjones/Documents/csc116/Comp Exercise/Comp-Exercise/src/Event.java:260:57: '12' is a magic number. [MagicNumber]
[WARN] /Users/xavierjones/Documents/csc116/Comp Exercise/Comp-Exercise/src/Event.java:264:71: '31' is a magic number. [MagicNumber]
[WARN] /Users/xavierjones/Documents/csc116/Comp Exercise/Comp-Exercise/src/Event.java:286:25: '24' is a magic number. [MagicNumber]
[WARN] /Users/xavierjones/Documents/csc116/Comp Exercise/Comp-Exercise/src/Event.java:287:28: '60' is a magic number. [MagicNumber]
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

    /** Size of the Event array */
    public static final int EVENT_ARRAY_SIZE = 20;

    /** Date of event */
    String date;

    /** Start time for event */
    String startTime = null;

    /** End time for event */
    String endTime = null;

    /** eventDescription of event */
    String eventDescription;
    //Date Start End Title
    /** Whether the user has overlapping plans for that day or not */
    boolean isOverlapping;

    /** Holds all events in the program */
    public static ArrayList<Event> events = new ArrayList<Event>();
    //Note - an array list is just an array that doesn't have a set Size
    //To add to it, do events.add(whatever u want);
    //To remove, do events.remove(whatever u want);
    //Much more convenient to use

    /**
     * Constructs an event object using an inputted date,
     * start time, end time, and eventDescription.
     * @param date is the date entered by user
     * @param startTime the beginning time to the event entered by user
     * @param endTime the end timeof the event entered by user
     * @param eventDescription the eventDescription of the event entered by user
     * @throws IllegalArgumentException if date, start or end
     * times are formatted incorrectly.
     */
    public Event(String date, String startTime, String endTime, String eventDescription) {
        if(checkDateString(date)) this.date = date;
        else throw new IllegalArgumentException("Invalid Date");

        if(checkTimeString(startTime)) this.startTime = startTime;
        else throw new IllegalArgumentException("Invalid Start Time");

        if(checkTimeString(endTime)) this.endTime = endTime;
        else throw new IllegalArgumentException("Invalid End Time");

        this.eventDescription = eventDescription;

        events.add(this);
    }

    /**
     * Constructs an all-day event object using an inputted date and eventDescription.
     * @param date is the date entered by user
     * @param eventDescription the eventDescription of the event entered by user
     * @throws IllegalArgumentException if the date is not formatted correctly.
     */
    public Event(String date, String eventDescription) {

        if(checkDateString(date)) this.date = date;
        else throw new IllegalArgumentException("Invalid Date");

        this.eventDescription = eventDescription;

        events.add(this);
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
        if(!checkTimeString(time)) throw new IllegalArgumentException("Invalid Time");
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
        if(!checkTimeString(time)) throw new IllegalArgumentException("Invalid Time");
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
        if(!checkDateString(date)) throw new IllegalArgumentException("Invalid Date");
        boolean noPlans = true;
        for(Event event : events){
            if(date.equals(event.getDate())) noPlans = false;
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
     * Finds events that have a specific date value
     * @param date is the date of the event entered by the user.
     * @return string containing info of those dates.
     */
    public static Event findDate(String date) {
        if(!checkDateString(date)) throw new IllegalArgumentException("Invalid Date");
        for(Event event : events){
            if(date.equals(event.getDate())) return event;
        }
        return null;
    }


    /**
     * Creates string to be printed
     */

    @Override
    public String toString() {
        String message = "";
        if(this.getStartTime() == null) {
            message += this.date + "\n";
            message += this.eventDescription + " ";
            message += this.startTime + " - " + this.endTime;
            return message;
        } else {
            message += this.date + "\n";
            message += this.eventDescription + " - All Day";
        }
        return message;
    }

     /**
     * Checks whether a date string is correct
     * @param date holds the date string to check
     * @return true if date string is correct
     */
    public static boolean checkDateString(String date){
        if(date.length() != DATE_LENGTH_MAX ) return false;
        if((date.charAt(2) != '/') || (date.charAt(SLASH_INDEX) != '/')) return false;
        try {
            if(Integer.parseInt(date.substring(0,2)) <= 0 ||
                Integer.parseInt(date.substring(0,2)) > 12){
                return false;
            }
            if(Integer.parseInt(date.substring(DAY_START,DAY_END)) <= 0 ||
                Integer.parseInt(date.substring(DAY_START,DAY_END)) > 31) {
                return false;
            }
            Integer.parseInt(date.substring(YEAR_START,YEAR_END));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

     /**
     * Checks whether a time string is correct
     * @param time holds the time string to check
     * @return true if time string is correct
    */
    public static boolean checkTimeString(String time){
        if(time.length() != LENGTH_OF_TIME_STRING) return false;
        if(time.charAt(TIME_SEMICOLON_INDEX) != ':') return false;
        try {
            int hours = Integer.parseInt(time.substring(0,2));
            int minutes = Integer.parseInt
                (time.substring(MINUTE_START_INDEX, MINUTE_END_INDEX));
            if((hours > 24 || hours < 0)) return false;
            if((minutes >= 60 || minutes < 0)) return false;
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

}
