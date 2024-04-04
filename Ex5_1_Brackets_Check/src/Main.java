// Написать программу определяющую правильность расстановки скобок
// a * (b + c)      true
// [a * (b + c)     false
// [a] {*} (b + c)  true
// [<a> * {(b + c)}]  true
// [a *>] {(b + c)} false

import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String test = "[a <*>] {(b + c)}";
        boolean check = checkBrackets(test);
        System.out.println(check);
    }

    // метод создающий словарь скобок
    public static HashMap<Character, Character> createDictBrackets() {
        HashMap<Character, Character> dictBrackets = new HashMap<>();
        dictBrackets.put('}', '{');
        dictBrackets.put(')', '(');
        dictBrackets.put(']', '[');
        dictBrackets.put('>', '<');
        return dictBrackets;
    }

    // метод возвращающем истину или ложь
    public static boolean checkBrackets(String str) {
        HashMap<Character, Character> dictBrackets = createDictBrackets();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (dictBrackets.containsValue(c)) { // если с есть в значениях словаря
                stack.push(c); // записали в стэк '('
            } else if (dictBrackets.containsKey(c)) { // если с есть в ключах словаря
                if (stack.isEmpty() || stack.pop() != dictBrackets.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}