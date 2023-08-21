package com.ejournal;

class Soldier {
    private static int count;
    private final int id;
    // Name soldier
    private String name;
    // List subjects and grades
    private final SubjectsGrades subjectsGrades;

    // Constructor
    Soldier(String name) {
        this.name = name;
        this.id = ++count;
        this.subjectsGrades = new SubjectsGrades();
    }

    public int getId() {
        return id;
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

    // update grades
    public void addGrade(String subject, int grade) {
        this.getGrades().setGradesMap(subject, grade);
    }

    // add subject
    public void addSubject(String subject) {
        this.getGrades().setSubjects(subject);
    }

    // remove subject
    public boolean removeSubject(String subject) {
        this.getGrades().getSubjects().remove(subject);
        return true;
    }

    @Override
    public String toString() {
        return id+" "+name;
    }
}
