import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void addGrades(String subject, int grade){
        grades.setGradesMap(subject, grade);
    }
    @Override
    public String toString() {
        String s = name + " " + rank + " " + group + " " + grades;
        return s;
    }
}
