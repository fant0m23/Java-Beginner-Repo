// Напишите функцию printPrimeNums, которая выведет на экран все простые числа в промежутке от 1 до 1000,
// каждое на новой строке. Напишите свой код в методе printPrimeNums класса Answer.
//        Пример:
//        2
//        3
//        5
//        7
//        11

class Answer {
    public void printPrimeNums() {
        for (int i = 2; i < 1000; i++) {
            if (i == 2) System.out.println(i);
            if (i % 2 == 0) continue;
            int d = 3;
            while (d * d <= i && i % d != 0) d += 2;
            if (d * d > i) System.out.println(i);
        }
    }
    public void printPrimeNums2() {
        // Проход начинается с 2, т.к. это число является наименьшим простым
        for (int i = 2; i <= 1000; i++) {
            boolean isPrime = true;
            // Проверка, является ли число i простым
            // Проход по циклу до корня числа,
            // т.к. дальше нет смысла искать, делителей нет.
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            // Если число i простое, вывод его на экран
            if (isPrime)
                System.out.println(i);
        }
    }
}

public class PrimeNums {
    public static void main(String[] args) {

        Answer ans = new Answer();
        ans.printPrimeNums();
        ans.printPrimeNums2();
    }
}

