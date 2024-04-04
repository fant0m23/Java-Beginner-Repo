//      Напишите метод, который находит самую длинную строку общего префикса среди массива строк.
//      Если общего префикса нет, вернуть пустую строку "".
//      Например: flowers flow flight
//      Результат:

public class SubstringIndexOf {
    public static void main(String[] args) {
        String text = "flowers flow flight";
        String[] words = text.split(" ");  // {"flowers", "flow", "flight"}

        System.out.println(myGetMaxPrefix(words));
        System.out.println(getMaxPrefix(words));
    }

    public static String myGetMaxPrefix(String[] words) { // моё решение
        if (words.length == 0 || words == null) return "";
        String prefix = "";
        int minWord = 100;
        for (String word : words) {
            if (word.length() < minWord) minWord = word.length();
        }
//        for (int index = 0; index < minWord; index++) {
//
//            for (int i = 0; i < words.length; i++) {
//                char temp = words[i][index];
//                if (){
//                    prefix += temp;
//                }
//            }
//        }
        return Integer.toString(minWord);
    }

    public static String getMaxPrefix(String[] words) {  // решение преподавателя
        if (words.length == 0 || words == null) return "";
        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            while (words[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}