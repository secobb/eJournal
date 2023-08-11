class Soldier {
    private String name;
    private Grades grades;

    Soldier(String name){
        this.name = name;
        this.grades = new Grades();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Grades getGrades() {
        return grades;
    }
    public void updateGrade(String subject, int grade){
        this.getGrades().setGradesMap(subject, grade);
    }
    public void addSubject(String subject){
        this.getGrades().addSubjects(subject);
    }

    @Override
    public String toString() {
        String s = name;
        return s;
    }
}
