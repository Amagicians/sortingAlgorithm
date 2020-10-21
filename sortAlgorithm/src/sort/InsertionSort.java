package sort;

/**
 * @Author: JI
 * @Date: 10/18/20 - 10 - 18 - 9:51 PM
 * @Description: sort
 * @version: 1.0
 */
public class InsertionSort {
    public static void sort(int[] arr){
        if (arr == null)
            return;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
