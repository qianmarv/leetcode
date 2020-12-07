class Solution {
    //Bucket
    //Runtime: 3 ms, faster than 69.08%
    //Memory Usage: 38.7 MB, less than 94.83%
    public String sortString(String s){
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i)-'a']++;
        }

        StringBuilder ret = new StringBuilder();
        int count = 0;
        while(count < s.length()){
            for(int i = 0; i < 26; i++){
                if(map[i] > 0){
                    ret.append((char)('a'+i));
                    map[i]--;
                    count++;
                }
            }
            for(int i = 25; i >= 0; i--){
                if(map[i] > 0){
                    ret.append((char)('a'+i));
                    map[i]--;
                    count++;
                }
            }
        }
        return ret.toString();
    }

    //Brute Force
    //Runtime: 128 ms, faster than 5.17%
    //Memory Usage: 39.3 MB, less than 42.58%
    public String sortString1(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        StringBuilder result = new StringBuilder();
        while(sb.length() > 0){
            // step 1-3
            char lastChar = 0;
            while(true){
                int prev  = -1;
                for(int i = 0; i < sb.length(); i++){
                    char c = sb.charAt(i);
                    if(c <= lastChar) continue;
                    if(prev == -1 || sb.charAt(prev) > c){
                        prev = i;
                    }
                }
                if(prev == -1) break; // not found
                lastChar = sb.charAt(prev);
                sb.deleteCharAt(prev);
                result.append(lastChar);
            }
            // step 4-6
            lastChar = 255;
            while(true){
                int prev  = -1;
                for(int i = 0; i < sb.length(); i++){
                    char c = sb.charAt(i);
                    if(c >= lastChar) continue;
                    if(prev == -1 || sb.charAt(prev) < c){
                        prev = i;
                    }
                }
                if(prev == -1) break; // not found
                lastChar = sb.charAt(prev);
                sb.deleteCharAt(prev);
                result.append(lastChar);
            }
        }
        return result.toString();
    }
}
