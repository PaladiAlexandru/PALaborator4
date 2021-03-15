package high.school.admission.problem;

import java.util.Comparator;

public class Student {
    private String nume;

    public Student(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public static int compareByName(Student o1, Student o2) {
        return o1.getNume().compareTo(o2.getNume());
    }

    @Override
    public String toString() {
        return nume;
    }
}
