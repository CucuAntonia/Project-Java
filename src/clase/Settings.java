package clase;

import java.util.ArrayList;
import java.util.List;

public class Settings {
    public static String STUDENTS_PATH = "studenti.csv";
    public static String TEACHERS_PATH = "profesori.csv";
    public static String COURSES_PATH = "cursuri.csv";
    public static LOAD_TYPE loadType = LOAD_TYPE.FILE;
    public static DISPLAY_TYPE displayType = DISPLAY_TYPE.GUI;
    List<Student> studenti = new ArrayList<>();
    List<Profesor> profi = new ArrayList<>();
    List<Curs> cursuri = new ArrayList<>();

    public void initApplication(String accounttype, String email) {
        ///read settings.txt and init all values from the file

        if (Settings.loadType == LOAD_TYPE.FILE) {
            FileDataManager fileDataManager = new FileDataManager(studenti, profi, cursuri);
        } else if (Settings.loadType == LOAD_TYPE.HARDCODAT) {
            DataManager dataManager = new DataManager();
            dataManager.createCoursesData();
            dataManager.createProfesorData();
            dataManager.createStudentsData();

        } else if (Settings.loadType == LOAD_TYPE.KEYBOARD) {
            KeyboardDataManager keyboard = new KeyboardDataManager(studenti, profi, cursuri);

        }
        System.out.println("\n\n\nAfisare:");
        System.out.println(studenti);
        System.out.println(profi);
        //   cursuri.forEach(e-> System.out.println(e.getNume()));
        System.out.println("\n\n\n");

        if (Settings.displayType == DISPLAY_TYPE.FISIER) {
            FileWriterManager fileWriterManager = new FileWriterManager();
            fileWriterManager.writeCoursesData(cursuri);
            fileWriterManager.writeProfesorData(profi);
            fileWriterManager.writeStudentsData(studenti);
        } else if (Settings.displayType == DISPLAY_TYPE.CONSOLE) {
            ConsoleDisplayManager consoleWriter = new ConsoleDisplayManager();
            consoleWriter.StudentDisplay(studenti);
            consoleWriter.ProfDisplay(profi);
            consoleWriter.CoursesDisplay(cursuri);
        } else if (Settings.displayType == DISPLAY_TYPE.GUI) {
            if (accounttype.equals("profesor")) {
                GUIWriterManager GUI = new GUIWriterManager(studenti, profi, cursuri, email);
            } else {
                StudentMenu meniu_student = new StudentMenu(studenti, profi, cursuri, email);
            }
        }
    }
}
