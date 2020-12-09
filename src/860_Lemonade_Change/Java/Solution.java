class Solution {
    //Runtime: 1 ms, faster than 100.00%
    //Memory Usage: 40.5 MB, less than 9.62%
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        int PRICE = 5;
        for(int bill: bills){
            int change = bill - PRICE; // change will be: 0, 5, 15
            switch(change){
                case 5:
                    if(five == 0) return false;
                    five--;
                    ten++;
                break;
                case 15:
                if(ten > 0){
                    if(five == 0) return false;
                    ten--;
                    five--;
                }else{
                    if(five < 3) return false;
                    five -= 3;
                }
                break;
                default:
                five++;
            }
        }
        return true;
    }
}
