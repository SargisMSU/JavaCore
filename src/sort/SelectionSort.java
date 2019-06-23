package sort;

public class SelectionSort {

    /**
     * каждый раз меняем местами i-ый и
     * минимальный из a[i+1],...a[n]
     *
     * квадратичная сложность*/

    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (SortUtils.less(arr[j], arr[min])) {
                    min = j;
                }
            }
            if (min != i) {
                SortUtils.swap(arr, i, min);
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        SelectionSort selectionSort = new SelectionSort();

        Integer[] sorted = selectionSort.sort(arr);

        // Output => 1	  4	 6	9	12	23	54	78	231
        SortUtils.print(sorted);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        String[] sortedStrings = selectionSort.sort(strings);

        //Output => a	b	 c  d	e
        SortUtils.print(sortedStrings);
    }
}
