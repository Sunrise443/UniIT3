package lab4;

public class ArrayAverage {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        int sum = 0;

        try {
            if (arr.length == 0) {
                throw new IllegalArgumentException("Ошибка: в массиве нет данных.");
            }
            for (Integer arr1 : arr) {
                if (arr1 instanceof Integer) {
                    sum += arr1;
                } else {
                    throw new IllegalArgumentException("Ошибка: элемент массива не является числом.");
                } 
            }
            System.out.println("Среднее арифметическое массива: " + sum/arr.length);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
