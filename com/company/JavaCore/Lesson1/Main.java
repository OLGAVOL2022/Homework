package com.company.JavaCore.Lesson1;


public class Main {

    public static  void  main(String[] args) {
        People people1 = new People("Иван", 19, "легкоатлет", 4);
        People people2 = new People("Павел", 20, "многоборец", 18);
        People people3 = new People("Сергей", 18, "пловец", 16);
        People people4 = new People("Антон", 22, "легкоатлет", 6);
        Team team1 = new Team("Олимпийцы", people1, people2, people3, people4);

        People people12 = new People("Андрей", 22, "пловец", 10);
        People people22 = new People("Алексей", 19, "многоборец", 15);
        People people32 = new People("Семен", 21, "многоборец", 20);
        People people42 = new People("Тимофей", 20, "легкоатлет", 6);
        Team team2 = new Team("Самарцы", people12, people22, people32, people42);

        Course course = new Course(Barrier.values());

        course.doIt(team1);
        System.out.println(team1);
        System.out.println(team1.showResults());

        course.doIt(team2);
        System.out.println(team2);
        System.out.println(team2.showResults());

        if (team1.getSuccessPeoples().length > team2.getSuccessPeoples().length) {
            System.out.println("Победитель: " + team1.getName());
        } else if (team1.getSuccessPeoples().length < team2.getSuccessPeoples().length)  {
            System.out.println("Победитель: " + team2.getName());
        } else {
            System.out.println("Победитель: дружба");
        }
    }

}

