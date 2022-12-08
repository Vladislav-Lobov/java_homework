// Задача 04 от 6 декабря 2022 года (1 семинар)
// Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, 
// например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства. 
// Предложить хотя бы одно решение или сообщить, что его нет.

import java.util.Scanner;

public class j20221206_homework04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите двузначное число q (например 7?): ");
        String q = scan.nextLine();
        System.out.print("Введите двузначное число w (например ?2): ");
        String w = scan.nextLine();
        System.out.print("Введите двузначное число e (без ?): ");
        Boolean isInt = scan.hasNextInt();
        int e = 0;
        if (isInt) {
            e = scan.nextInt();
        } else {
            System.out.println("Вы ввели не число ");
            System.exit(0);
        }
        Boolean noSolution = true;

        if (q.equals("??") && !w.contains("?")) {
            System.out.println("Неизвестное ?? равно: " + (e - Integer.parseInt(w)));
            noSolution = false;
        }
        if (w.equals("??") && !q.contains("?")) {
            System.out.println("Неизвестное ?? равно: " + (e - Integer.parseInt(q)));
            noSolution = false;
        }

        Boolean abort = false;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 && !abort; j++) {
                String newQ = q.replace('?', (char) (j + '0'));
                String newW = w.replace('?', (char) (i + '0'));
                int intQ = Integer.parseInt(newQ);
                int intW = Integer.parseInt(newW);
                if (intQ + intW == e) {
                    System.out.printf("Совпадающие значения: %d + %d = %d \n", intQ, intW, e);
                    System.out.println("Первое неизвестное ?: " + j);
                    System.out.println("Второе неизвестное ?: " + i);
                    noSolution = false;
                    abort = true;
                }
            }

        }
        if (noSolution) {
            System.out.println("Уравнение не имеет решения ");
        }

    }
}
