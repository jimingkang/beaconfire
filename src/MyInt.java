import java.util.Objects;

public final class MyInt implements Comparable<MyInt> {
    private final int value;


    public MyInt(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public short shortValue() {
        return (short) value;
    }

    public byte byteValue() {
        return (byte) value;
    }

    public long longValue() {
        return value;
    }

    public float floatValue() {
        return value;
    }

    public double doubleValue() {
        return value;
    }

    @Override
    public int compareTo(MyInt other) {
        return Integer.compare(value, Objects.requireNonNull(other, "other").value);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyInt)) {
            return false;
        }
        MyInt myInt = (MyInt) other;
        return value == myInt.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public static void main(String[] args) {
        MyInt first = new MyInt(42);
        MyInt sameValue = new MyInt(42);
        MyInt larger = new MyInt(100);

        System.out.println("Value: " + first.intValue());
        System.out.println("As short: " + first.shortValue());
        System.out.println("Equal values: " + first.equals(sameValue));
        System.out.println("Comparison with 100: " + first.compareTo(larger));
        System.out.println("String form: " + first);
    }
}
