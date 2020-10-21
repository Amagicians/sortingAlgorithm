package sort;

/**
 * @Author: JI
 * @Date: 10/19/20 - 10 - 19 - 5:23 PM
 * @Description: sort
 * @version: 1.0
 */
public class MergeSort {

    public static void sort(int[] arr, int start, int end){
        if (start == end)
            return;
        int mid = start + ((end - start) >> 1); //计算分割点，不用（a+b）/2防止超出整数范围
        sort(arr,start,mid);                    //sort前半部分
        sort(arr,mid+1,end);              //sort后半部分
        merge(arr,start,mid,end);               //merge前后部分
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end-start+1];  //一定要注意这里不是arr的长度
        int index, i, j;
        index = 0;
        i = start;
        j = mid+1;

        while(i <= mid && j <= end){
            if (arr[i] < arr[j]){
                temp[index++] = arr[i++];
            }else{
                temp[index++] = arr[j++];
            }
        }
        //对任何剩余部分处理
        while(i<=mid){
            temp[index++] = arr[i++];
        }
        while (j <= end){
            temp[index++] = arr[j++];
        }
        //更新原数组arr
        for (int k = 0; k < temp.length; k++) {
            arr[k+start] = temp[k];
        }

    }
}
