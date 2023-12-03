package write;
import lombok.val;
import xml.TypeData;
import xml.Types;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WriteJson {
    public void writeJSONToFile(List<TypeData> typeDataList, String jsonFilePath) throws IOException {
            val typesData = new Types(typeDataList);
            val objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(jsonFilePath), typesData);
        }
    }
