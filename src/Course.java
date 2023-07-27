import java.util.ArrayList;
import java.util.List;

public class Course {
    private List<Soldier> soldiers;
    private Discipline disciplines;

    Course(){
        this.soldiers = new ArrayList<>();
        this.disciplines = new Discipline();
    }
    public void addSoldier(Soldier soldier){
        soldiers.add(soldier);
    }
    public List<Soldier> getSoldiers() {
        return soldiers;
    }
    public Discipline getDisciplines() {
        return disciplines;
    }
    public void setDisciplines(Discipline disciplines) {
        this.disciplines = disciplines;
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
    public List<Grade> getGradesBySubject(String subject){
        List<Grade> gradesBySubject = new ArrayList<>();
        for(Soldier soldier : soldiers){
            if(soldier.getGrades()){

            }
        }
    }
    public void addDiscipline(String subject){
        disciplines.add(subject);
    }
    public void delDiscipline(String subject){
        disciplines.delete(subject);
    }
}
