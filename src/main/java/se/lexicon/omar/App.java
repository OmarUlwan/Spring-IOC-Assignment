package se.lexicon.omar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.omar.data_access.ComponentScanConfig;
import se.lexicon.omar.models.Student;
import se.lexicon.omar.service.StudentManagement;


public class App {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        //@Bean("studentManagementConsoleImpl")
        // StudentDao studentDao = context.getBean(StudentDao.class);

        //@Bean("scannerInputService")
        // UserInputService userInputService = context.getBean(UserInputService.class);

        //@Bean("studentManagementConsoleImpl")
        StudentManagement studentManagement = context.getBean(StudentManagement.class);


        boolean end = true;
        while (end) {

            System.out.println(
                    "[1] Create a new student." +
                            "\n[2] Find student by ID." +
                            "\n[3] Find all students." +
                            "\n[4] Delete a student." +
                            "\n[5] Edit a student." +
                            "\n[6] Exit."
            );

            int i = 0;
            while (i < 1 || i > 6) {
                System.out.println("===========================");
                System.out.print("Enter the option number: ");
                i = studentManagement.getScannerService().getInt();
            }
            switch (i) {
                case 1:
                    System.out.println("===========================");
                    studentManagement.create();
                    System.out.println("===========================");
                    break;
                case 2:
                    System.out.println("===========================");
                    System.out.print("ُEnter a number to find student by ID:");
                    System.out.println(
                            studentManagement.find(studentManagement.getScannerService().getInt())
                    );
                    System.out.println("===========================");
                    break;
                case 3:
                    System.out.println("===========================");
                    for (Student s : studentManagement.findAll())
                        System.out.println(s);
                    System.out.println("===========================");
                    break;
                case 4:
                    System.out.println("===========================");
                    for (Student s : studentManagement.findAll())
                        System.out.println(s);
                    System.out.print("ُEnter a number to delete student by ID:");
                    System.out.println(
                            studentManagement.remove(studentManagement.getScannerService().getInt())
                    );
                    System.out.println("===========================");
                    break;
                case 5:
                    System.out.println("===========================");
                    for (Student s : studentManagement.findAll())
                        System.out.println(s);
                    System.out.print("ُEnter a number to edit student:");
                    System.out.println(
                            studentManagement.edit(
                                    studentManagement.find(studentManagement.getScannerService().getInt())
                            )
                    );
                    System.out.println("===========================");
                    break;
                case 6:
                    end = false;
                    System.out.println("===========================");
                    break;
            }
        }

        studentManagement.getScannerService().closeScanner();
        context.close();
    }
}
