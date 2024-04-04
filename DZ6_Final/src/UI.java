import java.util.Scanner;

public class UI {
    private static String filter = "\t1 - Производитель\n\t2 - Диагональ дисплея\n\t3 - Объем ОЗУ" +
            "\n\t4 - Объем внутренней памяти\n\t5 - Операционная система\n\t6 - Цвет корпуса" +
            "\nВведите цифру, соответствующую необходимому критерию фильтрации ноутбуков: ";

    private static Scanner scanner = new Scanner(System.in);

    public static int requestCriteria() {
        while (true) {
            System.out.print(filter);
            String userInput = scanner.nextLine();
            if (isInteger(userInput)) {
                int choice = Integer.parseInt(userInput);
                if (choice < 1 || choice > 6) {
                    System.out.println("Выберите критерий фильтрации, введя цифру от 1 до 6!");
                    continue;
                }
                return choice;
            } else {
                System.out.println("Выберите критерий фильтрации, введя цифру от 1 до 6!");
            }
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static double getMinValue() {
        while (true) {
            System.out.print("Введите минимальное значение для выбранного критерия: ");
            String userInput = scanner.nextLine();
            if (isDouble(userInput)) {
                return Double.parseDouble(userInput);
            } else {
                System.out.println("Следует вводить цифру!");
            }
        }
    }

    public static String getUserStr() {
        return scanner.nextLine();
    }
}
