package JSON;

import java.util.ArrayList;
import java.util.List;

public class TypeData {
    private String type;
    private List<Monster> monsters;

    public TypeData() {
    }

    public TypeData(String type) {
        this.type = type;
        this.monsters = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }
}
