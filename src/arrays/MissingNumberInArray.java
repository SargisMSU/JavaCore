package arrays;


/**
 * найти пропущенное число в заданном массиве целых чисел от 1 до n?
 * */

public class MissingNumberInArray {

    public static void main(String[] args) {
        int missingNumberInArray = getMissingNumberInArray(new int[]{1, 2, 3, 4, 6, 7});
        System.out.println("missingNumberInArray = " + missingNumberInArray);
    }

    public static int getMissingNumberInArray(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int lastNumber = array[array.length - 1];
        int missingNumber = (lastNumber * (lastNumber + 1)) / 2 - sum;
        return missingNumber == 0 ? lastNumber + 1 : missingNumber;
    }
}
