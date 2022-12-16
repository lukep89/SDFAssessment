import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // get args from command
        String csvName = args[0];
        String templateName = args[1];

        // file name with .csv or .txt
        String csvNameWithNoDir = csvName.replace(".csv", "");
        // System.out.println("> file name without dir: " + csvNameWithNoDir + "\n");
        String txtNameWithNoDir = templateName.replace(".txt", "");
        // System.out.println("> file name without dir: " + csvNameWithNoDir + "\n");

        // System.out.printf("> filename: %s, template name: %s", csvName,

        Map<String, String> infoMap = new HashMap<>();
        List<String> header = new ArrayList<>();

        // READ csv file
        try {
            FileReader fr = new FileReader("task01/".concat(csvName));
            BufferedReader br = new BufferedReader(fr);

            String line = "";

            line = br.readLine();

            String[] headStrings = line.trim().split(",");
            for (String i : headStrings) {
                header.add(i);
            }
            // System.out.println(header);

            for (String j : header) {
                infoMap.put(j, "");
            }

            while ((line = br.readLine()) != null) {

                // System.out.println("> " + line +" \n");
                String[] infoStrings = line.trim().split(",");

                infoMap.put(header.get(0), infoStrings[0]); // first name || salutations
                infoMap.put(header.get(1), infoStrings[1]); // last name
                infoMap.put(header.get(2), infoStrings[2]); // address || package name
                infoMap.put(header.get(3), infoStrings[3]); // years || price

                // CREATE file - duplicate thankyou.txt (templateName, args[1]) and rename to
                // fiestname.txt (harry.txt)
                Path originalFile = Paths.get("task01/".concat(templateName));
                String name = originalFile.getFileName().toString();

                String copiedName = "";
                if (header.get(0).equalsIgnoreCase("first_name")) {
                    copiedName = name.replace(txtNameWithNoDir,
                            infoMap.get(header.get(0)).concat("_" + txtNameWithNoDir));

                } else {
                    copiedName = name.replace(txtNameWithNoDir,
                            infoMap.get(header.get(1)).concat("_" + txtNameWithNoDir));
                }
                Path copiedFile = originalFile.resolveSibling(copiedName);

                try {
                    Files.copy(originalFile, copiedFile);
                    File f = copiedFile.toFile();

                    if (f.createNewFile()) {
                        System.out.println("file created -> " + f.getName());
                    } else {
                        System.out.println("file already exist -> " + f.getName());
                    }

                    // WRITE into the copied file
                    FileWriter fw = new FileWriter(copiedFile.toString(), false);
                    BufferedWriter bw = new BufferedWriter(fw);

                    if (header.get(0).equalsIgnoreCase("first_name")) {
                        bw.write(infoMap.get(header.get(2))); // .replaceAll("\n", "\\n")
                        bw.write("\n\n");
                        bw.write("Dear " + infoMap.get(header.get(0)) + " " + infoMap.get(header.get(1)));
                        bw.write("\n\n");
                        bw.write("Thank you for staying with us over these " + infoMap.get(header.get(3)) + " years");

                    } else if (header.get(0).equalsIgnoreCase("salutations")) {
                        bw.write("Dear " + infoMap.get(header.get(0)) + " " + infoMap.get(header.get(1)));
                        bw.write("\n\n");
                        bw.write("Thank you for your interest in our new" + infoMap.get(header.get(2)) + " package! ");
                        bw.write("For the 2022 Spring promotion, you can sign up for the low low price of $ " + infoMap
                                .get(header.get(3)) + " !");
                        bw.write("\n\n");
                        bw.write("Safe travels!");
                    }

                    bw.close();
                    fw.close();

                } catch (Exception e) {
                    System.out.println("> an create file error occured: " + e.getMessage());
                    e.printStackTrace();
                } // create file - unique to name

            }

            // System.out.println(infoMap);
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("> an read1 error occured: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("> an read2 error occured: " + e.getMessage());
            e.printStackTrace();

        } // read file

    }
}
