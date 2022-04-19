package com.company.JavaCore.Lesson4;

import java.util.*;

public class Main {

//Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи,
// а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

    public static void main(String[] args) {

        Map<String, Set<String>> dictionary = new HashMap<>();
        dictionary.put("Иванова Мария", new HashSet<>(Arrays.asList("892458761254", "865479521234")));
        dictionary.put("Задорнов Михаил", new HashSet<>(Arrays.asList("845912367845")));
        dictionary.put("Райкин Константин", new HashSet<>(Arrays.asList("849562137854", "8495785454577")));

        PhonesDictionary phonesDictionary = new PhonesDictionary(dictionary);
        phonesDictionary.add("Кузнецов", "88888888");

        Set<String> phones = phonesDictionary.getPhones("Кузнецов");

        if (phones != null) {
            System.out.println(phones);
        } else {
            System.out.println("Не найден");
        }
    }
}





