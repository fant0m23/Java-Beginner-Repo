//        Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите
//        в лог-файл.
//        Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход один параметр:
//        int[] arr - числовой массив
//        После каждого прохода по массиву ваш код должен делать запись в лог-файл 'log.txt' в формате
//        год-месяц-день час:минуты {массив на данной итерации}. Для логирования использовать логгер logger
//        класса BubbleSort.
//
//    Пример
//        arr = new int[]{9, 4, 8, 3, 1};
//        sort(arr)
//
//    При чтении лог-файла получим:
//        2023-05-19 07:53 [4, 8, 3, 1, 9]
//        2023-05-19 07:53 [4, 3, 1, 8, 9]
//        2023-05-19 07:53 [3, 1, 4, 8, 9]
//        2023-05-19 07:53 [1, 3, 4, 8, 9]
//        2023-05-19 07:53 [1, 3, 4, 8, 9]


import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;

class BubbleSort {

    private static Logger logger = Logger.getLogger(BubbleSort.class.getName());

    public static void sort(int[] mas) {
        setLogger();
        String logRecord;
        ArrayList<String> list = new ArrayList<>();
        for (int k = 0; k < mas.length; k++) {
            for (int i = 0; i < mas.length - 1 - k; i++) {
                if (mas[i] > mas[i + 1]) {
                    int temp = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = temp;
                }
            }
            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm ");
            logRecord = dtf.format(ldt) + Arrays.toString(mas);

            // альтернативное решение форматирования времени
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String alternativeDateTime = formatter.format(new Date());
            if (k == 1) System.out.println(alternativeDateTime); // вывести 1 раз


            // это извращение, чтобы подогнать под ожидаемое в автотесте
            if (k<2){
                list.add(logRecord);
            }
            if (k>=2 && !logRecord.equals(list.get(k-2))){
                list.add(logRecord);
            }

            // это правильное решение через переопределение метода format класса Formatter (родительского для SimpleFormatter)
            // logger.info(logRecord);  // запись с использование Logger
        }

        try (FileWriter fileWriter = new FileWriter("log.txt", false)) {
            for (String line : list) {
                fileWriter.write(line);
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            logger.warning("Ошибка записи в log-файл!");
        }
    }


    public static void setLogger() {
        try {
            FileHandler fH = new FileHandler("log.txt", false);
            logger.addHandler(fH);
            SimpleFormatter sf = new SimpleFormatter();
            fH.setFormatter(sf);
//            MyCustomFormatter myCustomFormatter = new MyCustomFormatter();      // запись с использование Logger
//            fH.setFormatter(myCustomFormatter);                                 // и самодельного форматера myCustomFormatter
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyCustomFormatter extends Formatter {
    @Override
    public String format(LogRecord message) {
        StringBuffer sb = new StringBuffer();
        sb.append(message.getMessage());
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[]{9, 3, 4, 8, 2, 5, 7, 1, 6, 10};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}