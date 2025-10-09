package advance.collection.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {

    private int mark;
    private String name;
    private int age;

    public Student(String name, int mark, int age ) {
        this.mark = mark;
        this.name = name;
        this.age = age;
    }

    public int compareTo(Student that) {
        if(this.age > that.age) {
            return 1;
        } else {
            return -1;
        }
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}



public class Main {

    public static void main(String[] args) {
        
        System.out.println("================== Comparable ===============");

        // Sorting with inbuilt compareT method
        List<Integer> compare = new ArrayList<>();
        compare.add(3);
        compare.add(5);
        compare.add(1);


        Collections.sort(compare);

        System.out.println(compare);

        System.out.println("================== Comparing with custom class comparable ===============");

        List<Student> students = new ArrayList<>();
        students.add(new Student("test1", 71, 27));
        students.add(new Student("test2", 80, 21));
        students.add(new Student("elango", 60, 24));

        Collections.sort(students);

        for (Student s : students) {
            System.out.println("Name: " + s.getName() + " Age: " + s.getAge() + " Mark: "+s.getMark());
        }
    }
}
