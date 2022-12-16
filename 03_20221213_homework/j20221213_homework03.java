// Задача 003 от 13 декабря 2022 года (3 семинар).

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;;

public class j20221213_homework03 {
    public static void main(String[] args) {

        int i = 0;
        int size = 8;
        Random random = new Random();
        ArrayList<Integer> arrayOfList = new ArrayList<>(size);

        while (i < size) {
            arrayOfList.add(random.nextInt(10) + 1);
            i++;
        }
        System.out.println("Массив на входе, длины " + size + " полученный случайным образом: " + arrayOfList);

        Collections.sort(arrayOfList);
        System.out.println("Минимальный элемент: " + arrayOfList.get(0));
        System.out.println("Максимальный элемент: " + arrayOfList.get(size - 1));

        float median;
        if (size % 2 == 0) {
            median = (arrayOfList.get(size / 2) + arrayOfList.get(size / 2 - 1)) / 2f;
        } else {
            median = arrayOfList.get(size / 2);
        }
        System.out.println("Медиана равна: " + median);

        float summa = 0;
        for (Integer item : arrayOfList) {
            summa += item;
        }
        System.out.println("Среднее арифметическое равно: " + summa / size);

        double multiply = 1;
        for (Integer item : arrayOfList) {
            multiply *= item;
        }
        System.out.println("Среднее геометрическое равно: " + Math.pow(multiply, 1d / size));
        System.out.println("Отсортированный массив: " + arrayOfList);

    }
}
