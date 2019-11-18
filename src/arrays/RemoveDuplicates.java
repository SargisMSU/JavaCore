package arrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 2, 3};
        System.out.println("array = " + Arrays.toString(array));
        int[] result = removeDuplicates(array);
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] removeDuplicates(int[] array){
        Arrays.sort(array);
        int[] result = new int[array.length];

        int prev = array[0];
        result[0] = prev;
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];

            if (prev != curr){
                result[i] = curr;
            }else {
                result[i] = -1;
            }
            prev = curr;
        }
        return result;
    }
}
