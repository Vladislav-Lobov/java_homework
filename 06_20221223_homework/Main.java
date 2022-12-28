// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, 
// отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
        public static void main(String[] args) {

                LinkedHashSet<Notebooks> set = new LinkedHashSet<>();

                int sizeOfItems = 44;
                String[] arrayBrend = { "Acer", "Acer", "Acer", "Acer", "Acer", "Acer", "Acer", "Acer", "Acer", "Acer",
                                "Acer",
                                "Acer", "Acer", "Acer", "ASUS", "ASUS", "ASUS", "ASUS", "ASUS", "ASUS", "ASUS",
                                "Gigabyte", "Gigabyte",
                                "Gigabyte", "Gigabyte", "HP Victus", "HP Victus", "Lenovo", "Lenovo", "Lenovo",
                                "Lenovo", "Lenovo",
                                "Lenovo", "Lenovo", "Lenovo", "Lenovo", "Lenovo", "Lenovo", "Lenovo", "Lenovo",
                                "Lenovo", "Lenovo",
                                "Lenovo", "Lenovo" };
                String[] arrayModel = { "Aspire-3-A315-35-C7AH", "Aspire-3-A315-35-C7AH", "Aspire-3-A315-56-32XE",
                                "Aspire-3-A315-56-32XE", "AspireAcer-Aspire-3-A315-56-37HA",
                                "AspireAcer-Aspire-3-A315-56-37HA",
                                "Aspire-3-A315-56-56CG", "Aspire-3-A315-58-320P", "Aspire-3-A315-58G-53JM",
                                "Aspire-3-A315-58G-53JM",
                                "Extensa-15-EX215-52-39AX", "Extensa-15-EX215-52-53U4", "TravelMate-P2-TMP215-53G-39CT",
                                "TravelMate-P2-TMP215-53G-39CT", "ExpertBook-B1-B1500 (90NX0441-M02LJ0)",
                                "ExpertBook-B1-B1500CEAE-BQ2615X (90NX0441-M02NT0)", "FX506HC-HN105-TUF Gaming",
                                "P1512CEA-BQ0825X (90NX05E1-M010F0)", "TUF-Gaming-FA506ICB-HN105",
                                "X515EASUS-X515EA-BQ1189",
                                "X515EA-BQ1461W", "AORUS-15-XE4", "AORUS-15-XE5", "AORUS-17-XE4", "AORUS-5-SE4",
                                "16-d1074ci-6X7Q8EA",
                                "16-e0051ur-4L678EA", "IdeaPad-3-15ALC6-82KU009GRK", "IdeaPad-3-15ALC6-82KU009JRK",
                                "IdeaPad-3-15ALC6-82KU009JRK", "IdeaPad-3-15II05-81WE0122RK",
                                "IdeaPad-3-15ITL6-82H8010NRK",
                                "IdeaPad-3-15ITL6-82H8010NRK", "IdeaPad-3-15ITL6-82HL005VRK",
                                "IdeaPad-3-15ITL6-82HL005VRK",
                                "IdeaPad-3-15ITL6-82HL008DKG,", "IdeaPad-3-15ITL6-82HL008DKG,",
                                "IdeaPad-S145-15IIL-81W800SEKG",
                                "Legion-5-15IMH6-82NL000GRK", "V15-IGL-82C3001URU", "V15-IGL-82C3001URU",
                                "V15-IIL-82C500FNRU",
                                "V15-IIL-82C500JQRU", "Yoga-S740-15IRH" };
                float[] arrayDiagonal = { 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f,
                                15.6f,
                                15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 17.3f,
                                15.6f, 16.1f, 16.1f,
                                15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f, 15.6f,
                                15.6f, 15.6f, 15.6f,
                                15.6f, 15.6f };
                int[] arrayRam = { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 16, 16, 8, 8, 8, 8, 8, 8, 8, 8, 16, 16,
                                8, 8, 8,
                                4, 8, 8, 8, 8, 8, 8, 4, 8, 4, 4, 8, 8, 8 };
                int[] arrayHdd = { 256, 480, 256, 480, 256, 480, 256, 256, 256, 480, 256, 512, 256, 480, 256, 512, 512,
                                512,
                                512, 256, 256, 512, 512, 256, 256, 512, 512, 128, 256, 480, 1000, 256, 480, 256, 480,
                                240, 256, 1000,
                                256, 128, 240, 240, 240, 256 };
                String[] arrayOs = { "DOS", "DOS", "DOS", "DOS", "DOS", "DOS", "DOS", "DOS", "DOS", "DOS", "DOS", "DOS",
                                "DOS",
                                "DOS", "DOS", "Windows11", "DOS", "Windows11", "DOS", "DOS", "Windows11", "Windows11",
                                "DOS", "DOS",
                                "Windows11", "DOS", "DOS", "No", "No", "No", "DOS", "No", "No", "DOS", "DOS", "DOS",
                                "DOS", "DOS",
                                "DOS", "No", "No", "DOS", "DOS", "Windows10" };
                String[] arrayColor = { "Black", "White", "Grey", "Red", "Yellow", "Black", "White", "Grey", "Red",
                                "Yellow",
                                "Black", "White", "Grey", "Red", "Yellow", "Black", "White", "Grey", "Red", "Yellow",
                                "Black", "White",
                                "Grey", "Red", "Yellow", "Black", "White", "Grey", "Red", "Yellow", "Black", "White",
                                "Grey", "Red",
                                "Yellow", "Black", "White", "Grey", "Red", "Yellow", "White", "Grey", "Red", "Yellow" };
                int[] arrayPrice = { 26198, 27783, 33290, 34875, 32122, 33707, 40716, 34708, 52313, 56068, 33374, 44220,
                                42635,
                                43803, 42961, 75377, 73923, 64515, 62576, 32539, 33707, 64515, 62576, 32539, 33707,
                                95980, 76456, 42551,
                                35376, 34708, 32111, 25781, 26949, 34660, 35509, 39881, 37545, 30870, 73144, 23028,
                                23862, 42551, 40549,
                                68416 };

                for (int i = 0; i < sizeOfItems; i++) {
                        Notebooks item = new Notebooks(arrayBrend[i], arrayModel[i], arrayDiagonal[i], arrayRam[i],
                                        arrayHdd[i],
                                        arrayOs[i], arrayColor[i], arrayPrice[i]);
                        set.add(item);
                }

                HashMap<Integer, String> mapChoice = new HashMap<>();
                InputOutput inputOutput = new InputOutput();
                mapChoice = inputOutput.getUserRequest();
                Notebooks getFilter = new Notebooks();
                Set<Notebooks> outputSet = new LinkedHashSet<>();
                outputSet = getFilter.filter(set, mapChoice);
                inputOutput.printSet(outputSet);

        }

}
