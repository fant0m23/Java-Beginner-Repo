/*
Задание
        -Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
        методы. Реализовать в java.
        -Создать множество ноутбуков.
        -Написать метод, который будет запрашивать у пользователя критерий (или критерии)
        фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
        хранить в Map. Например:
        "Введите цифру, соответствующую необходимому критерию":
        1 - ОЗУ
        2 - Объем ЖД
        3 - Операционная система
        4 - Цвет …
        -Далее нужно запросить минимальные значения для указанных критериев - сохранить
        параметры фильтрации можно также в Map.
        -Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
        условиям.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LaptopMain {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наш компьютерный магазин!");

        Laptop laptop1 = new Laptop("Asus", 17.3, 16, 512,
                "Windows 11", "Black"); // как и laptop3 - override equals,hashcode
        Laptop laptop2 = new Laptop("MSI", 17.1, 32, 512,
                "Без ОС", "White");
        Laptop laptop3 = new Laptop("Asus", 17.3, 16, 512,
                "Windows 11", "Black");
        Laptop laptop4 = new Laptop("Lenovo", 15.6, 8, 256,
                "Windows 10", "Black");
        Laptop laptop5 = new Laptop("Asus", 15.6, 16, 512,
                "Linux", "Grey");
        Laptop laptop6 = new Laptop("Apple", 15, 4, 128,
                "Mac OS", "Silver");

        Set<Laptop> laptops = new HashSet<>(
                Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6));

        ArrayList<Laptop> outputList = new ArrayList<>();

        switch (UI.requestCriteria()) {
            case 1:
                System.out.println("Введите компанию-изготовителя ноутбука\n" +
                        "(возможные варианты: Asus, Lenovo, Apple, MSI): ");
                String userBrand = UI.getUserStr().strip();
                for (Laptop laptop : laptops) {
                    if (laptop.getBrand().equalsIgnoreCase(userBrand)) {
                        outputList.add(laptop);
                    }
                }
                System.out.printf("\tНоутбуки производства \"%s\":\n", userBrand);
                showFilteredLaptops(outputList);
                break;
            case 2:
                double minUserDisplay = UI.getMinValue();
                for (Laptop laptop : laptops) {
                    if (laptop.getDisplayDiagonal() >= minUserDisplay) {
                        outputList.add(laptop);
                    }
                }
                System.out.printf("\tНоутбуки с диагональю дисплея от %.1f дюймов:\n", minUserDisplay);
                showFilteredLaptops(outputList);
                break;
            case 3:
                double minUserRAM = UI.getMinValue();
                for (Laptop laptop : laptops) {
                    if (laptop.getSizeRAM() >= minUserRAM) {
                        outputList.add(laptop);
                    }
                }
                System.out.printf("\tНоутбуки с оперативной памятью от %.0fGb:\n", minUserRAM);
                showFilteredLaptops(outputList);
                break;
            case 4:
                double minUserROM = UI.getMinValue();
                for (Laptop laptop : laptops) {
                    if (laptop.getSizeROM() >= minUserROM) {
                        outputList.add(laptop);
                    }
                }
                System.out.printf("\tНоутбуки с объемом SSD-накопителя от %.0fGb:\n", minUserROM);
                showFilteredLaptops(outputList);
                break;
            case 5:
                System.out.println("Введите предпочтительную операционную систему\n" +
                        "(возможные варианты: Windows 11, Windows 10, Без ОС, Mac OS, Linux): ");
                String userOS = UI.getUserStr().strip();
                for (Laptop laptop : laptops) {
                    if (laptop.getOS().equalsIgnoreCase(userOS)) {
                        outputList.add(laptop);
                    }
                }
                System.out.printf("\tНоутбуки с операционной системой \"%s\":\n", userOS);
                showFilteredLaptops(outputList);
                break;
            case 6:
                System.out.println("Введите предпочтительный цвет корпуса\n" +
                        "(возможные варианты: Black, White, Grey, Silver): ");
                String userColor = UI.getUserStr().strip();
                for (Laptop laptop : laptops) {
                    if (laptop.getCaseColor().equalsIgnoreCase(userColor)) {
                        outputList.add(laptop);
                    }
                }
                System.out.printf("\tНоутбуки с цветом корпуса \"%s\":\n", userColor);
                showFilteredLaptops(outputList);
                break;
        }
    }

    private static void showFilteredLaptops(ArrayList<Laptop> outputList) {
        if (outputList.isEmpty()) {
            System.out.println("Ноутбуки, удовлетворяющие критерию поиска не найдены.");
        } else {
            for (Laptop laptop : outputList) {
                System.out.println(laptop);
            }
        }
    }
}