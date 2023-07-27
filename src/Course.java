import java.util.ArrayList;
import java.util.List;

public class Course {
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
    public static void main(String[] args) {
        Soldier soldier1 = new Soldier("Голубенко Сергій", "старший сержант", "2101");
        soldier1.addGrades("Математика", 95);
        System.out.println(soldier1);
    }
}
