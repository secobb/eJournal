class Soldier {
    private String name;
    private String rank;
    private String group;
    private Grades grades;
    Soldier(String name, String rank, String group){
        this.name = name;
        this.rank = rank;
        this.group = group;
        this.grades = new Grades();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
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
    public void addGrades(String discipline, int grade){
        grades.setGradesMap(discipline, grade);
    }
    @Override
    public String toString() {
        String s = name + " " + rank + " " + group;
        return s;
    }
}
