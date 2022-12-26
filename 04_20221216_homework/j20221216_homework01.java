// Задача 001 от 16 декабря 2022 года (4 семинар)

// Пусть дан LinkedList с несколькими элементами. 
// Реализуйте метод, который вернет “перевернутый” список.

import java.util.LinkedList;

public class j20221216_homework01 {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("Однажды ");
        list.add("в студеную зимнюю пору ");
        list.add("я из лесу вышел ");
        list.add("был сильный мороз ");
        list.add("гляжу ");


        System.out.println("Список на входе: " + list);

        reverseList(list);

        System.out.println("Список на выходе: " + list);
    }

    public static void reverseList(LinkedList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            list.add(i, list.pollLast());
        }
    }
}