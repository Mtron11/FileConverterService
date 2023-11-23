package read;
import xml.Characteristics;
import xml.Monster;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class ReadXml {
    private Document document;

    public ReadXml(String xmlFilePath) throws Exception {
        SAXReader reader = new SAXReader();
        document = reader.read(xmlFilePath);
    }

    public List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        Element monstersElement = document.getRootElement();

        for (Element monsterElement : monstersElement.elements("monster")) {
            String name = monsterElement.elementText("name");
            String habitat = monsterElement.elementText("habitat");
            String type = monsterElement.elementText("type");

            Element characteristicsElement = monsterElement.element("characteristics");
            String strength = characteristicsElement.elementText("strength");
            String agility = characteristicsElement.elementText("agility");
            String resistance = characteristicsElement.elementText("resistance");

            List<String> weaknesses = new ArrayList<>();
            Element weaknessesElement = characteristicsElement.element("weaknesses");
            for (Element weaknessElement : weaknessesElement.elements()) {
                weaknesses.add(weaknessElement.getText());
            }

            Characteristics characteristics = new Characteristics(strength, agility, resistance, weaknesses);
            Monster monster = new Monster(name, habitat, type, characteristics);
            monsters.add(monster);
        }

        return monsters;
    }
}