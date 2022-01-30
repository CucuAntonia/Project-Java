package clase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

enum AccountType {
    STUDENT, TEACHER
}

public class Cont {
    HashMap<String, String> logininfo = new HashMap<String, String>();
    HashMap<String,String> typeAccount=new HashMap<>();
    HashMap<String,String>email=new HashMap<>();
    Cont() {
        FileReader f = null;
        try {
            f = new FileReader("users.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(f);
        Scanner line;
        while (sc.hasNextLine()) {
            String linie = sc.nextLine();
            line = new Scanner(linie);
            line.useDelimiter(",");
            String username = line.next();
            String parola = line.next();
            line.useDelimiter(",");
           email.put(username,line.next());
          line.useDelimiter(",");
           String tip=line.next();
           typeAccount.put(username,tip);
          //AccountType accountType= AccountType.valueOf(line.next());
            System.out.println(typeAccount);
            logininfo.put(username,parola);
            line.useDelimiter(" \n");

        }
    }

    public HashMap<String, String> getEmail() {
        return email;
    }

    public void setEmail(HashMap<String, String> email) {
        this.email = email;
    }

    public HashMap getLoginInfo() {
        return logininfo;
    }

    public HashMap<String, String> getTypeAccount() {
        return typeAccount;
    }
}
