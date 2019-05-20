package setron;

public class Test {
    public static void out(int[][] m) {
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[i].length; ++j) {
                System.out.print(m[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void out(int[] m) {
        for (int i = 0; i < m.length; ++i) {
            System.out.print(m[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
