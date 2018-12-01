package com.company;
import Stopwatch.MyStopwatch;
import MaxValArray.MaxValArray;
import java.time.ZonedDateTime;
import java.util.Scanner;

import ArraySum.ArraySum;
import CalcPie.CalcPie;

public class Main {

    public static void main(String[] args) {

        //q1 - Stopwatch


        MyStopwatch watch1 = new MyStopwatch();
        Thread t1 = new Thread(watch1);
        Thread t2 = new Thread(watch1);
        Thread t3 = new Thread(watch1);
        t1.start();
        t2.start();
        t3.start();


        //q2 - Find max value in array


        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        int arr1[] = new int [n/4];
        int arr2[] = new int [n/4];
        int arr3[] = new int [n/4];
        int arr4[] = new int [n/4 + n%4];

        System.arraycopy(arr, 0, arr1, 0, n/4);
        System.arraycopy(arr, n/4, arr2, 0, n/4);
        System.arraycopy(arr, n/2, arr3, 0, n/4);
        System.arraycopy(arr, (n/4)*3, arr4, 0, (n/4+n%4));

        MaxValArray m1 = new MaxValArray(arr1);
        MaxValArray m2 = new MaxValArray(arr2);
        MaxValArray m3 = new MaxValArray(arr3);
        MaxValArray m4 = new MaxValArray(arr4);

        m1.start();
        m2.start();
        m3.start();
        m4.start();

        while(m1.isAlive() || m2.isAlive() || m3.isAlive() || m4.isAlive());
        int maxArr[] = {m1.GetMax(), m2.GetMax(), m3.GetMax(), m4.GetMax()};
        m1 = new MaxValArray(maxArr);
        m1.start();
        while (m1.isAlive());
        System.out.println("Max:"+m1.GetMax());


        //q3 - Calculate array sum

        int arrr[] = {1,2,3,4,5,6,7,8};
        int nn = arr.length;
        int arrr1[] = new int [nn/4];
        int arrr2[] = new int [nn/4];
        int arrr3[] = new int [nn/4];
        int arrr4[] = new int [nn/4 + n%4];

        System.arraycopy(arrr, 0, arrr1, 0, nn/4);
        System.arraycopy(arrr, n/4, arrr2, 0, nn/4);
        System.arraycopy(arrr, n/2, arrr3, 0, nn/4);
        System.arraycopy(arrr, (n/4)*3, arrr4, 0, (nn/4+nn%4));

        ArraySum mm1 = new ArraySum(arrr1);
        ArraySum mm2 = new ArraySum(arrr2);
        ArraySum mm3 = new ArraySum(arrr3);
        ArraySum mm4 = new ArraySum(arrr4);

        mm1.start();
        mm2.start();
        mm3.start();
        mm4.start();

        while(mm1.isAlive() || mm2.isAlive() || mm3.isAlive() || mm4.isAlive());
        System.out.print("Sum:");
        System.out.println(mm1.GetSum()+mm2.GetSum()+mm3.GetSum()+mm4.GetSum());

        //q4 - Calculate pie
        while (t1.isAlive() || t2.isAlive() || t3.isAlive());
        Scanner s = new Scanner(System.in);
        int acc = s.nextInt();
        CalcPie calc[] = new CalcPie[acc];
        for (int i=0; i<acc; i++)
            calc[i] = new CalcPie();
        for (int i=0; i<acc; i++)
            calc[i].start();

        for(int i=0; i<acc; i++)
            while (calc[i].isAlive());

        int sumC=0, sumN=0;

        for (int i=0; i<acc; i++){
            if (calc[i].GetC()==1)
                sumC++;
            if (calc[i].GetN()==1)
                sumN++;
        }
        double frac = (double)sumC/(double)sumN;
        System.out.println(frac*4);
    }
}
