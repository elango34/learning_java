package advance.stream.forEachStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    

    public static void main(String[] args) {
        
        List<Integer> interable = new ArrayList<>();
        interable.add(3);
        interable.add(35);
        interable.add(2);
        interable.add(32);

        // Consumer<Integer> con = new Consumer<Integer>() {
        //     public void accept(Integer i) {
        //         System.out.println(i);        
        //     }
        // };

        // this is a functional interface so use lambda expression
        // Consumer<Integer> con = (Integer i) -> {
        //         System.out.println(i);     
        // };

        // that lambda expression can be even simpler like this
        Consumer<Integer> con = (i) -> System.out.println(i);

        
        interable.forEach(con);
        
        
        System.out.println("============================");

        // Those are for our understanding purpose how we can define the forEach consumer
        // That can be eventually written like below
        interable.forEach((i) -> System.out.println(i));
        

    }

}
