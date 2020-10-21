package sort;

/**
 * @Author: JI
 * @Date: 10/19/20 - 10 - 19 - 3:57 PM
 * @Description: sort
 * @version: 1.0
 */
public class ShellSort {

    public static void sort(int[] arr){
        if (arr == null)
            return;
        int size = arr.length;
        int h = 1;
        while(h <= size/3){ //使用Knuth序列
            h = h*3+1;
        }

        while(h != 0){
                for (int i = 0; i < size; i++) {
                    for (int j = i; j > h-1; j-=h) {
                        if (arr[j] < arr[j-h]){
                            int temp = arr[j-h];
                            arr[j-h] = arr[j];
                            arr[j] = temp;
                        }
                    }
                }
            h = (h-1)/3;
        }
    }
}
