import java.util.Arrays;
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int m = 0;
        for(int i = 0; i < arr2.length; i++){
            int n = m - 1;
            while(++n < arr1.length){
                if(arr1[n] != arr2[i]) continue;
                if(m != n) exch(arr1, m, n);
                m++;
            }
        }
        if(m < arr1.length - 1) sort(arr1, m);
        return arr1;
    }
    private void exch(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private void sort(int[] arr, int start){
        int[] tmp = new int[arr.length - start];
        int index = start;
        for(int i = 0; i < tmp.length; i++){
            tmp[i] = arr[index++];
        }
        Arrays.sort(tmp);
        index = start;
        for(int i = 0; i < tmp.length; i++){
            arr[index++] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        Solution so = new Solution();
        int[] result = so.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}
