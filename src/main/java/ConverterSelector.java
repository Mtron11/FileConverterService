import json.TypeData;
import lombok.experimental.UtilityClass;
import read.ReadJson;
import read.ReadXml;
import write.WriteJson;
import write.WriteXml;
import xml.XmlToJsonConverter;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;
@Log4j2
@UtilityClass
public class ConverterSelector {
    public static void convertJsonToXml(String jsonFilePath, String xmlFilePath) {
        try {
            log.info("Начата конвертация из JSON в XML.");

            ReadJson reader = new ReadJson();
            List<TypeData> typeDataList = reader.readJSONFromFile(jsonFilePath);

            WriteXml writer = new WriteXml();
            writer.writeXMLToFile(typeDataList, xmlFilePath);

            log.info("Конвертация успешно завершена.");
        } catch (IOException e) {
            log.error("Ошибка при чтении/записи файлов: " + e.getMessage());
        }
    }

    public static void convertXmlToJson(String xmlFilePath, String jsonFilePath) {
        try {
            log.info("Начата конвертация из XML в JSON.");

            ReadXml xmlParser = new ReadXml(xmlFilePath);
            XmlToJsonConverter converter = new XmlToJsonConverter(xmlParser);
            List<xml.TypeData> typeDataList = converter.convertToJSONFile();
            WriteJson jsonWriter = new WriteJson();
            jsonWriter.writeJSONToFile(typeDataList, jsonFilePath);

            log.info("Конвертация успешно завершена.");
        } catch (Exception e) {
            log.error("Ошибка при чтении/записи файлов: " + e.getMessage());
        }
    }
}
