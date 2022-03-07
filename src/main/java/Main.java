/*
 * На входе функция получает параметр n - натуральное число.
 * Необходимо
 *     сгенерировать n-массивов;
 *     заполнить массивы случайными числами;
 *     каждый массив случайного размер;
 *     размеры массивов не должны совпадать;
 *     отсортировать массивы:
 *         - массивы с четным порядковым номером отсортировать по возрастанию;
 *         - с нечетным порядковым номером - по убыванию.
 * На выходе функция должна вернуть массив с отсортированными массивами.
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Проверка работы метода
        Integer[][] test = randomArray(20);
        System.out.println("Массив test: ");
        for (int i = 0; i < test.length; i++){
            for(int j = 0; j < test[i].length; j++){
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Integer[][] randomArray(int N) {
        // Создаем массив для хранения уникальных случайных чисел
        // которые будут использоваться для создания массивов разной длинны
        int[] sizeMassiv = new int[N];
        // Заполняем массив уникальными случайными числами от 1 до 100
        for (int i = 0; i < N; i++){
            boolean found = false;
            // Создаем случайно число от 1 до 100
            int newNum = (int) (Math.random() * (100-1) + 1);
            // Проверяем не добавлено ли уже такое число в массив
            // если числа нет в массиве значение переменной found не меняется
            // если число есть в массиве found принимает значчение = true
            for (int y = 0; y < sizeMassiv.length; y++){
                if (newNum == sizeMassiv[y]){
                    found = true;
                    break;
                }
            }
            // Если числа в массиве ещё нет - добавлем число в массив
            // иначе уменьшаем значение счетчика цикла на 1 и повторяем прогон
            if (found == false) {
                sizeMassiv[i] = newNum;
            } else {
                i = i-1;
            }
        }

        // Логгируем массив с уникальными случайными числами для отладки
    /*
        System.out.print("Массив с размерами массивов: ");
        for (int i = 0; i < sizeMassiv.length; i++){
            System.out.print(sizeMassiv[i] + " ");
        }
    */
        // Создаем многомерный маасив с количеством строк равным N (кол-во запрошенных массивов)
        Integer[][] multiArray = new Integer[N][];

        // Заполняем многомерный массив массивами с длинной взятой \
        // из созданного ранее массива sizeMassiv с уникальными числами
        for (int i = 0; i < sizeMassiv.length; i++) {
            multiArray[i] = new Integer[sizeMassiv[i]];
            for (int j = 0; j < multiArray[i].length; j++){
                int randomNumber = (int) (Math.random() * (100-1)+1);
                multiArray[i][j] = randomNumber;
            }
            // Сортируем массив по убыванию или возрастанию в зависимости от порядкого номера
            if (i % 2 != 0) {
                Arrays.sort(multiArray[i]);
            } else {
                Arrays.sort(multiArray[i], Collections.reverseOrder());
            }
        }

        // Вывод содержимого двумерного массива для отладки
    /*
        System.out.println("");
        System.out.println("Массив массивов: ");
        for (int i = 0; i<multiArray.length; i++){
            for(int j = 0; j<multiArray[i].length; j++){
                System.out.print(multiArray[i][j] + " ");
            }
            System.out.println();
        }
    */
        return multiArray;
    }

}
