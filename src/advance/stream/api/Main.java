package advance.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {


    private final int myVariable = 10;

    public static void main(String[] args) {
        
        List<Integer> arrlist = Arrays.asList(4,5,22,23,42);


        int result = arrlist.stream()
                    .filter((i) -> i>5)
                    .map((i) -> i*2)
                    .reduce(0, (c,e) -> c+e);



        Stream<Integer> st = arrlist.stream();
        
        st.forEach(n -> System.out.println(n));
        st.forEach(n -> System.out.println("again streaming "+n));

        System.out.println(result);

        char chars[] = {'a', 'b', 'c', 'd', 'e', 'f'};

        String newString = chars.toString();
        StringBuffer sb = new StringBuffer(newString);
        sb.trimToSize();


        // myVariable = 10;

        
        
    }
}

class Outer {

    class Inner{
    
        public void m1(){
        
            System.out.println("inner class instance m1()");
        }
    
    }
    
    public static void main(String[] args) {
        Inner i = new Inner();
        i.m1();
     }
        
        
}


