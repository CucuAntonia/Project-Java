package clase;

import java.util.List;

public class ConsoleDisplayManager {
    public void StudentDisplay(List<Student> studenti){
        System.out.println("Afisare studenti la consola");
        System.out.println(studenti);
    }

    public void ProfDisplay(List<Profesor> profi){
        System.out.println("Afisare profesori la consola");
        System.out.println(profi);
    }
    public void CoursesDisplay(List<Curs> cursuri) {
        System.out.println("Afisare cursuri la consola");
        System.out.println(cursuri);
    }
}
