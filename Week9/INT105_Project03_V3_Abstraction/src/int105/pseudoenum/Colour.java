package int105.pseudoenum;

import static int105.pseudoenum.Sex.FEMALE;
import static int105.pseudoenum.Sex.MALE;

public class Colour extends PseudoEnum {

    public static final Colour RED = new Colour("RED", 0);
    public static final Colour GREEN = new Colour("GREEN", 1);
    public static final Colour BLUE = new Colour("BLUE", 2);
    public static final Colour[] VALUES = new Colour[3];

    static {
        VALUES[0] = RED;
        VALUES[1] = GREEN;
        VALUES[2] = BLUE;
    }

    public Colour(String name, int ordinal) {
        super(name, ordinal);
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public static Colour[] values() {
        Colour values[] = new Colour[3];
        System.arraycopy(VALUES, 0, values, 0, VALUES.length);
        return values;
    }

    public static Colour valueOf(String name) {
        if (name == null) {
            return null;
        }
        for (Colour colour : VALUES) {
            if (name.equals(colour.name())) {
                return colour;
            }
        }
        return null;
    }

}
