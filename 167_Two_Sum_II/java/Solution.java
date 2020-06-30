class Solution{
    public int[] twoSum(int [] numbers, int target){
        int lo = 0;
        int hi = numbers.length -1;
        int y = target - numbers[lo];
        while(lo < hi){
            if(y == numbers[hi]){
                return new int[]{lo+1, hi+1};
            }else if(y < numbers[hi]){
                hi--;
            }else{
                lo++;
                y = target - numbers[lo];
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] numbers, int target){
        for(int i = 0; i < numbers.length; i++){
            int j = binarySearch(numbers, target - numbers[i], i+1, numbers.length-1);
           if(j != -1) {
               return new int[]{i+1,j+1};
           }
        }
        return new int[0];
    }

    public int binarySearch(int[] numbers, int target, int lo, int hi){
        if(lo > hi)
            return -1;
        int mid = lo + (hi - lo)/2;
        if(target == numbers[mid]){
            return mid;
        }else if(target > numbers[mid]){
            return binarySearch(numbers, target, mid+1, hi);
        }else{
            return binarySearch(numbers, target, lo, mid-1);
        }
    }
}
