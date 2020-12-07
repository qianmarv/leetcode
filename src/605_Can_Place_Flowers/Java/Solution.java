class Solution {
    //Runtime: 1 ms, faster than 95.37%
    //Memory Usage: 40.4 MB, less than 93.69%
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowers = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0 &&
               (i == 0 || flowerbed[i-1] == 0 ) &&
               (i == flowerbed.length-1 || flowerbed[i+1] == 0)){
                flowers++;
                flowerbed[i] = 1;
                if(flowers >= n){
                    return true;
                }
            }
        }
        return flowers >= n;
    }
}
