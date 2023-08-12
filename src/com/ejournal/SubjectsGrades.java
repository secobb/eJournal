package com.ejournal;

import java.util.*;

class SubjectsGrades {
    private static final List<String> subjects = new ArrayList<>(Arrays.asList("Вища математика", "Фізика", "ООП", "Історія України", "Англійська мова"));

    private final Map<String, List<Integer>> gradesMap;

    SubjectsGrades() {
        this.gradesMap = new HashMap<>();
        initializeSubjects();
    }

    public void initializeSubjects(){
        int i = 0;
        while (i < getSubjects().size()) {
            this.gradesMap.put(getSubject(i), new ArrayList<>());
            i++;
        }
    }

    public static List<String> getSubjects() {
        return subjects;
    }

    public static String getSubject(int index) {
        return subjects.get(index);
    }

    public static void setSubjects(String subject) {
        subjects.add(subject);
    }

    public void addSubject(String subject) {
        gradesMap.put(subject, new ArrayList<>());
    }

    public static void removeSubject(String subject) {
        subjects.remove(subject);
    }

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