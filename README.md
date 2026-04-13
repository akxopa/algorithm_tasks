# Здесь описание проекта 
# Algorithm Tasks

### Цель проекта
Показать свое портфолио и чему я научилась при решении задач на алгоритмы.
Задачи взяты из CodeRun и Тренировок по алгоритмам от Яндекс 2026.

### Основная идея проекта
Algorithm Tasks - консольное приложение.

Пользователю дается описание кнопок
затем выводится лист с задачами
1: Oligopoliya
2: Decode the string
...

0: Exit

При нажатии кнопки с задачей выводится:
Описание задачи
Пример входных данных 
Пример выходных данных

Пользователью предлагается:
s: запустить решение задачи
m: выйти в меню
0: завершить приложение

Пример:
2: Decode the string

 Раскодируй строку
 символам a - i соответсвуют числа 1 по 9
 символам j - z соответсвуют 10# по 26#

Ввод:
32410#12326#

Вывод:
cbdjabcz

Код:

```
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Раскодируй строку
 * символам a - i соответсвуют числа 1 по 9
 * символам j - z соответсвуют 10# по 26#
 * 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = reader.readLine();

        writer.write(service(line));

        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }

    static String service(String input) {
        if (input == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int inputLength = input.length(); // размер исходной строки
        String str = input + "**"; // добавляем звез чтобы при считывании после символов не получить исключение
        int position = 0; // позиция

        while (position < inputLength) {
            if (str.charAt(position + 2) == '#') {

                result.append(translate(str.substring(position, position + 2)));
                position = position + 3;
            } else {
                result.append(translate(str.substring(position, position + 1)));
                ++position;
            }

        }

        return result.toString();
    }

    static String translate(String digitStr) {
        int num = Integer.parseInt(digitStr);
        char ch = (char) ('a' + num - 1);
        return String.valueOf(ch);
    }

}

```


