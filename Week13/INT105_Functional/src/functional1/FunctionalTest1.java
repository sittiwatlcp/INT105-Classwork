package functional1;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

public class FunctionalTest1 {

    public static void main(String[] args) {
        greetingTest();
    }

    public static void TestingMe() {
        UnaryOperator m = i -> "Hello " + i;
        IntBinaryOperator s = (i, j) -> i + j;
        BinaryOperator<String> t = (i, j) -> i + j;
        System.out.println("String : " + t.apply("Hello ", "there"));
        System.out.println("Result of Testing : " + s.applyAsInt(11, 33));
        System.out.println(m.apply("World"));
    }

    public static void greetingTest() {
        Greeting[] array = new Greeting[4];
        array[0] = helloClass();
        array[1] = helloAnonymous();
        array[2] = helloLambda();
        array[3] = helloTest();
        for (Greeting var : array) {
            var.greet();
        }
    }

    private static Greeting helloClass() {
        return new Hello();
    }

    private static Greeting helloAnonymous() {
        return new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello Anonymous.");
            }
        };
    }

    private static Greeting helloTest() {
        Greeting x = () -> System.out.println("AAAAA");
        return x;
    }

    private static Greeting helloLambda() {
        return () -> System.out.println("Hello Lambda.");
    }
}

class Hello implements Greeting {

    @Override
    public void greet() {
        System.out.println("Hello Class.");
    }
}
