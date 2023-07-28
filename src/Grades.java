import java.util.HashMap;
import java.util.Map;

class Grades {
    private int grade;
    private String discipline;
    private Map<String, Integer> gradesMap;
    Grades(){
        this.gradesMap = new HashMap<>();
    }
    Grades(String discipline, int grade){
        this.discipline = discipline;
        this.grade = grade;
    }
    public void setGradesMap(String discipline, int grade) {
        this.gradesMap.put(discipline, grade);
    }
    public Map<String, Integer> getGradesMap() {
        return gradesMap;
    }
    @Override
    public String toString() {
        return gradesMap.toString();
    }
}