package com.testtask.resumegenerator.model;

import com.testtask.resumegenerator.ResumeProperties;
import com.testtask.resumegenerator.file.FileUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;

/**
 * Класс для получения данных для заполнения шаблона резюме
 * @version 1.0
 */
public class ResumeDataReaderImpl implements ResumeDataReader {
    /** Путь к файлу с данными для резюме */
    public static final String RESUME_DATA_FILE_PATH =
            "\\source\\resumeData.properties";

    /** Кодировка файла с данными */
    public static final String RESUME_DATA_ENCODING = "utf-8";

    /**
     * Получение данных для заполнения резюме
     * @return данные в виде таблицы ключ-значение. Перечень ключей - {@link ReplaceTagName}
     *         или {@code NULL} в случае ошибки
     */
    public ResumeProperties getResumeData() {
        try {
            ResumeProperties resumeProperties = new ResumeProperties();
            BufferedReader bufferedReader = FileUtils.readFile(RESUME_DATA_FILE_PATH, RESUME_DATA_ENCODING);
            resumeProperties.load(bufferedReader);
            return resumeProperties;
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка загрузки файла с данными: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Ошибка кодировки файла с данными: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка парсинга файла с данными: " + e.getMessage());
        }
        return null;
    }
}
