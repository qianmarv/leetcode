class Solution {
    //Runtime: 16 ms, faster than 35.95%
    //Memory Usage: 39.6 MB, less than 92.05%
    public int leastInterval(char[] tasks, int n) {

        if(n == 0) return tasks.length;

        int[] map   = new int[26];
        for(char c: tasks){
            map[c-'A']++;
        }

        Queue<Character> pq = new PriorityQueue<>(new Comparator<Character>(){
            @Override
            public int compare(Character a, Character b){
                return map[b-'A'] - map[a-'A'];
            }
        });
        for(int i = 0; i < 26; i++){
            if(map[i] > 0) pq.add((char)(i+'A'));
        }

        int ret = 0;
        while(!pq.isEmpty()){
            int count = 0;
            char[] stores = new char[n+1];
            do{
                stores[count] = pq.poll();
                ret++;
            }while(++count <= n && !pq.isEmpty());

            for(int i = 0; i < stores.length && stores[i] >= 'A'; i++){
                int idx = stores[i] - 'A';
                map[idx]--;
                if(map[idx] > 0) pq.add(stores[i]);
            }
            if(!pq.isEmpty()){
                ret += n - count + 1;
            }
        }
        return ret;
    }
}
