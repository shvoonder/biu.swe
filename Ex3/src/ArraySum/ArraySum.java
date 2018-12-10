package ArraySum;

public class ArraySum extends Thread implements Runnable{

    private int arr[];
    private int sum;

    public ArraySum(int arr[]){
        this.arr = arr;
        this.sum = 0;
    }

    public void run(){

        for (int i=0; i<arr.length; i++)
            this.sum += arr[i];
    }

    public int GetSum(){
        return sum;
    }
}
