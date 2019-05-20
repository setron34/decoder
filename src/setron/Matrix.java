package setron;

abstract class Matrix {


    public static int[][] findReversed(int[][] m){ //Нахождение обратной матрицы
        int size = m.length;
        int[][] tm = new int [size][size * 2];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                tm[i][j] = m[i][j];
                tm[i][j + size] = 0;
            }
        }
        for (int i = 0; i < size; ++i) {
            tm[i][size + i] = 1;
        }
        for (int i = 0; i < size; ++i) {
            int del = tm[i][i];
            for (int k = i; k < 2 * size; ++k) {
                tm[i][k] = GaluaNumber.div(tm[i][k], del);
            }
            for (int j = i + 1; j < size; ++j) {
                int mul = tm[j][i];
                for (int k = i; k < 2 * size; ++k) {
                    tm[j][k] = GaluaNumber.add(tm[j][k], GaluaNumber.mul(tm[i][k], mul));
                }
            }
        }
        for (int i = size - 1; i > 0; --i) {
            int mul = tm[i-1][i];
            for (int k = i; k < 2 * size; ++k) {
                tm[i-1][k] = GaluaNumber.add(tm[i-1][k], GaluaNumber.mul(tm[i][k], mul));
            }
        }
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                m[i][j] = tm[i][j + size];
            }
        }
        return m;
    }
}
