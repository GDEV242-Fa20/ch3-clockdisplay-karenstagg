
/**
 * This ClockDisplay class implements a digital clock display for a
 * 12 hour clock. The clock shows hours, minutes and AM or PM. 
 * The range of the clock is 00:00 to 11:59,
 * using AM or PM variable to denote the time of day.
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Karen Stagg
 * @version September 26,2020
 * Week 3 - Lab 3.38
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Return the current time of this display in the format HH:MM AM/PM.
     */
    public String get12HourInternalDisplay()
    {
        //Create a local variable to hold current value of hour for analysis.
        int hourValue;
        
        //Create a local variable to hold AM or PM, default of AM.
        String daytimeOrNitetime = "AM";
        
        //Get the current value of hours object and store in hourValue.
        hourValue = hours.getValue();
        
        //If the hour value is 0, set to 12.
        if (hourValue == 0)
        {
            hourValue = 12;
        }
        
        //Create the display string to return.
        displayString = hourValue + ":" + minutes.getDisplayValue() + " "
                        + daytimeOrNitetime;
        return displayString;             
        
    }
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
}
