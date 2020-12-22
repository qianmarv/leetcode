class Solution {
    //Runtime: 10 ms, faster than 68.58%
    //Memory Usage: 39.6 MB, less than 40.03%
    public int firstUniqChar(String s) {
        //one map with count, after scan, we can filter those with count = 1
        //the other map with index, only those count = 1 matters, leave min
        //boundary: not found such
        int[] counts  = new int[26];
        int[] indices = new int[26];
        int ret = s.length();
        for(int i = 0; i < s.length(); i++){
            counts[s.charAt(i)-'a']++;
            indices[s.charAt(i)-'a'] = i;
        }
        for(int i = 0; i < 26; i++){
            if(counts[i] != 1) continue;
            ret = Math.min(ret, indices[i]);
        }
        return ret == s.length() ? -1 : ret;
    }
}
