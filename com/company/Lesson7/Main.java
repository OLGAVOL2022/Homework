package com.company.Lesson7;

public class Main {

    public static  void  main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Васька", 120);
        cats[1] = new Cat("Муська", 50);
        cats[2] = new Cat("Барсик", 100);

        Plate plate = new Plate(200);

        for(int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            StringBuilder builder = new StringBuilder("Кот ");
            builder.append(cats[i].getName());
            builder.append(" сыт: ");
            builder.append(cats[i].isSatiety());
            System.out.println(builder);
        }

        System.out.println(plate.getFood());
    }

}
