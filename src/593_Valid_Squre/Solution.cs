public class Solution {
    public bool ValidSquare(int[] p1, int[] p2, int[] p3, int[] p4)
    {
        List<Tuple<int[], int[]>> points = new List<Tuple<int[], int[]>>(){
            Tuple.Create(p1, p2),
            Tuple.Create(p1, p3),
            Tuple.Create(p1, p4),
            Tuple.Create(p2, p3),
            Tuple.Create(p2, p4),
            Tuple.Create(p3, p4)
        };

        var distMap = new Dictionary<int, int>();
        foreach(var t in points){
            int dist = CalcDistance(t.Item1, t.Item2);
            if(distMap.ContainsKey(dist)){
                distMap[dist]++;
            }else{
                distMap[dist] = 1;
            }
        }

        int sideSqr2 = 0;
        int diagonalSqr2 = 0;

        foreach(var pair in distMap){
            if(pair.Value == 4){
                sideSqr2 = pair.Key;
            }else if (pair.Value == 2) {
                diagonalSqr2 = pair.Key;
            }
        }

        return sideSqr2 != 0
            && diagonalSqr2 != 0
            && sideSqr2 + sideSqr2 == diagonalSqr2;
    }

    private int CalcDistance(int[] p1, int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
