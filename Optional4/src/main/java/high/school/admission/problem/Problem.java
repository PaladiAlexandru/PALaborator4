package high.school.admission.problem;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Problem {
    Map<Student, List<School>> studentsPreferences;
    Map<School, List<Student>> schoolsPreferences;


    public Problem() {
    }
    public void showProblem(){
        var students = IntStream.range(0,4).
                mapToObj(i -> new Student("S"+i)).toArray(Student[]::new);
        var highSchools = IntStream.range(0,3).
                mapToObj(i -> new School("H"+i)).toArray(School[]::new);
        highSchools[0].setCapacity(1);
        highSchools[1].setCapacity(2);
        highSchools[2].setCapacity(2);
        studentsPreferences = new HashMap<>();
        studentsPreferences.put(students[0], Arrays.asList(highSchools[0],highSchools[1],highSchools[2]));
        studentsPreferences.put(students[1],Arrays.asList(highSchools[0],highSchools[1],highSchools[2]));
        studentsPreferences.put(students[2],Arrays.asList(highSchools[0],highSchools[1]));
        studentsPreferences.put(students[3],Arrays.asList(highSchools[0],highSchools[2]));

        System.out.println("Students preferences:");
        studentsPreferences.forEach((k,v) -> System.out.println(k + ": " + v));

        schoolsPreferences = new TreeMap<>();
        schoolsPreferences.put(highSchools[0], Arrays.asList(students[3],students[0],students[1],students[2]));
        schoolsPreferences.put(highSchools[1], Arrays.asList(students[0],students[2],students[1]));
        schoolsPreferences.put(highSchools[2], Arrays.asList(students[0],students[1],students[3]));

        System.out.println("Schools preferences:");
        schoolsPreferences.forEach((k,v) -> System.out.println(k + ": " + v));

        List<School> schoolList = new ArrayList<>();
        schoolList.add(highSchools[0]);
        schoolList.add(highSchools[1]);
        students[0].setPreferences(Arrays.asList(highSchools[0],highSchools[1],highSchools[2]));
        students[1].setPreferences(Arrays.asList(highSchools[0],highSchools[1],highSchools[2]));
        students[2].setPreferences(Arrays.asList(highSchools[0],highSchools[1]));
        students[3].setPreferences(Arrays.asList(highSchools[0],highSchools[2]));

        studentsWhoFindsAcceptable(Arrays.asList(students), schoolList);

        //Fake names
        Faker faker = new Faker();
        for(Student student: students){
            student.setNume(faker.funnyName().name());
            System.out.println(student.getNume());
        }


    }
    private void studentsWhoFindsAcceptable(List<Student> studentList, List<School> schoolList){
        var studs = studentList.stream().filter(s->s.getPreferences().containsAll(schoolList)).toArray(Student[]::new);
        for(Student s:studs){
            System.out.println("Students that find acc["+ schoolList + "]:" + s.getNume());
        }
    }

}
