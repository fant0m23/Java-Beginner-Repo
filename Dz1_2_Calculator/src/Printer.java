// В методе calculate класса Calculator реализовать калькулятор, который будет выполнять математические операции
// (+,- *, /) над двумя целыми числами и возвращать результат вещественного типа. В классе Printer необходимо
// реализовать проверку переданного оператора, при некорректном операторе программа должна вывести сообщение
// об ошибке "Некорректный оператор: 'оператор'".
//
// Аргументы, передаваемые в метод/функцию:
//        '3'
//        '+'
//        '7'
// На выходе:
//              10.0

class Calculator {
    public float calculate(char op, int a, int b) {
        float res = 0f;
        switch (op) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                if (b == 0) throw new ArithmeticException("Делить на ноль нельзя!");
                res = a / (float) b;
                break;
            default:
                throw new IllegalArgumentException("Некорректный оператор: '" + op + "'");
        }
        return res;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        int a = 0;
        char op = ' ';
        int b = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '/';
            b = 0;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        Calculator calculator = new Calculator();
        try {
            float result = calculator.calculate(op, a, b);
            System.out.println(result);
        } catch (ArithmeticException zeroDiv) {
            System.out.println(zeroDiv.getMessage());
        } catch (IllegalArgumentException opError) {
            System.out.println(opError.getMessage());
        }
    }
}
