
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Задача 1: Вывести текущие дату, время.
        LocalDateTime dataTime = LocalDateTime.now();
        Date dateOldFormat = Date.from(Instant.now()); // устаревший класс работы с системным временем (также Calendar)
        System.out.println(dateOldFormat);
        System.out.println(dataTime);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя >>> ");
        String name = scanner.nextLine();
        scanner.close();

        System.out.printf("Привет, %s!\n", name);

        // Задача 2
        // Дан массив двоичных чисел, например [1,1,0,1,1,1,1], вывести максимальное количество подряд идущих 1.
        int[] mass = new int[]{1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1};
        int count = 0;
        int maxCount = 0;
        for (int i = 1; i < mass.length; i++) {
            if (mass[i] == 1) count++;
            else count = 0;
            if (count > maxCount) maxCount = count;
        }
        // варианты использования интерполяции
        String test = "Максимальное количество подряд идущих единиц равно";
        float f = 36.145f;
        double d = 22.7;
        String urlString = String.format("%s %d.\nРешил задачу: %s. \n%f \n%g \n%s", test, count, name, f, d, dataTime);
        // спецификаторы функции format:
        //      %s - для строки !!! (осуществит приведение любого типа к строке)
        //      %d - для целых типов (int, byte, long)
        //      %f - для float
        //      %f или %g - для double, при этом можно указать количество знаков после запятой при округлении
        //                  например: %4.2f означает 4 цифры всего 2 из которых после запятой
        //                              %.1f - покажет число с точностью до десятых
        //      %c - для char
        //      %b - преобразует в boolean (True/False)
        //      %t_ - для объектов LocalDateTime (есть множество вариантов %tA - день недели, %tY - год, %tL - мс, и др.)
        System.out.println(urlString);
        System.out.printf("%s %d.\nРешил задачу: %s.", test, count, name);
    }
}
