import Read.ReadXML;
import XML.XMLToJSONConverter;

public class Main {
    public static void main(String[] args) throws Exception {
        String xmlFilePath = "C:\\Users\\Mtron\\Desktop\\Monsters.xml";
        String jsonFilePath = "C:\\Users\\Mtron\\Desktop\\Monsters.json";

        ReadXML xmlParser = new ReadXML(xmlFilePath);
        XMLToJSONConverter converter = new XMLToJSONConverter(xmlParser);
        converter.convertAndWriteToJSONFile(jsonFilePath);
    }
}
