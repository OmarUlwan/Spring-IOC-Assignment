package se.lexicon.omar.data_access;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.omar.service.StudentManagementConsoleImpl;
import se.lexicon.omar.util.ScannerInputService;

import java.util.Scanner;

@Configuration()
@ComponentScan(basePackages = {"se.lexicon.omar.data_access","se.lexicon.omar.util"})
public class ComponentScanConfig {

    @Bean
    public Scanner newScanner(){
        return new Scanner(System.in);
    }

    @Bean
    public StudentManagementConsoleImpl StudentManagementConsoleImpl(){
        return new StudentManagementConsoleImpl(
                new ScannerInputService(),
                new StudentDaoListImpl()
        );
    }

}
