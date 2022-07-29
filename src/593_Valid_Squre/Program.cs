public class Program{
    public static void Main(string[] args){
        var sol = new Solution();

        Tuple<int[], int[],int[],int[]> points = Tuple.Create(
            new int[]{0,0},
            new int[]{0,1},
            new int[]{1,0},
            new int[]{1,1}
        );

        var result = sol.ValidSquare(
            points.Item1,
            points.Item2,
            points.Item3,
            points.Item4
        );

        Console.WriteLine(result);
    }
}
