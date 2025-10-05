package advance.innerClass;


@FunctionalInterface
interface A {
    void printSomething();

}


public class InnerClass {
    public static void main(String[] args) {
        A obj = new A() {
            public void printSomething() {
                System.out.println("print something");
            }
        };

        obj.printSomething();
    }
}


// Instead of creating a class then implementing a method, we can use anonymous inner class

// class B implements A {
//     public void printSomething() {
//         System.out.println("something to print");
//     }
// }
