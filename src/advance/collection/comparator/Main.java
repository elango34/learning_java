package advance.collection.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class StringComparator implements Comparator<String> {

    @Override
    public int compare (String s1, String s2) {
        if (s1.length() > s2.length()) {
            return 1;
        } else {
            return -1;
        }
    }
}


public class Main {

    public static void main(String[] args) {

        // Comparator<String> comparator = new Comparator<String>() {
        //     @Override
        //     public int compare (String s1, String s2) {
        //         if (s1.length() > s2.length()) {
        //             return 1;
        //         } else {
        //             return -1;
        //         }
        //     }
        // };

        Comparator<String> comparator = (String s1, String s2) -> {
                if (s1.length() > s2.length()) {
                    return 1;
                } else {
                    return -1;
                }
        };




        List<String> list = new ArrayList<String>();
        list.add("Testsss");
        list.add("Test");
        list.add("Testing");
        list.add("testss");


        List<String> list2 = new ArrayList<String>();
        list2.add("Testsssr3");
        list2.add("Test32");
        list2.add("Testin3g");
        list2.add("tests2s");


        Collections.sort(list, comparator);

        StringComparator comparator2 = new StringComparator();
        Collections.sort(list2, comparator2);

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println();

        for (String s : list2) {
            System.out.println(s);
        }


    }

}
