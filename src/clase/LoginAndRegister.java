package clase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginAndRegister extends JFrame implements ActionListener {

    public static JFrame frame = new JFrame("Login or Register");
    JLabel text;
    JButton Login, Register;

    LoginAndRegister() {
        frame.getContentPane().removeAll();
        frame.repaint();
        SwingUtilities.updateComponentTreeUI(frame);
        JLabel label = new JLabel();
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text = new JLabel("Login/Register:");
        Login = new JButton("Login");
        Register = new JButton("Register");


        Login.setBounds(50, 50, 150, 25);
        Register.setBounds(50, 120, 150, 25);


        text.setBounds(150, 20, 120, 25);
        text.setForeground(Color.red);
        text.setFont(new Font("Times new roman", Font.BOLD, 15));

        Login.setVisible(true);
        Register.setVisible(true);
        Login.addActionListener(this);
        Register.addActionListener(this);
        frame.add(Login);
        frame.add(Register);
        frame.add(text);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            String typeAccount=null;
            Cont cont=new Cont();
            LoginPage loginPage=new LoginPage(cont.getLoginInfo(),cont.getTypeAccount());
            frame.dispose();
        }
        if (e.getSource() == Register) {
            RegisterPage registerPage = new RegisterPage();
        }

    }
}
