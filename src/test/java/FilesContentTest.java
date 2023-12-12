
import org.example.service.ConverterSelector;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FilesContentTest {
    @Test
    void testXmlConvertEquality() throws Exception {
        String expectedJsonPath = "src/test/resources/Monsters.json";
        String outputPath = "src/test/resources/converted/Monsters.json";
        String input = "src/test/resources/Monsters.xml";

        ConverterSelector.convertXmlToJson(Path.of(input), Path.of(outputPath));

        String expectedJson = Files.readString(Path.of(expectedJsonPath));
        String resultJson = Files.readString(Path.of(outputPath));

        assertEquals(expectedJson, resultJson);
        //файлы совпадают (байтовое сравнение)
        assertTrue(Files.isSameFile(Path.of(expectedJsonPath), Path.of(outputPath)));
    }

    @Test
    void testJsonConvertEquality() throws Exception {
        String expectedXmlPath = "src/test/resources/Monsters.xml";
        String outputPath = "src/test/resources/converted/Monsters.xml";
        String input = "src/test/resources/Monsters.json";

        ConverterSelector.convertJsonToXml(Path.of(input), Path.of(outputPath));

        String expectedJson = Files.readString(Path.of(expectedXmlPath));
        String resultJson = Files.readString(Path.of(outputPath));

        assertEquals(expectedJson, resultJson);
        //файлы совпадают (байтовые сравнение)
        assertTrue(Files.isSameFile(Path.of(expectedXmlPath), Path.of(outputPath)));
    }
}
