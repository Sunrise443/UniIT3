package lab6;

import java.util.*;
import java.util.Map.Entry;
/*
Вариант 1
ArrayList для храниения списка проданных товаров

(HashMap для товар-цена)

Учет продаж в магазине
Добавлять проданные товары в коллекцию
Выводить список проданных товаров
Считать общую сумму продаж и наиболее популярный товар

список
товар - кол-во проданного - цена за 1 товар
товар - цена за 1 товар (подсчет кол-ва как в 1 задании)
два списка - проданные товары и цена на каждый. второй вызывается по названию товара
*/

public class Sold {
    private ArrayList<String> sold;
    private final HashMap<String, Integer> prices;
    
    public Sold () {
        this.sold = new ArrayList<>();
        this.prices = new HashMap<>();
        prices.put("soap", 12);
        prices.put("cup", 400);
        prices.put("rope", 35);
        prices.put("pen", 5);
        prices.put("lichtbulb", 56);
    }

    public void put (String item) {
        sold.add(item);
        System.out.println("An item has been sold.");
    }

    public ArrayList<String> show() {
        if (sold.isEmpty()) {
            System.out.println("Nothing has been sold.");
            return null;
        }
        System.out.println("The items that have been sold:");
        return sold;
    }

    public HashMap<String, Integer> totalSold() {
        HashMap<String, Integer> total = new HashMap<>();
        if (sold.isEmpty()) {
            System.out.println("Nothing has been sold.");
            return null;
        }
        for (String item : sold) {
            if (!total.containsKey(item)) {
                total.put(item, 1);
            } else {
                total.replace(item, total.get(item)+1);
            }
        }
        
        Integer totalSold = sold.size();
        System.out.println("Total sold: " + totalSold);
        return total;
    }
    
    public String mostPopularItem() {
        HashMap<String, Integer> total = totalSold();
        total.remove("Total sold: ");
        List<Entry<String, Integer>> mList = new ArrayList<>(total.entrySet());
        Collections.sort(mList, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return "The most popular item is: " + mList.get(0).getKey() + ". Amount sold is: " + mList.get(0).getValue();
    }
    
    public Map<String, Integer> totalPrice() {
        HashMap<String, Integer> total = totalSold();

        if (sold.isEmpty()) {
            System.out.println("Nothing has been sold.");
            return null;
        }
        for (Entry<String, Integer> entry : total.entrySet()) {
            total.replace(entry.getKey(), entry.getValue()*prices.get(entry.getKey()));
        }

        Integer totalPrice = 0;
        for (Entry<String, Integer> entry : total.entrySet()) {
            totalPrice += entry.getValue();
        }

        System.out.println("Total price: " + totalPrice);
        return total;
    } 
}
