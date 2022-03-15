package com.company.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Tictactoe {

    public static boolean isGameOver = false;

    public static void main(String[] args) {
        String[][] map = initField(3);
        System.out.println("Игра началась! Вперед!");


        while (true) {

            printMap(map);
            playerTurn(map);

            if (isGameOver) {
                System.out.println("Победил игрок");
                break;
            }

            computerTurn(map);
            printMap(map);

            if (isGameOver) {
                System.out.println("Победил компьютер");
                break;
            }

            System.out.println();

        }
    }


    public static void computerTurn(String[][] map) {
        System.out.println("Компьютер ходит,подождите");
        Random random = new Random();

        boolean isActiveTurn = true;

        while (isActiveTurn) {

            int x = random.nextInt(map[0].length);
            int y = random.nextInt(map.length);

            if (map[x][y].equals("*")) {
                map[x][y] = "0";
                isActiveTurn = false;

            } else {
                System.out.println("Вы сходили на занятую ячейку");
            }
        }
        isGameOver = checkDiagonal("0", map) || checkLanes("0", map);
    }


    public static void playerTurn(String[][] map) {

        System.out.println("Игрок ходит, на какие клетки вы ходите?");

        Scanner sc = new Scanner(System.in);

        boolean isActiveTurn = true;

        while (isActiveTurn) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            if ((x > 0 && x <= map[0].length) && (y > 0 && y <= map.length)) {
                if (map[x - 1][y - 1].equals("*")) {
                    map[x - 1][y - 1] = "X";
                    isActiveTurn = false;

                } else {
                    System.out.println("Вы сходили на занятую ячейку");
                }
            } else {
                System.out.println("Вы вышли за пределы поля");
            }
        }
        isGameOver = checkDiagonal("X", map) || checkLanes("X", map);
    }

    static boolean checkDiagonal(String symb, String[][] map) {
        boolean toright, toleft;
        toright = true;
        toleft = true;
        for (int i = 0; i < map.length; i++) {
            toright &= (map[i][i].equals(symb));
            toleft &= (map[map.length - i - 1][i].equals(symb));

        }
        return toright || toleft;
    }


    static boolean checkLanes(String symb, String[][] map) {
        boolean cols, rows;
        for (int j = 0; j < map[0].length; j++) {
            cols = true;
            rows = true;
            for (int i = 0; i < map.length; i++) {
                cols &= (map[j][i].equals(symb));
                rows &= (map[i][j].equals(symb));
            }

            if (cols || rows) return true;
        }

        return false;
    }


    public static void printMap(String[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static String[][] initField(int size) {

        String[][] map = new String[size][size];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = "*";
            }
        }
        return map;
    }
}




