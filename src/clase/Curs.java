package clase;

import java.util.*;

public class Curs {
    String nume;
    String descriere;
    Profesor profu;
    public Set<Student> studenti;
    HashMap<Student, Integer> nota = new HashMap<>();

    public Curs() {
    }

    public Curs(String nume, String descriere) {
        this.nume = nume;
        this.descriere = descriere;
    }

    // Adaugarea profesorului se face in constructor
    public Curs(String nume, String descriere, Profesor profu, Set<Student> studenti) {
        this.nume = nume;
        this.descriere = descriere;
        this.profu = profu;
        this.studenti = studenti;
        this.nota = new HashMap<Student, Integer>();
    }

    public Curs(ArrayList<String> properties, List<Curs> cursuri) throws Exception {
        if (properties.size() == 0) {
            throw new Exception("Invalid number of properties! The student cannot be created!");
        } else {
            this.nume = properties.get(0);
            this.descriere = properties.get(1);
            Profesor prof = new Profesor();
            prof.nume = properties.get(2);
            prof.prenume = properties.get(3);
            Set<Student> studentu = new HashSet<>();
            Map<Student, Integer> nota_hash = new HashMap<>();

            for (int i = 4; i < properties.size(); i++) {
                Student stud;
                String nume = properties.get(i++);
                String prenume = properties.get(i++);
                int grupa = Integer.parseInt(properties.get(i++));
                int nota = Integer.parseInt(properties.get(i));
                stud = new Student(nume, prenume, grupa);
                studentu.add(stud);
                nota_hash.put(stud, nota);
            }
            cursuri.add(new Curs(this.nume, this.descriere, prof, studentu, nota_hash));
            for (Map.Entry entry : nota_hash.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public Curs(String nume, String descriere, Profesor prof, Set<Student> studentu, Map<Student, Integer> nota_hash) {
        this.nume = nume;
        this.descriere = descriere;
        this.profu = prof;
        this.studenti = studentu;
        this.nota = (HashMap<Student, Integer>) nota_hash;
    }

    public String AfisareCursFisier() {
        return "Curs [nume=" + nume + ", Descriere=" + descriere + '\n' + "Profesor= " + profu.formatForDisplay() + '\n' + "Studenti= " + studenti.toString() + "]\n";
    }

    public Curs(String nume) {
        this.nume = nume;
        this.studenti = new HashSet<Student>();
    }

    public String getNume() {
        return nume;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nume == null) ? 0 : nume.hashCode());
        return result;
    }

    public Set<Student> getStudenti() {
        return studenti;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curs other = (Curs) obj;
        if (nume == null) {
            if (other.nume != null)
                return false;
        } else if (!nume.equals(other.nume))
            return false;
        return true;
    }

    public void UpdateProfesor(Profesor profu) {
        this.profu = profu;
    }

    public void AddStudent(Student student) {
        this.studenti.add(student);
    }

    public void StergeStudent(Student student) throws Exception {
        // Verific daca studentul este inscris la curs
        if (!this.studenti.remove(student)) {
            throw new Exception("Studentul " + student + " nu este inscris la acest curs");
        }
        this.nota.remove(student);
    }

    public void ModificaStudent(Student student, Student studentnou) {
        // Sterg studentul vechi
        if (this.studenti.remove(student)) {
            // Adaug studentul nou in set
            this.studenti.add(studentnou);
        }
        // Sterg nota studentului vechi si adaug aceeasi nota pentru studentul nou introdus
        if (this.nota.get(student) != null) {
            Integer notaStudent = this.nota.get(student);
            this.nota.remove(student);
            this.nota.put(studentnou, notaStudent);
        }
    }

    @Override
    public String toString() {
        String str = "Curs: " + "nume=" + nume + ", descriere=" + descriere + ",\nprofu=" + profu + ",\nstudenti:\n";
        for (Student s : studenti) {
            ///System.out.println("\n");
            Integer notaStudent = nota.get(s) != null ? nota.get(s) : 0;
            str += s + " " + notaStudent;
        }
        return str;
    }

    public void AfisareStudenti() {
        String str = "";
        for (Student s : studenti) {
            str += s + " " + nota.get(s);
        }
        System.out.println(str);
    }

    public Profesor getProfu() {
        return profu;
    }

    public void noteazaStudent(Student s, int notaStudentului) throws Exception {
        if (this.studenti.contains(s)) {
            this.nota.put(s, notaStudentului);
        } else {
            throw new Exception("Studentul " + s + " nu poate fi notat pentru ca nu participa la curs");
        }
    }

    public void AfisareNumeCurs() {
        System.out.println(this.nume + ":");
    }

    public float MediaStudenti() {
        // Varianta moderna Java
        return (float) nota.values().stream().mapToInt(a -> a).average().orElse(0);
		/* Varianta in care scrieti voi parcurgerea
		int media = 0;
		for (Student s: studenti) {
			media += nota.get(s);
		}
		return media / (float)studenti.size(); */
    }

}