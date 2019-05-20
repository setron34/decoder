package setron;

abstract class GaluaNumber {
    //Работаем в поле GF(16) с примитивным полиномом g(x) = x^4 + x + 1
    private static int[] st = {1, 2, 4, 8, 3, 6, 12, 11, 5,
            10, 7, 14, 15, 13, 9, 1}; //Таблица степеней, st[x] = 2^x
    private static int[] invSt = {0, 0, 1, 4, 2, 8, 5, 10, 3,
            14, 9, 7, 6, 13, 11, 12}; //Таблица обратных степеней st[2^x] = x

    public static int add(int a, int b) {  //Реализация операции сложения
        return a ^ b;
    }

    public static int mul(int a, int b) {  //Реализация операции умножения
        if (a * b == 0) {
            return 0;
        } else {
            return st[(invSt[a] + invSt[b]) % 15];
        }

    }

    public static int div(int a, int b) {  //Реализация операции деления
        if (a == 0) {
            return 0;
        } else {
            return st[(invSt[a] - invSt[b] + 15) % 15];
        }
    }

    public static int pow(int a, int b) {  //Реализация операции деления
        if (a == 0 && b == 0) {
            return 1;
        } else  if (a == 0) {
            return 0;
        } else {
            return st[(invSt[a] * b) % 15];
        }
    }

    public static int log(int a) {
        return invSt[a];
    }

}
