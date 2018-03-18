package com.testtask.resumegenerator.model;

import com.testtask.resumegenerator.ResumeProperties;

import java.io.Serializable;

/**
 * Интерфейс получения данных для заполнения шаблона резюме
 * @version 1.0
 */
public interface ResumeDataReader extends Serializable {
    /**
     * Получение данных для заполнения резюме
     * @return данные в виде таблицы ключ-значение. Перечень ключей - {@link ReplaceTagName}
     */
    public ResumeProperties getResumeData();
}
