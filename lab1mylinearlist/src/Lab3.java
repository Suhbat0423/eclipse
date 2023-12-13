import java.util.Scanner;
import java.util.Arrays;

public class Lab3 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display Stack");
            System.out.println("4. Unique Elements");
            System.out.println("5. Add Elements Range");
            System.out.println("6. Check Element Existence");
            System.out.println("7. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    Object element = scanner.next();
                    stack.push(element);
                    System.out.println("Element pushed onto the stack.");
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        Object poppedElement = stack.pop();
                        System.out.println("Popped element: " + poppedElement);
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 3:
                    Object[] stackArray = stack.toArray();
                    System.out.println("Stack contents: " + Arrays.toString(stackArray));
                    break;
                case 4:
                    MyStack uniqueStack = stack.unique();
                    Object[] uniqueArray = uniqueStack.toArray();
                    System.out.println("Unique Elements: " + Arrays.toString(uniqueArray));
                    break;
                case 5:
                    System.out.print("Enter the number of elements to add: ");
                    int numElements = scanner.nextInt();
                    Object[] elementsToAdd = new Object[numElements];
                    for (int i = 0; i < numElements; i++) {
                        System.out.print("Enter element " + (i + 1) + ": ");
                        elementsToAdd[i] = scanner.next();
                    }
                    stack = stack.addRange(elementsToAdd);
                    System.out.println("Elements added to the stack.");
                    break;
                case 6:
                    System.out.print("Enter the element to check: ");
                    Object elementToCheck = scanner.next();
                    boolean exists = stack.exists(elementToCheck);
                    if (exists) {
                        System.out.println("Element exists in the stack.");
                    } else {
                        System.out.println("Element exists in the stack.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid operation.");
            }
        }
    }
}
