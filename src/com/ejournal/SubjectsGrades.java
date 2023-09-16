package com.ejournal;

import java.util.*;

class SubjectsGrades {
    // List of subjects
    private static List<String> subjects = new ArrayList<>(Arrays.asList("Вища математика", "Фізика", "ООП", "Історія України", "Англійська мова"));
    // Subjects and grades
    private Map<String, List<Integer>> gradesMap;

    // Constructor
    SubjectsGrades() {
        this.gradesMap = new HashMap<>();
        initializeSubjects();
    }

    // Initialized subjects and grades
    public void initializeSubjects() {
        int i = 0;
        while (i < getSubjects().size()) {
            this.gradesMap.put(getSubject(i), new ArrayList<>(Arrays.asList(90,85,80,75)));
            i++;
        }
    }

    // get list of subjects
    public static List<String> getSubjects() {
        return subjects;
    }

    // get one subject
    public String getSubject(int index) {
        return subjects.get(index);
    }

    public void removeSubject(String subject){
        this.gradesMap.remove(subject);
    }

    // add subject to soldier
    public void setSubjects(String subject) {
        gradesMap.put(subject, new ArrayList<>());
    }

    // add subject to list
    public static void addSubject(String subject) {
        subjects.add(subject);
    }

    // get subjects and grades
    public Map<String, List<Integer>> getGradesMap() {
        return gradesMap;
    }

    public void setGradesMap(String subject, int grade) {
        if (this.gradesMap.containsKey(subject)) {
            this.gradesMap.get(subject).add(grade);
        }
    }

    @Override
    public String toString() {
        return gradesMap.toString();
    }
}