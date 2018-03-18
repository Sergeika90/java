package com.testtask.resumegenerator.model;

import java.io.BufferedReader;
import java.io.Serializable;

/**
 * Интерфейс получения шаблона для заполнения резюме
 * @version 1.0
 */
public interface TemplateReader extends Serializable {
    /**
     * Получение HTML шаблона для заполнения
     * @return символьный поток данных шаблона или {@code NULL} в случае ошибки
     */
    public BufferedReader getHTMLTemplate();
}
