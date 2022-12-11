// Задача 002. Семинар 2 от 09 декабря 2022 года.

// Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.


import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class j20221209_homework02 {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(j20221209_homework02.class.getName());
        logger.setLevel(Level.INFO);
        try {
            System.setProperty(
                    "java.util.logging.SimpleFormatter.format",
                    "[%1$tF %1$tT.%1$tL] %5$s %n");
            FileHandler ch = new FileHandler("log.log");
            ch.setEncoding("UTF-8");
            logger.addHandler(ch);
            SimpleFormatter sFormat = new SimpleFormatter();
            ch.setFormatter(sFormat);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int size = 9;
        int[] RandomArray = getRandomArray(size);
        RandomArray = sortArray(RandomArray, logger);

    }

    public static int[] getRandomArray(int size) {
        int[] RandomArray = new int[size];
        for (int i = 0; i < size; i++) {
            RandomArray[i] = (int) (Math.random() * 10);
        }
        return RandomArray;

    }

    public static int[] sortArray(int[] array, Logger logger) {

        logger.info("Input array: " + Arrays.toString(array));
        Boolean isSorted;
        int temp = 0;
        int count = 0;

        for (int j = 0; j < array.length - 1; j++) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - j; i++) {
                if (array[i + 1] < array[i]) {
                    temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            logger.info(++count + " iteration: " + Arrays.toString(array));

        }
        return array;

    }

}
