import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Course {
    private Soldier soldier;
    private List<Soldier> soldiers;
    Course(){
        this.soldiers = new ArrayList<>();
    }
    public void addSoldier(Soldier soldier){
        soldiers.add(soldier);
    }
    public List<Soldier> getSoldiers() {
        return soldiers;
    }
    public List<Soldier> getSoldiersByGroup(String group){
        List<Soldier> groupSoldier = new ArrayList<>();
        for(Soldier soldier : soldiers){
            if(soldier.getGroup().equals(group)){
                groupSoldier.add(soldier);
            }
        }
        return groupSoldier;
    }
    public void displayGradesByGroup(String group) {
        System.out.println("Grades for students in Group: " + group);
        for (Soldier soldier : soldiers) {
            if (soldier.getGroup().equals(group)) {
                System.out.println(soldier);
                Map<String, Integer> grades = soldier.getGrades().getGradesMap();
                grades.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue()).forEach(System.out::println);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Course myCourse = new Course();
        Discipline myDiscipline = new Discipline();
        myDiscipline.add("Математика");
        myDiscipline.add("Фізика");
        Soldier soldier1 = new Soldier("Голубенко Сергій", "старший сержант", "2101");
        soldier1.addGrades(myDiscipline.getSubject(0), 95);
        soldier1.addGrades(myDiscipline.getSubject(1), 94);
        Soldier soldier2 = new Soldier("Романенко", "старший сержант", "2101");
        soldier2.addGrades(myDiscipline.getSubject(0), 78);
        myCourse.addSoldier(soldier1);
        myCourse.addSoldier(soldier2);
        myCourse.displayGradesByGroup("2101");
        System.out.println(myDiscipline.getSubjects());
        myDiscipline.delete("Математика");
        System.out.println(myDiscipline.getSubjects());
        myCourse.displayGradesByGroup("2101");
       // System.out.println(soldier1);
    }
}
