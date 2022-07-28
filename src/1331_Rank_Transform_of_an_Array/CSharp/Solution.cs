public class Solution {
    public int[] ArrayRankTransform(int[] arr) {
        int[] sorted = new int[arr.Length];
        Array.Copy(arr, sorted, arr.Length);

        Array.Sort(sorted);

        Dictionary<int, int> sortedDic = new Dictionary<int, int>();
        int idx = 1;
        foreach(var num in sorted){
            if(!sortedDic.ContainsKey(num)){
                sortedDic[num] = idx++;
            }
        }

        for(int i = 0; i < arr.Length; i++){
            sorted[i] = sortedDic[arr[i]];
        }

        return sorted;
    }
}
