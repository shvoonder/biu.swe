package Stopwatch;

import java.time.ZonedDateTime;
import java.util.Scanner;

public class MyStopwatch extends Thread implements Runnable {
    private ZonedDateTime currTime;
    private int endMin;
    private int endSec;
    private int endHour;
    private int startMin;
    private int startSec;
    private int startHour;
    private Scanner s;

    public MyStopwatch (){
        s  = new Scanner(System.in);
        this.currTime = ZonedDateTime.now();
        this.startSec = currTime.getSecond();
        this.startMin = currTime.getMinute();
        this.startHour = currTime.getHour();
    }

    public void run(){
        chk();
        this.currTime = ZonedDateTime.now();
        this.endSec = currTime.getSecond();
        this.endMin = currTime.getMinute();
        this.endHour = currTime.getHour();
        printTime();
    }

    private void printTime(){
        int secTot = this.endSec - this.startSec;
        int minTot = this.endMin - this.startMin;
        int hourTot = this.endHour - this.startHour;
        if (secTot < 0) {
            secTot = 60 + secTot;
            minTot--;
        }
        if (minTot < 0){
            minTot = 60 + minTot;
            hourTot--;
        }
        System.out.println(hourTot + ":" + minTot + ":" + secTot);
    }
    private synchronized void chk (){
        String str = s.nextLine();
    }

}
