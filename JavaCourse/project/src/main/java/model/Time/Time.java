package model.Time;

import model.Time.Exceptions.TimeException;

import java.util.Random;

public class Time {
    private int hour;
    private int minute;

    public Time(){
       this.hour = 0;
       this.minute = 0;
    }

    public Time (int hour, int minute) throws TimeException {
        this.hour = TimeValidator.hourValidityCheck(hour);
        this.minute = TimeValidator.minuteValidityCheck(minute);
    }

    public Time(String time) throws TimeException {
        String[] temp = TimeValidator.formatValidityCheck(time).split(":");

        this.hour = TimeValidator.hourValidityCheck(Integer.parseInt(temp[0]));
        this.minute = TimeValidator.minuteValidityCheck(Integer.parseInt(temp[1]));
    }

    public void setHour(int hour) throws TimeException {
        this.hour = TimeValidator.hourValidityCheck(hour);
    }

    public int getHour(){
        return this.hour;
    }

    public void setMinute(int minute) throws TimeException {
        this.minute = TimeValidator.minuteValidityCheck(minute);
    }

    public int getMinute(){
        return this.minute;
    }

    public Time random() {
        Random rand = new Random();
        this.hour = rand.nextInt(24);
        this.minute = rand.nextInt(60);

        return this;
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
