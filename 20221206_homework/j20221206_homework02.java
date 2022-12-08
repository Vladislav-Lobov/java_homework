// Задача 02 от 6 декабря 2022 года (1 семинар)
// Вывести все простые числа от 1 до 1000

import java.util.ArrayList;

public class j20221206_homework02 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Boolean isPrime;
        for (int i = 2; i <= 1000; i++) {
            isPrime = true;
            for (int j : list) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                list.add(i);
            }

        }
        System.out.println(list);
    }
}
