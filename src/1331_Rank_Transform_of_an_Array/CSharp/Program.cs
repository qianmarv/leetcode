public class Program{
    public static void Main(string[] args){
        var sol = new Solution();
        var result = sol.ArrayRankTransform(new int[]{10, 13, 09});
        foreach(var item in result){
            Console.WriteLine(item);
        }
    }
}
