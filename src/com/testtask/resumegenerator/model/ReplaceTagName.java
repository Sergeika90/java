package com.testtask.resumegenerator.model;

/**
 * Перечисление возможных типов тегов,
 * заменяемых в html-шаблоне на данные
 * @version 1.0
 */
public enum ReplaceTagName {
    /** Название тега - ФИО автора резюме */
    FIO("@FIO"),

    /** Название тега - дата рождения */
    DOB("@DOB"),

    /** Название тега - номер телефона */
    PHONE("@phone"),

    /** Название тега - почта */
    MAIL("@mail"),

    /** Название тега - skype */
    SKYPE("@skype"),

    /** Название тега - цель */
    TARGET("@target"),

    /** Название тега - опыт работы */
    EXPERIENCE("@experience"),

    /** Название тега - образование */
    EDUCATION("@education"),

    /** Название тега - доп.образование, курсы*/
    COURSES("@courses"),

    /** Название тега - навыки */
    SKILLS("@skills"),

    /** Название тега - пример кода */
    CODE_EXAMPLES("@codeExamples");

    /** Название тега в html-шаблоне для замены на данные */
    private String tagName;

    /**
     * Конструктор с присвоением названия тега
     * @param tagName название тега для замены
     */
    ReplaceTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * Геттер названия тега для замены в html-шаблоне
     * @return название тега для замены в html-шаблоне
     */
    public String getTagName() {
        return this.tagName;
    }
}
