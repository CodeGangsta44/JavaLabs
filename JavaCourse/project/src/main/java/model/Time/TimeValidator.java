package model.Time;

import model.Time.Exceptions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeValidator {
    private static final String TIME_FORMAT_ERROR = "The format of the time should match the pattern: \"hh:mm\"";
    private static final String HOUR_RANGE_ERROR = "The value of the argument \"hour\" should belong to the interval [0; 23]";
    private static final String MINUTE_RANGE_ERROR = "The value of the argument \"minute\" should belong to the interval [0; 59]";

    private static final Pattern p = Pattern.compile("^\\d{2}:\\d{2}$");

    public static String formatValidityCheck(String target) throws TimeException {
        Matcher m = p.matcher(target);
        if(!m.matches()) throw new TimeFormatException(target, TIME_FORMAT_ERROR);
        return target;
    }

    public static int hourValidityCheck(int hour) throws TimeException {
        if (hour < 0 || hour > 23) throw new TimeRangeException(hour, HOUR_RANGE_ERROR);
        return hour;
    }

    public static int minuteValidityCheck(int minute) throws TimeException {
        if (minute < 0 || minute > 59) throw new TimeRangeException(minute, MINUTE_RANGE_ERROR);
        return minute;
    }
}
