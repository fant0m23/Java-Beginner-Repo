// Напишите метод, который принимает на вход строку (String) и определяет является ли строка
//        палиндромом (возвращает boolean значение).
//

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userStr = scan.nextLine();

        System.out.println(isPalindrom(userStr));
    }

    public static boolean isPalindrom(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
