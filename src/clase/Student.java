package clase;


import java.util.ArrayList;
import java.util.function.IntFunction;

public class Student extends ArrayList<Student>implements Comparable<Student> {
    String nume;
    String prenume;
    int grupa;

    Student(String nume, String prenume, int grupa) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
    }
    public Student(){

    }
    Student (ArrayList<String> properties) throws Exception {
        if(properties.size()!=3) {
            throw new Exception("Invalid number of properties! The student cannot be created!");
        }
        else {
            this.nume= properties.get(0);
            this.prenume = properties.get(1);
            this.grupa = Integer.parseInt(properties.get(2));
        }
    }
    public int getGrupa() {
        return grupa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "Student [nume=" + nume + ", prenume=" + prenume + ", grupa=" + grupa + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + grupa;
        result = prime * result + ((nume == null) ? 0 : nume.hashCode());
        result = prime * result + ((prenume == null) ? 0 : prenume.hashCode());
        return result;
    }

    public String getPrenume() {
        return prenume;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (nume == null) {
            if (other.nume != null)
                return false;
        } else if (!nume.equals(other.nume))
            return false;
        if (prenume == null) {
            if (other.prenume != null)
                return false;
        } else if (!prenume.equals(other.prenume))
            return false;
        return true;
    }

    ///• Studentii sa poata fi afisati in ordine fara a implementa un algoritm de
    //sortare
    @Override
    public int compareTo(Student o) {
        int CompareResult = this.nume.compareTo(o.nume);
        if (CompareResult < 0)
            return -1;
        else if (CompareResult > 0)
            return 1;
        else if (CompareResult == 0) {
            int Compareresult2 = this.prenume.compareTo(o.prenume);
            if (Compareresult2 < 0)
                return -1;
            else if (Compareresult2 > 0)
                return 1;
        }
        return 0;
    }
}





