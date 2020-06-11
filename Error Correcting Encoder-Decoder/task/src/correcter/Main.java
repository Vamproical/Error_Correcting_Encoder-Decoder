package correcter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ErrorCorrection errorCorrection = new ErrorCorrection(input);
        errorCorrection.callback();
    }
}
