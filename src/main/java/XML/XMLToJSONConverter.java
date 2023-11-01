package XML;
import Read.ReadXML;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class XMLToJSONConverter {
    private ReadXML xmlParser;

    public XMLToJSONConverter(ReadXML xmlParser) {
        this.xmlParser = xmlParser;
    }

    public String convertToJSON() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(xmlParser.getMonsters());
    }
}
