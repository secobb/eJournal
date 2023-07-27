import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Course firstCours = new Course();
        firstCours.addSoldier(new Soldier("Голубенко Сергій", "старший сержант", "2101"));
        firstCours.addSoldier(new Soldier("Краснокут Станіслав", "старший солдат", "2101"));
        firstCours.addSoldier(new Soldier("Харченко Олександр", "сержант", "2101"));
        firstCours.addSoldier(new Soldier("Крагель Леся", "старший солдат", "2102"));
        firstCours.addSoldier(new Soldier("Гриценко Олена", "старший солдат", "2102"));
        firstCours.addSoldier(new Soldier("Шевченко Антон", "молодший сержант", "2102"));
        firstCours.addSoldier(new Soldier("Карнаух Юрій", "молодший сержант", "2103"));
        firstCours.addSoldier(new Soldier("Солончук Владислав", "старший солдат", "2103"));
        firstCours.addSoldier(new Soldier("Лашин Олексій", "сержант", "2103"));
        firstCours.addDiscipline("Вища математика");
        firstCours.addDiscipline("Фізика");
        firstCours.addDiscipline("Історія України");
        firstCours.addDiscipline("Програмування");
        firstCours.addDiscipline("Схемотехніка");
        firstCours.getSoldiers().get(1).addGrade(new Grade(90, firstCours.getDisciplines().getSubjects().get(1)));
        firstCours.delDiscipline("Фізика");
        System.out.println(firstCours.getSoldiersByGroup("2101").toString());
        System.out.println(firstCours.getDisciplines().toString());
        //System.out.println(firstCours.getDisciplines().toString());
    }
}
