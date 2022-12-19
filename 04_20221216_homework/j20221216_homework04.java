// Задача 004 от 16 декабря 2022 года (4 семинар)

// ** Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения. 
// primat.org/news/obratnaja_polskaja_zapis/2016-04-09-1181 Вычислить запись если это возможно. 
// (Объяснение подобной задачи есть в лекции)

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class j20221216_homework04 {

    public static void main(String[] args) {

        System.out.println("Внимание! Программа работает только с целыми числами. ");
        System.out.println("Если приоритеты операций равны (* и /) или (+ и -) программа вычисляет слева направо ");

        Scanner scanner = new Scanner(System.in);
        String expr = "";

        while (!expr.equals("exit")) {
            System.out.print("Выход: exit. Введите математическое выражение: ");
            expr = scanner.nextLine();
            if (!expr.equals("exit")) {

                if (!expr.contains("*") && !expr.contains("/") && !expr.contains("+") && !expr.contains("-")) {
                    System.out.println("Ваше выражение не содержит символов операций. ");
                    continue;
                }

                String polishView = stringToPolish(expr);
                System.out.println("Обратная польская запись выражения: " + polishView);
                System.out.println("Результат вычисления: " + exec_from_polish(polishView));
                System.out.println("------------------------------------------");
            }
        }
    }

    public static String stringToPolish(String expr) {
        Map<String, Integer> precedence = new HashMap<>();
        precedence = Map.of("*", 3,
                "/", 3,
                "+", 2,
                "-", 2,
                "(", 1);

        String top;
        Stack<String> stack = new Stack<>();
        Stack<String> postfix = new Stack<>();
        ArrayList<String> tokens = new ArrayList<>();
        String newExpr;

        expr = expr.replaceAll("\\s", "");
        newExpr = expr.replaceAll("^-(\\d+)", "(0-$1)");
        newExpr = newExpr.replaceAll("\\(\\-(\\d+)", "((0-$1)");
        newExpr = newExpr.replaceAll("\\*\\-(\\d+)", "*(0-$1)");
        newExpr = newExpr.replaceAll("\\/\\-(\\d+)", "/(0-$1)");
        newExpr = newExpr.replaceAll("\\+\\-(\\d+)", "+(0-$1)");
        newExpr = newExpr.replaceAll("\\-\\-(\\d+)", "-(0-$1)");

        if (!newExpr.equals(expr)) {
            System.out.println("Ваша строка содержит унарный минус, \nвыполним преобразование: " + newExpr);
        } else {
            System.out.println("Ваша строка не содержит унарный минус, \nпреобразование не требуется ");
        }

        String pattern = "(\\d+|[\\(\\)\\+\\*\\-\\/])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(newExpr);
        while (m.find()) {
            tokens.add(m.group(1));
        }

        for (String token : tokens) {
            if (token.chars().allMatch(Character::isDigit)) {
                postfix.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                top = stack.pop();
                while (!top.equals("(")) {
                    postfix.push(top);
                    top = stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence.get(stack.peek()) >= precedence.get(token)) {
                    postfix.push(stack.pop());
                }
                stack.push(token);

            }

        }
        while (!stack.isEmpty()) {
            postfix.push(stack.pop());
        }

        return String.join(" ", postfix);

    }

    static public int exec_from_polish(String srt) {

        int cnt1, cnt2;
        Stack<Integer> stack = new Stack<>();
        String[] polString = new String[srt.length()];
        polString = srt.split(" ");
        try {
            for (String item : polString) {
                if (item.chars().allMatch(Character::isDigit)) {
                    stack.push(Integer.parseInt(item));
                } else {
                    cnt1 = stack.pop();
                    cnt2 = stack.pop();
                    stack.push(operations(item, cnt2, cnt1));
                }
            }

            return stack.pop();

        } catch (EmptyStackException e) {
            System.out.println("Ваше выражение содержит ошибку ");
            return Integer.MIN_VALUE;
        }

    }

    public static int operations(String item, int cnt2, int cnt1) {
        int result = 0;

        if (item.equals("+")) {
            result = cnt2 + cnt1;
        } else if (item.equals("-")) {
            result = cnt2 - cnt1;
        } else if (item.equals("*")) {
            result = cnt2 * cnt1;
        } else if (item.equals("/")) {
            result = cnt2 / cnt1;
        }
        return result;
    }
}
