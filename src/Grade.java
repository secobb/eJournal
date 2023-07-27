class Grade {
    private int grade;
    private String discipline;
    Grade(int grade, String discipline){
        this.grade = grade;
        this.discipline = discipline;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public String getDiscipline() {
        return discipline;
    }
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    @Override
    public String toString() {
        return grade+" "+discipline.toString();
    }
}