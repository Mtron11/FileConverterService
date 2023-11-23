package xml;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TypeData {
    private String type;
    private List<Monster> monsters;

    public TypeData(String type) {
        this.type = type;
    }

    public void addMonster(Monster monster) {
        if (monsters == null) {
            monsters = new ArrayList<>();
        }
        monsters.add(monster);
    }
}
