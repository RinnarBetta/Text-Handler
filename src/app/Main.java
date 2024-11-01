package app;

import java.nio.file.Paths;

public class Main {

    private static final String BASE_PATH = "files/";

    public static void main(String[] args) {
        String newFileName = "myfile";
        String content = "Super information.";
        String filePath = BASE_PATH + newFileName + ".txt";

        // Создаем экземпляр FileHandler, передавая путь к файлу
        FileHandler handler = new FileHandler(filePath);

        // Вызовы методов для работы с файлом
        getOutput(handler.createFile()); // Создание файла
        getOutput(handler.writeToFile(content)); // Запись в файл
        getOutput("CONTENT: " + handler.readFromFile()); // Чтение из файла
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
