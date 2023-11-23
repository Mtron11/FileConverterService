package xml;
import read.ReadXml;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class XmlToJsonConverter {
    private ReadXml xmlParser;

    public List<TypeData> convertToJSONFile() {
        List<Monster> monsters = xmlParser.getMonsters();
        List<TypeData> typeDataList = new ArrayList<>();
        List<String> addedTypes = new ArrayList<>();

        for (Monster monster : monsters) {
            String type = monster.getType();
            if (!addedTypes.contains(type)) {
                TypeData typeData = new TypeData(type);
                for (Monster monstr : monsters) {
                    if (monstr.getType().equals(type)) {
                        typeData.addMonster(monstr);
                    }
                }
                typeDataList.add(typeData);
                addedTypes.add(type);
            }
        }

        return typeDataList;
    }
}
