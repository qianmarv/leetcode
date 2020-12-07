import java.util.*;
public class Solution {
    //Runtime: 10 ms, faster than 85.94%
    //Memory Usage: 40 MB, less than 95.10%
    public String frequencySort(String s){
        HashMap<Character, Integer> charFrequency = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(charFrequency.containsKey(c)){
                charFrequency.replace(c, charFrequency.get(c)+1);
            }else{
                charFrequency.put(c, 1);
            }
        }

        ArrayList<Character>[] buckets = new ArrayList[s.length()+1];

        charFrequency.forEach((c, freq) -> {
                if(buckets[freq] == null){
                    buckets[freq] = new ArrayList<Character>();
                }
                buckets[freq].add(c);
            });

        StringBuilder result = new StringBuilder();
        for(int i = buckets.length - 1; i >= 0; i--){
            if(buckets[i] == null) continue;
            for(char c : buckets[i]){
                String str = String.valueOf(c);
                result.append(str.repeat(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        String str = args[0];
        System.out.println(so.frequencySort(str));
    }
}
