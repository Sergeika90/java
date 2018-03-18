1.Основной класс: ResumeGenerator.

Обратите внимание на переменные 
ResumeGenerator.RESUME_FILE_PATH, 
ResumeDataReaderImpl.RESUME_DATA_FILE_PATH,
TemplateReaderImpl.TEMPLATE_FILE_PATH

это пути к результирующему файлу, файлу данных, файлу шаблона соответственно. У вас эти пути будут другими.

Еще один путь жестко прописан в итоговом файле с резюме, это путь к bootstrap. Его можно загружать из сети или как-то изящнее прописать.

2.Как запускать. Открываете проект в IntelliJ IDEA. В resumeData.properties вводите свои данные после знака "=". Сохраняете изменения "Ctrl+S". Запускаете проект (Run). Ждете пару сек. Идете в папку result запускаете resultResume.html и радуетесь