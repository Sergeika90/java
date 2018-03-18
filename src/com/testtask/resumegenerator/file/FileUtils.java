package com.testtask.resumegenerator.file;

import javafx.beans.binding.StringBinding;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.InputStreamReader;
/**
 * Методы для работы с файлами
 * @version 1.0
 */
public class FileUtils {
    /**
     * Чтение файла по заданному пути с использованием кодировки
     * @param path путь к файлу
     * @param encodingName кодировка
     * @exception FileNotFoundException файл на найден
     * @exception UnsupportedEncodingException ошибка кодировки файла
     * @return символьный поток файла
     */
    public static BufferedReader readFile(String path, String encodingName) throws FileNotFoundException, UnsupportedEncodingException {
        FileInputStream inputStream = new FileInputStream(path);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        return new BufferedReader(new InputStreamReader(dataInputStream,encodingName));
    }

    /**
     * Запись файла по заданному пути
     * @param fileContent содержимое файла
     * @param path путь к файлу
     * @exception FileNotFoundException файл на найден
     */
    public static void writeFile(StringBuilder fileContent, String path) {
        try (PrintWriter out = new PrintWriter(path)){
            out.println(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
