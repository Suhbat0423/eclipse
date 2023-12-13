import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:/Users/svhba/Desktop/python/random_numbers.txt";
        
        MyChain ch1 = new MyChain();
        MyChain ch2 = new MyChain();

        readAndSplitFile(filePath, ch1, ch2);

        System.out.println("ch1: " + Arrays.toString(ch1.toArray()));
        System.out.println("ch2: " + Arrays.toString(ch2.toArray()));

        MyChain intersectCh = findIntersectionBruteForce(ch1, ch2);
        System.out.println("Intersection: " + Arrays.toString(intersectCh.toArray()));
    }

    private static void readAndSplitFile(String filename, MyChain ch1, MyChain ch2) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());

                if (count < 25000) {
                    ch1.add(ch1.size(), number);
                } else {
                    ch2.add(ch2.size(), number);
                }

                count++;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static MyChain findIntersectionBruteForce(MyChain ch1, MyChain ch2) {
        MyChain intersectCh = new MyChain();
        int k = 0;

        for (int i = 0; i < ch1.size(); i++) {
            for (int j = 0; j < ch2.size(); j++) {
                if ((int) ch1.get(i) == (int) ch2.get(j)) {
                    intersectCh.add(k, ch1.get(i));
                    k++;
                }
            }
        }

        return intersectCh;
    }
}
