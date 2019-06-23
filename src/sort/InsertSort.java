package sort;

public class InsertSort {

    /**
     * каждый раз вставляем i-ый среди
     * a[0],...a[i-1]
     *
     * квадратичная сложность*/

    public <T extends Comparable<T>> T[] sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i ; j >0 && SortUtils.less(arr[j], arr[j-1]); j--) {
                SortUtils.swap(arr, j, j - 1);
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        InsertSort insertSort = new InsertSort();

        Integer[] sorted = insertSort.sort(arr);

        // Output => 1  4	 6	9	12	23	54	78	231
        SortUtils.print(sorted);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        String[] sortedStrings = insertSort.sort(strings);

        //Output => a	b	 c  d	e
        SortUtils.print(sortedStrings);
    }
}
