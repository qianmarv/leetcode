public class Solution {
    public string LongestCommonPrefix(string[] strs) {
        int index = 0;
        bool matching = true;
        StringBuilder sb = new StringBuilder();
        char curr;
        while(matching){
            for(int i = 0; i < strs.Length; i++){
                if(index >= strs.Length){
                    matching = false;
                    break;
                }
                if(i == 0){
                    curr = strs[i][index];
                }else{
                    if(curr != strs[i][index]){
                        matching = false;
                        break;
                    }
                }
            }
            sb.Add(curr);
            index++;
        }
        return sb.toString();
    }
}
