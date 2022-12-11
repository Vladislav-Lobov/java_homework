// Задача 001. Семинар 2 от 09 декабря 2022 года.

// Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class j20221209_homework01 {

    public static void main(String[] args) {
        StringBuilder sql = new StringBuilder();
        StringBuilder isContainsNull = new StringBuilder();

        try {

            // используется массив записей JSON
            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray) parser.parse(new FileReader("file.json"));

            for (Object o : a) {
                JSONObject object = (JSONObject) o;

                String name = (String) object.get("name");
                String country = (String) object.get("country");
                String city = (String) object.get("city");
                String age = (String) object.get("age");

                isContainsNull.setLength(0);
                isContainsNull.append(name).append(country).append(city).append(age);

                if (isContainsNull.indexOf("null") != -1) {
                    continue;
                }

                sql.setLength(0);
                sql.append("SELECT * FROM students WHERE ");
                sql.append("name:\"").append(name);
                sql.append("\" AND country:\"").append(country);
                sql.append("\" AND city:\"").append(city);
                sql.append("\" AND age:\"").append(age).append("\"");

                System.out.println(sql);
            }
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
    }
}