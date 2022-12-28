import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Notebooks {

    private String brend;
    private String model;
    private float diagonal;
    private int ram;
    private int hdd;
    private String os;
    private String color;
    private int price;

    public Notebooks() {
    }

    public Notebooks(String brend, String model, float diagonal, int ram, int hdd, String os, String color, int price) {

        this.brend = brend;
        this.model = model;
        this.diagonal = diagonal;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
        this.price = price;

    }

    @Override
    public String toString() {

        return String.format("%-10s %-49s %3.1f\" %5dGb %7dGb %-11s %-8s %7dруб", brend, model, diagonal, ram, hdd, os,
                color, price);

    }

    public Set<Notebooks> filter(Set<Notebooks> inputSet, HashMap<Integer, String> mapChoice) {
        Set<Notebooks> outputSet = new LinkedHashSet<>(inputSet);

        for (Notebooks item : inputSet) {

            if (mapChoice.containsKey(1)) {
                if (item.ram != Integer.parseInt(mapChoice.get(1))) {
                    outputSet.remove(item);
                }
            }
            if (mapChoice.containsKey(2)) {
                if (item.hdd != Integer.parseInt(mapChoice.get(2))) {
                    outputSet.remove(item);
                }
            }
            if (mapChoice.containsKey(3)) {
                if (!item.os.equals(mapChoice.get(3))) {
                    outputSet.remove(item);
                }
            }
            if (mapChoice.containsKey(4)) {
                if (item.price > Integer.parseInt(mapChoice.get(4))) {
                    outputSet.remove(item);
                }

            }

        }

        if (outputSet.isEmpty()) {
            System.out.println("Товаров по Вашему фильтру нет");
        }
        return outputSet;

    }

}