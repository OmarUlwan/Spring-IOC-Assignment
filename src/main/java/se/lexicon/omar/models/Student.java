package se.lexicon.omar.models;

public class Student {

    private final int id;
    private String name;

    public Student(String name) {
        this.id = StudentSequencer.nextPersonId();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
