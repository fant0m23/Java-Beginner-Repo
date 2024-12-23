/*
1.  Написать метод, возвращающий количество чётных элементов массива.
        countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
2.  Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами
        переданного не пустого массива.
3.  Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента,
        с нулевым значением.

*/


public class Main {
    public static void main(String[] args) {

        int[] nums = {1, 9, 5, -2, 5, 29, 7, 0, 0};

        System.out.println(countEvens(nums));
        System.out.println(difBetweenMinMaxValues(nums));
        System.out.println(zerosSideBySide(nums));
    }

    private static int countEvens(int[] nums) {
        int counter = 0;
        for (int i : nums) {
            if (i%2 == 0) counter++;
        }
        return counter;
    }

    private static int difBetweenMinMaxValues(int[] nums) {
        if (nums.length == 0) {
            System.out.print("Количество элементов массива равно ");
            return 0;
        }
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > maxValue) maxValue = i;
            if (i < minValue) minValue = i;
        }
        return maxValue - minValue;
    }

    private static boolean zerosSideBySide(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0) {
                if (array[i + 1] == 0) return true;
            }
        }
        return false;
    }
}
