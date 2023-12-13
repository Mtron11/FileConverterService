package org.example.service;

import lombok.experimental.UtilityClass;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@UtilityClass
public class ContentChecker {
    private final Logger log = LoggerFactory.getLogger(ContentChecker.class);

    public void main(String[] args) {
        convert(args);
    }
    public void convert(String[] args) {
        Options options = new Options();
        options.addOption("i", "input", true, "Input file");
        options.addOption("o", "output", true, "Output file");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("i") && cmd.hasOption("o")) {
                Path inputFile = Path.of(cmd.getOptionValue("i"));
                Path outputFile = Path.of(cmd.getOptionValue("o"));

                if (isJsonFile(inputFile)) {
                    ConverterSelector.convertJsonToXml(inputFile, outputFile);
                } else if (isXmlFile(inputFile)) {
                    ConverterSelector.convertXmlToJson(inputFile, outputFile);
                } else {
                    log.error("Неподдерживаемые форматы файлов. Используйте .json для входного файла и .xml для выходного.");
                }
            } else {
                log.error("Необходимо указать оба параметра -i и -o. Используйте: java ConverterSelector -i <inputFile> -o <outputFile>");
            }
        }
        catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean isJsonFile(final Path filePath) throws IOException {
        return getFileContent(filePath).trim().startsWith("{");
    }
    private boolean isXmlFile(final Path filePath) throws IOException {
        return getFileContent(filePath).trim().startsWith("<");
    }

    private String getFileContent(final Path filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int nextChar;
            while ((nextChar = reader.read()) != -1) {
                content.append((char) nextChar);
                return content.toString();
            }
            return null;
        } catch (IOException e) {
            throw new IOException("Не удалось считать файл");
        }
    }
}
