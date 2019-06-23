package sort;

import java.util.Arrays;

public class QuickSort {

    /**
     * Выбрать опорный элемент из массива. Обычно опорным элементом является средний элемент.
     * Разделить массив на два подмассива: элементы, меньше опорного и элементы, больше опорного.
     * Рекурсивно применить сортировку к двум подмассивам.
     * https://i1.wp.com/java-master.com/wp-content/uploads/2017/06/Quicksort-in-Java-example-fast.gif?resize=300%2C180
     * */

    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void doSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) / 2;
        T pivot = array[mid];

        while (left <= right) {
            while (SortUtils.less(array[left], pivot)) {
                ++left;
            }
            while (SortUtils.less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                SortUtils.swap(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        Integer[] array = {3, 4, 1, 32, 0, 1, 5, 12, 2, 5, 7, 8, 9, 2, 44, 111, 5};
        //Integer[] array = {2, 3, 4, 5, 0, 1, 6};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);

        System.out.println(Arrays.toString(array));

        String[] stringArray = {"c", "a", "e", "b", "d"};
        quickSort.sort(stringArray);

        System.out.println(Arrays.toString(stringArray));
    }
}
