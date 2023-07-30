import java.util.*;

class Grades {
    private int grade;
    private static List<String> subjects = new ArrayList<String>(Arrays.asList("Вища математика","Фізика","ООП","Історія України","Англійська мова","Українська мова"));;
    private Map<String, Integer> gradesMap;
    Grades(){
        this.grade = 0;
        this.gradesMap = new HashMap<>();
        int i = 0;
        while (i < this.getSubjects().size()){
            this.gradesMap.put(this.getSubject(i), grade);
            i++;
        }
    }
    public static String getSubject(int index) {
        return subjects.get(index);
    }
    public static List<String> getSubjects() {
        return subjects;
    }
    public static void delete(String subject){
        subjects.remove(subject);
    }
    public Map<String, Integer> getGradesMap() {
        return gradesMap;
    }

    public void setGradesMap(String subject, int grade){
        for(String s : gradesMap.keySet()){
            if(s.equals(subject)){
                gradesMap.put(s, grade);
            }
        }
    }

    @Override
    public String toString() {
        return gradesMap.toString();
    }
}