import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MainMethod2 {
    public static void main(String[] args) {
        String filePath = "C:/Users/svhba/Desktop/python/random_numbers.txt";

        MyChain ch1 = new MyChain();
        MyChain ch2 = new MyChain();

        readAndSplitFile(filePath, ch1, ch2);

        System.out.println("ch1: " + Arrays.toString(ch1.toArray()));
        System.out.println("ch2: " + Arrays.toString(ch2.toArray()));

        MyChain sortedCh1 = sortList(ch1);
        MyChain sortedCh2 = sortList(ch2);

        MyChain intersectCh = findIntersectionSorted(sortedCh1, sortedCh2);
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

    private static MyChain sortList(MyChain chain) {
        Object[] arr = chain.toArray();
        Arrays.sort(arr);

        MyChain sortedChain = new MyChain();
        sortedChain.addRange(arr);

        return sortedChain;
    }

    private static MyChain findIntersectionSorted(MyChain sortedCh1, MyChain sortedCh2) {
        MyChain intersectCh = new MyChain();
        int i = 0;
        int j = 0;

        while (i < sortedCh1.size() && j < sortedCh2.size()) {
            int val1 = (int) sortedCh1.get(i);
            int val2 = (int) sortedCh2.get(j);

            if (val1 == val2) {
                intersectCh.add(intersectCh.size(), val1);
                i++;
                j++;
            } else if (val1 < val2) {
                i++;
            } else {
                j++;
            }
        }

        return intersectCh;
    }
}
