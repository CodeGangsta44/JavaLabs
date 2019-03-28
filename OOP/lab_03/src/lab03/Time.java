package lab03;

public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    public Time(String time){
        String[] temp = time.split(":");
        this.hour = Integer.parseInt(temp[0]);
        this.minute = Integer.parseInt(temp[1]);
    }

    public void setHour(int hour){
        this.hour = hour;
    }

    public int getHour(){
        return this.hour;
    }

    public void setMinute(int minute){
        this.minute = minute;
    }

    public int getMinute(){
        return this.minute;
    }

    public boolean afterThisTime(Time time){
        if (this.hour > time.getHour()) return true;
        return time.getHour() == this.hour && this.minute > time.getMinute();
//        if (time.getHour() > this.hour) return true;
//        return time.getHour() == this.hour && time.getMinute() > this.minute;
    }

    public void print(){
        System.out.printf("%02d:%02d", this.hour, this.minute);
    }

    public String toString(){
        StringBuilder result = new StringBuilder();

        if(this.hour < 10)result.append('0');
        result.append(this.hour);

        result.append(':');

        if(this.minute < 10)result.append('0');
        result.append(this.minute);

        return result.toString();
    }
}
