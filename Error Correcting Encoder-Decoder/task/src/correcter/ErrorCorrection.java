package correcter;

import java.util.Random;

public class ErrorCorrection {
    private String inputString;

    ErrorCorrection(String inputString) {
        this.inputString = inputString;
    }

    private String triplingMessage(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(i)).append(input.charAt(i)).append(input.charAt(i));
        }
        return result.toString();
    }

    private String simulatePoorConnection(String input) {
        Random random = new Random();
        char[] charInput = input.toCharArray();
        for (int i = 0; i < charInput.length; i += 3) {
            int range = random.nextInt(Math.min(3, charInput.length - i));
            char rchar = (char) (random.nextInt(96) + 32);

            charInput[i + range] = rchar;
        }
        return new String(charInput);
    }

    private String decodeString(String input) {
        char[] string = input.toCharArray();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < string.length; i += 3) {
            output.append(string[i] == string[i + 1] || string[i] == string[i + 2] ? string[i] : string[i + 1]);
        }
        return output.toString();
    }

    public void callback() {
        System.out.println(inputString);
        String errorMessage = triplingMessage(inputString);
        System.out.println(errorMessage);
        String badConnectionString = simulatePoorConnection(errorMessage);
        System.out.println(badConnectionString);
        System.out.println(decodeString(badConnectionString));
    }
}
