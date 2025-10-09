package advance.collection.comparator;

public class Student implements Comparable<Student>{

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
