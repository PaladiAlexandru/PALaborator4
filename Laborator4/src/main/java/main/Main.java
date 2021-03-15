package main;

import high.school.admission.problem.School;
import high.school.admission.problem.Student;

import java.awt.image.AreaAveragingScaleFilter;
import java.text.CollationElementIterator;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var students = IntStream.range(0,4).
                mapToObj(i -> new Student("S"+i)).toArray(Student[]::new);
        var highSchools = IntStream.range(0,3).
                mapToObj(i -> new School("H"+i)).toArray(School[]::new);
        highSchools[0].setCapacity(1);
        highSchools[1].setCapacity(2);
        highSchools[2].setCapacity(2);

        List<Student> studentList = new LinkedList<>();
        Collections.addAll(studentList, students);
        studentList.sort(Student::compareByName);
        System.out.println(studentList);

        Set<School> schoolSet = new TreeSet<>();
        schoolSet.add(highSchools[0]);
        schoolSet.add(highSchools[1]);

        Map<Student,List<School>> studentsPrefMap = new HashMap<>();
        studentsPrefMap.put(students[0],Arrays.asList(highSchools[0],highSchools[1],highSchools[2]));
        studentsPrefMap.put(students[1],Arrays.asList(highSchools[0],highSchools[1],highSchools[2]));
        studentsPrefMap.put(students[2],Arrays.asList(highSchools[0],highSchools[1]));
        studentsPrefMap.put(students[3],Arrays.asList(highSchools[0],highSchools[2]));

        System.out.println("Students preferences:");
        studentsPrefMap.forEach((k,v) -> System.out.println(k + ": " + v));

        Map<School,List<Student>> schoolPrefMap = new TreeMap<>();
        schoolPrefMap.put(highSchools[0], Arrays.asList(students[3],students[0],students[1],students[2]));
        schoolPrefMap.put(highSchools[1], Arrays.asList(students[0],students[2],students[1]));
        schoolPrefMap.put(highSchools[2], Arrays.asList(students[0],students[1],students[3]));

        System.out.println("Schools preferences:");
        schoolPrefMap.forEach((k,v) -> System.out.println(k + ": " + v));


    }
}
