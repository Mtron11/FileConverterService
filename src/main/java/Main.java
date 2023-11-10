import JSON.TypeData;
import Read.ReadJSON;
import Read.ReadXML;
import Write.WriteJson;
import Write.WriteXML;
import XML.XMLToJSONConverter;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        /*String xmlFilePath = "src\\main\\resources\\Monsters.xml";
        String jsonFilePath = "C:\\Users\\Mtron\\Desktop\\Monsters.json";
        ReadXML xmlParser = new ReadXML(xmlFilePath);
        XMLToJSONConverter converter = new XMLToJSONConverter(xmlParser);
        List<TypeData> typeDataList = converter.convertToJSONFile();
        WriteJson jsonWriter = new WriteJson();
        jsonWriter.writeJSONToFile(typeDataList, jsonFilePath);*/

        // Чтение JSON из файла
        ReadJSON jsonReader = new ReadJSON();
        List<TypeData> typeDataList = jsonReader.readJSONFromFile("src\\main\\resources\\Monsters.json");

        // Запись данных в XML
        WriteXML xmlWriter = new WriteXML();
        xmlWriter.writeXMLToFile(typeDataList, "C:\\Users\\Mtron\\Desktop\\Monsters.xml");
    }
}
