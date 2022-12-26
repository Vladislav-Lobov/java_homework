// Задача 003 от 16 декабря 2022 года (4 семинар)

//* В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;

public class j20221216_homework03 {
    public static void main(String[] args) {
        Stack stack = new Stack<>();

        int number1;
        System.out.println("Выход: exit");
        System.out.println("Отмена: back");

        System.out.print("Введите число: ");
        number1 = getIntegerInput();

        int result = number1;
        String operation;
        int number2 = 0;
        boolean exit = false;
        while (!exit) {
            System.out.print("Введите операцию из +,-,*,/,exit,back : ");
            operation = getStringInput();

            if (operation.equals("exit")) {
                exit = true;
            }

            if (!operation.equals("back") && !operation.equals("exit")) {
                System.out.print("Введите число: ");
                number2 = getIntegerInput();
            }

            if (operation.equals("+")) {
                result = number1 + number2;
                System.out.println("Результат: " + result);
            } else if (operation.equals("-")) {
                result = number1 - number2;
                System.out.println("Результат: " + result);
            } else if (operation.equals("*")) {
                result = number1 * number2;
                System.out.println("Результат: " + result);
            } else if (operation.equals("/")) {
                result = number1 / number2;
                System.out.println("Результат: " + result);
            }

            if (operation.equals("back")) {
                try {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    System.out.println(stack);
                    number1 = (int) stack.peek();
                } catch (EmptyStackException e) {
                    System.out.println("Очередь пуста ");
                }

            } else if (!operation.equals("exit")) {
                stack.push("|");
                stack.push(number1);
                stack.push(operation);
                stack.push(number2);
                stack.push("=");
                stack.push(result);
                System.out.println(stack);
                number1 = result;
            }

        }

    }

    public static String getStringInput() {

        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        while (!input.equals("exit") && !input.equals("back")
                && !input.equals("+") && !input.equals("-")
                && !input.equals("*") && !input.equals("/")) {
            System.out.print("Недопустимая команда повторите ввод: ");
            input = scanner.nextLine();
        }

        return input;

    }

    public static int getIntegerInput() {

        int input;
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.print("Неверный символ. Повторите ввод: ");
            scanner.next();
        }
        input = scanner.nextInt();
        return input;

    }

}