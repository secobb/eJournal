import java.util.HashMap;
import java.util.Map;

class Grades {
    private int grade;
    private String subject;
    private Map<String, Integer> gradesMap;
    Grades(){
        this.gradesMap = new HashMap<>();
    }
    Grades(String subject, int grade){
        this.subject = subject;
        this.grade = grade;
    }
    public void setGradesMap(String subject, int grade) {
        this.gradesMap.put(subject, grade);
    }
    public Map<String, Integer> getGradesMap() {
        return gradesMap;
    }
    @Override
    public String toString() {
        return gradesMap.toString();
    }
}