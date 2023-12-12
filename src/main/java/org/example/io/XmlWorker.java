package org.example.io;

import lombok.NoArgsConstructor;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.example.json.Monster;
import org.example.json.TypeData;
import lombok.val;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.example.xml.Characteristics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor
public class XmlWorker {
    private final Logger log = LoggerFactory.getLogger(XmlWorker.class);
    private Document document;

    public XmlWorker(final Path xmlFilePath) throws IOException {
        try (InputStream inputStream = new FileInputStream(xmlFilePath.toFile())) {
            val reader = new SAXReader();
            document = reader.read(inputStream);
        } catch (Exception e) {
            log.error("Ошибка при чтении XML-файла", e);
        }
    }

    public void writeXMLToFile(Stream<TypeData> typeDataStream, final Path xmlFilePath) throws IOException {
        document = DocumentHelper.createDocument();
        val monstersElement = document.addElement("monsters");

        // Проход по каждому типу монстров
        typeDataStream.flatMap(typeData -> typeData.getMonsters().stream()
                        .map(monster -> new Object[]{typeData.getType(), monster}))
                .forEach(data -> {
                    val type = (String) data[0];
                    val monster = (Monster) data[1];

                    val monsterElement = monstersElement.addElement("monster");
                    monsterElement.addElement("name").setText(monster.getName());
                    monsterElement.addElement("habitat").setText(monster.getHabitat());
                    monsterElement.addElement("type").setText(type);

                    // Добавление элементов для характеристик и слабостей
                    val characteristicsElement = monsterElement.addElement("characteristics");
                    characteristicsElement.addElement("strength").setText(monster.getCharacteristics().getStrength());
                    characteristicsElement.addElement("agility").setText(monster.getCharacteristics().getAgility());
                    characteristicsElement.addElement("resistance").setText(monster.getCharacteristics().getResistance());

                    // Проход по слабостям монстра
                    val weaknesses = monster.getCharacteristics().getWeaknesses();
                    val weaknessesElement = characteristicsElement.addElement("weaknesses");
                    weaknesses.forEach(weakness -> weaknessesElement.addElement("weakness").setText(weakness));
                });

        // Запись XML-документа в файл
        try (Writer writer = new FileWriter(xmlFilePath.toFile())) {
            val xmlWriter = new XMLWriter(writer, OutputFormat.createPrettyPrint());
            xmlWriter.write(document);
        } catch (Exception e) {
            log.error("Ошибка при записи XML-файла", e);
        }
    }

    public List<org.example.xml.Monster> getMonsters() {
        val monstersElement = document.getRootElement();

        return monstersElement.elements("monster").stream()
                .map(monsterElement -> {
                    val name = monsterElement.elementText("name");
                    val habitat = monsterElement.elementText("habitat");
                    val type = monsterElement.elementText("type");

                    val characteristicsElement = monsterElement.element("characteristics");
                    val strength = characteristicsElement.elementText("strength");
                    val agility = characteristicsElement.elementText("agility");
                    val resistance = characteristicsElement.elementText("resistance");

                    val weaknesses = characteristicsElement.element("weaknesses").elements().stream()
                            .map(Element::getText)
                            .collect(Collectors.toList());

                    val characteristics = Characteristics.builder()
                            .strength(strength)
                            .agility(agility)
                            .resistance(resistance)
                            .weaknesses(weaknesses)
                            .build();

                    return org.example.xml.Monster.builder()
                            .name(name)
                            .type(type)
                            .habitat(habitat)
                            .characteristics(characteristics)
                            .build();
                })
                .collect(Collectors.toList());
    }
}
