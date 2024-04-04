// Напишите метод, который сжимает строку. Пример: вход aaaabbbcdd.
//        результат a4b3c1d2

public class Compression {
    public static void main(String[] args) {
        String input = "aaaabbbcdd";

        System.out.println(CompressionStr(input));
    }

    public static String CompressionStr(String basic){
        int count = 1;
        char currentChar = basic.charAt(0);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < basic.length(); i++) {
            if(basic.charAt(i)==currentChar){
                count ++;
            }
            else{
                sb.append(currentChar).append(count);
                currentChar = basic.charAt(i);
                count = 1;
            }
        }
        sb.append(currentChar).append(count);

        return sb.toString();
    }
}
