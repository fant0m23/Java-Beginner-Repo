//        Заполнить список десятью случайными числами.
//        Отсортировать список методом sort() класса Collections и вывести его на
//        экран.


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        List<Integer> arrayList = fillArrayList(size);

        System.out.println(arrayList);
        Collections.sort(arrayList);

        System.out.println(arrayList);

    }

    private static List<Integer> fillArrayList(int size) {
        List<Integer> arrayList = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < size; i++) {
            arrayList.add(rnd.nextInt(100));
        }
        return arrayList;
    }
}