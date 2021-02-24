package se.lexicon.omar.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.omar.data_access.ComponentScanConfig;
import se.lexicon.omar.models.Student;
import se.lexicon.omar.models.StudentSequencer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class StudentManagementConsoleImplTest {

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ComponentScanConfig.class);

    //@Bean("studentManagementConsoleImpl")
    StudentManagement studentManagement = context.getBean(StudentManagement.class);

    Student studentTest;
    Student student;
    Student student2;
    Student student3;
    Student student4;
    Student student5;

    @Before
    public void beforeTest(){
        student = new Student("studentName");
        student2 = new Student("studentName2");
        student3 = new Student("studentName3");
        student4 = new Student("studentName4");
        student5 = new Student("studentName5");
    }

    @After
    public void afterTest(){
        StudentSequencer.reset();
    }

    @Test
    public void createTest(){
        String input = "studentName";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        studentTest = studentManagement.create();

        assertNotNull(studentTest);
        assertEquals(6, studentTest.getId());
        assertEquals("studentName", studentTest.getName());
    }

    @Test
    public void saveTest(){
        studentTest = studentManagement.save(student);
        assertNotNull(studentTest);
        assertEquals(student,studentTest);
    }

    @Test
    public void findTest(){
        studentManagement.save(student);
        studentManagement.save(student2);

        assertEquals(student, studentManagement.find(1));
        assertEquals(student2, studentManagement.find(2));
        assertNull(studentManagement.find(3));
    }

    @Test
    public void removeTest(){
        studentManagement.save(student);
        studentManagement.save(student2);
        studentManagement.save(student3);
        studentManagement.save(student4);


        assertNotNull(studentManagement.findAll());
        assertEquals(4,studentManagement.findAll().size());

        studentManagement.remove(2);
        assertEquals(3,studentManagement.findAll().size());

        studentManagement.remove(11);
        assertEquals(3,studentManagement.findAll().size());
    }

    @Test
    public void findAllTest(){
        studentManagement.save(student);
        studentManagement.save(student2);
        assertNotNull(studentManagement.findAll());
        assertEquals(2,studentManagement.findAll().size());

        studentManagement.save(student3);
        assertEquals(3,studentManagement.findAll().size());
    }

    @Test
    public void editTest(){

        studentManagement.save(student5);

        String input = "The student has been updated";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        studentTest = studentManagement.edit(student5);

        assertNotNull(studentTest);
        assertEquals(5, studentTest.getId());
        assertEquals("The student has been updated", studentTest.getName());

    }
}
