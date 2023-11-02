package Write;

<<<<<<< HEAD
import XML.Monster;
import XML.TypeData;
import XML.Types;
=======

import XML.Monster;
>>>>>>> origin/master
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WriteJson {
<<<<<<< HEAD
    public void writeJSONToFile(List<TypeData> typeDataList, String jsonFilePath) throws IOException {
        Types types = new Types(typeDataList);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File(jsonFilePath), types);
=======
    public void WriteJson(List<Monster> monsters, String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File(jsonFilePath), monsters);
>>>>>>> origin/master
    }
}
