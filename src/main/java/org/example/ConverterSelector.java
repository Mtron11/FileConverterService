package org.example;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import read.ReadJson;
import read.ReadXml;
import write.WriteJson;
import write.WriteXml;
import xml.XmlToJsonConverter;

import java.io.IOException;
import java.util.List;
@UtilityClass
public class ConverterSelector {
    private final Logger log = LoggerFactory.getLogger(ConverterSelector.class);

    public void convert(String[] args) {
        if (args.length != 2) {
            log.error("Неверное количество аргументов. Используйте: java Launcher <inputFile> <outputFile>");
            return;
        }

        val inputFile = args[0];
        val outputFile = args[1];

        try {
            if (inputFile.endsWith(".json") && outputFile.endsWith(".xml")) {
                convertJsonToXml(inputFile, outputFile);
            } else if (inputFile.endsWith(".xml") && outputFile.endsWith(".json")) {
                convertXmlToJson(inputFile, outputFile);
            } else {
                log.error("Неподдерживаемые форматы файлов. Используйте .json для входного файла и .xml для выходного.");
            }
        } catch (Exception e) {
            log.error("Ошибка при выполнении конвертации: {}", e.getMessage());
        }
    }
    public void convertJsonToXml(String jsonFilePath, String xmlFilePath) {
        try {
            log.info("Начата конвертация из JSON в XML.");

            val reader = new ReadJson();
            val typeDataList = reader.readJSONFromFile(jsonFilePath);

            val writer = new WriteXml();
            writer.writeXMLToFile(typeDataList, xmlFilePath);

            log.info("Конвертация успешно завершена.");
        } catch (IOException e) {
            log.error("Ошибка при чтении/записи файлов: {}", e.getMessage());
        }
    }

    public void convertXmlToJson(String xmlFilePath, String jsonFilePath) {
        try {
            log.info("Начата конвертация из XML в JSON.");

            val xmlParser = new ReadXml(xmlFilePath);
            val converter = new XmlToJsonConverter(xmlParser);
            List<xml.TypeData> typeDataList = converter.convertToJSONFile();
            val jsonWriter = new WriteJson();
            jsonWriter.writeJSONToFile(typeDataList, jsonFilePath);

            log.info("Конвертация успешно завершена.");
        } catch (Exception e) {
            log.error("Ошибка при чтении/записи файлов: {}", e.getMessage());
        }
    }
}
