package util;

import java.util.Scanner;

public class InputUtils {

    private static Scanner sc = new Scanner(System.in);

    public static int inputInteger(String valueName) {
        while (true) {
            try {
                System.out.print(String.format(
                        "Please enter the value for %s: ", valueName));
                int input = Integer.parseInt(sc.nextLine());
                return input;
            } catch (Exception e) {
                System.out.println(String.format(
                        "Invalid %s! Please re-do.", valueName));
            }
        }
    }

    public static int inputInteger(String valueName, int min, int max) {
        while (true) {
            try {
                System.out.print(String.format(
                        "Please enter the value for %s: ", valueName));
                int input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) {
                    throw new IllegalArgumentException();
                }
                return input;
            } catch (Exception e) {
                System.out.println(String.format(
                        "Invalid %s! Please re-do.", valueName));
            }
        }
    }

    public static int inputPositiveInteger(String valueName) {
        while (true) {
            try {
                System.out.print(String.format(
                        "Please enter the value for %s: ", valueName));
                int input = Integer.parseInt(sc.nextLine());
                if (input < 0) {
                    throw new IllegalArgumentException();
                }
                return input;
            } catch (Exception e) {
                System.out.println(String.format(
                        "Invalid %s! Please re-do.", valueName));
            }
        }
    }

    public static String inputNonEmptyString(String valueName) {
        while (true) {
            System.out.print(String.format(
                    "Please enter the value for %s: ", valueName));
            String input = sc.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.out.println(String.format(
                    "Invalid %s! Please re-do.", valueName));

        }
    }

}
