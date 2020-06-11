package correcter;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char[] input = scanner.nextLine().toCharArray();

        for (int i = 0; i < input.length; i += 3) {
            int range = random.nextInt(Math.min(3, input.length - i));
            char rchar = (char) (random.nextInt(96) + 32);

            input[i + range] = rchar;
        }

        System.out.println(input);
    }
}
