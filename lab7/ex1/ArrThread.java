package ex1;

public class ArrThread extends Thread {
    private ArrSum arrSum;

    public ArrThread(ArrSum arrSum) {
        this.arrSum = arrSum;
    }

    public void run(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            arrSum.increment(arr[i]);
        }
    }
}
