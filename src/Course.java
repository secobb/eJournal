import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private List<Group> groups;

    Course() {
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void updateSoldier(Soldier soldier, String name, int group) {
        soldier.setName(name);
        soldier.setGroup(group);
    }

    public void displaySoldiersByGroup(Group group) {
        for (Soldier soldier : group.getSolders())
            System.out.println(soldier);
    }

    public void displayGradesByGroup(Group group) {
        for (Soldier soldier : group.getSolders()) {
            System.out.println(soldier);
            Map<String, Integer> grades = soldier.getGrades().getGradesMap();
            grades.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue()).forEach(System.out::println);
            System.out.println();
        }
    }
    public void displayGradesByGroup(Group group, String subject) {
        for (Soldier soldier : group.getSolders()) {
            System.out.println(soldier);
            Map<String, Integer> grades = soldier.getGrades().getGradesMap();
            if(grades.get(subject) == null){
                System.out.println("Предмет "+subject+" не знайдено");
            }
            else
            System.out.println(subject + ": "+grades.get(subject));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Course myCourse = new Course();
        Group group1 = new Group(2101);
        Soldier soldier1 = new Soldier("Голубенко Сергій", 2101);
        Soldier soldier2 = new Soldier("Романенко", 2101);
        group1.addSoldier(soldier1);
        group1.addSoldier(soldier2);
        myCourse.addGroup(group1);
        myCourse.displayGradesByGroup(group1);
        myCourse.updateSoldier(soldier2, "Романенко Віктор", 2101);
        soldier1.updateGrade("Вища математика", 95);
        myCourse.displayGradesByGroup(group1, "Вища математика");
    }
}
