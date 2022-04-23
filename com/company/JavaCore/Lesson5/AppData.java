package com.company.JavaCore.Lesson5;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AppData {
    private Map<String, List<Integer>> table = new HashMap<>();

    public AppData() {
    }

    public AppData(Map<String, List<Integer>> table) {
        this.table = table;
    }

    void write(Writer writer) throws IOException {
        List<String> headers = new ArrayList<>(table.keySet()).stream().sorted().collect(Collectors.toList());
        int rows = table.values().stream().mapToInt(List::size).max().orElse(0);
        writer.write(String.join(";", headers));
        writer.write(System.lineSeparator());
        for (int i = 0; i < rows; i++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int j = 0; j < headers.size(); j++) {
                List<Integer> integerList = table.get(headers.get(j));
                if (integerList != null && integerList.size() > i) {
                    rowBuilder.append(integerList.get(i));
                }
                if (j < headers.size() - 1) {
                    rowBuilder.append(";");
                }
            }
            writer.write(rowBuilder.toString());
            writer.write(System.lineSeparator());
        }
        writer.flush();
    }

    void readFile(BufferedReader bufferedReader) throws IOException {
        table.clear();
        String[] headers = bufferedReader.readLine().split(";");
        for (String header : headers) {
            table.put(header, new ArrayList<>());
        }
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(";");
            for (int i = 0; i < values.length; i++) {
                if (i < headers.length) {
                    try {
                        Integer integer = Integer.parseInt(values[i]);
                        table.get(headers[i]).add(integer);
                    } catch (NumberFormatException e) {
                        table.get(headers[i]).add(Integer.MIN_VALUE);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "AppData{" +
                "table=" + table +
                '}';
    }
}
