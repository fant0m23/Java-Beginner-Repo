
//      1. Напишите метод, который заполнит массив из 1000 элементов случайными
//         цифрами от 0 до 500
//      2. Создайте метод, в который передайте заполненный выше массив и с
//         помощью Set вычислите процент уникальных значений в данном массиве и
//         верните его в виде числа с плавающей запятой.
//         Для вычисления процента используйте формулу:
//         процент уникальных чисел = количество уникальных чисел * 100 / общее
//         количество чисел в массиве.


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    private static int size = 1000;
    private static int maxValue = 500;
    private static int[] array = new int[size];

    public static void main(String[] args) {
        fillArray(array,maxValue);
        System.out.println(getPercentUnicNums(array));
    }

    public static void fillArray(int[] a, int maxValue){
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(maxValue);
        }
    }

    public static double getPercentUnicNums(int[] arr){
        Set<Integer> numsSet = new HashSet<>();
        for (Integer integer : arr) {
            numsSet.add(integer);
        }
        double percent = numsSet.size() * 100.0/arr.length;
        return percent;
    }
}