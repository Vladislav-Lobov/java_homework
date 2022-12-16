// Задача 002 от 13 декабря 2022 года (3 семинар).

// Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.Random;

public class j20221213_homework02 {

    public static void main(String[] args) {

        int i = 0;
        int size = 8;
        Random random = new Random();
        ArrayList<Integer> arrayOfList = new ArrayList<>(size);

        while (i < size) {
            arrayOfList.add(random.nextInt(10));
            i++;
        }
        System.out.println("Массив на входе, длины " + size + " полученный случайным образом: " + arrayOfList);

        arrayOfList.removeIf(x -> x % 2 == 0);

        System.out.println("Массив на выходе, без четных чисел " + arrayOfList);
    }
}
