// Задача 001 от 20 декабря 2022 года (5 семинар)

// Реализуйте структуру телефонной книги с помощью HashMap, 
// учитывая, что 1 человек может иметь несколько телефонов.

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class J20221220_homework01 {

    public static void main(String[] args) {

        boolean noDuplicates = true;
        HashMap<String, String> phoneBook = new HashMap<>();

        for (int i = 0; i < 15; i++) {

            phoneBook.put(getPhone(), getName());
        }

        for (Map.Entry entry : phoneBook.entrySet()) {

            System.out.println(entry);

        }

        Set<String> namesSet = new HashSet<String>(phoneBook.values());

        for (String item : namesSet) {

            if (Collections.frequency(phoneBook.values(), item) > 1) {
                System.out.println("Повторы: " + item);
                noDuplicates = false;
            }

        }
        System.out.println(noDuplicates ? "Повторов нет" : "");

    }

    public static String getName() {

        String[] surname = {
                "Абрамов Даниил", "Акимов Альберт", "Андреев Юрий", "Анисимов Олег",
                "Антонов Матвей", "Архипов Иван", "Афанасьев Леонид", "Баранов Илья",
                "Белов Андрей", "Белоусов Владимир", "Беляев Антон", "Бирюков Аркадий",
                "Богданов Роман", "Борисов Алексей", "Быков Константин", "Васильев Станислав",
                "Виноградов Артемий", "Власов Лев", "Волков Михаил", "Воробьев Тарас",
                "Гончаров Игнат", "Горбунов Алексей", "Горшков Владимир", "Грачев Ярослав",
                "Григорьев Валерий", "Гришин Василий", "Громов Виктор", "Гусев Виталий",
                "Давыдов Владимир", "Данилов Владислав", "Демидов Вячеслав", "Демин Геннадий",
                "Денисов Георгий", "Дмитриев Григорий", "Егоров Денис", "Елисеев Дмитрий",
                "Емельянов Евгений", "Еремин Егор", "Ермаков Иван", "Ефимов Игорь",
                "Ефремов Илья", "Жуков Кирилл", "Журавлев Константин", "Зайцев Леонид",
                "Исаев Максим", "Казаков Михаил", "Калинин Никита", "Карпов Николай",
                "Кириллов Олег", "Киселев Павел", "Комаров Пётр", "Кондратьев Роман",
                "Коновалов Руслан", "Королев Сергей", "Котов Станислав", "Краснов Степан",
                "Крылов Федор", "Лебедев Эдуард", "Левин Юрий" };

        Random random = new Random();

        return surname[random.nextInt(surname.length)];

    }

    public static String getPhone() {

        Random random = new Random();

        return "+79" + (random.nextInt(900000000) + 100000000);
    }

}