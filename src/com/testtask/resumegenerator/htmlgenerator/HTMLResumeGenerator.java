package com.testtask.resumegenerator.htmlgenerator;

import com.testtask.resumegenerator.model.ReplaceTagName;
import com.testtask.resumegenerator.ResumeProperties;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Класс для генерации HTML резюме
 * @version 1.0
 */
public class HTMLResumeGenerator {
    /** HTML шаблон */
    private BufferedReader templateReader;

    /**
     * Загрузка шаблона
     * @param bufferedReader символьный поток данных шаблона
     */
    public void loadTemplate(BufferedReader bufferedReader) {
        this.templateReader = bufferedReader;
    }

    /**
     * Генерирование резюме на основе шаблона и данных
     * @param templateReader html шаблон для заполнения
     * @param resumeProperties данные для заполнения
     * @return заполненное разюме в html формате или {@code NULL} в случае ошибки
     */
    public static StringBuilder generateResume(BufferedReader templateReader, ResumeProperties resumeProperties) {
        if ((templateReader != null) && (resumeProperties != null)) {
            try {
                // Построчное чтение файла-шаблона
                String line = templateReader.readLine();
                StringBuilder stringBuilder = new StringBuilder();
                while (line != null) {
                    stringBuilder.append(line).append("\n");
                    line = templateReader.readLine();
                }

                // Теги внутри шаблона заменяются на данные
                for (String key : resumeProperties.stringPropertyNames()) {
                    if ((key != null)) {
                        Integer startIndex = stringBuilder.indexOf("@" + key);
                        if (startIndex != -1) {
                            stringBuilder.replace(startIndex, startIndex + key.length() + 1, resumeProperties.get(key).toString());
                        }
                    }
                }

                // Очистка неиспользованных тегов в шаблоне
                for (ReplaceTagName tagName : ReplaceTagName.values()) {
                    Integer startIndex = stringBuilder.indexOf(tagName.getTagName());
                    if (startIndex != -1) {
                        stringBuilder.replace(startIndex, startIndex + tagName.getTagName().length(), "");
                    }
                }

                return stringBuilder;
            } catch (IOException e) {
                System.out.println("Ошибка преобразования строки шаблона: " + e.getMessage());
            }
        }
        return null;
    }
}
