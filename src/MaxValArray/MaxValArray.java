package MaxValArray;

public class MaxValArray extends Thread implements Runnable{

    private int arr[];
    private int maxVal;

    public MaxValArray(int arr[]){
        this.arr = arr;
    }

    public void run(){
        maxVal=this.arr[0];
        for (int i=1; i<arr.length; i++)
            if (arr[i] > this.maxVal)
                maxVal = arr[i];

    }

    public int GetMax(){
        return maxVal;
    }
}
