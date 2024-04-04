import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListSplit {
    public static void main(String[] args) {
        String[] mass = new String[]{"null", "0"};
        LinkedList<String> linkList = new LinkedList<>();
        int pos = 1;
        while (true) {
            // принимаем на вход строку вида text~num
            System.out.println("Введите строку вида text~num >>> ");
            Scanner scan = new Scanner(System.in);
            String usersInput = scan.nextLine();

            // рассплит по ~ и кладем text в связный список на позицию num
            mass = usersInput.split("~");
            pos = Integer.parseInt(mass[1]) - 1;
            if (mass[0].equals("print")) {
                System.out.println(printNum(linkList, pos));
                break;
            }
            if (pos + 1 > linkList.size()) {
                for (int i = 0; i <= pos - linkList.size() + 2; i++) {
                    linkList.addLast("null");
                }
            }
            linkList.set(pos, mass[0]);
            System.out.println(linkList);
            scan.close();
        }

        System.out.println(linkList);
    }

    public static String printNum(LinkedList list, int pos) {
        return list.remove(pos).toString();
    }
}