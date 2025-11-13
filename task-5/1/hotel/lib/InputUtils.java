package hotel.lib;

import java.util.Scanner;

public class InputUtils {
    private final static Scanner in = new Scanner(System.in);

    public static int readInt(String prompt) {
        System.out.print(prompt);
        return in.nextInt();
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        in.nextLine();
        return in.nextLine();
    }

    public static float readFloat(String prompt) {
        System.out.print(prompt);
        return in.nextFloat();
    }

    public static double readDouble(String prompt) {
        System.out.print(prompt);
        return in.nextDouble();
    }
}