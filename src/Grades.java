import java.util.*;

class Grades {
    private static List<String> subjects = new ArrayList<String>(Arrays.asList("Вища математика","Фізика","ООП","Історія України","Англійська мова","Українська мова"));;
    private Map<String, List<Integer>> gradesMap;
    Grades(){
        this.gradesMap = new HashMap<>();
        int i = 0;
        while (i < this.getSubjects().size()){
            this.gradesMap.put(this.getSubject(i), new ArrayList<Integer>());
            i++;
        }
    }
    public static String getSubject(int index) {
        return subjects.get(index);
    }
    public static List<String> getSubjects() {
        return subjects;
    }
    public static void addSubject(String subject){
        subjects.add(subject);
    }
    public static void delete(String subject){
        subjects.remove(subject);
    }
    public Map<String, List<Integer>> getGradesMap() {
        return gradesMap;
    }

    public void setGradesMap(String subject, int grade){
            if(this.gradesMap.containsKey(subject)){
                this.gradesMap.get(subject).add(grade);
            }
        }
    public void addSubjects(String subject){
        gradesMap.put(subject, new ArrayList<>());
    }

    @Override
    public String toString() {
        return gradesMap.toString();
    }
}