public class AlternatingChars {
    public static void main(String[] args) {
        int n = 100_000_000;
        char c1 = 'a';
        char c2 = 'b';
        long start = System.currentTimeMillis();
        // System.out.println(alternatingCharsString(n, c1, c2));
        //alternatingCharsString(n, c1, c2);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        alternatingCharsSBuilder(n, c1, c2);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static String alternatingCharsString(int n, char c1, char c2) {
        String str = "";
        for (int i = 0; i < n / 2; i++) {
            str += c1;
            str += c2;
        }
        return str;
    }

    public static String alternatingCharsSBuilder(int n, char c1, char c2) {
        StringBuilder sb = new StringBuilder(n); // по умолчанию конструктор создает внутренний массив на 16 символов,
        // при превышении кол-ва эл-тов будет пересобираться массив, поэтому лучше в конструкторе сразу указывать длину
        for (int i = 0; i < n / 2; i++) {
            sb.append(c1).append(c2);
        }
        return sb.toString();
    }
}
