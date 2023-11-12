import JSON.TypeData;
import Read.ReadJSON;
import Read.ReadXML;
import Write.WriteJson;
import Write.WriteXML;
import XML.XMLToJSONConverter;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Неверное количество аргументов. Используйте: java Main <inputFile> <outputFile>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        if (inputFile.endsWith(".json") && outputFile.endsWith(".xml")) {
            convertJsonToXml(inputFile, outputFile);
        } else if (inputFile.endsWith(".xml") && outputFile.endsWith(".json")) {
            convertXmlToJson(inputFile, outputFile);
        } else {
            System.out.println("Неподдерживаемые форматы файлов. Используйте .json для входного файла и .xml для выходного.");
        }
    }
    private static void convertJsonToXml(String jsonFilePath, String xmlFilePath) {
        try {
            ReadJSON reader = new ReadJSON();
            List<TypeData> typeDataList = reader.readJSONFromFile(jsonFilePath);

            WriteXML writer = new WriteXML();
            writer.writeXMLToFile(typeDataList, xmlFilePath);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файлов: " + e.getMessage());
        }
    }

    private static void convertXmlToJson(String xmlFilePath, String jsonFilePath) {
        try {
            ReadXML xmlParser = new ReadXML(xmlFilePath);
            XMLToJSONConverter converter = new XMLToJSONConverter(xmlParser);
            List<XML.TypeData> typeDataList = converter.convertToJSONFile();
            WriteJson jsonWriter = new WriteJson();
            jsonWriter.writeJSONToFile(typeDataList, jsonFilePath);
        } catch (Exception e) {
            System.out.println("Ошибка при чтении/записи файлов: " + e.getMessage());
        }
    }
}
