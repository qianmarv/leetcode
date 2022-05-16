public class Solution {
    public int RomanToInt(string s) {
        int result = 0;
        int prev = 1000;
        foreach(char c in s){
            int curr = GetIntFromChar(c);
            if(curr > prev){
                result += curr - prev - prev;
            }else{
                result += curr;
            }
            prev = curr;
        }
        return result;
    }

    public int GetIntFromChar(char c){
        switch(c){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                throw new Exception("Invalid char");
        }
    }

    public static void main(string[] args){

    }
}
