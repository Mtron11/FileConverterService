package write;

import json.Monster;
import json.TypeData;
import lombok.val;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class WriteXml {
    public void writeXMLToFile(List<TypeData> typeDataList, String xmlFilePath) throws IOException {
        // Создание нового XML-документа
        Document document = DocumentHelper.createDocument();
        val monstersElement = document.addElement("monsters");

        // Проход по каждому типу монстров
        for (val typeData : typeDataList) {
            // Проход по каждому монстру в данном типе
            List<Monster> monsters = typeData.getMonsters();
            for (val monster : monsters) {
                val monsterElement = monstersElement.addElement("monster");
                monsterElement.addElement("name").setText(monster.getName());
                monsterElement.addElement("habitat").setText(monster.getHabitat());
                monsterElement.addElement("type").setText(typeData.getType());

                // Добавление элементов для характеристик и слабостей
                val characteristicsElement = monsterElement.addElement("characteristics");
                characteristicsElement.addElement("strength").setText(monster.getCharacteristics().getStrength());
                characteristicsElement.addElement("agility").setText(monster.getCharacteristics().getAgility());
                characteristicsElement.addElement("resistance").setText(monster.getCharacteristics().getResistance());

                // Проход по слабостям монстра
                List<String> weaknesses = monster.getCharacteristics().getWeaknesses();
                val weaknessesElement = characteristicsElement.addElement("weaknesses");
                IntStream.range(0, weaknesses.size())
                        .forEach(i -> weaknessesElement.addElement("weakness" + (i + 1)).setText(weaknesses.get(i)));
            }
        }

        // Запись XML-документа в файл
        val writer = new XMLWriter(new FileWriter(xmlFilePath), OutputFormat.createPrettyPrint());
        writer.write(document);
        writer.close();
    }
}
