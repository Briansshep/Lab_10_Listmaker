import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> arrayList = new ArrayList<>();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean done = false;
        String cmd;

        do {
            displayList();
            displayMenu();
            cmd = SafeInput.getRegExString(in, "Choose an option", "[AaDdIiPpQq]");

            switch (cmd.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    done = quitProgram();
                    break;
            }
        } while (!done);

        System.out.println("Goodbye.");
    }

    private static void displayList() {
        System.out.println("\n=== Current List ===");
        if (arrayList.size() == 0) {
            System.out.println("(The list is empty)");
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.printf("%3d. %s%n", i + 1, arrayList.get(i));
            }
        }
        System.out.println("====================");
    }

    private static void displayMenu() {
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I = Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item you want to add");
        arrayList.add(item);
    }

    private static void deleteItem() {
        if (arrayList.size() == 0) {
            System.out.println("The list is empty. There is nothing to delete.");
            return;
        }
        int num = SafeInput.getRangedInt(in, "Enter the number of the item you want to delete", 1, arrayList.size());
        String removed = arrayList.remove(num - 1);
        System.out.println("Deleted: " + removed);
    }

    private static void insertItem() {
        int num = SafeInput.getRangedInt(in, "Enter the location number to insert at", 1, arrayList.size() + 1);
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
        arrayList.add(num - 1, item);
    }

    private static void printList() {
        displayList();
    }

    private static boolean quitProgram() {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
    }
}
