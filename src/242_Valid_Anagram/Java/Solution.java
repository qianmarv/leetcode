class Solution {
    public boolean isAnagram(String s, String t) {
        return byRealHash(s ,t);
    }
    //Runtime: 16 ms, faster than 10.49%
    //Memory Usage: 43 MB, less than 5.35%
    private boolean byRealHash(String s, String t){
        Map<Character, Integer>map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i = 0; i < t.length(); i++){
            int count = map.getOrDefault(t.charAt(i), 0)-1;
            if(count < 0) return false;
            map.put(t.charAt(i), count);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0) return false;
        }
        //map.forEach((k,v) -> {
        //    if(v < 0) return false;
        //});
        return true;
    }
    //Runtime: 6 ms, faster than 31.46%
    //Memory Usage: 40 MB, less than 14.06%
    private boolean bySimpleHash(String s, String t){
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i)-'a']++;
        }
        for(int j = 0; j < t.length(); j++){
            int index = t.charAt(j) - 'a';
            map[index]--;
            if(map[index] < 0) return false;
        }
        for(int i = 0; i < map.length; i++){
            if(map[i] != 0) return false;
        }
        return true;
    }
    //Runtime: 2 ms, faster than 95.10%
    //Memory Usage: 39.1 MB, less than 82.77%
    private boolean bySort(String s, String t){
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return new String(sArray).equals(new String(tArray));
    }
}
