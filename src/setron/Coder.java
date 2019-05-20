package setron;

public abstract class Coder {
    private static int[] genPolynom = {12, 10, 12, 3, 9, 7, 1};  //Порождающий полином Соломона-Рида

    public static int[] encode(int[] a){
        int[] b = new int[15];
        for (int i = 0; i < 6; ++i){
            b[i] = 0;
        }
        for (int i = 6; i < 15; ++i){
            b[i] = a[i - 6];
        }
        return Polynomial.add(b, Polynomial.del(b, genPolynom));
    }
}
