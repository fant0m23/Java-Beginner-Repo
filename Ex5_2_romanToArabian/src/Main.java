//  Написать метод, кот. переводит число из римского формата в арабский
//  MMXXIV = 2024


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String testStr = "B";
        System.out.printf("%s - это %s", testStr, convertRomeToArabian(testStr));
    }

    public static String convertRomeToArabian(String rome) {
        int sum = 0;
        HashMap<Character, Integer> dictMXVI = createDictMXVI();
        char[] romeArr = rome.toCharArray();
        // данный алгоритм в цикле не доделан после 2-го if !!!!!!!!!!!!!!!!!!!
        for (int i = romeArr.length - 1; i >= 0; i++) {
            if (!dictMXVI.containsKey(romeArr[i])) {
                return "не римское число!";
            }
            if (romeArr.length == 1){
                sum += dictMXVI.get(romeArr[i]);
                break;
            }
            if (i == 0 && dictMXVI.get(romeArr[i]) >= dictMXVI.get(romeArr[i + 1])) {
                sum += dictMXVI.get(romeArr[i]);
            } else {
                sum += dictMXVI.get(romeArr[i + 1]) - dictMXVI.get(romeArr[i]);
            }
        }
        return String.format("%d", sum);
    }

    public static HashMap<Character, Integer> createDictMXVI() {
        HashMap<Character, Integer> dictMXVI = new HashMap<>();
        dictMXVI.put('M', 1000);
        dictMXVI.put('D', 500);
        dictMXVI.put('C', 100);
        dictMXVI.put('L', 50);
        dictMXVI.put('X', 10);
        dictMXVI.put('V', 5);
        dictMXVI.put('I', 1);
        return dictMXVI;
    }
}