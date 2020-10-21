package sort;

import java.util.Arrays;

/**
 * @Author: JI
 * @Date: 10/20/20 - 10 - 20 - 5:27 PM
 * @Description: sort
 * @version: 1.0
 */
public class interview {
    public static void main(String[] args) {
        int[] arr = {4,1,9,1,1,1,1,4,1,1,1};
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i]+1; j++) {
                if (i+j >= arr.length)
                    break;
                else if (ans[i+j] != 0){
                    ans[i+j] = Math.min(ans[i]+1,ans[i+j]);
                }else{
                    ans[i+j] = ans[i] +1;
                }
            }
            System.out.println(Arrays.toString(ans));
        }

        System.out.println(ans[arr.length-1]);
    }
}
