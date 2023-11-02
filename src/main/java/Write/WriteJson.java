package Write;
import XML.Monster;
import XML.TypeData;
import XML.Types;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WriteJson {
    public void writeJSONToFile(List<TypeData> typeDataList, String jsonFilePath) throws IOException {
            Types typesData = new Types(typeDataList);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(jsonFilePath), typesData);
        }
    }
