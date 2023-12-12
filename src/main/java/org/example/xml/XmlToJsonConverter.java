package org.example.xml;
import lombok.val;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.example.io.XmlWorker;

@AllArgsConstructor
public class XmlToJsonConverter {
    private XmlWorker xmlParser;

    public List<TypeData> convertToJSONFile() {
        val monsters = xmlParser.getMonsters();

        Map<String, List<Monster>> monstersByType = monsters.stream()
                .collect(Collectors.groupingBy(Monster::getType));

        return monstersByType.entrySet().stream()
                .map(entry -> {
                    val typeData = new TypeData(entry.getKey());
                    typeData.setMonsters(entry.getValue());
                    return typeData;
                })
                .collect(Collectors.toList());
    }
}
