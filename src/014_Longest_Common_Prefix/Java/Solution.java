class Solution{
    public String longestCommonPrefix_1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix_2(String[] strs) {
        boolean match = true;
        int index = -1;
        while(match){
            index++;
            char curr = ' ';
            for(int i = 0; i < strs.length; i++){
                String str = strs[i];
                if(index >= str.length()) {
                    match = false;
                    break;
                }
                if(i == 0) {
                    curr = str.charAt(index);
                }else{
                    if(curr != str.charAt(index)){
                        match = false;
                        break;
                    }
                }
            }
        }
        if(index > 0){
            return strs[0].substring(0,index);
        }else{
            return "";
        }
    }
}
