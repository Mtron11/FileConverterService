package Read;

import JSON.TypeData;
import JSON.Types;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadJSON {
    public List<TypeData> readJSONFromFile(String jsonFilePath) throws IOException {
        // Инициализация ObjectMapper для чтения JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Чтение данных из JSON-файла и преобразование в объект Types
        Types typesData = objectMapper.readValue(new File(jsonFilePath), Types.class);

        // Получение списка типов монстров
        return typesData.getTypes();
    }
}
