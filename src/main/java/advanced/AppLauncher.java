package advanced;

import java.util.Scanner;

/**
 * @author Evgenii_Lartcev (created on 10/10/2016).
 */
public class AppLauncher {
    public static void main(String[] args) {
        final String[] strings = {};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which program would you run? Please, press a key as shown below:");
        System.out.println("1 - Map With Feautures");
        System.out.println("2 - View to EPAM by satellite");
        int numOfProgram = scanner.nextInt();
        System.out.println("The start process may be getting some time....");
        switch (numOfProgram) {
            case 1: MapWithFeautures.main(strings);
                break;
            case 2: ViewToEPAM.main(strings);
                break;
        }

    }
}
