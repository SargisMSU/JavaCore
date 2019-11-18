package arrays;

import java.util.Arrays;

/**
 * Find all pairs on integer array whose sum is equal to k*
 */
public class ArrayPairs {

    public static void main(String[] args) {
        prettyPairsPrint( new int[]{ 12, 14, 17, 15, 19, 20, -11}, 9);
        prettyPairsPrint( new int[]{ 2, 4, 7, 5, 9, 10, -1}, 9);
    }

    public static void printPairsUsingTwoPointers(int[] numbers, int k){
        if(numbers.length < 2){
            return;
        }
        Arrays.sort(numbers);

        int left = 0; int right = numbers.length -1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == k){
                System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
                left = left + 1;
                right = right -1;

            }else if(sum < k){
                left = left +1;

            }else{
                right = right -1;
            }
        }

    }

    public static void prettyPairsPrint(int[] random, int k){
        System.out.println("input int array : " + Arrays.toString(random));
        System.out.println("All pairs in an array of integers whose sum is equal to a given value " + k);
        printPairsUsingTwoPointers(random, k);
    }
}
