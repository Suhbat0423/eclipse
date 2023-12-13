import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        MyChain mc = new MyChain();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add element to MyChain");
            System.out.println("2. Display elements in MyChain");
            System.out.println("3. Find intersection with another MyChain");
            System.out.println("4. Find union with another MyChain");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter an element to add: ");
                    int element = scanner.nextInt();
                    mc.add(mc.size(), element);
                    break;
                case 2:
                    System.out.println("Elements in MyChain:");
                    Object[] elements = mc.toArray();
                    for (Object obj : elements) {
                        System.out.println(obj);
                    }
                    break;
                case 3:
                    MyChain mlist = new MyChain();
                    System.out.print("Enter elements for the second MyChain (space-separated): ");
                    String input = scanner.nextLine();
                    input = scanner.nextLine();
                    String[] elementsArray = input.split(" ");
                    for (String elementStr : elementsArray) {
                        mlist.add(mlist.size(), Integer.parseInt(elementStr));
                    }
                    MyChain intersection = mc.intersect(mlist);
                    System.out.println("Intersection of MyChain and the second MyChain:");
                    Object[] intersectionElements = intersection.toArray();
                    for (Object obj : intersectionElements) {
                        System.out.println(obj);
                    }
                    break;
                case 4:
                    MyChain anotherChain = new MyChain();
                    System.out.print("Enter elements for the second MyChain (space-separated): ");
                    String inputUnion = scanner.nextLine(); 
                    inputUnion = scanner.nextLine();
                    String[] elementsArrayUnion = inputUnion.split(" ");
                    for (String elementStr : elementsArrayUnion) {
                        anotherChain.add(anotherChain.size(), Integer.parseInt(elementStr));
                    }
                    MyChain union = mc.union(anotherChain);
                    System.out.println("Union of MyChain and the second MyChain:");
                    Object[] unionElements = union.toArray();
                    for (Object obj : unionElements) {
                        System.out.println(obj);
                    }
                    break;
                case 5:
                	System.out.println(mc.size());
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}
