import java.util.*;

class Solution {
    //Runtime: 1 ms, faster than 99.56%
    //Memory Usage: 39.1 MB, less than 12.35%
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(s, new StringBuilder(), 1);
    }
    
    private List<String> restoreIpAddresses(String s, StringBuilder prefix, int segment){
        List<String> ret = new ArrayList<String>();

        if(s.length() == 0) return ret;

        if(segment == 4){
            if(s.equals("0") ||
               (s.compareTo("1") >= 0 && s.length() < 4 && Integer.valueOf(s) <= 255)){
                ret.add(prefix.append(s).toString());
            }
            return ret;
        }

        for(int i = 1; i < 4 && i <= s.length(); i++){
            String str = s.substring(0,i);
            StringBuilder curr = new StringBuilder(prefix.toString());
            if(str.equals("0") || (str.compareTo("1") >= 0 && str.length() < 4 && Integer.valueOf(str) <= 255)){
                List<String> subSet = restoreIpAddresses(s.substring(i), curr.append(str).append("."), segment+1);
                for(String sub: subSet){
                    ret.add(sub);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = args[0];
        Solution so = new Solution();
        System.out.println(so.restoreIpAddresses(s).toString());
    }
}
