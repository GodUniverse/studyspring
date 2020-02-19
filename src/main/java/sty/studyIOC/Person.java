package sty.studyIOC;

public class Person {

    private String name;

    public Person() {
        System.out.println("...111");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
