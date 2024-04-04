//      Создать список типа ArrayList<String>.
//        📌 Поместить в него как строки, так и целые числа.
//        📌 Пройти по списку, найти и удалить целые числа.


import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("-28");
        arr.add("5");
        arr.add("cat");
        arr.add("12");
        arr.add("%^");
        //delDigits(arr);
        System.out.println(arr);
        delDigitWithIterator(arr);
        System.out.println(arr);
    }

    public static void delDigits(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (isInteger(list.get(i))) {
                list.remove(i);
                i--;
            }
        }
    }

    public static void delDigitWithIterator(ArrayList<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (isInteger(str)) iterator.remove();
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
}