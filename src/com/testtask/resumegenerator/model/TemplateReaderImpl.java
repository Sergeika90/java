package com.testtask.resumegenerator.model;

import com.testtask.resumegenerator.ResumeProperties;
import com.testtask.resumegenerator.file.FileUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Класс получения HTML шаблона для заполнения резюме
 * @version 1.0
 */
public class TemplateReaderImpl implements TemplateReader {
    /** Путь к файлу с данными для резюме */
    public static final String TEMPLATE_FILE_PATH =
            "C:\\Users\\User\\Downloads\\ResumeGenerator\\source\\template.html";

    /** Кодировка файла с данными */
    public static final String TEMPLATE_FILE_ENCODING = "utf-8";

    /**
     * Получение HTML шаблона для заполнения
     * @return символьный поток данных шаблона или {@code NULL} в случае ошибки
     */
    public BufferedReader getHTMLTemplate() {
        try {
            return FileUtils.readFile( TEMPLATE_FILE_PATH, TEMPLATE_FILE_ENCODING);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка загрузки файла с шаблоном: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Ошибка кодировки файла с шаблоном: " + e.getMessage());
        }
        return null;
    }

}
