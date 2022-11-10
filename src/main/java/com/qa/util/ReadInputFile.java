package com.qa.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadInputFile {
    private static Pattern regNumberPattern = Pattern.compile("[A-Z]{2}[0-9]{2}[\\s]?[A-Z]{3}");

    public static ArrayList read(String inputFilePathProperty) {
        ArrayList<String> registrationNumberList = new ArrayList();
        File file = new File(ConfigReader.getInputFilePath(inputFilePathProperty));
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                Matcher matcher = regNumberPattern.matcher(line);
                while (matcher.find()) {
                    registrationNumberList.add(matcher.group().replaceAll("\\s+", ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registrationNumberList;
    }
}
