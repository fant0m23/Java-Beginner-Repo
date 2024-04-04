//        Реализуйте метод, который принимает на вход целочисленный массив arr:
//        - Создаёт список ArrayList, заполненный числами из исходного массива arr.
//        - Сортирует список по возрастанию и выводит на экран.
//        - Находит минимальное значение в списке и выводит на экран - Minimum is {число} - Находит
//        максимальное значение в списке и выводит на экран - Maximum is {число}
//        - Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
//        Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers принимает
//        на вход один параметр:
//
//        Integer[] arr - массив целых чисел.
//        Пример.
//        Исходный массив:
//        4, 2, 7, 5, 1, 3, 8, 6, 9
//        Результаты:
//        [1, 2, 3, 4, 5, 6, 7, 8, 9]
//        Minimum is 1
//        Maximum is 9


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Answer {
    public static void analyzeNumbers(Integer[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(arrayList);
        System.out.println(arrayList);
        System.out.println("Minimum is " + Collections.min(arrayList)); // проще: + arrayList.get(0));
        System.out.println("Maximum is " + Collections.max(arrayList)); // проще: + arrayList.get(arrayList.size()-1));
        double sum = 0;
        for (int item : arrayList) {
            sum += item;
        }
        System.out.println("Average is " + sum / arrayList.size());
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{4, 2, 3, 5, 1, 3, 3, 6, 9};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.analyzeNumbers(arr);
    }
}