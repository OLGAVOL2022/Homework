package com.company.JavaCore.Lesson4;

import java.util.*;

public class Cities {
//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать, сколько раз встречается каждое слово.

    public static void main(String[] args) {


        ArrayList<String> cities = new ArrayList<>();
        cities.add("Москва");
        cities.add("Москва");
        cities.add("Москва");
        cities.add("Санк-Петербург");
        cities.add("Сочи");
        cities.add("Адлер");
        cities.add("Самара");
        cities.add("Тольятти");
        cities.add("Нижневартовск");
        cities.add("Улано-де");
        cities.add("Красноярск");
        cities.add("Новосибирск");
        cities.add("Магадан");
        cities.add("Нижний Новгород");
        cities.add("Ижевск");
        cities.add("Уфа");
        cities.add("Стерлитомак");

        Map<String, Integer> map = new HashMap<>();
        for (String city : cities) {
            map.putIfAbsent(city, 0);
            map.put(city, map.get(city) + 1);
        }

        System.out.println(Arrays.toString(map
                .entrySet()
                .stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue() == 1)
                .map(Map.Entry::getKey).toArray()));
    }
}

