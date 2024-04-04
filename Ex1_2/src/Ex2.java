import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4, 8, 3, 6, 8, 2, 3, 0, 2, 3};
        int val = 3;
        appendValue(nums, val);
        System.out.println(Arrays.toString(nums));

    }
    public static void appendValue(int[] mass, int value) {
        int size = mass.length;
        int count = 0;
        for (int i = 0; i < mass.length - 1; i++) {
            if (mass[i]==value){
                count ++;
            }
        }
    }
}
