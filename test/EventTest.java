package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Event;

/**
 * Tests the methods for the Event class
 * @author Xavier Jones
 * @author Brianna Soto
 * @author Jamel Clarke
 */
public class EventTest{

     /**
     * Test toString for Event
     */
    @Test
    public void testToStringEvent() {
        Event event = new Event("02/20/2003", "15:00", "16:00", "Founder's Day");
        /*
        String message = "";
        message += this.date + "\n";
        message += this.eventDescription + " ";
        message += this.startTime + " - " + this.endTime;
        */
        String exp = "2/20/2003\nFounder's Day 15:00 - 16:00";
        assertEquals(exp, event.toString());

        event = new Event("02/20/2003","Founder's Day");
        exp = "2/20/2003\nFounder's Day - All Day";
        assertEquals(exp, event.toString());
    }
    /**
    * Tests exceptions
    */
   @Test
   public void testExceptions() {
       // Testing constructor with invalid date
       Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Event("2/20/2003", "15:00", "16:00", "Founder's Day"), "Invalid Date Length");
       assertEquals("Invalid Date", exception.getMessage(),
            "Testing invalid date message");

        // Testing constructor with invalid date month
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Event("20/20/2003", "15:00", "16:00", "Founder's Day"), "Invalid Date Month Length");
        assertEquals("Invalid Date", exception.getMessage(),
            "Testing invalid date message");

        // Testing constructor with invalid date day
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Event("12/33/2003", "15:00", "16:00", "Founder's Day"), "Invalid Date Day Length");
        assertEquals("Invalid Date", exception.getMessage(),
            "Testing invalid date day message");

        // Testing constructor with invalid start time hours
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Event("12/20/2003", "30:00", "16:00", "Founder's Day"), "Invalid Start Time Value");
        assertEquals("Invalid Start Time", exception.getMessage(),
            "Testing invalid start time value message");

        // Testing constructor with invalid start time minutes
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Event("12/20/2003", "15:70", "16:00", "Founder's Day"), "Invalid Start Time Value");
        assertEquals("Invalid Start Time", exception.getMessage(),
            "Testing invalid start time value message");

        // Testing constructor with invalid end time hours
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Event("12/20/2003", "15:00", "30:00", "Founder's Day"), "Invalid End Time Value");
        assertEquals("Invalid End Time", exception.getMessage(),
            "Testing invalid end time value message");

        // Testing constructor with invalid end time minutes
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Event("12/20/2003", "15:00", "16:70", "Founder's Day"), "Invalid End Time Value");
        assertEquals("Invalid End Time", exception.getMessage(),
            "Testing invalid end time value message");

        // Testing getHour with invalid time string
        exception = assertThrows(IllegalArgumentException.class,
            () -> Event.getHour("30:57"), "Invalid Time");
        assertEquals("Invalid Time", exception.getMessage(),
            "Testing invalid time message");

        // Testing getMinute with invalid time string
        exception = assertThrows(IllegalArgumentException.class,
            () -> Event.getMinute("30:57"), "Invalid Time");
        assertEquals("Invalid Time", exception.getMessage(),
            "Testing invalid time message");

        // Testing noPlans with invalid date string
        exception = assertThrows(IllegalArgumentException.class,
            () -> Event.noPlans("May 20, 2003"), "Invalid Date");
        assertEquals("Invalid Date", exception.getMessage(),
            "Testing invalid date message");

        // Testing noPlans with invalid date string
        exception = assertThrows(IllegalArgumentException.class,
            () -> Event.findDate("May 20, 2003"), "Invalid Date");
        assertEquals("Invalid Date", exception.getMessage(),
            "Testing invalid date message");


   }
}
