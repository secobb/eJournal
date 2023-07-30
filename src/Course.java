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
    public void deleteSoldier(Soldier soldier){
        soldiers.remove(soldier);
    }
    public Soldier getSoldier(int id) {
        return soldiers.get(id);
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }
    public Soldier updateSoldier (Soldier soldier, String name, String group){
        soldier.setName(name);
        soldier.setGroup(group);
        return soldier;
    }
    public List<Soldier> displaySoldiersByGroup(String group){
        List<Soldier> groupSoldier = new ArrayList<>();
        for(Soldier soldier : soldiers){
            if(soldier.getGroup().equals(group)){
                groupSoldier.add(soldier);
                System.out.println(soldier);
            }
        }
        return groupSoldier;
    }
    public void displayGradesByGroup(String group) {
        for (Soldier soldier : soldiers) {
            if (soldier.getGroup().equals(group)) {
                System.out.println(soldier);
                Map<String, Integer> grades = soldier.getGrades().getGradesMap();
                grades.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue()).forEach(System.out::println);
                System.out.println();
            }
        }
    }

    public void addGrade(Soldier soldier, String subject, int grade){
        soldier.getGrades().setGradesMap(subject, grade);
    }

    public static void main(String[] args) {
        Course myCourse = new Course();
        Soldier soldier1 = new Soldier("Голубенко Сергій", "2101");
        Soldier soldier2 = new Soldier("Романенко", "2101");
        myCourse.addSoldier(soldier1);
        myCourse.addSoldier(soldier2);
        myCourse.addGrade(soldier1,"Вища математика", 95);
        myCourse.displayGradesByGroup("2101");
        myCourse.updateSoldier(soldier2,"Романенко Виктор", "2101");
        myCourse.displaySoldiersByGroup("2101");
       // System.out.println(soldier1);
    }
}
