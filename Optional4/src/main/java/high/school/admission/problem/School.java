package high.school.admission.problem;

import com.sun.source.tree.Scope;

public class School implements Comparable<School> {
    private String nume;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public School(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public int compareTo(School o) {
        return this.nume.compareTo(o.nume);
    }

    @Override
    public String toString() {
        return nume ;
    }
}
