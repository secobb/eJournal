package com.ejournal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Soldier {
    // count id
    private static int count;
    // Id soldier
    private int id;
    // Name soldier
    private String name;
    // List subjects and grades
    private final SubjectsGrades subjectsGrades;
    // Group id
    private int groupId;

    // Constructor
    Soldier(String name) {
        this.name = name;
        this.id = ++count;
        this.subjectsGrades = new SubjectsGrades();
    }

    // get Id
    public int getId() {
        return id;
    }

    // set groupeId
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    // get name soldier
    public String getName() {
        return name;
    }

    // set name soldier
    public void setName(String name) {
        this.name = name;
    }

    // get grades and subjects
    public SubjectsGrades getGrades() {
        return subjectsGrades;
    }

    // add grade
    public void addGrade(String subject, int grade) {
        this.getGrades().setGradesMap(subject, grade);
    }
    // get average grade
    public double getAverageGrade() {
        double sum = 0;
        int count = 0;
        Map<String, List<Integer>> grades = this.getGrades().getGradesMap();
        for (Map.Entry<String, List<Integer>> subject : grades.entrySet()) {
            String k = subject.getKey();
            for (Integer v : subject.getValue()) {
                sum += v;
                count++;
            }
        }
        return (double) sum / count;
    }

    // add subject
    public void addSubject(String subject) {
        this.getGrades().setSubjects(subject);
    }

    // remove subject
    public boolean removeSubject(String subject) {
        this.getGrades().removeSubject(subject);
        return true;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
