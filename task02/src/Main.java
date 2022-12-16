import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final String EXIT = "exit";

    public static void main(String[] args) {
        System.out.println("Welcome.");

        Console cons = System.console();
        Boolean stop = false;

        // Map<String, Float> dataMap = new HashMap<>();

        List<Float> lastList = new ArrayList<>();
        lastList.add(0f);

        while (!stop) {
            String line = cons.readLine("> ");
            line = line.trim();
            String[] term = line.trim().split(" ");

            // if(term.length <= 0){
            // line = cons.readLine("please enter operation > ");

            // }

            // when user type exit
            if (term[0].equalsIgnoreCase(EXIT)) {
                System.out.println("Bye bye");
                stop = true;

            }

            else {

                // System.out.println(term[0]);

                Float value1 = Float.parseFloat(term[0]);
                Float value2 = Float.parseFloat(term[2]);

                Float calulatedValue = 0f;

                Float last = 0f;

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

                last = calulatedValue;
                System.out.println("$last = " + last);

                lastList.add(calulatedValue);
                System.out.println("lastList value is: " + lastList.get(lastList.size() - 1));
                System.out.println(lastList);

            } // if loop

        } // while

    } // psvm

}
