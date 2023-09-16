package com.ejournal;

import java.util.*;

class Course {
    // list groups
    private static List<Group> groups;

    // constructor
    Course() {
        groups = new ArrayList<>();
    }

    // add groups to course
    public void setGroups(List<Group> groups) {
        Course.groups = groups;
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

    // add soldier to group
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
                                    System.out.println("Дані військовослужбовця змінено");
                                }
                            }
                        }
        if(!flagSoldier){
            System.out.println("Такий номер військовослужбовця не існує.");
        }
    }

    // delete soldier
    public static void deleteSoldier(){
        Scanner scanner = new Scanner(System.in);
        int idSoldier;
        boolean flagSoldier = false;
        displayAll();
        System.out.println("Введіть номер військовослужбовця, якого ви хочете видалити:");
        idSoldier = scanner.nextInt();
        for (Group group : groups) {
            for (Soldier soldier : group.getSolders()) {
                if (soldier.getId() == idSoldier) {
                    group.removeSoldier(idSoldier);
                    flagSoldier = true;
                    System.out.println("Військовослужбовця видалено");
                    break;
                }
            }
        }
        if(!flagSoldier){
            System.out.println("Такий номер військовослужбовця не існує.");
        }
    }

    // display all subjects and grades of course
    public static void displayAllGrades() {
        for (Group group : groups) {
            for (Soldier soldier : group.getSolders()) {
                System.out.println(soldier);
                Map<String, List<Integer>> grades = soldier.getGrades().getGradesMap();
                grades.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue()).forEach(System.out::println);
                System.out.println();
            }
        }
    }

    // display all grades for group of soldiers
    public static void displayGradesForGroup() {
        Scanner scanner = new Scanner(System.in);
        boolean flagGroup = false;
        System.out.println("Введіть номер групи: ");
        int idGroup = scanner.nextInt();
        for (Group group : groups) {
            if (group.getGroupId() == idGroup) {
                flagGroup = true;
                System.out.println("Група "+idGroup);
                for (Soldier soldier : group.getSolders()) {
                    System.out.println(soldier);
                    Map<String, List<Integer>> grades = soldier.getGrades().getGradesMap();
                    grades.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue()).forEach(System.out::println);
                    System.out.println();
                }
            }
        }
        if(!flagGroup){
            System.out.println("Даної групи не існує.");
        }
    }

    // display subject grades per group
    public static void displaySubjectGradesPerGroup() {
        Scanner scanner = new Scanner(System.in);
        boolean flagGroup = false;
        int idGroup;
        System.out.println("На курсі викладають наступні предмети: ");
        System.out.println(SubjectsGrades.getSubjects());
            System.out.println("Введіть номер групи: ");
            if (scanner.hasNextInt()) {
                idGroup = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Некорректно введено номер групи.");
                return;
            }
        System.out.println("Введіть назву предмету: ");
        String subject = scanner.nextLine();
        for (Group group : groups) {
            if (group.getGroupId() == idGroup) {
                flagGroup = true;
                System.out.println("Група " + idGroup);
                for (Soldier soldier : group.getSolders()) {
                    if (!SubjectsGrades.getSubjects().contains(subject)) {
                        System.out.println("Предмет " + subject + " не викладають на курсі");
                        break;
                    }
                    System.out.println(soldier);
                    Map<String, List<Integer>> grades = soldier.getGrades().getGradesMap();
                    System.out.println(subject + ": " + grades.get(subject));
                }
            }
        }
        if (!flagGroup) {
            System.out.println("Даної групи не існує.");
        }
    }

    // add grade to soldier
    public static void addGradeToSoldier(){
        boolean flagSoldier = false;
        displayAll();
        System.out.println("На курсі викладають наступні предмети: ");
        System.out.println(SubjectsGrades.getSubjects());
        System.out.println("Введіть номер військовослужбовця, якому будемо ставити оцінку: ");
        Scanner scan = new Scanner(System.in);
        int idSoldier = scan.nextInt();
        scan.nextLine();
        System.out.println("Введіть назву предмету: ");
        String subject = scan.nextLine();
        System.out.println("Додати оцінку: ");
        int gradeSoldier = scan.nextInt();
        for (Group group : groups) {
            for (Soldier soldier : group.getSolders()) {
                if (soldier.getId() == idSoldier) {
                    soldier.addGrade(subject, gradeSoldier);
                    flagSoldier = true;
                    System.out.println("Оцінку додано");
                    break;
                }
            }
        }
        if(!flagSoldier){
            System.out.println("Такий номер військовослужбовця не існує.");
        }
    }

    // add subject to course
    public static void addSubject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву предмету, який хочете добавити: ");
        String subject = scanner.nextLine();
        SubjectsGrades.addSubject(subject);
        for (Group group : groups) {
            for (Soldier soldier : group.getSolders()) {
                soldier.addSubject(subject);
            }
        }
        System.out.println("Предмет додано");
    }

    // delete subject from course
    public static void removeSubject(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву предмету, який треба видалити: ");
        String subject = scanner.nextLine();
        if(SubjectsGrades.getSubjects().contains(subject)){
            SubjectsGrades.getSubjects().remove(subject);
            for (Group group : groups) {
                for (Soldier soldier : group.getSolders()) {
                    soldier.removeSubject(subject);
                }
            }
            System.out.println("Предмет видалено");
        }
    }

    // average grade for course
    public static void getAverageGradeForCourse(){
        double totalGrades = 0;
        int totalSoldiers = 0;
        for (Group group : groups) {
            for (Soldier soldier : group.getSolders()) {
                totalGrades+=soldier.getAverageGrade();
                totalSoldiers++;
            }
        }
        System.out.println("Середній бал за весь курс: "+ totalGrades / totalSoldiers);
    }

    // average grade for group
    public static void getAverageGradeByGroup(){
        Scanner scanner = new Scanner(System.in);
        double totalGrades = 0;
        int totalSoldiers = 0;
        System.out.println("Введіть номер групи:");
        int idGroup = scanner.nextInt();
        for (Group group : groups) {
            if(group.getGroupId() == idGroup) {
                for (Soldier soldier : group.getSolders()) {
                    totalGrades += soldier.getAverageGrade();
                    totalSoldiers++;
                }
            }
        }
        System.out.println("Середній бал за групу "+idGroup+" : "+ totalGrades / totalSoldiers);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainChoice;
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
        } while (mainChoice != 5);
    }

    public static void printMainMenu(){
        System.out.println("Головне меню. Виберіть опцію:");
        System.out.println("1. Особовий склад");
        System.out.println("2. Оцінки");
        System.out.println("3. Предмети");
        System.out.println("4. Рейтинг успішності");
        System.out.println("5. Вихід");
        System.out.print("Введіть номер пункту меню та нажміть Enter: ");
    }

    public static void handleChoiceMainMenu(int choice, Scanner scanner){
        switch (choice) {
            case 1:
                printSoldierMenu(scanner);
                break;
            case 2:
                printGradesMenu(scanner);
                break;
            case 3:
                printSubjectsMenu(scanner);
                break;
            case 4:
                printRatingMenu(scanner);
                break;
            case 5:
                System.out.println("Завершення програми.");
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
        }
    }

    // menu for soldiers
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
    // submenu for soldiers
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
                deleteSoldier();
                break;
            case 5:
                System.out.println("Повернення до головного меню.");
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
        }
    }

    // menu for grades
    public static void printGradesMenu(Scanner scanner){
        int gradesMenuChoice;
        do {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Відображення оцінок за всі предмети за курс");
            System.out.println("2. Відображення оцінок за всі предмети за групу");
            System.out.println("3. Відображення оцінок з предмету за групу");
            System.out.println("4. Добавити оцінку військовослужбовцю");
            System.out.println("5. Назад");
            System.out.print("Введіть номер пункту меню та нажміть Enter: ");
            gradesMenuChoice = scanner.nextInt();
            handleChoiceGradesMenu(gradesMenuChoice);
        } while (gradesMenuChoice != 5);
    }

    // submenu for subjects and grades
    public static void handleChoiceGradesMenu(int choice){
        switch (choice) {
            case 1:
                displayAllGrades();
                break;
            case 2:
                displayGradesForGroup();
                break;
            case 3:
                displaySubjectGradesPerGroup();
                break;
            case 4:
                addGradeToSoldier();
                break;
            case 5:
                System.out.println("Повернення до головного меню.");
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
        }
    }

    //menu for Subjects
    public static void printSubjectsMenu(Scanner scanner){
        int subjectsMenuChoice;
        do {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Показати всі предмети на курсі");
            System.out.println("2. Додати предмет для вивчення на курсі");
            System.out.println("3. Видалити предмет з вивчення на курсі");
            System.out.println("4. Назад");
            System.out.print("Введіть номер пункту меню та нажміть Enter: ");
            subjectsMenuChoice = scanner.nextInt();
            handleChoiceSubjectsMenu(subjectsMenuChoice);
        } while (subjectsMenuChoice != 4);
    }

    // submenu for subjects and grades
    public static void handleChoiceSubjectsMenu(int choice){
        switch (choice) {
            case 1:
                System.out.println(SubjectsGrades.getSubjects());
                break;
            case 2:
                addSubject();
                break;
            case 3:
                removeSubject();
                break;
            case 4:
                System.out.println("Повернення до головного меню.");
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
        }
    }

    // menu for rating
    public static void printRatingMenu(Scanner scanner){
        int ratingMenuChoice;
        do {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Показати рейтинг успішності курсу");
            System.out.println("2. Показати рейтинг успішності групи");
            System.out.println("3. Назад");
            System.out.print("Введіть номер пункту меню та нажміть Enter: ");
            ratingMenuChoice = scanner.nextInt();
            handleChoiceRatingMenu(ratingMenuChoice);
        } while (ratingMenuChoice != 3);
    }

    // submenu for rating
    public static void handleChoiceRatingMenu(int choice){
        switch (choice) {
            case 1:
                getAverageGradeForCourse();
                break;
            case 2:
                getAverageGradeByGroup();
                break;
            case 3:
                System.out.println("Повернення до головного меню.");
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
        }
    }
}