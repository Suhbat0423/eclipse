import java.util.Arrays;
import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyArrayLinearList l1 = new MyArrayLinearList(10);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Add elements");
            System.out.println("2. Find the minimum element");
            System.out.println("3. Find the maximum element");
            System.out.println("4. Calculate the sum of elements");
            System.out.println("5. Remove odd elements");
            System.out.println("6. Calculate the average");
            System.out.println("7. Sort the list (High to Low)");
            System.out.println("8. Sort the list (Low to High)");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of elements to add: ");
                    int numElements = scanner.nextInt();
                    for (int i = 0; i < numElements; i++) {
                        System.out.print("Enter element " + (i + 1) + ": ");
                        int element = scanner.nextInt();
                        l1.add(0, element);
                    }
                    System.out.println("Elements added.");
                    break;

                case 2:
                    if (!l1.isEmpty()) {
                        System.out.println("Min: " + l1.min());
                    } else {
                        System.out.println("The list is empty.");
                    }
                    break;

                case 3:
                    if (!l1.isEmpty()) {
                        System.out.println("Max: " + l1.max());
                    } else {
                        System.out.println("The list is empty.");
                    }
                    break;

                case 4:
                    if (!l1.isEmpty()) {
                        System.out.println("Sum: " + l1.sum());
                    } else {
                        System.out.println("The list is empty.");
                    }
                    break;

                case 5:
                    l1.removeOdd();
                    System.out.println("Odd elements removed.");
                    break;

                case 6:
                    if (!l1.isEmpty()) {
                        System.out.println("Average: " + l1.average());
                    } else {
                        System.out.println("The list is empty.");
                    }
                    break;

                case 7:
                    l1.sortHighToLow();
                    System.out.println("Sorted High to Low: " + Arrays.toString(l1.toArray()));
                    break;

                case 8:
                    l1.sortLowToHigh();
                    System.out.println("Sorted Low to High: " + Arrays.toString(l1.toArray()));
                    break;

                case 9:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid action.");
                    break;
            }

            System.out.println("Current List: " + Arrays.toString(l1.toArray()));
        }
    }
}
