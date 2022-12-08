// Задача 03 от 6 декабря 2022 года (1 семинар)
// Реализовать простой калькулятор

import java.util.Scanner;

public class j20221206_homework03 {

    public static void main(String[] args) {
        int number1 = 0;
        int number2 = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        if (scan.hasNextInt()) {
            number1 = scan.nextInt();
        } else {
            System.out.println("Некорректный ввод");
            System.exit(0);
        }
        System.out.print("Введите второе число: ");
        if (scan.hasNextInt()) {
            number2 = scan.nextInt();
        } else {
            System.out.println("Некорректный ввод");
            System.exit(0);
        }

        String operation;
        do {
            System.out.print("Введите операцию (+ , - , * , /): ");
            operation = scan.next();
        } while (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/"));
        System.out.print("Результат: ");
        switch (operation) {
            case "+":
                System.out.println(number1 + number2);
                break;
            case "-":
                System.out.println(number1 - number2);
                break;
            case "*":
                System.out.println(number1 * number2);
                break;
            case "/":
                if (number2 != 0) {
                    System.out.println(number1 / number2);
                    break;
                } else {
                    System.out.println("Деление невозможно - знаменатель ноль ");
                }
        }
    }
}
