package com.company.Lesson2;

public class Main {

    public static void main(String[] args) {
        System.out.println(check(2, 5));
        printPositiveOrNegative(150);
        System.out.println("Положительное: " + checkPositive(-50));
        printWords("Hello", 10);

    }

    public static boolean check(int a, int b) {
        int s = a + b;
        return (10 <= s) && (s <= 20);
    }

    public static void printPositiveOrNegative(int value) {
        if (value >= 0)
            System.out.println("Положительное");
        else
            System.out.println("Отрицательное");

    }

    public static boolean checkPositive(int value) {
        return value >= 0;

    }

    public static void printWords(String words, int repeatCount) {
        for (int i = 0; i < repeatCount; i++)
            System.out.println(words);
    }
}
