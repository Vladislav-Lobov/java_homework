// Задача 001 от 13 декабря 2022 года (3 семинар).

// Реализовать алгоритм сортировки слиянием

import java.util.Arrays;
import java.util.Random;

public class j20221213_homework01 {
    public static void main(String[] args) {

        int size = 6;
        int[] randomArray = createRandom(size);
        System.out.println("Массив на входе, длины " + size + " полученный случайным образом: " + Arrays.toString(randomArray));
        sortArray(randomArray, 0, size - 1);
        System.out.println("Отсортированный массив: " + Arrays.toString(randomArray));

    }

    public static int[] createRandom(int size) {

        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        
        return array;

    }

    public static void joinArray(int[] array, int l, int m, int r) {
        int sizeArray1 = m - l + 1;
        int sizeArray2 = r - m;

        int[] array1 = new int[sizeArray1];
        int[] array2 = new int[sizeArray2];

        for (int i = 0; i < sizeArray1; i++) {
            array1[i] = array[i + l];
        }
        for (int i = 0; i < sizeArray2; i++) {
            array2[i] = array[m + i + 1];
        }

        int i, j, k;
        i = 0;
        j = 0;
        k = l;

        while (i < sizeArray1 && j < sizeArray2) {

            if (array1[i] <= array2[j]) {
                array[k] = array1[i];
                i += 1;
            } else {
                array[k] = array2[j];
                j += 1;
            }
            k += 1;
        }

        for (; i < sizeArray1; i++) {
            array[k++] = array1[i];
        }

        for (; j < sizeArray2; j++) {
            array[k++] = array2[j];
        }
    }

    public static void sortArray(int[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sortArray(array, l, m);
            sortArray(array, m + 1, r);
            joinArray(array, l, m, r);

        }

    }

}