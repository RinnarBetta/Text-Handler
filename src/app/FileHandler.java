package app;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class FileHandler {
    private final Path path;

    // Конструктор для инициализации пути файла
    public FileHandler(String filePath) {
        this.path = Paths.get(filePath); // Используем Paths.get вместо Path.of
    }

    // Метод для создания файла
    public String createFile() {
        try {
            Files.createFile(path);
            return "Created " + path;
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
    }

    // Метод для записи в файл
    public String writeToFile(String content) {
        try {
            Files.write(path, Collections.singletonList(content), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            return "Recorded in " + path;
        } catch (IOException e) {
            return "Error writing to file: " + e.getMessage();
        }
    }

    // Метод для чтения из файла
    public String readFromFile() {
        try {
            return new String(Files.readAllBytes(path)); // Альтернатива для Files.readString в Java 8
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }
}