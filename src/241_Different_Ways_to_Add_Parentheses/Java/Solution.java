import java.util.*;

public class Solution {
    // private static int level = 0;
    //Runtime: 1 ms, faster than 99.46%
    //Memory Usage: 39 MB, less than 76.79%
    public List<Integer> diffWaysToCompute(String input) {
        // level++;
        // String s = "==".repeat(level) + ">";
        // System.out.printf("%sEntering with %s\n",s,input);
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                // level--;
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                // level--;
                // System.out.printf("%sleft=>%s, right=>%s\n",s, left.toString(), right.toString());
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                        case '+':
                            ways.add(l + r);
                            break;
                        case '-':
                            ways.add(l - r);
                            break;
                        case '*':
                            ways.add(l * r);
                            break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        // System.out.printf("%sReturn=>: %s\n",s,ways.toString());
        return ways;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        String expr = args[0];
        System.out.println(so.diffWaysToCompute(expr).toString());
    }
}
