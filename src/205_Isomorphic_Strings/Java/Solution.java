class Solution {
    //Runtime: 6 ms, faster than 76.31%
    //Memory Usage: 38.9 MB, less than 86.24%
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(!map.containsKey(cs)){
                if(!set.add(ct)) return false; // value duplicate
                map.put(cs, ct);
            }else{
                char cn = map.get(cs);
                if(cn != ct) return false;
            }
        }
        return true;
    }
}
