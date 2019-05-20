package setron;

abstract class Polynomial {

    private static int[] copyFrom(int[] a) {
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            ans[i] = a[i];
        }
        return ans;
    }

    public static int function(int[] a, int b) {  //Функция f(x)
        int ans = 0;
        for (int i = 0; i < a.length; ++i) {
            ans = GaluaNumber.add(ans, GaluaNumber.mul(a[i], GaluaNumber.pow(b, i)));
        }
        return ans;
    }

    public static int[] del(int[] a, int[] b) {  //Деление полиномов
        int[] ans = copyFrom(a);
        for (int i = 0; i < ans.length - b.length + 1; ++i){
            int del = GaluaNumber.div(ans[ans.length - 1 - i], b[b.length - 1]);
            for (int j = 0; j < b.length; ++j){
                int tmp = GaluaNumber.mul(b[b.length - 1 - j], del);
                ans[ans.length - 1 - i - j] = GaluaNumber.add(ans[ans.length - 1 - i - j], tmp);
            }
        }
        return ans;
    }

    public static int[] add(int[] a, int[] b) {  //Суммирование полиномов
        if (a.length < b.length){
            int[] t = a;
            a = b;
            b = t;
        }
        int[] ans = new int[a.length];
        for (int i = 0; i < b.length; ++i) {
            ans[i] = GaluaNumber.add(a[i], b[i]);
        }
        return ans;
    }
}
