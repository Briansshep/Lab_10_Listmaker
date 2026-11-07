import java.util.Scanner;

public class SafeInput {

    /**
     *
     * @param pipe a Scanner. Open to read from System.in
     * @param prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    /**
     * Int value
     * @param pipe - Scanner
     * @param prompt
     * @return int value
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("you must enter an int:" + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Double
     * @param pipe - Scanner
     * @param prompt
     * @return
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Get int
     * @param pipe - Scanner
     * @param prompt
     * @param low
     * @param high
     * @return
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a value in range [" + low + " - " + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }
    /**
     * Get double
     * @param pipe - Scanner
     * @param prompt
     * @param low
     * @param high
     * @return
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a value in range [" + low + " - " + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Yes or No
     * @param pipe - Scanner
     * @param prompt
     * @return
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean retVal = false;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                retVal = true;
                done = true;
            } else if (response.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            } else {
                System.out.println("You must enter a Y or N: " + response);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Get string
     * @param pipe - Scanner
     * @param prompt
     * @param regExPattern
     * @return
     */
    public static String getRegExString(Scanner pipe, String prompt, String regExPattern) {
        String response = "";
        boolean gotVal = false;
        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regExPattern)) {
                gotVal = true;
            } else {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);
                System.out.println("Try again.");
            }
        } while (!gotVal);

        return response;
    }
}