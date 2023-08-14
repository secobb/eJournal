package com.ejournal;

import java.util.*;

public class Course {
    private List<Group> groups;

    Course() {
        this.groups = new ArrayList<>();
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void updateSoldier(Soldier soldier, String name) {
        soldier.setName(name);
    }

    public void addSubjectByGroup(String subject, Group group) {
        for (Soldier soldier : group.getSolders()) {
            soldier.addSubject(subject);
        }
    }

    public void displayGradesByGroup(Group group) {
        for (Soldier soldier : group.getSolders()) {
            System.out.println(soldier);
            Map<String, List<Integer>> grades = soldier.getGrades().getGradesMap();
            grades.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue()).forEach(System.out::println);
            System.out.println();
        }
    }

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
        System.out.println("Електронний журнал обліку успішності підрозділу");
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
        myCourse.displayGradesByGroup(group1);
        group1.getSolders().get(1).addGrade("Вища математика", 95);
        group1.getSolders().get(1).addGrade("Вища математика", 90);
        group1.getSolders().get(1).addGrade("Вища математика", 90);
        myCourse.displayGradesByGroup(group1, "Вища математика");
        myCourse.addSubjectByGroup("Метрологія", group1);
        myCourse.displayGradesByGroup(group1);
        group3.removeSoldier(10);
        myCourse.displayGradesByGroup(group3);
    }
}
