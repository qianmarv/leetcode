class Solution {
    private boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) != -1;
    }
    //Runtime: 29 ms, faster than 12.86%
    //Memory Usage: 39.2 MB, less than 97.83%
    public String reverseVowels_1(String s){
        int i = 0;
        int j = s.length()-1;
        StringBuilder sbi = new StringBuilder();
        StringBuilder sbj = new StringBuilder();
        while(i <= j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!isVowel(ci)){
                i++;
                sbi.append(ci);
            }else if(!isVowel(cj)){
                j--;
                sbj.insert(0,cj);
            }else{
                sbi.append(cj);
                if(i!=j){
                    sbj.insert(0, ci);
                }
                i++;
                j--;
            }
        }
        return sbi.toString() + sbj.toString();
    }
    //Runtime: 3 ms, faster than 84.69%
    //Memory Usage: 39.4 MB, less than 86.45%
    public String reverseVowels(String s){
        int i = 0;
        int j = s.length()-1;
        char[] result = new char[s.length()];
        while(i <= j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!isVowel(ci)){
                result[i++] = ci;
            }else if(!isVowel(cj)){
                result[j--] = cj;
            }else{
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
    
    public static void main(String[] args){
        Solution so = new Solution();
        System.out.printf("Input=>%s,Output=>%s", args[0], so.reverseVowels(args[0]));
    }
}
