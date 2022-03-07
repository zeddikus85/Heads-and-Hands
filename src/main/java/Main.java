/*
 * На входе функция получает параметр n - натуральное число.
 * Необходимо
 *     сгенерировать n-массивов;
 *     заполнить массивы случайными числами;
 *     каждый массив случайного размера;
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

    public static Integer[][] randomArray(int n) {
        // Создаем массив для хранения уникальных случайных чисел
        // которые будут использоваться для создания массивов разной длинны
        int[] sizeArray = new int[n];
        // Заполняем массив уникальными случайными числами от 1 до 100
        for (int i = 0; i < n; i++){
            boolean found = false;
            // Создаем случайно число от 1 до 100
            int newNumber = (int) (Math.random() * (100-1) + 1);
            // Проверяем не добавлено ли уже такое число в массив
            // если числа нет в массиве значение переменной found не меняется
            // если число есть в массиве found принимает значчение = true
            for (int y = 0; y < sizeArray.length; y++){
                if (newNumber == sizeArray[y]){
                    found = true;
                    break;
                }
            }
            // Если числа в массиве ещё нет - добавлем число в массив
            // иначе уменьшаем значение счетчика цикла на 1 и повторяем прогон
            if (found == false) {
                sizeArray[i] = newNumber;
            } else {
                i = i-1;
            }
        }

        // Логгируем массив с уникальными случайными числами для отладки
    /*
        System.out.print("Массив с размерами массивов: ");
        for (int i = 0; i < sizeArray.length; i++){
            System.out.print(sizeArray[i] + " ");
        }
    */
        // Создаем многомерный маасив с количеством строк равным n (кол-во запрошенных массивов)
        Integer[][] multiArray = new Integer[n][];

        // Заполняем многомерный массив массивами с длинной взятой
        // из созданного ранее массива sizeArray с уникальными числами
        for (int i = 0; i < sizeArray.length; i++) {
            multiArray[i] = new Integer[sizeArray[i]];
            for (int j = 0; j < multiArray[i].length; j++){
                int randomNumber = (int) (Math.random() * 201 - 100);
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
