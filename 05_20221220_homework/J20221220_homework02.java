// Задача 002 от 20 декабря 2022 года (5 семинар)

// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class J20221220_homework02 {

    public static void main(String[] args) {

        Map<String, String> peopleMap = new HashMap<>();
        peopleMap.put("Иванов", "Иван");
        peopleMap.put("Петрова", "Светлана");
        peopleMap.put("Белова", "Кристина");
        peopleMap.put("Мусина", "Анна");
        peopleMap.put("Крутова", "Анна");
        peopleMap.put("Юрин", "Иван");
        peopleMap.put("Лыков", "Петр");
        peopleMap.put("Чернов", "Павел");
        peopleMap.put("Чернышов", "Петр");
        peopleMap.put("Федорова", "Мария");
        peopleMap.put("Светлова", "Марина");
        peopleMap.put("Савина", "Мария");
        peopleMap.put("Рыкова", "Мария");
        peopleMap.put("Лугова", "Марина");
        peopleMap.put("Владимирова", "Анна");
        peopleMap.put("Мечников", "Иван");
        peopleMap.put("Петин", "Петр");
        peopleMap.put("Ежов", "Иван");

        Map<String, Integer> namesMap = new HashMap<>();
        Set<String> namesSet = new HashSet<String>(peopleMap.values());

        for (String item : namesSet) {
            namesMap.put(item, Collections.frequency(peopleMap.values(), item));
        }

        ArrayList<Integer> freqArray = new ArrayList<>(namesMap.values());
        Collections.sort(freqArray);
        Collections.reverse(freqArray);

        Map<String, Integer> resultMap = new LinkedHashMap<>();

        for (var item_array : freqArray) {

            for (Map.Entry<String, Integer> item : namesMap.entrySet()) {
                if (item.getValue().equals(item_array)) {
                    resultMap.put(item.getKey(), item.getValue());
                }
            }
        }

        System.out.println(resultMap);

    }

}
