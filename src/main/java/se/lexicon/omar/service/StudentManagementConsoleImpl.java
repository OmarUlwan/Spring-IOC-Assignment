package se.lexicon.omar.service;

import org.springframework.stereotype.Component;
import se.lexicon.omar.data_access.StudentDao;
import se.lexicon.omar.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.omar.util.UserInputService;

import java.util.List;

@Component
public class
StudentManagementConsoleImpl implements StudentManagement {


    private final UserInputService scannerService;

    private final StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }

    public UserInputService getScannerService() {
        return scannerService;
    }


    @Override
    public Student create() {
        System.out.print("Create a new student\nEnter the student's name: ");
        return studentDao.save(
                new Student(
                        scannerService.getString().trim()
                )
        );
    }


    @Override
    public Student save(Student student) {
        return (student != null) ? studentDao.save(student) : null;
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student removedStudent = studentDao.find(id);
        if ((removedStudent != null)) studentDao.delete(id);
        return removedStudent;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if (student != null) {
            System.out.println("You are editing the " + student + ".");
            System.out.print("Enter new name: ");
            student.setName(scannerService.getString().trim());
        }
        return student;
    }
}
