// Задача 003 от 20 декабря 2022 года (5 семинар)

// Реализовать алгоритм пирамидальной сортировки (HeapSort). (Можно использовать массивы)

import java.util.Arrays;

public class J20221220_homework03 {
    public static void main(String[] args) {
        int[] arr = { 0, 2, 2, 6, 3, 1, 6, 9, 0, 4, 3, 2, 5, 4, 1 , 9};
        System.out.println("Несортированный массив: " + Arrays.toString(arr));
        int[] sortedArr = sort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArr));

    }

    public static int[] sort(int[] arr) {
        for (int root = arr.length / 2 - 1; root >= 0; root--) {
            heapify(arr, root, arr.length);
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            swap(arr, 0, j);
            heapify(arr, 0, j);
        }
        return arr;
    }

    public static void heapify(int[] arr, int root, int size) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int x = root;
        if (left < size && arr[left] > arr[x])
            x = left;
        if (right < size && arr[right] > arr[x])
            x = right;
        if (x == root)
            return;
        swap(arr, x, root);
        heapify(arr, x, size);
    }

    public static void swap(int[] arr, int a, int b) {
        int x = arr[a];
        arr[a] = arr[b];
        arr[b] = x;
    }

}
