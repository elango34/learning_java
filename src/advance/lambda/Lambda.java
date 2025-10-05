package advance.lambda;


@FunctionalInterface
interface A {
    int sum(int a, int b);
}


public class Lambda {
    
    public static void main(String[] args) {
        A obj = (int a, int b) -> a+b; 

        System.out.println(obj.sum(2, 8));
    }
}
