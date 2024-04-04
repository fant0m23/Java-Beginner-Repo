// Наполнение стэка из массива


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(array));
        arrayToStack(array);
        arrayToQueue(array);
    }

    public static void arrayToStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int item : arr){
            stack.push(item); // единственный метод добавления элемента в стэк
        }
        while (!stack.empty()){
            System.out.println(stack.pop()); // метод извлечения элемента стэка
            // .peek() только считывание "текущего" (последнего) элемента
        }
    }

    public static void arrayToQueue(int[]arr){
        Queue<Integer> queue = new LinkedList<>();
        for (int item:arr) {
            queue.add(item);
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll()); // лучше использовать именно метод интерфейса .poll()
            // а не наследованный от класса List метод .remove()
        }
    }
}