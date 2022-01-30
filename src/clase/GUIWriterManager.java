package clase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

public class GUIWriterManager extends JFrame implements ActionListener {
    public static JFrame frame = new JFrame("Proiect");
    JLabel text;
    JButton profesori, studenti, cursuri, back, adauga_nota;
    JTable tabel_profesori, tabel_studenti, tabel_cursuri;
    /// LOAD_TYPE load_type;
    List<Student> lista_studenti;
    List<Profesor> lista_profi;
    List<Curs> lista_cursuri;
    String Email;


    public void writeStudentsData() {
        frame.getContentPane().removeAll();
        frame.repaint();
        SwingUtilities.updateComponentTreeUI(frame);
        frame.setSize(1000, 600);
        String[] columnNames = {"Nume ", "Prenume", "Grupa"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        tabel_studenti = new JTable(tableModel);
        tabel_studenti.setBounds(30, 50, 400, 300);
        JScrollPane sp = new JScrollPane(tabel_studenti);
        sp.setBounds(30, 50, 700, 300);
        int i = 0;
        while (i < lista_studenti.size()) {
            String nume = lista_studenti.get(i).nume;
            String prenume = lista_studenti.get(i).prenume;
            int grupa = lista_studenti.get(i).grupa;
            String[] data = {nume, prenume, String.valueOf(grupa)};
            tableModel.addRow(data);
            i++;
        }
        back = new JButton("back");
        back.setBounds(100, 400, 70, 25);
        back.addActionListener(this);
        back.setVisible(true);
        frame.add(back);
        frame.getContentPane().add(sp);
    }


    public void writeCoursesData() {
        frame.getContentPane().removeAll();
        frame.repaint();
        SwingUtilities.updateComponentTreeUI(frame);
        frame.setSize(1000, 600);
        String[] columnNames = {"Nume ", "Descriere", "Nume prof", "Prenume prof", "Nume student", "Prenume Student", "Grupa", "Nota"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

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
                String[] data = {nume, descriere, nume_prof, prenume_prof, stud.nume, stud.prenume, String.valueOf(stud.grupa), String.valueOf(lista_cursuri.get(i).nota.get(stud))};
                tableModel.addRow(data);
            }
            i++;
        }
        back = new JButton("back");
        back.setBounds(100, 400, 75, 25);
        back.addActionListener(this);
        back.setVisible(true);
        frame.add(back);
        frame.getContentPane().add(sp);
    }

    public void writeProfesorData() {
        frame.getContentPane().removeAll();
        frame.repaint();
        SwingUtilities.updateComponentTreeUI(frame);
        frame.setSize(1000, 600);
        String[] columnNames = {"Nume ", "Prenume"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        tabel_profesori = new JTable(tableModel);
        tabel_profesori.setBounds(30, 50, 400, 300);
        JScrollPane sp = new JScrollPane(tabel_profesori);
        sp.setBounds(30, 50, 700, 300);
        int i = 0;
        while (i < lista_profi.size()) {
            String nume = lista_profi.get(i).nume;
            String prenume = lista_profi.get(i).prenume;
            String[] data = {nume, prenume};
            tableModel.addRow(data);
            i++;
        }
        back = new JButton("back");
        back.setBounds(100, 400, 70, 25);
        back.addActionListener(this);
        back.setVisible(true);
        frame.add(back);
        frame.getContentPane().add(sp);
    }

    GUIWriterManager(java.util.List<Student> list_studenti, java.util.List<Profesor> list_profi, List<Curs> list_cursuri, String email) {
        frame.getContentPane().removeAll();
        frame.repaint();
        SwingUtilities.updateComponentTreeUI(frame);
        adauga_nota = new JButton("Noteaza elev");
        Email = email;
        adauga_nota.setVisible(true);
        adauga_nota.addActionListener(this);
        adauga_nota.setBounds(50, 260, 150, 25);
        frame.add(adauga_nota);



        lista_studenti = list_studenti;
        lista_profi = list_profi;
        lista_cursuri = list_cursuri;
        JLabel label = new JLabel();
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text = new JLabel("Alege ce vrei sa vezi john");
        profesori = new JButton("Profesori");
        studenti = new JButton("Studenti");
        cursuri = new JButton("Cursuri");

        profesori.setBounds(50, 50, 150, 25);
        studenti.setBounds(50, 120, 150, 25);
        cursuri.setBounds(50, 190, 150, 25);

        text.setBounds(50, 20, 150, 25);
        text.setForeground(Color.red);
        text.setFont(new Font("Times new roman", Font.BOLD, 20));

        profesori.setVisible(true);
        studenti.setVisible(true);
        cursuri.setVisible(true);
        profesori.addActionListener(this);
        studenti.addActionListener(this);
        cursuri.addActionListener(this);
        frame.add(studenti);
        frame.add(profesori);
        frame.add(cursuri);
        frame.add(text);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profesori) {
            writeProfesorData();
        }
        if (e.getSource() == studenti) {
            writeStudentsData();
        }
        if (e.getSource() == cursuri) {
            writeCoursesData();
        }
        if (e.getSource() == back) {
            new GUIWriterManager(lista_studenti, lista_profi, lista_cursuri, Email);
        }
        if (e.getSource() == adauga_nota) {
            frame.dispose();
            NoteazaStudenti noteazaStudent = new NoteazaStudenti(lista_studenti, lista_cursuri, lista_profi, Email);

        }

    }


}
