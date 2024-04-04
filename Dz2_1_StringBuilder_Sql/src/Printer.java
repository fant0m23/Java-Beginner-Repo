//        Дана строка sql-запроса: select * from students where "
//        Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные (параметры)
//        для фильтрации приведены в виде json-строки в примере ниже. Если значение null, то параметр
//        не должен попадать в запрос.
//        Напишите свой код в методе answer класса Answer. Метод answer принимает на вход два параметра:
//        String QUERY - начало SQL-запроса String PARAMS - JSON с параметрами
//        Пример: Строка sql-запроса:
//        select * from students where
//        Параметры для фильтрации:
//        {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//        Результат:
//        select * from students where name='Ivanov' and country='Russia' and city='Moscow'

import java.util.ArrayList;

class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS) {
        StringBuilder result = new StringBuilder(QUERY);
        ArrayList<String> list = jsonToArrayList(PARAMS);
        for (int i = 1; i < list.size(); i += 2) {
            if (!list.get(i).equals("null")) {
                result.append(list.get(i - 1)).append("='").append(list.get(i)).append("' and ");
            }
        }
        if (result.length() > QUERY.length()) {
            result.setLength(result.length() - 5); // отрезаем " and " в конце строки (-5 символов)
        }
        return result;
    }

    private static ArrayList<String> jsonToArrayList(String PARAMS) {
        ArrayList<String> list = new ArrayList<>();
        int indexStart = 0;
        int indexEnd = 0;
        String subPARAMS = "";
        while (PARAMS.indexOf('\"', indexEnd + 1) > 0) {
            indexStart = PARAMS.indexOf('\"', indexEnd) + 1;
            indexEnd = PARAMS.indexOf('\"', indexStart);
            subPARAMS = PARAMS.substring(indexStart, indexEnd);
            if (!subPARAMS.equals(":") && !subPARAMS.equals(", ")) {
                list.add(subPARAMS);
            }
        }
        return list;
    }
}

// Решение от GB (работает в 1,5 - 2 раза медленнее):
class AnswerObrazec {
    public static StringBuilder answerObrazec(String QUERY, String PARAMS) {
        String paramsNew = PARAMS.replace('{', ' ').replace('}', ' ');
        String[] params = paramsNew.split(",");
        StringBuilder stringBuilder = new StringBuilder(QUERY);

        for (int i = 0; i < params.length; i++) {
            String[] elements = params[i].replace('"', ' ').split(":");
            if (!"null".equals(elements[1].trim())) {
                stringBuilder.append(elements[0].trim()).append("=").append("'").append(elements[1].trim()).append("'");
                if (i < params.length - 2) stringBuilder.append(" and ");
            }
        }
        return stringBuilder;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
            PARAMS = "{\"name\":\"Ivan\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        } else {
            QUERY = args[0];
            PARAMS = args[1];
        }
            // проверка работы методов и ЗАСЕЧЕНИЕ ВРЕМЕНИ с помощью -----> System.currentTimeMillis()  !!!!!!!!
        long start = System.currentTimeMillis();
        Answer ans = new Answer();
        for (int i = 0; i < 10_000_000; i++) {
            ans.answer(QUERY, PARAMS);
        }
        System.out.println(ans.answer(QUERY, PARAMS));
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        AnswerObrazec ans2 = new AnswerObrazec();
        for (int i = 0; i < 10_000_000; i++) {
            ans2.answerObrazec(QUERY, PARAMS);
        }
        System.out.println(ans2.answerObrazec(QUERY, PARAMS));
        System.out.println(System.currentTimeMillis() - start);
    }
}
