class Soldier {
    private String name;
    private String group;
    private Grades grades;
    Soldier(String name, String group){
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
   public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public Grades getGrades() {
        return grades;
    }
    //    public void addGrades(String discipline, int grade){
//        grades.setGradesMap(discipline, grade);
//    }
    @Override
    public String toString() {
        String s = name + " " + group;
        return s;
    }
}
