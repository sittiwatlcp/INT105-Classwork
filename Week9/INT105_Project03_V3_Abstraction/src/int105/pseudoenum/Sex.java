package int105.pseudoenum;

public class Sex extends PseudoEnum {

    public static final Sex MALE = new Sex("MALE", 0);
    public static final Sex FEMALE = new Sex("FEMALE", 1);
    public static final Sex[] VALUES = new Sex[2];

    static {
        VALUES[0] = MALE;
        VALUES[1] = FEMALE;
    }

    public Sex(String name, int ordinal) {
        super(name, ordinal);
    }

    public static Sex[] values() {
        Sex values[] = new Sex[2];
        System.arraycopy(VALUES, 0, values, 0, VALUES.length);
        return values;
    }

    public static Sex valueOf(String name) {
        if (name == null) {
            return null;
        }
        for (Sex sex : VALUES) {
            if (name.equals(sex.name())) {
                return sex;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
