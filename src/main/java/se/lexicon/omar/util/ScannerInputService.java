package se.lexicon.omar.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {

    private Scanner scanner;

    @Autowired
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        String inputString = null;
        boolean isTrue = true;
        while (isTrue) {
            try {
                scanner = new Scanner(System.in);
                inputString = scanner.nextLine();
                isTrue = false;
            } catch (Exception ex) {
                System.out.print("Error. Re-enter:");
            }
        }
        return inputString;
    }

    @Override
    public int getInt() {
        int inputInteger = 0;
        boolean isTrue = true;
        while (isTrue) {
            try {
                scanner = new Scanner(System.in);
                inputInteger = scanner.nextInt();
                isTrue = false;
            } catch (Exception ex) {
                System.out.print("Error. Re-enter:");
            }
        }
        return inputInteger;
    }

    @Override
    public void closeScanner() {
        scanner.close();
    }

}
