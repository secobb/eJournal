package com.ejournal;

import java.util.*;

class SubjectsGrades {
    private final List<String> subjects = new ArrayList<>(Arrays.asList("Вища математика", "Фізика", "ООП", "Історія України", "Англійська мова"));
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

    public List<String> getSubjects() {
        return subjects;
    }

    public String getSubject(int index) {
        return subjects.get(index);
    }

    public void setSubjects(String subject) {
        gradesMap.put(subject, new ArrayList<>());
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