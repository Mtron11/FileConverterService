package xml;
import lombok.val;
import read.ReadXml;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class XmlToJsonConverter {
    private ReadXml xmlParser;

    public List<TypeData> convertToJSONFile() {
        val monsters = xmlParser.getMonsters();
        List<TypeData> typeDataList = new ArrayList<>();
        List<String> addedTypes = new ArrayList<>();

        for (val monster : monsters) {
            String type = monster.getType();
            if (!addedTypes.contains(type)) {
                val typeData = new TypeData(type);
                for (val monstr : monsters) {
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
