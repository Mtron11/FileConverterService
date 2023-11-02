import Read.ReadXML;
import Write.WriteJson;
import XML.TypeData;
import XML.XMLToJSONConverter;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String xmlFilePath = "src\\main\\resources\\Monsters.xml";
        String jsonFilePath = "C:\\Users\\Mtron\\Desktop\\Monsters.json";
        ReadXML xmlParser = new ReadXML(xmlFilePath);
        XMLToJSONConverter converter = new XMLToJSONConverter(xmlParser);
        List<TypeData> typeDataList = converter.convertToJSONFile();
        WriteJson jsonWriter = new WriteJson();
        jsonWriter.writeJSONToFile(typeDataList, jsonFilePath);
    }
}
