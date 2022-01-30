package clase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class NoteazaStudenti extends JFrame implements ActionListener {

    JComboBox<String> combo_studenti;

    private JComboBox combo_note = new JComboBox();
    JLabel studentField = new JLabel("Alegeti studentul");
    JLabel alegetiNotaTextField = new JLabel("Selectati nota");
    JButton adaugaButton = new JButton("Adauga");
    JButton backButton = new JButton("Inapoi");
    JLabel messageLabel;
    public static JFrame frame = new JFrame("Notare Studenti");
    List<Student> studenti;
    List<Curs> cursuri;
    List<Profesor> profi;
    String Email;

    public void introdu_studenti() {
        String[] nume_studenti = new String[studenti.size()];
        int counter = 0;
        for (Student stud : studenti) {
            String nume_stud = stud.getPrenume() + " " + stud.getNume();
            nume_studenti[counter++] = nume_stud;
        }
        try {
            combo_studenti = new JComboBox<String>(nume_studenti);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    NoteazaStudenti(List<Student> students, List<Curs> courses, List<Profesor> profesors, String email) {
        frame.setSize(500, 500);
        studenti = students;
        cursuri = courses;
        profi = profesors;
        Email = email;


        // frame.setPreferredSize(new Dimension(500, 500));
        adaugaButton.addActionListener(this);
        backButton.addActionListener(this);
        introdu_studenti();
        combo_note.addItem("1");
        combo_note.addItem("2");
        combo_note.addItem("3");
        combo_note.addItem("4");
        combo_note.addItem("5");
        combo_note.addItem("6");
        combo_note.addItem("7");
        combo_note.addItem("8");
        combo_note.addItem("9");
        combo_note.addItem("10");
        studentField.setBounds(50, 50, 100, 20);
        alegetiNotaTextField.setBounds(220, 50, 100, 25);
        combo_studenti.setBounds(50, 80, 150, 25);
        combo_note.setBounds(220, 80, 150, 25);
        backButton.setBounds(50, 150, 150, 25);
        adaugaButton.setBounds(220, 150, 150, 25);
        adaugaButton.addActionListener(this);
        backButton.addActionListener(this);
        frame.setLayout(null);
        frame.add(combo_studenti);
        frame.add(combo_note);
        frame.add(alegetiNotaTextField);
        frame.add(studentField);
        frame.add(adaugaButton);
        frame.add(backButton);
        combo_studenti.setLightWeightPopupEnabled(false);
        combo_studenti.setVisible(true);
        // frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private String verifica_profesor() {

        for (Profesor p : profi) {
            String nume_profesor = p.nume + p.prenume;
            nume_profesor = nume_profesor.toLowerCase();
            String[] parti = Email.split("@");
            if (parti[0].equals(nume_profesor)) {
                return nume_profesor;
            }
        }
        return null;
    }

    public int return_grupa(String nume, String prenume) {
        for (Student s : studenti) {
            if (s.nume.equals(nume) && s.prenume.equals(prenume))
                return s.grupa;
        }
        return -1;
    }

    public void adaugaNota() {
        Curs curs = new Curs();
        System.out.println("Scrierea in fisierul profesori_out: ");
        FileWriter profOut = null;
        String nume_prof = verifica_profesor();

        try {
            profOut = new FileWriter("cursuri.csv");
            ///pentru ca algoritmul sa mearga,in cazul unei materii noi va trebui introdus manual "numele materiei,descrierea,nume profesor,prenume profesor,"
            for (Curs c : cursuri) {
                profOut.write(c.nume + "," + c.descriere + "," + c.getProfu().nume + "," + c.getProfu().prenume + ",");
                int index = 1;
                String nume = c.profu.nume + c.profu.prenume;
                nume = nume.toLowerCase();
                if (nume.equals(nume_prof)) {
                    String nume_student_ales = (String) combo_studenti.getSelectedItem();
                    String[] parti = nume_student_ales.split(" ");
                  //  profOut.write(parti[1] + "," + parti[0]+"," + return_grupa(parti[1], parti[0]) + "," + combo_note.getSelectedItem());
                    c.studenti.add(new Student(parti[1],parti[0],return_grupa(parti[1], parti[0])));
                    if(c.studenti.size()>1){
                      //  profOut.write(",");
                    }
                }
                for (Student s : c.studenti) {
                    if(!c.nota.containsKey(s))
                        c.nota.put(s,combo_note.getSelectedIndex()+1);
                    profOut.write(s.nume + "," + s.prenume + "," + s.grupa + "," + c.nota.get(s));
                    if (index != c.studenti.size()) {
                        profOut.write(",");
                    }
                    index++;
                }
                profOut.write("\n");
            }


        } catch (IOException e) {
            System.out.println("In catch block");
            e.printStackTrace();
        }
        try {
            profOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(frame,
                "Student notat cu succes!");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new GUIWriterManager(studenti, profi, cursuri, Email);
            frame.dispose();
        }
        if (e.getSource() == adaugaButton) {
            adaugaNota();
        }
    }

    private void createUIComponents() {
        introdu_studenti();
    }
}
