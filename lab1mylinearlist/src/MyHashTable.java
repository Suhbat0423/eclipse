import dataStructures.HashTable;
import dataStructures.HashChains;
import java.util.Scanner;

public class MyHashTable extends HashTable {

    private Scanner sc = new Scanner(System.in);

    public MyHashTable(int divisor) {
        super(divisor);
    }

    public void insert() {
        try {
        	Object key, element;
            System.out.println("Түлхүүрийг оруул");
            key = sc.next();
            System.out.println("Элементийг оруул");
            element = sc.next();
            put(key, element);
            System.out.println("Нэмэгдлээ");
        } catch (Exception e) {
            System.out.println("Утга нэмхэд алдаа гарлаа: " + e.getMessage());
        }
    }

    public void MySearch(Object theKey) {
        try {
            int index = super.search(theKey);
            System.out.println(table[index].element.toString());
        } catch (Exception e) {
            System.out.println("Утга хайхад алдаа гарлаа: " + e.getMessage());
        }
    }

    public void edit() {
        try {
            System.out.println("Засах элементийн түлхүүр оруул");
            Object key = sc.next();
            System.out.println("Засах элемент оруул");
            Object element = sc.next();
            put(key, element);
            System.out.println("Элемент амжилттай засагдлаа");
        } catch (Exception e) {
            System.out.println("Элемент засахад алдаа гарлаа: " + e.getMessage());
        }
    }

    public void delete(Object theKey) {
        try {
            Object element = this.get(theKey);
            if(element != null)
            {
            	int b = this.search(theKey);
            	this.table[b] = null;
            	this.size--;
            	System.out.println("Element deleted successfully.");
            }
            
        } catch (Exception e) {
            System.out.println("Error deleting element: " + e.getMessage());
        }
    }

   

	public void menu() {
        System.out.println("1. Нэмэх");
        System.out.println("2. Хайх");
        System.out.println("3. Засах");
        System.out.println("4. Устгах");
        System.out.println("5. Гарах");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Хэш хүснэгтийн утгийг оруул");
        int divisor = sc.nextInt();
        MyHashTable myHash = new MyHashTable(divisor);

        while (true) {
            myHash.menu();
            System.out.println("Командаа оруул");
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    myHash.insert();
                    break;
                case 2:
                	System.out.println("haih tulhuuree oruul");
                    Object theKey = sc.next();
                    myHash.MySearch(theKey);
                    break;
                case 3:
                    myHash.edit();
                    break;
                case 4:
                	System.out.println("Enter the key to delete:");
                    Object keyToDelete = sc.next();
                    myHash.delete(keyToDelete);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Тухайн команд байхгүй байна.");
            }
        }
    }
}