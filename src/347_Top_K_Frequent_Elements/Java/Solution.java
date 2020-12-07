import java.util.*;
public class Solution {
    //Runtime: 9 ms, faster than 88.23%
    //Memory Usage: 41.1 MB, less than 99.93% 
    public int[] topKFrequent(int[] nums, int k){
        // Put num into the bucket with frequency
        HashMap<Integer, Integer> freqForNum = new HashMap<Integer, Integer>();
        for(int num: nums){
            int freq = 1;
            if(freqForNum.containsKey(num)){
                freq += freqForNum.get(num);
                freqForNum.replace(num, freq);
            }else{
                freqForNum.put(num, freq);
            }
        }
        // Map the bucket into an array with frequency as index
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        freqForNum.forEach((kNum, vFreq) -> {
                if(buckets[vFreq] == null){
                    buckets[vFreq] = new ArrayList<>();
                }
                buckets[vFreq].add(kNum);
            });

        // for(int z = 0; z < buckets.length; z++){
        //     if(buckets[z] != null){
        //         System.out.println(buckets[z].toString());
        //     }
        // }
        // Retrieve the numbers from bucket in decending order
        int[] result = new int[k];
        int j = 0;
        for (int i = buckets.length - 1; i >= 0 && j < k; i--){
            if(buckets[i] == null) continue;
            for(int m = 0; m < buckets[i].size() && j < k; m++){
                result[j++] = buckets[i].get(m);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] act1 = so.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        System.out.println(Arrays.toString(act1));
        int[] act2 = so.topKFrequent(new int[]{1, 2}, 2);
        System.out.println(Arrays.toString(act2));
    }
}
