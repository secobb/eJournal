import java.util.*;

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

    public void updateSoldier(Soldier soldier, String name) {
        soldier.setName(name);
    }
    public void addSubject(String subject){
        Grades.addSubject(subject);
        for (Group group : groups){
            for(Soldier soldier : group.getSolders()){
                soldier.addSubject(subject);
            }
        }
    }

    public void displaySoldiersByGroup(Group group) {
        for (Soldier soldier : group.getSolders())
            System.out.println(soldier);
    }

    public void displayGradesByGroup(Group group) {
        for (Soldier soldier : group.getSolders()) {
            System.out.println(soldier+ " Группа: "+group.getGroupId());
            Map<String, List<Integer>> grades = soldier.getGrades().getGradesMap();
            grades.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue()).forEach(System.out::println);
            System.out.println();
        }
    }
    public void displayGradesByGroup(Group group, String subject) {
            System.out.println("Група: "+group.getGroupId());
        for (Soldier soldier : group.getSolders()) {
            System.out.println(soldier);
            Map<String, List <Integer>> grades = soldier.getGrades().getGradesMap();
            if(grades.get(subject) == null){
                System.out.println("Предмет "+subject+" не знайдено");
            }
            else
            System.out.println(subject + ": "+grades.get(subject));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Електронний журнал обліку успішності підрозділу");
        Course myCourse = new Course();

        Group group1 = new Group(2101);
        Soldier soldier1 = new Soldier("Голубенко Сергій");
        Soldier soldier2 = new Soldier("Романенко Віктор");
        Soldier soldier3 = new Soldier("Вікторія Канашкіна");
        Soldier soldier4 = new Soldier("Віталій Вовнянко");
        Soldier soldier5 = new Soldier("Валентина Зінченко");
        Soldier soldier6 = new Soldier("Владислав Рябовол");
        Soldier soldier7 = new Soldier("В'ячеслав Гуменюк");
        Soldier soldier8 = new Soldier("Данило Ремішевський");
        Soldier soldier9 = new Soldier("Жанна Михайлюк");
        Soldier soldier10 = new Soldier("Микола Хоменко");
        Soldier soldier11 = new Soldier("Надія Кучеренко");
        Soldier soldier12 = new Soldier("Оксана Лежнюк");
        Soldier soldier13 = new Soldier("Ольга Танасієнко");
        Soldier soldier14 = new Soldier("Тетяна Валентюк");
        Soldier soldier15 = new Soldier("Юлія Петрочкова");
        Soldier soldier16 = new Soldier("Яна Братченко");
        Soldier soldier17 = new Soldier("Ярослав Плетенецький");
        group1.addSoldier(soldier1);
        group1.addSoldier(soldier2);
        myCourse.addGroup(group1);
        myCourse.displayGradesByGroup(group1);
        myCourse.updateSoldier(soldier2, "Романенко Віктор");
        soldier1.updateGrade("Вища математика", 95);
        soldier1.updateGrade("Вища математика", 90);
        myCourse.displayGradesByGroup(group1, "Вища математика");
        myCourse.displayGradesByGroup(group1);
        myCourse.addSubject("Метрологія");
        myCourse.displayGradesByGroup(group1);
    }
}
