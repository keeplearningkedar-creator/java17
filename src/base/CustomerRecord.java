package base;

public record CustomerRecord(String Name, Integer age, Integer cardNumber
//                             ,Address address
) {
    @Override
    public boolean equals(Object obj) {
    // you can override default equals
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public String getName() {
        return "Every One had same name";
    }

}
