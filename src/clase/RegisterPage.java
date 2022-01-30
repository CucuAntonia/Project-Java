package clase;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterPage extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPanel panel1;
    private JPasswordField passwordField;
    private JTextField numeField;
    private JButton RegisterButton;
    private JTextField prenumefield;
    JLabel messageLabel = new JLabel();
    JFrame frame;


    public RegisterPage() {
        frame = new JFrame("Register");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(false);

        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        RegisterButton.addActionListener(this);
        frame.setVisible(true);

    }

    private void inregistrare() {

        try {
            FileWriter fw = new FileWriter("users.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(usernameField.getText() + "," + passwordField.getText() + "," + numeField.getText().toLowerCase() + prenumefield.getText().toLowerCase() + "@unitbv.ro"+",student"); //contul va fi creat direct ca fiind student, urmand ca administratorul aplicatiei sa modifice in fisierul users.csv daca un profesor s-a inregistrat
            //nu am dorit sa adaug un combobox pentru a alege student/profesor pentru ca studentii sa nu-si poata crea cont de profesor
            bw.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            FileWriter fw = new FileWriter("studenti.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            int random_int = (int)Math.floor(Math.random()*(4-1+1)+1);

            bw.write(numeField.getText()+","+prenumefield.getText()+","+random_int);
            JOptionPane.showMessageDialog(frame,
                    "Cont creat cu succes! Va puteti autentifica acum!");
            bw.close();
            frame.dispose();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RegisterButton) {
            if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty() || numeField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "Toate campurile trebuie completate!",
                        "Eroare",
                        JOptionPane.WARNING_MESSAGE);
            } else
                inregistrare();
        }
    }


}
