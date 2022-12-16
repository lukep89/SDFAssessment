import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class Main {

    public static final String EXIT = "exit";

    public static void main(String[] args) {
        System.out.println("Welcome.");

        Console cons = System.console();
        Boolean stop = false;

        List<Float> lastList = new ArrayList<>();
        lastList.add(0f);

        while (!stop) {
            String line = cons.readLine("> ");
            line = line.trim();
            String[] term = line.trim().split(" ");

            // e.g. ["$last", + , 3]

            // when user type exit
            if (term[0].equalsIgnoreCase(EXIT)) {
                System.out.println("Bye bye");
                lastList.clear();

                stop = true;

            }

            else {

                // for case if user key in "$last"
                String[] modifiedTerm = new String[3];

                if ((term[0] == "$last") || (term[2] == "$last")) {

                    List<String> termList = new ArrayList<>();
                    termList = Arrays.asList(term);

                    Float v = lastList.get(lastList.size() - 1);

                    String vString = v.toString();

                    Integer lastIdx = termList.indexOf("$last");
                    termList.set(lastIdx, vString);

                    modifiedTerm = (String[]) termList.toArray();
                    System.out.println(modifiedTerm.toString());

                    Float modValue1 = Float.parseFloat(modifiedTerm[0]);
                    Float modValue2 = Float.parseFloat(modifiedTerm[2]);

                    Float calulatedValue = 0f;

                    switch (modifiedTerm[1]) {
                        case "+":
                            calulatedValue = modValue1 + modValue2;
                            System.out.println(calulatedValue);
                            break;

                        case "-":
                            calulatedValue = modValue1 - modValue2;
                            System.out.println(calulatedValue);
                            break;

                        case "/":
                            calulatedValue = modValue1 / modValue2;
                            System.out.println(calulatedValue);
                            break;

                        case "*":
                            calulatedValue = modValue1 * modValue2;
                            System.out.println(calulatedValue);
                            break;

                        default:
                            break;
                    } // switch

                    lastList.add(calulatedValue);
                    // System.out.println("lastList value is: " + lastList.get(lastList.size() -
                    // 1));
                    // System.out.println(lastList);

                }

                Float value1 = Float.parseFloat(term[0]);
                Float value2 = Float.parseFloat(term[2]);

                Float calulatedValue = 0f;

                switch (term[1]) {
                    case "+":
                        calulatedValue = value1 + value2;
                        System.out.println(calulatedValue);
                        break;

                    case "-":
                        calulatedValue = value1 - value2;
                        System.out.println(calulatedValue);
                        break;

                    case "/":
                        calulatedValue = value1 / value2;
                        System.out.println(calulatedValue);
                        break;

                    case "*":
                        calulatedValue = value1 * value2;
                        System.out.println(calulatedValue);
                        break;

                    default:
                        break;
                } // switch

                // Float last = calulatedValue;
                // System.out.println("$last = " + last);

                lastList.add(calulatedValue);
                // System.out.println("lastList value is: " + lastList.get(lastList.size() -
                // 1));
                // System.out.println(lastList);

            } // if loop

        } // while

    } // psvm

}
