package se.lexicon.omar.data_access;

import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.omar.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {

    private static List<Student> students;

    @Autowired
    public StudentDaoListImpl() {
        students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        boolean addedStudent = false;
        if (student != null) addedStudent = students.add(student);
        return (addedStudent) ? student : null;
    }

    @Override
    public Student find(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
