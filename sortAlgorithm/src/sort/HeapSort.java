package sort;

/**
 * @Author: JI
 * @Date: 10/21/20 - 10 - 21 - 3:12 PM
 * @Description: sort
 * @version: 1.0
 */
public class HeapSort {
    //递归将树转化为大顶堆
    public static void heapify(int[] arr, int n, int i){
        if (i > n)
            return;
        int lNode = i*2+1;
        int rNode = i*2+2;
        int max = i;
        if (lNode < n && arr[lNode] > arr[max]){
            max = lNode;
        }
        if (rNode < n && arr[rNode] > arr[max]){
            max = rNode;
        }
        if (max != i){              //避免重复置换
            swap(arr, max, i);
            heapify(arr,n,max);        //确保大顶堆的特性
        }
    }
    //将无需数组堆化
    public static void build_heap(int[] arr, int n){
        int last_node = n -1;
        int parent = (last_node-1)/2;

        for (int i = parent; i >= 0 ; i--) {
            heapify(arr, n, i);
        }
    }
    //将大顶堆头部跟尾部切换，之后再对头部进行堆化（其余部分已经在build_heap 完成了堆化）
    public static void sort(int[] arr){
        build_heap(arr, arr.length);
        for (int i = arr.length-1; i >= 0 ; i--) {
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }

    public static void swap(int arr[], int a, int b){
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,3,1,10,4};
        sort(arr);
        SortChecker.printArr(arr);
    }
}
