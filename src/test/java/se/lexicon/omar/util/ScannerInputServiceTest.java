package se.lexicon.omar.util;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.omar.data_access.ComponentScanConfig;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class ScannerInputServiceTest {

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ComponentScanConfig.class);

    //@Bean("scannerInputService")
    UserInputService userInputService = context.getBean(UserInputService.class);


    @Test
    public void getIntTEST() {

        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(5, userInputService.getInt());
    }

    @Test
    public void getStringTEST() {
        String input = "studentName";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("studentName", userInputService.getString());
    }
}
