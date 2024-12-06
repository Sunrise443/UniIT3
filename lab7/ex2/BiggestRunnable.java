package ex2;

public class BiggestRunnable extends Thread {
    private int[] arr;
    private int mx;

    public BiggestRunnable(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        mx = arr[0];
        for (int element : arr) {
            if (mx<element) {
                mx = element;
            }
        }
        ex2.BiggestMain.biggestOfLines.add(mx);
    }
}
