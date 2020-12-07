class Solution {
    private String[] numberAlphabet = new String[]{
        "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    //Runtime: 1 ms, faster than 82.92%
    //Memory Usage: 37.5 MB, less than 44.81%
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits.length() == 0) return ret;
        int index =  (int)(digits.charAt(0)) - (int)('0');
        String alphabets = numberAlphabet[index];
        List<String> restLetters = letterCombinations(digits.substring(1));
        if(restLetters.isEmpty()){
            restLetters.add("");
        }
        for(int j = 0; j < alphabets.length(); j++){
            for(String letter: restLetters){
                ret.add(alphabets.substring(j,j+1) + letter);
            }
        }
        return ret;
    }
}
