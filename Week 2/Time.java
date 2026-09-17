import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        Long time = System.currentTimeMillis();

        MyTime noArg = new MyTime();
        MyTime formattedTime = new MyTime(time);
        MyTime inputTime = new MyTime(01, 02, 03);

        System.out.println(noArg.getHour());
        System.out.println(noArg.getMinute());
        System.out.println(noArg.getSecond());
    }
}

class MyTime {

    private Long millies;

    private int hour;
    private int minute;
    private int second;

    public MyTime() {
        this.millies = System.currentTimeMillis();

        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date(millies);

        String[] splitTime = format.format(date).split(":");
        hour = Integer.parseInt(splitTime[0]);
        minute = Integer.parseInt(splitTime[1]);
        second = Integer.parseInt(splitTime[2]);
    }

    public MyTime(Long millies) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date(millies);

        System.out.println(format.format(date));
    }

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;

        System.out.println(hour + ":" + minute + ":" + second);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

}
