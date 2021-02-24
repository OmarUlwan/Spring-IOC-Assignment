package se.lexicon.omar.data_access;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.omar.models.Student;
import se.lexicon.omar.models.StudentSequencer;

import static org.junit.Assert.*;


public class StudentDaoListImplTest {

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ComponentScanConfig.class);

    //@Bean("studentManagementConsoleImpl")
    StudentDao studentDao = context.getBean(StudentDao.class);

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
    public void saveTest(){
        studentTest = studentDao.save(student);
        assertNotNull(studentTest);
        assertEquals(student,studentTest);
    }

    @Test
    public void findTest(){
        studentDao.save(student);
        studentDao.save(student2);

        assertEquals(student, studentDao.find(1));
        assertEquals(student2, studentDao.find(2));
        assertNull(studentDao.find(3));
    }

    @Test
    public void findAllTest(){
        studentDao.save(student);
        studentDao.save(student2);

        assertNotNull(studentDao.findAll());
        assertEquals(2,studentDao.findAll().size());

        studentDao.save(student3);
        assertEquals(3,studentDao.findAll().size());
    }

    @Test
    public void deleteTest(){
        studentDao.save(student);
        studentDao.save(student2);
        studentDao.save(student3);
        studentDao.save(student4);
        studentDao.save(student5);

        assertNotNull(studentDao.findAll());
        assertEquals(5,studentDao.findAll().size());

        studentDao.delete(2);
        assertEquals(4,studentDao.findAll().size());

        studentDao.delete(11);
        assertEquals(4,studentDao.findAll().size());

    }

}
