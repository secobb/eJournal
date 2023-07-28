import java.util.ArrayList;
import java.util.List;

public class Discipline {
    private String subject;
    private List<String> subjects;
    Discipline(){
        this.subjects = new ArrayList<>();
    }
    Discipline(String subject){
        this.subject = subject;
        this.subjects = new ArrayList<>();
    }
    public void setSubject(String subject) {
        this.subjects.add(subject);
    }
    public String getSubject(int index) {
        return subjects.get(index);
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
        return subject.toString();
    }
}
