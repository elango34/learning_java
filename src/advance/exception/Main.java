package advance.exception;

class CustomException extends Exception {
    public CustomException(String s) {
        super(s);
    }
}


class Division {
    public int division(int i, int j) throws Exception {
        return i / j;
    }
}

public class Main {
    public static void main(String[] args) {
        
        int i = 12;
        int k = 0;

        try {
            int j = i / k;
            System.out.println("After exception....");
        } catch(ArithmeticException e) {
            System.out.println("Got the correct exception!");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Something went wrong...");
            System.out.println(e);
        }


        System.out.println();
        System.out.println("=======================================");
        System.out.println("USING THROW METHOD");
        System.out.println("=======================================");
        System.out.println();

        try {
            if (k == 0) {
                throw new NullPointerException("sending some message in the exception..."); // just for experimenting
            }
            int j = i / k;
            System.out.println("After exception....");
        } catch(NullPointerException e) {
            System.out.println("Got the correct exception!");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Something went wrong..." + "\n" + "Using Normal Exception");
            System.out.println(e);
        }

        System.out.println();
        System.out.println("=======================================");
        System.out.println("USING CUSTOM METHOD");
        System.out.println("=======================================");
        System.out.println();

        try {
            if (k == 0) {
                throw new CustomException("Divisor is zero, so it will return an error!"); // just for experimenting
            }
            int j = i / k;
            System.out.println("After exception....");
        } catch(CustomException e) {
            System.out.println("Got the correct custom exception!");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Something went wrong..." + "\n" + "Using Normal Exception");
            System.out.println(e);
        }


        System.out.println();
        System.out.println("=======================================");
        System.out.println("USING THROWS");
        System.out.println("=======================================");
        System.out.println();

        Division division = new Division();

        try {
            int result = division.division(12, 0);
            System.out.println("Result = " + result);
        } catch (Exception e) {
            System.out.println("Catched exception from Division throws....");
        }

    }
}
