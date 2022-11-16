package Utils;

import java.util.Scanner;

public class CustomerInputUtil {

    public static String takeCustomerInput() {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
    }
}
