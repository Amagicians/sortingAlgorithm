package sort;

import java.util.Arrays;

/**
 * @Author: JI
 * @Date: 10/20/20 - 10 - 20 - 12:09 PM
 * @Description: sort
 * @version: 1.0
 */
public class RadixSort {
    public static void sort(int[] arr, int length){     //这里的length为带入数组中最大数的位数，且此方法没有处理位数不一样的情况
        int[] result = new int[arr.length];
        int[] bucket = new int[10];         //0~9

        for (int i = 0; i < length; i++) {
            int division = (int)Math.pow(10,i);
            for (int j = 0; j < arr.length; j++) {
                int num = arr[j]/division % 10;         //截取每一位
                bucket[num]++;
            }

            for (int j = 1; j < bucket.length; j++) {   //前缀和得到对应下标原数组末尾位置
                bucket[j] += bucket[j - 1];
            }

            for (int j = arr.length - 1; j > 0; j--) {    //保证数组稳定性进行排序
                int num = arr[j]/division % 10;
                result[--bucket[num]] = arr[j];
            }

            System.arraycopy(result,0,arr,0,arr.length);
            Arrays.fill(bucket,0);
        }

        SortChecker.printArr(arr);
    }

    public static void main(String[] args) {
        sort(new int[]{412,223,115,894,234,777,673},3);
        sort(new int[]{42,43,15,94,34,67,13},2);
    }
}
