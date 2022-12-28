import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class InputOutput {

    public HashMap<Integer, String> getUserRequest() {
        HashMap<Integer, String> mapChoice = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String userChoice = "-1";
        while (!userChoice.equals("0")) {
            System.out.println("-------------------\nВведите параметр фильтра: ");
            System.out.println(
                    "1 --- ОЗУ \n2 --- объем ЖД \n3 --- Операционная система \n4 --- Цена \n0 --- Отобразить товары");
            userChoice = scanner.next();
            switch (userChoice) {
                case "1":
                    System.out.println("Введите требуемый объем ОЗУ (В наличии: 4,8,16): ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Неверный символ. Повторите ввод: ");
                        scanner.next();
                    }
                    userChoice = Integer.toString(scanner.nextInt());
                    mapChoice.put(1, userChoice);
                    break;
                case "2":
                    System.out.println(
                            "Введите требуемый объем жесткого диска (В наличии: 240, 256, 480, 512, 1000): ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Неверный символ. Повторите ввод: ");
                        scanner.next();
                    }
                    userChoice = Integer.toString(scanner.nextInt());
                    mapChoice.put(2, userChoice);
                    break;
                case "3":
                    System.out.println(
                            "Введите операционную систему (В наличии: DOS, Windows10, Windows11, No): ");
                    userChoice = scanner.next();
                    mapChoice.put(3, userChoice);
                    break;
                case "4":
                    System.out.println("Введите максимальную стоимость (от 23028 до 95980): ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Неверный символ. Повторите ввод: ");
                        scanner.next();
                    }
                    userChoice = Integer.toString(scanner.nextInt());
                    mapChoice.put(4, userChoice);
                    break;
                case "0":
                    break;

                default:
                    System.out.println("\nНекорректный ввод ");
                    break;
            }
            System.out.println("-------------------\nВаш фильтр: ");

            for (Map.Entry<Integer, String> item : mapChoice.entrySet()) {
                switch (item.getKey()) {
                    case 1:
                        System.out.println("ОЗУ: " + item.getValue());
                        break;
                    case 2:
                        System.out.println("Объем жесткого диска: " + item.getValue());
                        break;
                    case 3:
                        System.out.println("Операционная система: " + item.getValue());
                        break;
                    case 4:
                        System.out.println("Цена: " + item.getValue());
                        break;
                    default:
                        System.out.println("Вы ничего не выбрали ");
                        break;
                }
            }

        }

        return mapChoice;

    }

    public void printSet(Set set) {
        System.out.println("-------------------");
        for (var item : set) {
            System.out.println(item);
        }
    }

}