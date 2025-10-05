import java.io.Serializable;

import test.*;


enum Status {
    DISCHARGED, ADMITTED, CANCELLED;
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hellow");
        long a = 1233333444333333333l;
        System.out.println(a);



        int b = Integer.MAX_VALUE;

        int intValue = (b/2);
        short  shortValue = (short) (b / 2);

        byte byteValue = (byte) (b / 2);

        System.out.println(shortValue + " " + byteValue + " " + intValue);

        long x = 10000000000l;
        long y = 20000000000l;
        long z = x + y;
        System.out.println(z);


        // IF RHS has byte datatype operation, it will be converted to int and do the operation as
        // byte don't have arithmetic inst. after completion of operation it can't stored in the byte variable.
        // It must be explicitly cast to byte 

        byte ba = 13;
        byte bb = 2;

        byte cc = (byte) (ba + bb);
        System.out.println(cc);


        double da = 5;
        double db = 3;

        // The RHS is taken as int and performed int operation and it can be fit into double, so no error
        // if you want double calculation then make into float number or give number from double datatype
        double dc = 5 / 3;

        System.out.println(dc);

        // char is 2 byte in java based on the evolution.
        // it must be stored in single quotes
        // doubel quotes would be used for string
        char ca = 'b';
        char cb = '\u0044';
        System.out.println(ca);
        System.out.println(cb); 

        boolean bba = true;
        System.out.println(bba);



        // ARRAy

        int ar[] = new int[2];
        ar[0] = 3;
        ar[1] = 4;

        System.out.println(ar[1]);

        // Multi dimentional array
        int mar[][] = new int[3][4];
        mar[0][3] = 23;

        System.out.println(mar[0][3]);


        for (int oa = 0; oa < mar.length; oa++) {
            for (int ia = 0; ia < mar[oa].length; ia++) {
                mar[oa][ia] = (int)(Math.random() * 100);
            }
        }
        for (int a1[]: mar) {
            for (int n : a1) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

        System.out.println("Student Attendence = " + Student.attendence);

        Student elango = new Student();
        elango.rollNo = 123123;
        elango.name = "elango ravi";

        Student bharat = new Student();
        bharat.rollNo = 4213123;
        bharat.name = "bharat";


        Student students[] = new Student[2];
        students[0] = elango;
        students[1] = bharat;

        for (Student s : students) {
            System.out.println(s.rollNo + " " + s.name);
        }


        // String
        String sa = new String("elango");
        String sb = new String("elango");

        System.out.println(sa == sb);



        // ************ INHERITENCE ****************

        Car maruthi = new Car("maruthi", 600);
        System.out.println(maruthi.getCc());
        maruthi.ignition();
        System.out.println(maruthi.getFuel());
        // maruthi.start("maruthi");

            
        Status patientStatus = Status.ADMITTED;
        System.out.println(patientStatus.toString());

        Status ss = Status.DISCHARGED;
        
        switch(ss) {
            case DISCHARGED:
                System.out.println("discharged ...");
                break;
            case ADMITTED:
                System.out.println("admitted");
                break;
        }

    
    }
}

class Student implements Serializable{
    int rollNo;
    String name;

    static boolean attendence;

    static {
        attendence = true;
    }
}
 