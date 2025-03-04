import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParenSymmetry {

    public Boolean isBalanced(String s) {
        int firstInt = 0;
        int secondInt = 0;

        while (secondInt < s.length()) {
            char current = s.charAt(secondInt);

            if (current == '(') {
                firstInt += 1;
            } else if (current == ')') {
                firstInt -= 1;
            } else if (firstInt < 0) {
                return false;
            }
            secondInt++;

        }

        return (firstInt == 0);
    }

    private void checkFile(String filename) {
        // open file named filename

        try {
            File file = new File(filename);
            Scanner scReader = new Scanner(file);
            // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced
            while (scReader.hasNextLine()) {
                String data = scReader.nextLine();
                System.out.println(isBalanced(data));
            }

            // CLOSE the file
            scReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

        ps.checkFile("TestStrings0.txt");

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
