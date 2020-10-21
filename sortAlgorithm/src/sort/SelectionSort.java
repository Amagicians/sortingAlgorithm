package sort;
/**
 * @Author: JI
 * @Date: 10/16/20 - 10 - 16 - 4:10 PM
 * @Description: sort
 * @version: 1.0
 */
public class SelectionSort {

    public static void sort(int[] arr){
        if (arr == null)    //corner case
            return;
        int size = arr.length;
        int minIndex;
        for (int i = 0; i < size; i++){
            minIndex = i;
            for (int j = i+1; j < size; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;   //record the min index
                }
            }
            //swap the ith element with the min num
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

}

