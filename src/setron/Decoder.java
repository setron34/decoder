package setron;

public class Decoder {
    private static int[] genPolynom = {12, 10, 12, 3, 9, 7, 1};

    public static int[] errorCorrect(int[] a) {
        int[] e = Polynomial.del(a, genPolynom);
        int[] s = new int[genPolynom.length - 1];
        for (int i = 0; i < genPolynom.length - 1; ++i){
            s[i] = Polynomial.function(e, GaluaNumber.pow(2, i + 1));
        }
        int tr = 3;
        int[][] matrix = new int[tr][tr]; //Здесь должно быть t real
        for (int i = 0; i < tr; ++i) {
            for (int j = 0; j < tr; ++j) {
                matrix[i][j] = s[tr - 1 - j + i];
            }
        }
        matrix = Matrix.findReversed(matrix);
        int[] v = new int[tr];
        for (int i = 0; i < tr; ++i) {
            v[i] = s[tr + i];
        }
        int[] l = new int[tr + 1];
        l[0] = 1;
        for (int i = 0; i < tr; ++i) {
            l[i + 1] = 0;
            for (int j = 0; j < tr; ++j) {
                l[i + 1] = GaluaNumber.add(l[i + 1], GaluaNumber.mul(matrix[i][j], v[j]));
            }
        }

        int[] w = new int[tr];
        for (int i = 0; i < tr; ++i) {
            w[i] = 0;
        }
        for (int i = 0; i < tr; ++i) {
            for (int j = 0; j < tr - i; ++j) {
                w[i + j] = GaluaNumber.add(w[i + j], GaluaNumber.mul(l[i], s[j]));
            }
        }

        int[] lans = new int[tr];
        int ti = 0;
        for (int j = 0; j < 16; ++j) {
            if (Polynomial.function(l, j) == 0) {
                lans[ti] = j;
                ti++;
            }
        }

        int[] errPos = new int[tr];
        for (int i = 0; i < tr; ++i) {
            errPos[i] = (15 - GaluaNumber.log(lans[i])) % 15;
        }
        int[] lpr = new int[tr];
        for (int i = 0; i < tr; ++i) {
            if (i % 2 == 0) {
                lpr[i] = l[i + 1];
            }
        }


        int[] errKey = new int[tr];
        for (int i = 0; i < tr; ++i) {
            errKey[i] = GaluaNumber.div(Polynomial.function(w, lans[i]), Polynomial.function(lpr, lans[i]));
        }
        for (int i = 0; i < tr; ++i) {
            a[errPos[i]] = GaluaNumber.add(a[errPos[i]], errKey[i]);
        }
        Test.out(errKey);
        return a;
    }

    public static int[] decode(int[] a) {
        int ans[] = new int[9]; //n inf
        for (int i = 0; i < 9; ++i) {
            ans[i] = a[i + 6];
        }
        return ans;
    }
}
