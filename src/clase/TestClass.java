package clase;


import java.io.*;
import java.util.*;

enum LOAD_TYPE {
    HARDCODAT, KEYBOARD, FILE
}
enum DISPLAY_TYPE {
    CONSOLE, FISIER, GUI
}
public class TestClass {


    public static void main(String[] args) {

        LoginAndRegister loginAndRegister = new LoginAndRegister();


        DataManager dataManager = new DataManager();

        dataManager.gradeStudents();
        dataManager.manager.reportAllCourses();
        dataManager.manager.reportAllStudentsGrades();
        dataManager.manager.reportAllCourses();
        try {
            dataManager.manager.RemoveCurs(new Curs("PLCP 1"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Dupa stergere:");
        dataManager.manager.reportAllCourses();

        dataManager.manager.reportAllStudentsGrades();

        try {
            dataManager.manager.EditCurs(new Curs("Limba engleza"), new Curs("Limba engleza II", "descriere", new Profesor("Ana", "Maria"), dataManager.createRandomSetOfStudents()));
            dataManager.manager.reportAllCourses();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ///List<Student> list = Arrays.asList(dataManager.dataSetOfStudent);
        List<Student> studenti = new LinkedList<Student>(Arrays.asList(dataManager.dataSetOfStudent));
        System.out.println('\n' + "Gruparea studentilor dupa grupa din care fac parte : ");
        dataManager.manager.GrupareStudentiDupaGrupa(studenti);
        System.out.println('\n' + "Sortarea in ordine a studentilor: ");
        //List<Student>studenti = Arrays.asList(dataManager.dataSetOfStudent);
        Collections.sort(studenti);
        for (Student s : studenti) {
            System.out.println(s);
        }
        System.out.println('\n' + "Ordonare cursuri dupa numarul de studenti: ");

        Collections.sort(dataManager.cursuri, new CursSortNrStudenti());
        for (Curs c : dataManager.cursuri)
            System.out.println(c.nume + "\n" + "Nr studenti: " + c.getStudenti().size());

        System.out.println('\n' + "Ordonare cursuri dupa numele cursului:  ");
        Collections.sort(dataManager.cursuri, new CursSortName());
        for (Curs c : dataManager.cursuri)
            System.out.println(c.nume);

        System.out.println('\n' + "Ordonare cursuri dupa numele profesorului:  ");
        Collections.sort(dataManager.cursuri, new CursSortNumeProf());
        for (Curs c : dataManager.cursuri)
            System.out.println(c.nume + " - " + c.getProfu());


    }
}





