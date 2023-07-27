import java.util.ArrayList;
import java.util.List;

public class Discipline {
    private String subject;
    private List<String> subjects;
    Discipline(String subject){
        this.subject = subject;
        this.subjects = new ArrayList<>();
    }
    public void setSubject(String subject) {
        this.subject = subject;
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
