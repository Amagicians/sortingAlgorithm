package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: JI
 * @Date: 10/16/20 - 10 - 16 - 4:10 PM
 * @Description: sort
 * @version: 1.0
 */
public class SortChecker {

    /**
     * generate a array with random value
     *
     * @return generated array
     */
    static int[] randArrayGenerator() {
        Random rnd = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10000);
        }
        return arr;
    }

    /**
     * compared with default sort method to
     * check the correctness of our algorithms
     */
    static void check() {
        boolean isSame = true;
        for (int m = 0; m < 10; m++) {
            int[] arr = randArrayGenerator();
            int[] arr2 = new int[arr.length];
            int[] arr3 = new int[arr.length];
            int[] arr4 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            System.arraycopy(arr, 0, arr3, 0, arr.length);
            System.arraycopy(arr, 0, arr4, 0, arr.length);

            long start1 = System.currentTimeMillis();
            Arrays.sort(arr);      //default sort method
            long end1 = System.currentTimeMillis();

            long start2 = System.currentTimeMillis();
            MergeSort.sort(arr2, 0, arr2.length - 1);
            long end2 = System.currentTimeMillis();

            long start3 = System.currentTimeMillis();
            QuickSort.sort(arr3, 0, arr3.length - 1);
            long end3 = System.currentTimeMillis();

            long start4 = System.currentTimeMillis();
            HeapSort.sort(arr4);
            long end4 = System.currentTimeMillis();

            System.out.println("系统程序运行时间：" + (end1 - start1) + "ms"); //输出程序运行时间
            System.out.println("merge程序运行时间：" + (end2 - start2) + "ms"); //输出程序运行时间
            System.out.println("quick程序运行时间：" + (end3 - start3) + "ms"); //输出程序运行时间
            System.out.println("heap程序运行时间：" + (end4 - start4) + "ms"); //输出程序运行时间


            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != arr4[i]) {
                    isSame = false;
                    break;
                }
            }
        }

        System.out.println(isSame);

    }

    static void printArr(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }


    public static void main(String args[]) {
        check();
    }
}
