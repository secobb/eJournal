package com.ejournal;

import java.util.*;

public class Course {
    // list groups
    private static List<Group> groups;

    // constructor
    Course() {
        this.groups = new ArrayList<>();
    }

    // add groups to course
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    // get list of groups
    public static List<Group> getGroups() {
        return groups;
    }

    // display list of all soldiers
    public static void displayAll(){
        String title = "Список військовослужбовців курсу";
        System.out.println(title.toUpperCase());
        for (Group group : groups){
            System.out.println("Група "+group.getGroupId());
            for (Soldier soldier : group.getSolders()){
                System.out.println(soldier);
            }
        }
    }

    public static void addSoldier(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        System.out.println("Введіть прізвище та ім'я військовослужбовця: ");
        String name = scanner.nextLine();
        while (!flag) {
        System.out.println("Введіть номер групи: ");
        int idGroup = scanner.nextInt();
            for (Group group : groups) {
                if (group.getGroupId() == idGroup) {
                    group.addSoldier(new Soldier(name));
                    flag = true;
                }
            }
            if (flag) {
                System.out.println("Військовослужбовця додано");
            } else {
                System.out.println("Даної групи не існує.");
            }
        }
    }

    // update information about soldier
    public static void updateSoldier() {
        Scanner scanner = new Scanner(System.in);
        int idSoldier;
        boolean flagSoldier = false;
        displayAll();
        System.out.println("Введіть номер військовослужбовця:");
        idSoldier = scanner.nextInt();
            for (Group group : groups) {
                        for (Soldier soldier : group.getSolders()) {
                                if (soldier.getId() == idSoldier) {
                                    Scanner scanNameSoldier = new Scanner(System.in);
                                    flagSoldier = true;
                                    System.out.println("Введіть нове ім'я та прізвище:");
                                    String soldierName = scanNameSoldier.nextLine();
                                    soldier.setName(soldierName);
                                }
                            }
                        }
        if(!flagSoldier){
            System.out.println("Такий номер військовослужбовця не існує.");
        }
    }

    // add subject to group
    public void addSubjectByGroup(String subject, Group group) {
        for (Soldier soldier : group.getSolders()) {
            soldier.addSubject(subject);
        }
    }

    // display all subjects and grades for group of soldiers
    public void displayGradesByGroup(Group group) {
        for (Soldier soldier : group.getSolders()) {
            System.out.println(soldier);
            Map<String, List<Integer>> grades = soldier.getGrades().getGradesMap();
            grades.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue()).forEach(System.out::println);
            System.out.println();
        }
    }

    // display grades for subject
    public void displayGradesByGroup(Group group, String subject) {
        System.out.println("Група: " + group.getGroupId());
        for (Soldier soldier : group.getSolders()) {
            System.out.println(soldier);
            Map<String, List<Integer>> grades = soldier.getGrades().getGradesMap();
            if (grades.get(subject) == null) {
                System.out.println("Предмет " + subject + " не знайдено");
            } else
                System.out.println(subject + ": " + grades.get(subject));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainChoice = 0;
        System.out.println("Електронний журнал обліку успішності");
        Course myCourse = new Course();
        Group group1 = new Group(2101);
        Group group2 = new Group(2102);
        Group group3 = new Group(2103);
        myCourse.setGroups(Arrays.asList(group1, group2, group3));
        group1.addSoldier(new Soldier("Голубенко Сергій"));
        group1.addSoldier(new Soldier("Романенко Віктор"));
        group1.addSoldier(new Soldier("Вікторія Канашкіна"));
        group2.addSoldier(new Soldier("Віталій Вовнянко"));
        group2.addSoldier(new Soldier("Валентина Зінченко"));
        group2.addSoldier(new Soldier("Владислав Рябовол"));
        group3.addSoldier(new Soldier("В'ячеслав Гуменюк"));
        group3.addSoldier(new Soldier("Данило Ремішевський"));
        group3.addSoldier(new Soldier("Жанна Михайлюк"));
        do{
            printMainMenu();
            mainChoice = scanner.nextInt();
            handleChoiceMainMenu(mainChoice, scanner);
        } while (mainChoice != 3);

//        System.out.println("1. Військовослужбовці.");
//        System.out.println("2. Предмети.");
//        System.out.println("3. Оцінки.");
//        System.out.println("4. Звіти");
//        System.out.println("Введіть номер пункту меню та нажміть Enter");
//
//        myCourse.displayGradesByGroup(group1);
//        group1.getSolders().get(1).addGrade("Вища математика", 95);
//        group1.getSolders().get(1).addGrade("Вища математика", 90);
//        group1.getSolders().get(1).addGrade("Вища математика", 90);
//        myCourse.displayGradesByGroup(group1, "Вища математика");
//        myCourse.addSubjectByGroup("Метрологія", group1);
//        myCourse.displayGradesByGroup(group1);
//        group3.removeSoldier(10);
//        myCourse.displayGradesByGroup(group3);
    }

    public static void printMainMenu(){
        System.out.println("Головне меню. Виберіть опцію:");
        System.out.println("1. Особовий склад");
        System.out.println("2. Предмети та оцінки");
        System.out.println("3. Вихід");
        System.out.print("Введіть номер пункту меню та нажміть Enter: ");
    }

    public static void handleChoiceMainMenu(int choice, Scanner scanner){
        switch (choice) {
            case 1:
                printSoldierMenu(scanner);
                break;
            case 2:
                System.out.println("Ви обрали Варіант 2");
                // Додайте код для обробки опції 2
                break;
            case 3:
                System.out.println("Завершення програми.");
                // Додайте код для обробки опції 3
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
        }
    }

    public static void printSoldierMenu(Scanner scanner){
        int soldierMenuChoice;
        do {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Список військовослужбовців курсу");
            System.out.println("2. Додати військовослужбовця");
            System.out.println("3. Змінити дані військовослужбовця");
            System.out.println("4. Видалити військовослужбовця");
            System.out.println("5. Назад");
            System.out.print("Введіть номер пункту меню та нажміть Enter: ");
            soldierMenuChoice = scanner.nextInt();
            handleChoiceSoldierMenu(soldierMenuChoice);
        } while (soldierMenuChoice != 5);
    }

    public static void handleChoiceSoldierMenu(int choice){
        switch (choice) {
            case 1:
                displayAll();
                break;
            case 2:
                addSoldier();
                break;
            case 3:
                updateSoldier();
                break;
            case 4:
                System.out.println("Повернення до головного меню.");
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
        }
    }
}
