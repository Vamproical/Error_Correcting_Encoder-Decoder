package correcter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = "";
        ErrorCorrection errorCorrection = new ErrorCorrection(input);
        errorCorrection.callback();
    }
}
