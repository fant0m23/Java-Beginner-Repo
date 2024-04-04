//      Задание №2.1
//        📌 Заполнить список названиями планет Солнечной
//        системы в произвольном порядке с повторениями.
//        📌 Вывести название каждой планеты и количество его
//        повторений в списке.
//        Задание состоит из двух блоков
//        Задание №2.2 (если выполнено первое задание)
//        📌 Пройти по списку из предыдущего задания и удалить
//        повторяющиеся элементы.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> planets = new ArrayList<>();
        planets.add("Меркурий");
        planets.add("Марс");
        planets.add("Венера");
        planets.add("Сатурн");
        planets.add("Марс");
        planets.add("Юпитер");
        planets.add("Уран");
        planets.add("Нептун");
        planets.add("Марс");
        planets.add("Земля");
        planets.add("Юпитер");
        planets.add("Нептун");
        planets.add("Венера");
        System.out.println(planets);

        showPlanetsAndAmount(planets);
        deleteDubl(planets);

        System.out.println(planets);
    }

    public static void showPlanetsAndAmount(List<String> list){
        List<String> planets = new ArrayList<>(list);
        Collections.sort(planets);
        String currentPlanet = planets.get(0);
        int counter = 1;
        for (int i = 1; i < planets.size(); i++) {

            if (planets.get(i).equals(currentPlanet)){
                counter ++;
            }
            else {
                System.out.printf("%s -> %d \n", currentPlanet, counter);
                currentPlanet = planets.get(i);
                counter = 1;
            }
        }
        System.out.printf("%s -> %d \n", currentPlanet, counter);
    }

    private static void deleteDubl(List<String> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = array.size() - 1; j > i; j--) {
                if (array.get(i).equals(array.get(j))) {
                    array.remove(j);
                }
            }
        }
    }
}