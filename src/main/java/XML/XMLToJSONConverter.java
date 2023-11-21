package XML;
import Read.ReadXML;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class XMLToJSONConverter {
    private ReadXML xmlParser;

    public List<TypeData> convertToJSONFile() {
        List<Monster> monsters = xmlParser.getMonsters();
        List<TypeData> typeDataList = new ArrayList<>();
        List<String> addedTypes = new ArrayList<>();

        for (Monster monster : monsters) {
            String type = monster.getType();
            if (!addedTypes.contains(type)) {
                TypeData typeData = new TypeData(type);
                for (Monster m : monsters) {
                    if (m.getType().equals(type)) {
                        typeData.addMonster(m);
                    }
                }
                typeDataList.add(typeData);
                addedTypes.add(type);
            }
        }

        return typeDataList;
    }
}
