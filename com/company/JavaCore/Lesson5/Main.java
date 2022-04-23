package com.company.JavaCore.Lesson5;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        java.util.Map<String, List<Integer>> table = new HashMap<>();
        table.put("Value1", Arrays.asList(100, 300));
        table.put("Value2", Arrays.asList(200, 400));
        table.put("Value3", Arrays.asList(123, 500));
        AppData appData = new AppData(table);
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("test.csv"))) {
            appData.write(outputStreamWriter);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("test.csv")))) {
            AppData newAppData = new AppData();
            newAppData.readFile(bufferedReader);
            System.out.println(newAppData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
