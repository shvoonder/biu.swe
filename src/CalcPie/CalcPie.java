package CalcPie;

public class CalcPie extends Thread implements Runnable{

    private int c;
    private int n;
    public CalcPie(){
        this.c=0;
        this.n=0;
    }

    public void run(){
        this.n++;
        double y = Math.random();
        double x = Math.random();
        if ((x*x+y*y) < 1)
            this.c++;
    }
    public int GetC(){
        return this.c;
    }

    public int GetN(){
        return this.n;
    }
}
