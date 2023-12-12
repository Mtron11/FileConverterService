package org.example.io;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.val;
import org.example.json.TypeData;
import org.example.json.Types;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class JsonWorker {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<TypeData> readJSONFromFile(final Path jsonFilePath) throws IOException {
        try (InputStream inputStream = Files.newInputStream(jsonFilePath)) {
            // Чтение данных из JSON-файла и преобразование в объект Types
            val typesData = objectMapper.readValue(inputStream, Types.class);

            // Получение списка типов монстров
            return typesData.getTypes();
        }
    }

    public void writeJSONToFile(Stream<org.example.xml.TypeData> typeDataStream, final Path jsonFilePath) throws IOException {
        // Преобразование Stream в List
        List<org.example.xml.TypeData> typeDataList = typeDataStream.toList();

        // Создание объекта Types с использованием списка
        org.example.xml.Types typesData = new org.example.xml.Types(typeDataList);

        try (OutputStream outputStream = Files.newOutputStream(jsonFilePath)) {
            // Включение форматированного вывода
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Запись в файл с использованием ObjectMapper
            objectMapper.writeValue(outputStream, typesData);
        }
    }
}
