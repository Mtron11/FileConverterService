package XML;
import Read.ReadXML;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.util.List;

public class XMLToJSONConverter {
    private ReadXML xmlParser;

    public XMLToJSONConverter(ReadXML xmlParser) {
        this.xmlParser = xmlParser;
    }

    public String convertAndWriteToJSONFile(String jsonFilePath) throws Exception {
            List<Monster> monsters = xmlParser.getMonsters();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.writeValueAsString(monsters);
    }
}
