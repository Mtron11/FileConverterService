package Write;

import JSON.Monster;
import JSON.TypeData;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteXML {
    public void writeXMLToFile(List<TypeData> typeDataList, String xmlFilePath) throws IOException {
        // Создание нового XML-документа
        Document document = DocumentHelper.createDocument();
        Element monstersElement = document.addElement("monsters");

        // Проход по каждому типу монстров
        for (TypeData typeData : typeDataList) {
            // Проход по каждому монстру в данном типе
            List<Monster> monsters = typeData.getMonsters();
            for (Monster monster : monsters) {
                Element monsterElement = monstersElement.addElement("monster");
                monsterElement.addElement("name").setText(monster.getName());
                monsterElement.addElement("habitat").setText(monster.getHabitat());

                // Добавление элементов для характеристик и слабостей
                Element characteristicsElement = monsterElement.addElement("characteristics");
                characteristicsElement.addElement("strength").setText(monster.getCharacteristics().getStrength());
                characteristicsElement.addElement("agility").setText(monster.getCharacteristics().getAgility());
                characteristicsElement.addElement("resistance").setText(monster.getCharacteristics().getResistance());

                // Проход по слабостям монстра
                List<String> weaknesses = monster.getCharacteristics().getWeaknesses();
                Element weaknessesElement = characteristicsElement.addElement("weaknesses");
                for (String weakness : weaknesses) {
                    weaknessesElement.addElement("weakness").setText(weakness);
                }
            }
        }

        // Запись XML-документа в файл
        XMLWriter writer = new XMLWriter(new FileWriter(xmlFilePath), OutputFormat.createPrettyPrint());
        writer.write(document);
        writer.close();
    }
}
