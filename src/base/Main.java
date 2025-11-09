package base;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        CustomerRecord record = new CustomerRecord("Kedar", 42, Integer.valueOf(123)
                //, new Address("Aurora","IL",60504)
                );
        CustomerRecord record1 = new CustomerRecord("Kedar", 42, Integer.valueOf(123)
                //,  new Address("Aurora","IL",60504)
                );

        System.out.println("Compare "+ record.equals(record1));

    }





}