import java.util.ArrayList;
import java.util.List;

public class Group {
    private int groupId;
    private List<Soldier> soldiers;
    public Group(int groupId){
        this.groupId = groupId;
        this.soldiers = new ArrayList<>();
    }
    public int getGroupId() {
        return this.groupId;
    }
    public void addSoldier(Soldier soldier){
        soldiers.add(soldier);
    }
    public void addSolders(List<Soldier> soldier){
        soldiers.addAll(soldier);
    }
    public void removeSoldier(Soldier soldier){
        soldiers.remove(soldier);
    }
    public List<Soldier> getSolders() {
        return soldiers;
    }
}
