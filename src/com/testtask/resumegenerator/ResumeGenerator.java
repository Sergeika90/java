package com.testtask.resumegenerator;

import com.testtask.resumegenerator.file.FileUtils;
import com.testtask.resumegenerator.htmlgenerator.HTMLResumeGenerator;
import com.testtask.resumegenerator.model.ResumeDataReader;
import com.testtask.resumegenerator.model.ResumeDataReaderImpl;
import com.testtask.resumegenerator.model.TemplateReader;
import com.testtask.resumegenerator.model.TemplateReaderImpl;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для генерации резюме по HTML шаблону
 * @version 1.0
 */
public class ResumeGenerator {
    /** Путь к файлу со сгенерированным резюме */
    public static final String RESUME_FILE_PATH= "\\result\\resultResume.html";

    public static void main(String[] args) {
        // Получение данных для заполнения
        ResumeDataReader resumeDataReader = new ResumeDataReaderImpl();
        ResumeProperties resumeProperties = resumeDataReader.getResumeData();
        if (resumeProperties != null) {
            // Получение шаблона
            TemplateReader templateReader = new TemplateReaderImpl();
            BufferedReader templateBufferedReader = templateReader.getHTMLTemplate();

            // Заполенение шаблона данными
            StringBuilder stringBuilder =
                    new HTMLResumeGenerator().generateResume(templateBufferedReader, resumeProperties);

            // Сохранение резюме
            if (stringBuilder != null) {
               FileUtils.writeFile(stringBuilder, RESUME_FILE_PATH);
            }
        }

    }
}
