package advance.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ListDemo {

}

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(7);
        numbers.add(11);

        System.out.println(numbers);

        System.out.println(numbers.get(3));
    }

}

