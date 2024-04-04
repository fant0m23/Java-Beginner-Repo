/*
Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки
кучей (Heap Sort). Программа должна работать следующим образом:

Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен, программа
использует массив по умолчанию. Сначала выводить исходный массив на экран.
Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке
возрастания. Выводить отсортированный массив на экран.

Ваше решение должно содержать два основных метода: buildTree, который строит сортирующее дерево
на основе массива, и heapSort, который выполняет собственно сортировку кучей.
Программа должна быть способной сортировать массив, даже если он состоит из отрицательных чисел
и имеет дубликаты.

На входе:
'5 8 12 3 6 9'

На выходе:
Initial array:
[5, 8, 12, 3, 6, 9]
Sorted array:
[3, 5, 6, 8, 9, 12]

*/

import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] tree, int i, int n) {
        //левый ребёнок
        int l = i * 2 + 1;
        //правый ребёнок
        int r = i * 2 + 2;
        //Инициализируем наибольший элемент как корень
        int largest = i;
        //Проверка чтоб дети не стали больше чем родители
        //Если левый дочерний элемент больше корня
        if(l < n && tree[l] > tree[largest])
            largest = l;
        //Если правый дочерний элемент больше,
        // чем самый большой элемент на данный момент
        if(r < n && tree[r] > tree[largest])
            largest = r;
        //Если, ребёнок оказался больше родителя, то делаем обмен,
        //ребёнка с родителем. Если самый большой элемент не корень
        if (i != largest){
            int temp = tree[i];
            tree[i] = tree[largest];
            tree[largest] = temp;

            //Проверяем ещё раз чтоб дети были меньше чем родители,
            //если, вдруг у детей есть свои дети
            //Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            buildTree(tree, largest, n);
        }
    }

    public static void heapSort(int[] arr, int sortLength) {

        int n = sortLength;

        //создаём дерево, построение кучи (перегруппируем массив)
        for(int i  = n / 2 - 1; i >= 0; i--)
            buildTree(arr, i , n);

        //Делаем сортировку массива, уже отсортированного дерева,
        //Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--){

            // Перемещаем текущий корень в конец
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // Вызываем процедуру buildTree на уменьшенной куче
            buildTree(arr, 0, i);
        }
    }
}
// Не удаляйте и не меняйте метод Main!
public class Printer {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}