package org.example.service;

import lombok.experimental.UtilityClass;
import lombok.val;
import org.example.io.JsonWorker;
import org.example.io.XmlWorker;
import org.example.xml.TypeData;
import org.example.xml.XmlToJsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
@UtilityClass
public class ConverterSelector {
    private final Logger log = LoggerFactory.getLogger(ConverterSelector.class);

        public void convertJsonToXml(final Path jsonFilePath, final Path xmlFilePath) {
        try {
            log.info("Начата конвертация из JSON в XML.");

            val reader = new JsonWorker();
            val typeDataList = reader.readJSONFromFile(jsonFilePath);

            val writer = new XmlWorker();
            writer.writeXMLToFile(typeDataList.stream(), xmlFilePath);

            log.info("Конвертация успешно завершена.");
        } catch (IOException e) {
            log.error("Ошибка при чтении/записи файлов: {}", e.getMessage());
        }
    }

    public void convertXmlToJson(final Path xmlFilePath, final Path jsonFilePath) {
        try {
            log.info("Начата конвертация из XML в JSON.");

            val xmlParser = new XmlWorker(xmlFilePath);
            val converter = new XmlToJsonConverter(xmlParser);
            List<TypeData> typeDataList = converter.convertToJSONFile();
            val jsonWriter = new JsonWorker();
            jsonWriter.writeJSONToFile(typeDataList.stream(), jsonFilePath);

            log.info("Конвертация успешно завершена.");
        } catch (Exception e) {
            log.error("Ошибка при чтении/записи файлов: {}", e.getMessage());
        }
    }
}
