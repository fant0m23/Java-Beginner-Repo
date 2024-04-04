//        Дан произвольный массив целых чисел. Создайте список ArrayList, заполненный данными
//        из этого массива. Необходимо удалить из списка четные числа и вернуть результирующий.
//
//        Напишите свой код в методе removeEvenNumbers класса Answer. Метод removeEvenNumbers
//        принимает на вход один параметр: Integer[] arr - список целых чисел, возвращает список
//        ArrayList<Integer>
//
//        Примеры.
//        Исходный массив:
//        1, 2, 3, 4, 5, 6, 7, 8, 9
//        Результат:
//        [1, 3, 5, 7, 9]
//        Исходный массив:
//        2, 4, 6, 8
//        Результат:
//        []


import java.util.ArrayList;
import java.util.Arrays;

class Answer {
    public static ArrayList<Integer> removeEvenNumbers(Integer[] arr) {
        ArrayList<Integer> aList = new ArrayList<>();
        for (int item : arr) {
            aList.add(item);
        }
        // без цикла проще методом Arrays.asList()
        // ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(arr));
        for (int i = aList.size() - 1; i >= 0; i--) {
            if (aList.get(i) % 2 == 0) {
                aList.remove(i);
            }
        }
        System.out.println(aList);
        return aList;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{2, 4, 11, 6, 8, 23};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.removeEvenNumbers(arr);
    }
}