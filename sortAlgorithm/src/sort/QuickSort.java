package sort;

/**
 * @Author: JI
 * @Date: 10/19/20 - 10 - 19 - 9:19 PM
 * @Description: sort
 * @version: 1.0
 */
public class QuickSort {

    public static void sort(int[] arr, int start, int end){
        if (start >= end)
            return;
        int mid = partition(arr, start, end);    //返回pivot位置
        sort(arr, start, mid-1);            //sort前半部分
        sort(arr, mid+1, end);             //sort后半部分
    }
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end]; //可随机取数避免最坏O(n^2)
        int i,j;
        i = start;
        j = end-1;

        while(i <= j){      //小于等于针对i=j的情况
            while(i <= j && arr[i] <= pivot){   //先判断范围确认不会IndexOutofBound
                i++;
            }
            while( i <= j && arr[j] > pivot){
                j--;
            }
            if (i < j)                          //必须添加，因为上面循环出来会存在i>j的可能
                swap(arr,i,j);

        }
        swap(arr,i,end);
        //System.out.println("start = " + start + "end = " + end);
        //SortChecker.printArr(arr);
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
