package sort;

/**
 * @Author: JI
 * @Date: 10/20/20 - 10 - 20 - 11:29 AM
 * @Description: sort
 * @version: 1.0
 * 此版本为改进后的稳定版计数排序
 */
public class CountingSort {
    public static void sort(int[] arr, int bucketSize){ //需要先计算好合适的bucketSize避免开辟过多的空间
        int[] bucket = new int[bucketSize];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        for (int i = 1; i < bucket.length; i++) {   //前缀和得到对应下标原数组末尾位置
            bucket[i] += bucket[i-1];
        }

        for (int i = arr.length-1; i > 0; i--) {    //保证数组稳定性进行排序
            result[--bucket[arr[i]]] = arr[i];
        }

        SortChecker.printArr(result);
    }

    public static void main(String[] args) {
        sort(new int[]{1,3,6,7,4,2,3,9,1},10);

    }
}
