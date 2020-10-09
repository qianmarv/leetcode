import java.util.*;
class Solution {
    //Runtime: 801 ms, faster than 15.93%
    //Memory Usage: 44.3 MB, less than 39.02%
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        int eIndex = 0;
        for(String end: wordList){
            if(endWord.equals(end)) break;
            eIndex++;
        }
        if(eIndex == wordList.size()){
            return 0;
        }
        wordList.add(beginWord);
        List<Integer>[] graph = buildGraph(wordList);

        return findLadder(graph, endWord, eIndex);
    }
    private List<Integer>[] buildGraph(List<String> wordList){
        List<Integer>[] graph = new List[wordList.size()];
        int N = wordList.size();
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<Integer>();
            for(int j = 0; j < N; j++){
                if(isConnect(wordList.get(i), wordList.get(j))){
                    graph[i].add(j);
                }
            }

        }
        return graph;
    }

    private boolean isConnect(String w1, String w2){
        int diffCount = 0;
        //w1 and w2 always have same length;
        for(int i = 0; i < w1.length(); i ++){
            if(w1.charAt(i) != w2.charAt(i)){
                diffCount++;
                if(diffCount > 1) break;;
            }
        }
        return diffCount == 1;
    }

    private int findLadder(List<Integer>[] graph, String endWord, int target){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(graph.length-1); // index of begin wordl
        boolean[] checked = new boolean[graph.length];
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            while(size-- > 0){
                int cur = queue.poll();
                checked[cur] = true;

                List<Integer> connects = graph[cur];
                for(int conn: connects){

                    if(conn == target) return depth+1;
                    if(!checked[conn]){
                        queue.add(conn);
                    }
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");
        Solution so = new Solution();
        System.out.printf("path=%d\n",so.ladderLength("hit","cog", words));
    }
}
