package sort;

/**
 * @Author: JI
 * @Date: 10/18/20 - 10 - 18 - 4:35 PM
 * @Description: sort
 * @version: 1.0
 */
public class BubbleSort {
    public static void sort(int[] arr){
        if (arr == null)
            return;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            boolean flag = true;
            for (int j = 0; j < size-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    flag = true;
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!flag)
                return;
        }
    }
}
