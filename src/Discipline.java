import java.util.ArrayList;
import java.util.List;

public class Discipline {
    private List<String> subjects;
    Discipline(){
        this.subjects = new ArrayList<>();
    }
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
    public List<String> getSubjects() {
        return subjects;
    }
    public void add(String discipline) {
        this.subjects.add(discipline);
    }
    public void delete(String discipline){
        this.subjects.remove(discipline);
    }
    @Override
    public String toString() {
        return subjects.toString();
    }
}
