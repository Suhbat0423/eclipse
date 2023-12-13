import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dataStructures.ArrayStack;

public class carParking extends ArrayStack {

    private ArrayStack temppark;

    public carParking() {
        super(10);
        temppark = new ArrayStack(10);
    }

    public void input(String number) {
        if (this.top == this.stack.length - 1) {
            System.out.println("Arrival " + number + " -> Garage full, this car cannot enter.");
        } else {
            this.push(number);
            System.out.println("Arrival " + number + " -> There is room.");
        }
    }

    public void output(String number) {
        if (this.empty()) {
            System.out.println("Departure " + number + " -> This car not in the garage.");
        } else {
            this.process(number);
        }
    }

    public void process(String number) {
        int k = 0;
        while (!this.empty()) {
            if (!this.peek().equals(number)) {
                temppark.push(this.pop());
                k++;
            } else {
                break;
            }
        }
        if (this.empty()) {
            System.out.println("Departure " + number + " -> This car not in the garage.");
        } else {
            System.out.println("Departure " + number + " -> " + k + " cars moved out.");
        }
        while (!temppark.empty()) {
            this.push(temppark.pop());
        }
        if (k > 0 && k <= this.top) {
            System.out.println(number + " Dugaartai mashin butsaad zogsool ru orov");
        }
    }

    public static void main(String[] args) {
        carParking cp = new carParking();

        try {
            Scanner sc = new Scanner(new File("C:/Users/svhba/Desktop/cars.txt"));

            while (sc.hasNext()) {
                String[] inputLine = sc.nextLine().split(" ");
                if (inputLine[0].equals("A")) {
                    cp.input(inputLine[1]);
                } else {
                    cp.output(inputLine[1]);
                }
            }

            sc.close(); // Close the scanner after use
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
