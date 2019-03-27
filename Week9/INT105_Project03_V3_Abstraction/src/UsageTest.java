
import int105.enumerate.Color;
import int105.abstraction.GeometricObject;
import int105.abstraction.HasNext;
import int105.abstraction.Rectangle;
import int105.enumerate.DayOfWeek;
import int105.enumerate.Direction;
import int105.enumerate.RandomDay;
import int105.pseudoenum.Colour;
import int105.pseudoenum.Sex;

public class UsageTest {

    public static void main(String[] args) {
        testGenderEnum();
        testColor();
        testPseudoEnum();
        testGeometry();
        testDirection();
        testDayOfWeek();
        testHasNext();
        testRandomDay();
    }
    
    public static void testDirection() {
        System.out.println(":: Test Direction :: -----");
        System.out.println(Direction.NORTH.uturn());
        HasNext<Direction> d = Direction.WEST;
        for (int i = 0; i < 5; i++) {
            d = d.next();
            System.out.println(d);
        }
    }

    public static void testHasNext() {
        System.out.println(":: Test HasNext :: -----");
        HasNext<DayOfWeek> n = DayOfWeek.SUNDAY;
        for (int i = 0; i < 10; i++) {
            n = n.next();
            System.out.println(n);
        }
    }

    public static void testRandomDay() {
        System.out.println(":: Test RandomDay :: -----");
        HasNext<DayOfWeek> r = new RandomDay();
        for (int i = 0; i < 5; i++) {
            System.out.println(r.next());
        }
    }

    public static void testDayOfWeek() {
        System.out.println(":: Test DayOfWeek :: -----");
        for (DayOfWeek d : DayOfWeek.values()) {
            System.out.println(d.shortForm() + " : " + d
                    + " next is " + d.next());
        }
    }

    public static void testGenderEnum() {
        System.out.println(":: Test GenDerEnum :: -----");
        Person p = new Person("Steve", Gender.MALE);
        System.out.println(p);
        for (Gender sex : Gender.values()) {
            System.out.println(sex.name() + ":"
                    + sex.toString() + ": [" + sex.ordinal() + "]");
        }
    }

    public static void testColor() {
        System.out.println(":: Test Color :: -----");
        for (Color c : Color.values()) {
            System.out.print("ordinal(): " + c.ordinal());
            System.out.print("\ttoString(): " + c);
            System.out.print("\tname(): " + c.name());
            System.out.println();
        }
        System.out.println("Color.valueOf(\"RED\"): " + Color.valueOf("RED"));
        System.out.println("Color.valueOf(\"RED\").name(): " + Color.valueOf("RED").name());
    }

    public static void testPseudoEnum() {
        System.out.println(":: Test PseudoEnum :: -----");
        for (Sex sex : Sex.values()) {
            System.out.println(sex.name() + ":"
                    + sex.toString() + ": [" + sex.ordinal() + "]");
        }
        for (Colour c : Colour.values()) {
            System.out.print("ordinal(): " + c.ordinal());
            System.out.print("\ttoString(): " + c);
            System.out.print("\tname(): " + c.name());
            System.out.println();
        }
        System.out.println("Colour.valueOf(\"RED\"): " + Colour.valueOf("RED"));
        System.out.println("Colour.valueOf(\"RED\").name(): " + Colour.valueOf("RED").name());
    }

    public static void testGeometry() {
        System.out.println(":: Test Geometry :: -----");
        GeometricObject g = new Rectangle(20.0, 5.0);
        g.setColor(Color.RED);
        System.out.println(g);
        System.out.println(String.format("Area:%.2f, Perimeter: %.2f",
                g.getArea(), g.getPerimeter()));
    }
}

enum Gender {
    MALE, FEMALE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

class Person {

    String name;
    Gender sex;

    Person(String name, Gender sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return name + "[" + sex.name() + ":"
                + sex.toString() + ":" + sex.ordinal() + "]";
    }
}
