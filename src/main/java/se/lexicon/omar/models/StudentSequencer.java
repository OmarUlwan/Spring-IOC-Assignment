package se.lexicon.omar.models;

public class StudentSequencer {

    public static int studentId;

    public static int nextPersonId() {
        studentId = ++studentId;
        return studentId;
    }

    public static void reset() {
        studentId = 0;
    }
}
