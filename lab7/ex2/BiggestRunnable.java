package ex2;

public class BiggestRunnable extends Thread {
    private int[] arr;
    private int mx;

    public void setLine(int[] line) {
        arr = line;
    }

    public int getResult() {
        return mx;
    }

    @Override
    public void run() {
        mx = arr[0];
        for (int element : arr) {
            if (mx<element) {
                mx = element;
            }
        }
    }
}
