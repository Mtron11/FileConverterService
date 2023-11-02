import Read.ReadXML;
import Write.WriteJson;
import XML.XMLToJSONConverter;

public class Main {
    public static void main(String[] args) throws Exception {
        String xmlFilePath = "src\\main\\resources\\Monsters.xml";
        String jsonFilePath = "C:\\Users\\Mtron\\Desktop\\Monsters.json";

        ReadXML xmlParser = new ReadXML(xmlFilePath);
        XMLToJSONConverter converter = new XMLToJSONConverter(xmlParser);
        converter.convertToJSONFile(jsonFilePath);
        WriteJson jsonFileWriter = new WriteJson();
        jsonFileWriter.writeJSONToFile(xmlParser.getMonsters(), jsonFilePath);
    }
}
