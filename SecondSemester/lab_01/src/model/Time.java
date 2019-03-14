package model;

public class Time {
    private static String HOUR_RANGE_ERROR = "The value of the argument \"hour\" should belong to the interval [0; 23]";
    private static String MINUTE_RANGE_ERROR = "The value of the argument \"minute\" should belong to the interval [0; 59]";
    private int hour;
    private int minute;

    public Time (int hour, int minute) {
        this.hour = hourValidityCheck(hour);
        this.minute = minuteValidityCheck(minute);
    }

    public Time(String time){
        String[] temp = time.split(":");
        this.hour = hourValidityCheck(Integer.parseInt(temp[0]));
        this.minute = minuteValidityCheck(Integer.parseInt(temp[1]));
    }

    private int hourValidityCheck(int hour) {
        if (hour < 0 || hour > 23) throw new IllegalArgumentException(HOUR_RANGE_ERROR);
        return hour;
    }

    private int minuteValidityCheck(int minute) {
        if (minute < 0 || minute > 59) throw new IllegalArgumentException(MINUTE_RANGE_ERROR);
        return minute;
    }

    public void setHour(int hour){
        this.hour = hourValidityCheck(hour);
    }

    public int getHour(){
        return this.hour;
    }

    public void setMinute(int minute){
        this.minute = minuteValidityCheck(minute);
    }

    public int getMinute(){
        return this.minute;
    }

    public boolean afterThisTime(Time time){
        if (this.hour > time.getHour()) return true;
        return time.getHour() == this.hour && this.minute > time.getMinute();
    }

    public String toString(){
        StringBuilder result = new StringBuilder();

        result.append(String.format("%02d:%02d", hour, minute));

        return result.toString();
    }
}
