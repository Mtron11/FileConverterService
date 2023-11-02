package XML;

import java.util.ArrayList;
import java.util.List;

public class TypeData {
    private String type;
    private List<Monster> monsters;

    public TypeData(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void addMonster(Monster monster) {
        if (monsters == null) {
            monsters = new ArrayList<>();
        }
        monsters.add(monster);
    }
}
