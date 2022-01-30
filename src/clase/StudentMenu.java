package clase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentMenu implements ActionListener {


    JFrame frame = new JFrame();

    List<Student> lista_studenti;
    List<Profesor> lista_profi;
    List<Curs> lista_cursuri;
    JTable tabel_cursuri;
    String email;
    JButton cursuri, back, medie;

    StudentMenu(List<Student> list_studenti, List<Profesor> list_profi, List<Curs> list_cursuri, String email_arrive) {

        lista_cursuri = list_cursuri;
        lista_profi = list_profi;
        lista_studenti = list_studenti;
        email = email_arrive;
        cursuri = new JButton("Cursuri");
        cursuri.addActionListener(this);
        cursuri.setBounds(50, 50, 100, 30);
        cursuri.setVisible(true);

        medie = new JButton("Medie");
        medie.addActionListener(this);
        medie.setBounds(50, 100, 100, 30);
        medie.setVisible(true);
        frame.add(medie);
        frame.add(cursuri);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void vedere_cursuri() {
        frame.getContentPane().removeAll();
        frame.repaint();
        SwingUtilities.updateComponentTreeUI(frame);
        frame.setSize(1000, 600);
        String[] columnNames = {"Nume ", "Descriere", "Nume prof", "Prenume prof", "Nume student", "Prenume Student", "Grupa", "Nota"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        String nume_student = verifica_student();
        tabel_cursuri = new JTable(tableModel);
        tabel_cursuri.setBounds(30, 50, 400, 300);
        JScrollPane sp = new JScrollPane(tabel_cursuri);
        sp.setBounds(30, 50, 800, 300);
        int i = 0;
        while (i < lista_cursuri.size()) {
            String nume = lista_cursuri.get(i).nume;
            String descriere = lista_cursuri.get(i).descriere;
            String nume_prof = lista_cursuri.get(i).profu.nume;
            String prenume_prof = lista_cursuri.get(i).profu.prenume;
            Set<Student> studentI = lista_cursuri.get(i).studenti;
            for (Student stud : studentI) {
                String name = stud.nume + stud.prenume;
                if (name.toLowerCase().equals(nume_student)) {
                    String[] data = {nume, descriere, nume_prof, prenume_prof, stud.nume, stud.prenume, String.valueOf(stud.grupa), String.valueOf(lista_cursuri.get(i).nota.get(stud))};
                    tableModel.addRow(data);
                }
            }
            i++;
        }
        back=new JButton("Inapoi");
        back.addActionListener(this);
        back.setVisible(true);
        back.setBounds(400,500,100,35);
        frame.add(back);
        frame.getContentPane().add(sp);
    }

    private String verifica_student() {

        for (Student s : lista_studenti) {
            String nume_student = s.nume + s.prenume;
            nume_student = nume_student.toLowerCase();
            String[] parti = email.split("@");
            if (parti[0].equals(nume_student)) {
                return nume_student;
            }
        }
        return null;
    }

    public void calcul_medie() {
        frame.getContentPane().removeAll();
        frame.repaint();
        SwingUtilities.updateComponentTreeUI(frame);
        frame.setSize(1000, 600);
        String[] columnNames = {"Nume student", "Prenume Student", "Grupa", "Medie"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        String nume_student = verifica_student();
        tabel_cursuri = new JTable(tableModel);
        tabel_cursuri.setBounds(30, 50, 400, 300);
        JScrollPane sp = new JScrollPane(tabel_cursuri);
        sp.setBounds(30, 50, 800, 300);
        int i = 0;
        Student student = new Student();
        int suma = 0;
        int nr = 0;
        while (i < lista_cursuri.size()) {
            String nume = lista_cursuri.get(i).nume;
            String descriere = lista_cursuri.get(i).descriere;
            String nume_prof = lista_cursuri.get(i).profu.nume;
            String prenume_prof = lista_cursuri.get(i).profu.prenume;
            Set<Student> studentI = lista_cursuri.get(i).studenti;

            for (Student stud : studentI) {
                String name = stud.nume + stud.prenume;
                if (name.toLowerCase().equals(nume_student)) {
                    student = stud;
                    suma += lista_cursuri.get(i).nota.get(stud);
                    nr++;

                }
            }
            i++;
        }
        String[] data;
        if(nr>0){
            data = new String[]{student.nume, student.prenume, String.valueOf(student.grupa), String.valueOf(suma / nr)};
        }
        else {
            data = new String[]{student.nume, student.prenume, String.valueOf(student.grupa), String.valueOf("Fara note")};

        }
        tableModel.addRow(data);
        back=new JButton("Inapoi");
        back.addActionListener(this);
        back.setVisible(true);
        back.setBounds(400,500,100,35);
        frame.add(back);
        frame.getContentPane().add(sp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cursuri) {
            vedere_cursuri();
        }
        if (e.getSource() == back) {
            frame.dispose();
            new StudentMenu(lista_studenti, lista_profi, lista_cursuri, email);
        }
        if (e.getSource() == medie) {
            calcul_medie();
        }

    }
}

