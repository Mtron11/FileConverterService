
import org.example.ConverterSelector;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FilesContentTest {
    @Test
    void testXmlConvertEquality() throws Exception {
        String expectedJsonPath = "src/test/resources/Monsters.json";
        String outputPath = "src/test/resources/converted/Monsters.json";
        String input= "src/test/resources/Monsters.xml";

        ConverterSelector.convertXmlToJson(input, outputPath);
        String expectedJson = new String(Files.readAllBytes(Paths.get(expectedJsonPath)));
        String resultJson = new String(Files.readAllBytes(Paths.get(outputPath)));
        assertEquals(expectedJson, resultJson);

    }

    @Test
    void testJsonConvertEquality() throws Exception {
        String expectedXmlPath = "src/test/resources/Monsters.xml";
        String outputPath = "src/test/resources/converted/Monsters.xml";
        String input= "src/test/resources/Monsters.json";

        ConverterSelector.convertJsonToXml(input, outputPath);
        String expectedJson = new String(Files.readAllBytes(Paths.get(expectedXmlPath)));
        String resultJson = new String(Files.readAllBytes(Paths.get(outputPath)));
        assertEquals(expectedJson, resultJson);
    }
}
