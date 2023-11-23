import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            log.error("Неверное количество аргументов. Используйте: java Main <inputFile> <outputFile>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        if (inputFile.endsWith(".json") && outputFile.endsWith(".xml")) {
            ConverterSelector.convertJsonToXml(inputFile, outputFile);
            return;
        }

        if (inputFile.endsWith(".xml") && outputFile.endsWith(".json")) {
            ConverterSelector.convertXmlToJson(inputFile, outputFile);
            return;
        }

        log.error("Неподдерживаемые форматы файлов. Используйте .json для входного файла и .xml для выходного.");
    }
}
