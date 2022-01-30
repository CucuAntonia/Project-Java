package clase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KeyboardDataManager {
    public void createStudentsData(List<Student> studenti) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti numarul de studenti pe care doriti sa ii adaugati:");
        int i = sc.nextInt();
        sc.nextLine();
        do
        {
            System.out.println("Introduceti numele studentului:");
            String nume = sc.nextLine();
            System.out.println("Introduceti prenumele studentului:");
            String prenume = sc.nextLine();
            System.out.println("Introduceti grupa studentului:");
            int grupa = sc.nextInt();
            sc.nextLine();
            studenti.add(new Student(nume, prenume, grupa));
//            System.out.println("Nume:" + nume);
//            System.out.println("Prenume:" + prenume);
//            System.out.println("Grupa:" + grupa);
            i--;
        }while(i!=0);
    }
     KeyboardDataManager(List<Student> studenti,List<Profesor>profi,List<Curs>cursuri){
        createProfesorData(profi);
        createCoursesData(cursuri);
        createStudentsData(studenti);
    }


    public void createProfesorData(List<Profesor>profi) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduceti numarul de profesori pe care doriti sa ii adaugati:");
        int i = sc.nextInt();
        sc.nextLine();
        do
        {
            System.out.println("Introduceti numele profesorului:");
            String nume = sc.nextLine();
            System.out.println("Introduceti prenumele profesorului:");
            String prenume = sc.nextLine();
            profi.add(new Profesor(nume, prenume));
//            System.out.println("Nume:" + nume);
//            System.out.println("Prenume:" + prenume);
            i--;
        }while(i!=0);
    }


    public void createCoursesData(List<Curs> cursuri) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti numarul de cursuri pe care doriti sa le adaugati:");
        int i = sc.nextInt();
        sc.nextLine();
        do
        {
            System.out.println("Introduceti numele cursului:");
            String nume = sc.nextLine();
            System.out.println("Introduceti descrierea cursului:");
            String descriere = sc.nextLine();
            cursuri.add(new Curs(nume, descriere ));
//            System.out.println("Nume:" + nume);
//            System.out.println("Prenume:" + descriere);
            i--;
        }while(i!=0);
    }
}
