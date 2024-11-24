package lab6;

public class Main {
    public static void main(String[] args) {

        //Задание 2
        Stack<Integer> tStack = new Stack<>(5);
    
        tStack.push(12);
        tStack.push(1);
        tStack.push(234);
        tStack.push(666);

        System.out.println(tStack.peek());
        System.out.println(tStack.pop());
        System.out.println(tStack.peek());
        


        //Задание 3
        Sold shop1 = new Sold();

        shop1.put("soap");
        shop1.put("soap");
        shop1.put("soap");
        shop1.put("soap");
        shop1.put("rope");
        shop1.put("rope");
        shop1.put("pen");
        shop1.put("pen");
        shop1.put("pen");
        shop1.put("pen");
        shop1.put("pen");
        shop1.put("pen");
        shop1.put("pen");
        shop1.put("pen");

        System.out.println(shop1.show());
        System.out.println(shop1.totalPrice());
        System.out.println(shop1.totalSold());
        System.out.println(shop1.mostPopularItem());
    }
}
