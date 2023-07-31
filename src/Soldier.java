class Soldier {
    private String name;
    private int group;
    private Grades grades;
    Soldier(String name, int group){
        this.name = name;
        this.group = group;
        this.grades = new Grades();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGroup() {
        return group;
    }
    public void setGroup(int group) {
        this.group = group;
    }

    public Grades getGrades() {
        return grades;
    }
    public void updateGrade(String subject, int grade){
        this.getGrades().setGradesMap(subject, grade);
    }
    @Override
    public String toString() {
        String s = name + " Група " + group;
        return s;
    }
}
