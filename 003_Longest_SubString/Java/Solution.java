import java.util.HashMap;
import java.util.Map;

class Solution{
    //Runtime: 15 ms, faster than 28.39% of Java online submissions for Longest Substring Without Repeating Characters.
    //Memory Usage: 43.6 MB, less than 5.10% of Java online submissions for Longest Substring Without Repeating Characters.
    public int lengthOfLongestSubstring_1(String s){
        int result = 0; // Store the maximum length
        int fp     = 0; // Front Pointer
        int bp     = 0; // Back Pointer
        Map<Character, Integer> map = new HashMap<>(); // Store current string between bp & fp

        for(;fp < s.length();fp++){
            Character c = s.charAt(fp);
            if(map.containsKey(c)){
                if(map.size() > result){
                    result = map.size();
                }
                int pos = map.get(c);
                for(;bp<=pos;bp++){
                    map.remove(s.charAt(bp));
                }
            }
            map.put(c, fp);
        }
        if(map.size() > result){
            result = map.size();
        }
        return result;
    }

    // Seems with HashMap, both time and memory consumption is big
    // Runtime: 2 ms, faster than 99.92% of Java online submissions for Longest Substring Without Repeating Characters.
    // Memory Usage: 39.6 MB, less than 51.74% of Java online submissions for Longest Substring Without Repeating Characters.
    public int lengthOfLongestSubstring_2(String s){
        int result = 0; // Store the maximum length
        int fp     = 0; // Front Pointer
        int bp     = 0; // Back Pointer

        for(;fp < s.length();fp++){
            Character c = s.charAt(fp);
            for(int pos = bp; pos < fp; pos++){
                if(s.charAt(pos) == c){
                    if((fp - bp) > result){
                        result = fp - bp;
                    }
                    bp = pos + 1;
                    break;
                }
            }
        }
        if((fp - bp) > result){
            result = (fp - bp);
        }
        return result;
    }

    // Standard Solution
    public int lengthOfLongestSubstring(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(new Solution().lengthOfLongestSubstring(args[0]));
    }
}
