package com.ejournal;

class Soldier {
    private String name;
    private SubjectsGrades subjectsGrades;

    Soldier(){}
    Soldier(String name) {
        this.name = name;
        this.subjectsGrades = new SubjectsGrades();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubjectsGrades getGrades() {
        return subjectsGrades;
    }

    public void updateGrade(String subject, int grade) {
        this.getGrades().setGradesMap(subject, grade);
    }

    public void addSubject(String subject) {
        this.getGrades().addSubject(subject);
    }

    @Override
    public String toString() {
        return name;
    }
}
