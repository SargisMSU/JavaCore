package sort;

import static sort.SortUtils.*;

class BubbleSort{

    /**
     * в i-ом шагу найдем максимум из
     * a[0], ..., a[n-i] и
     * swap-им его, до того, как появится
     * на месте с индексом n-i
     *
     * квадратичная сложность*/

    public <T extends Comparable<T>> T[] sort(T array[]) {
        int last = array.length;
        do {
            for (int count = 0; count < last - 1; count++) {
                if (less(array[count], array[count + 1])) {
                    swap(array, count, count + 1);
                }
            }
            last--;
        } while (last > 0);
        return array;
    }

    // Driver Program
    public static void main(String[] args) {

        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(integers);

        // Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
        print(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        //Output => e, d, c, b, a
        print(bubbleSort.sort(strings));

    }
}