package clase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWriterManager implements IDataWriter {
    public void writeStudentsData(List<Student>studenti){
        System.out.println("Scrierea in fisierul studenti_out: ");
        FileWriter studOut = null;
        try {
            studOut = new FileWriter("studenti_out.txt");
            for(Student s: studenti) {
                studOut.write(s.toString() + '\n');
            }

        } catch(IOException e) {
            System.out.println("In catch block");
            e.printStackTrace();
        } finally {
            System.out.println("In finally block");
            try {
                if(studOut!=null) {
                    System.out.println("Trying to close studOut");
                    studOut.close();
                }

            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void writeCoursesData(List<Curs>cursuri){

        System.out.println("Scrierea in fisierul cursuri_out: ");
        FileWriter cursOut = null;
        try {
            cursOut = new FileWriter("cursuri_out.txt");
            for(Curs c : cursuri) {
                cursOut.write(c.AfisareCursFisier() + '\n');
            }

        } catch(IOException e) {
            System.out.println("In catch block");
            e.printStackTrace();
        } finally {
            System.out.println("In finally block");
            try {
                if(cursOut!=null) {
                    System.out.println("Trying to close cursOut");
                    cursOut.close();
                }

            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void writeProfesorData(List<Profesor>profi){

        System.out.println("Scrierea in fisierul profesori_out: ");
        FileWriter profOut = null;
        try {
            profOut = new FileWriter("profesori_out.txt");
            for(Profesor p : profi) {
                profOut.write(p.formatForDisplay() + '\n');
            }

        } catch(IOException e) {
            System.out.println("In catch block");
            e.printStackTrace();
        } finally {
            System.out.println("In finally block");
            try {
                if(profOut!=null) {
                    System.out.println("Trying to close profOut");
                    profOut.close();
                }

            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
