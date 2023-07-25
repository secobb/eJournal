public class Soldier {
    private String name;
    private String rank;
    private String group;

    public Soldier(String name, String rank, String group){
        this.name = name;
        this.rank = rank;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getGroup() {
        return group;
    }
}
