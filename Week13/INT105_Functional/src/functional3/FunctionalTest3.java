package functional3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.ToDoubleFunction;

public class FunctionalTest3 {

    public static void main(String[] args) {
        Group g = new Group();
        g.add(new Person(1, "Albert","Bryan", 5000.0));
        g.add(new Person(3, "Smith","Jordan", 5500.0));
        g.add(new Person(2, "Stark","Nite", 9000.0));
        g.add(new Person(9, "Johny","Smith", 3000.0));
        g.add(new Person(7, "Johnson","Dope", 1000.0));
        //g.sort((o1, o2) -> Double.compare(o1.getIncome(), o2.getIncome())); //id, name, salary
        g.sort(Person::getIncome);
        Person[] people = g.getPeople();
        for (Person person : people) {
            if (person != null) {
                System.out.println(person.toString());
            }
        }

    }
}

class Person implements Comparable<Person> {

    private int id;
    private String fristName;
    private String lastName;

    private double income;

    public Person(int id, String fristName,String lastName, double income) {
        this.id = id;
        this.fristName = Objects.requireNonNull(fristName);
                this.lastName = Objects.requireNonNull(lastName);
        this.income = income;
    }

    public double getIncome() {
        return income;
    }
    

    public void setIncome(double income) {
        this.income = income;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", fristName=" + fristName + ", lastName=" + lastName + ", income=" + income + '}';
    }



    @Override
    public int compareTo(Person o) {
        return this.id - o.id;
    }

}

class Group {

    Person[] people;
    int count;

    public Group() {
        people = new Person[16];
    }

    public void add(Person p) {
        Objects.requireNonNull(p);
        if (count == people.length) {
            reorganize();
        }
        people[count++] = p;
    }

    private void reorganize() {
        Person[] newPeople = new Person[people.length << 1];
        System.arraycopy(people, 0, newPeople, 0, count);
        people = newPeople;
    }
public void sort(Comparator<Person> comparator) {
        if (comparator == null) {

            comparator = Comparator.nullsLast(Comparator.naturalOrder());
        }
        Arrays.sort(people, 0, count, comparator);
    }

    public void sort(ToDoubleFunction<Person> func) {
        Comparator<Person> comparator;
        comparator = Comparator.comparingDouble(func);
        if(comparator == null) comparator = Comparator.naturalOrder();
        Arrays.sort(people, 0, count, comparator);
    }

    public Person[] getPeople() {
        return people;
    }
}
