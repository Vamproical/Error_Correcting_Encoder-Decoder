package correcter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ErrorCorrection {
    private String inputString = "";
    private String pathToTheFile = "send.txt";
    private String pathToOutput = "received.txt";

    ErrorCorrection(String inputString) {
        this.inputString = inputString;
    }

    private String readFile(String path) {
        StringBuilder outputFile = new StringBuilder();
        try (FileInputStream inFile = new FileInputStream(new File(path))) {
            ArrayList<Character> chars = new ArrayList<>();
            int inByte = inFile.read();
            while (inByte != -1) {
                chars.add((char) inByte);
                inByte = inFile.read();
            }
            Random random = new Random();
            for (int i = 0; i < chars.size(); i++) {
                char c = chars.get(i);
                int mask = random.nextInt(7);
                char now = (char) (c ^ (char) (1 << mask));
                outputFile.append(now);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputFile.toString();
    }

    private void writeFile(String data) {
        try (FileWriter writer = new FileWriter(new File(pathToOutput));) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        String output = readFile(pathToTheFile);
        writeFile(output);
        /*System.out.println(inputString);
        String errorMessage = triplingMessage(inputString);
        System.out.println(errorMessage);
        String badConnectionString = simulatePoorConnection(errorMessage);
        System.out.println(badConnectionString);
        System.out.println(decodeString(badConnectionString));*/
    }
}
