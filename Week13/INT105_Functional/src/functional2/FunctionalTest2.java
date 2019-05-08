package functional2;

public class FunctionalTest2 {
    public static void main(String[] args) {
        Greeting1 g1;
        Greeting2 g2;
        Greeting3 g3, g4;
        
        /*
        Lamb Expression Syntax:
        ( comma-separated parameter list ) -> { statement list }
        - data type for parameters may be omitted.
        - if there is only one parameter, both data type and ( ) may be omitted.
        - if there is only statement, both "return" and { } may be omitted.
        */

        // the following g1 assignments are all the same.
        // g1 = (String s) -> { System.out.println("G1: Hello, " + s); };
        // g1 = (String s) -> System.out.println("G1: Hello, " + s);
        // g1 = (s) -> { System.out.println("G1: Hello, " + s); };
        // g1 = (s) -> System.out.println("G1: Hello, " + s);
        // g1 = s -> { System.out.println("G1: Hello, " + s); };
        g1 = s -> System.out.println("G1: Hello, " + s);
        

        // the following g2 assignments are all the same.
        //g2 = (String s, String m) -> { System.out.println("G2: " + m + ", " + s); };
        //g2 = (s, m) -> { System.out.println("G2: " + m + ", " + s); };
        //g2 = (String s, String m) -> System.out.println("G2: " + m + ", " + s);
        g2 = (s, m) -> System.out.println("G2: " + m + ", " + s);

        // the following g3 assignments are all the same.
        //g3 = (String s) -> { return "G3: Hello, " + s; };
        //g3 = (String s) -> "G3: Hello, " + s;
        //g3 = (s) -> { return "G3: Hello, " + s; };
        //g3 = (s) -> "G3: Hello, " + s;
        //g3 = s -> { return "G3: Hello, " + s; };
        g3 = s -> "G3: Hello, " + s;

        // the following g4 assignments are all the same.
        //g4 = s -> "G4: Hello, " + s.toUpperCase();
        g4 = (String s) -> {
                String cap = s.toUpperCase();
                return "G4: Hello, " + cap;
             };
        
        g1.greet("you");
        g2.greet("Lambda", "Good Day");
        System.out.println(g3.greet("Simple Lambda"));
        System.out.println(g4.greet("A Little Complex Lambda"));
    }
}

interface Greeting1 {
    public void greet(String someone);
}

interface Greeting2 {
    public void greet(String someone, String message);
}

interface Greeting3 {
    public String greet(String someone);
}
