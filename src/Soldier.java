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

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
