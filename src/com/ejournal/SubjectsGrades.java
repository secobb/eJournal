package com.ejournal;

import java.util.*;

class SubjectsGrades {
    // List of subjects
    private final List<String> subjects = new ArrayList<>(Arrays.asList("Вища математика", "Фізика", "ООП", "Історія України", "Англійська мова"));
    // Subjects and grades
    private final Map<String, List<Integer>> gradesMap;

    // Constructor
    SubjectsGrades() {
        this.gradesMap = new HashMap<>();
        initializeSubjects();
    }

    // Initialized subjects and grades
    public void initializeSubjects() {
        int i = 0;
        while (i < getSubjects().size()) {
            this.gradesMap.put(getSubject(i), new ArrayList<>());
            i++;
        }
    }

    // get list of subjects
    public List<String> getSubjects() {
        return subjects;
    }

    // get one subject
    public String getSubject(int index) {
        return subjects.get(index);
    }

    // add subject
    public void setSubjects(String subject) {
        gradesMap.put(subject, new ArrayList<>());
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