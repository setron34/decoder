import setron.*;
public class Main {
    public static void main(String[] args){
        int[] encodeInput = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] encodeOutput = Coder.encode(encodeInput);
        Test.out(encodeInput);
        Test.out(encodeOutput);

        int[] decodeInput = {3, 6, 2, 2, 0, 14, 2, 3, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Полученный полином для декодирования: ");
        Test.out(decodeInput);

        int[] decodeOutput = Decoder.errorCorrect(decodeInput);
        System.out.print("Полином после исправления ошибок:  ");
        Test.out(decodeOutput);

        decodeOutput = Decoder.decode(decodeInput);
        System.out.print("Исходный полином:  ");
        Test.out(decodeOutput);
    }
}
