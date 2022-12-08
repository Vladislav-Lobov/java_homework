
// Задача 01 от 06 декабря 2022 года (01 семинар)
// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
import java.util.Scanner;

public class j20221206_homework01 {
    public static void main(String[] args) {
        System.out.print("Введите n: ");
        Scanner scan = new Scanner(System.in);
        boolean flag = scan.hasNextInt();
        if (!flag) {
            System.out.println("Некорректный ввод");
            System.exit(0);
        }
        int number = scan.nextInt();

        int triangle = 0;
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            triangle += i;
            factorial *= i;
        }
        System.out.printf("Сумма чисел от 1 до %d равна %d\n", number, triangle);
        System.out.printf("Произведение чисел от 1 до %d равно %d", number, factorial);
    }
}