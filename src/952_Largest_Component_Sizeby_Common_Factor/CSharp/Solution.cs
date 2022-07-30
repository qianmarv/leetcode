// 09:40 AM -- ?
public class Solution {
    public int LargestComponentSize(int[] nums) {
        int m = nums.Max();
        UnionFind uf = new UnionFind(m + 1);
        foreach (int num in nums){
           for (int i = 2; i * i <= num; i++){
               if (num % i == 0){
                   uf.Union(num, i);
                   uf.Union(num, num / i);
               }
           }
        }

        int[] counts = new int[m+1];
        int ans = 0;
        foreach (int num in nums){
            int root = uf.Find(num);
            counts[root]++;
            ans = Math.Max(ans, counts[root]);
        }
        return ans;
    }

    class UnionFind{
        int[] parent;
        int[] rank;

        public UnionFind(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }

            rank = new int[n];
        }

        public void Union(int x, int y){
            int rootX = Find(x);
            int rootY = Find(y);

            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]){
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }

        public int Find(int x){
            if (parent[x] != x){
                parent[x] = Find(parent[x]);
            }

            return parent[x];
        }
    }
}
