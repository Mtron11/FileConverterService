package read;
import lombok.val;
import xml.Characteristics;
import xml.Monster;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class ReadXml {
    private Document document;

    public ReadXml(String xmlFilePath) throws Exception {
        val reader = new SAXReader();
        document = reader.read(xmlFilePath);
    }

    public List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        val monstersElement = document.getRootElement();

        for (val monsterElement : monstersElement.elements("monster")) {
            val name = monsterElement.elementText("name");
            val habitat = monsterElement.elementText("habitat");
            val type = monsterElement.elementText("type");

            val characteristicsElement = monsterElement.element("characteristics");
            val strength = characteristicsElement.elementText("strength");
            val agility = characteristicsElement.elementText("agility");
            val resistance = characteristicsElement.elementText("resistance");

            List<String> weaknesses = new ArrayList<>();
            val weaknessesElement = characteristicsElement.element("weaknesses");
            for (val weaknessElement : weaknessesElement.elements()) {
                weaknesses.add(weaknessElement.getText());
            }

            Characteristics characteristics = Characteristics.builder()
                    .strength(strength)
                    .agility(agility)
                    .resistance(resistance)
                    .weaknesses(weaknesses)
                    .build();
            Monster monster = Monster.builder()
                    .name(name)
                    .type(type)
                    .habitat(habitat)
                    .characteristics(characteristics)
                    .build();
            monsters.add(monster);
        }

        return monsters;
    }
}
