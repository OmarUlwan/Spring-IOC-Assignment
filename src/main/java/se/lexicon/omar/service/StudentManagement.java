package se.lexicon.omar.service;

import se.lexicon.omar.models.Student;
import se.lexicon.omar.util.UserInputService;

import java.util.List;

public interface StudentManagement {

    Student create();
    Student save(Student student);
    Student find(int id);
    Student remove(int id);
    List<Student> findAll();
    Student edit(Student student);

    UserInputService getScannerService();
}
