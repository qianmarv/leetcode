class Solution {
    //Runtime: 0 ms, faster than 100.00%
    //Memory Usage: 39.1 MB, less than 93.91%
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] aux = new int[gas.length];
        for(int i = 0; i < aux.length; i++){
            aux[i] = gas[i] - cost[i];
        }
        for(int i = 0; i < aux.length; i++){
            if(aux[i] < 0) continue;
            //find first number >= 0
            int j = i;
            int sum = aux[i];
            do{
                j++;
                if(j == aux.length) j = 0;
                sum += aux[j];
                if(sum < 0) break;
            }while(j != i);
            if(i == j) return i;
            if(j > i) i = j - 1;
        }
        return -1;
    }
}
