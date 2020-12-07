class Solution{
    public String convert(String s, int numRows){
        if(numRows == 1) return s;

        StringBuilder[] strArr = new StringBuilder[numRows];
        //initialize string array for each rows
        for(int i = 0; i < numRows; i++){
            strArr[i] = new StringBuilder();
        }
        //loop the string, for every char, find it's position
        //if downward, the col is not changed, if upward, col increase for each loop
        boolean isDown = false;
        int index = 0;
        for(char c : s.toCharArray()){
            strArr[index].append(c);
            if(index == 0 || index == numRows - 1) isDown = !isDown;
            index = isDown ? index + 1 : index - 1;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            result.append(strArr[i]);
        }
        return result.toString();
    }

    // Another solution was row based
    public String convert2(String s, int numRows){
        StringBuilder result = new StringBuilder();
        int    delta = 2 * numRows - 2;

        if(numRows == 1) return s;

        for(int row = 0; row < numRows; row++){
            int indexDown = row;
            int indexUp   = delta - row;
            while(indexDown < s.length() || indexUp < s.length() ){
                if(indexDown < s.length()){
                    result.append(s.charAt(indexDown));
                }
                if(row != 0 && row != numRows-1 && indexUp < s.length()){ // Care index Down Only
                    result.append(s.charAt(indexUp));
                }
                indexDown += delta;
                indexUp += delta;
            }
        }
        return result.toString();
    }

    public static void main(String[] argv){
        Solution sol  = new Solution();
        String s    = argv[0];
        int numRows = Integer.parseInt(argv[1]);

        String exp = sol.convert(s, numRows);
        String act = sol.convert2(s, numRows);
        System.out.println("Expect: " + exp);
        System.out.println("Actual: " + act);
    }
}
