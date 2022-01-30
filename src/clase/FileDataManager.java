package clase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDataManager implements IDataLoader {

    public static Student readStudentFrom(String line) throws Exception {
        ///String[]  substringuri = line.split(",");
        try (Scanner rawScanner = new Scanner(line)) {
            rawScanner.useDelimiter(",");
            ArrayList<String> properties = new ArrayList<String>();
            while (rawScanner.hasNext()) {
                properties.add(rawScanner.next());
            }
            return new Student(properties);
        }
    }


    public static Curs readCourseFrom(String line,List<Curs>cursuri) throws Exception {
        ///String[]  substringuri = line.split(",");
        try (Scanner rawScanner = new Scanner(line)) {
            rawScanner.useDelimiter(",");
            ArrayList<String> properties = new ArrayList<String>();
            while (rawScanner.hasNext()) {
                properties.add(rawScanner.next());
            }
            return new Curs(properties,cursuri);

        }

    }

    public static Profesor readProfFrom(String line) throws Exception {
        ///String[]  substringuri = line.split(",");
        try (Scanner rawScanner = new Scanner(line)) {
            rawScanner.useDelimiter(",");
            ArrayList<String> properties = new ArrayList<String>();
            while (rawScanner.hasNext()) {
                properties.add(rawScanner.next());
            }
            return new Profesor(properties);

        }

    }

    public void createStudentsData(List<Student> studenti) {
        ///Settings.STUDENTS_PATH;
        System.out.println('\n' + "Citirea studentilor din fisier cu metoda scanner: ");
        try (Scanner scanner = new Scanner(new File("studenti.csv"))) {
            while (scanner.hasNextLine()) {
                try {
                    Student s = readStudentFrom(scanner.nextLine());
                    try {
                        studenti.add(s);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void createProfesorData(List<Profesor> profi, List<Curs> cursuri) {
        ///Settings.TEACHERS_PATH;

        System.out.println('\n' + "Citirea profesorilor din fisier cu metoda scanner: ");
        try (Scanner scanner = new Scanner(new File("profesori.csv"))) {

            Profesor p;

            for (Curs c : cursuri) {
                p = c.getProfu();
                profi.add(p);
            }

            while (scanner.hasNextLine()) {
                try {
                    Profesor pf = readProfFrom(scanner.nextLine());
                    profi.add(pf);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    FileDataManager(List<Student> studenti, List<Profesor> profi, List<Curs> cursuri) {
        createCoursesData(cursuri);
        createProfesorData(profi, cursuri);
        createStudentsData(studenti);
    }


    public void createCoursesData(List<Curs> cursuri) {
        ///Settings.COURSES_PATH;

        System.out.println('\n' + "Citirea cursurilor din fisier cu metoda scanner: ");
        try (Scanner scanner = new Scanner(new File("cursuri.csv"))) {
            while (scanner.hasNext()) {
                try {
                    Curs c = readCourseFrom(scanner.next(),cursuri);
                    System.out.println("Afisare curs:");
                    //cursuri.add(c);
                } catch (Exception ex) {
                    ex.printStackTrace();

                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
