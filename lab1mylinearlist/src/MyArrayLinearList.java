import dataStructures.ArrayLinearList;


public class MyArrayLinearList extends ArrayLinearList {

    public MyArrayLinearList(int initialCapacity) {
        super(initialCapacity);
    }
    
    public MyArrayLinearList() {
        super(10);
    }
    
    public MyArrayLinearList(MyArrayLinearList mylist) {
        super(mylist.size());
        for (int i = 0; i < mylist.size(); i++) {
            this.add(i, mylist.element[i]);
        }
    }
    
    public MyArrayLinearList reverse() {
        MyArrayLinearList temp = new MyArrayLinearList(this.size());
        int j = 0;
        for (int i = this.size() - 1; i >= 0; i--) {
            temp.add(j++, this.element[i]);
        }
        return temp;
    }

    public int min() {
        int minValue = (int) this.get(0);
        for (int i = 1; i < this.size(); i++) {
            int currentValue = (int) this.get(i);
            if (currentValue < minValue) {
                minValue = currentValue;
            }
        }
        return minValue;
    }

    public int max() {
        int maxValue = (int) this.get(0);
        for (int i = 1; i < this.size(); i++) {
            int currentValue = (int) this.get(i);
            if (currentValue > maxValue) {
                maxValue = currentValue;
            }
        }
        return maxValue;
    }

    public int sum() {
        int total = 0;
        for (int i = 0; i < this.size(); i++) {
            int currentValue = (int) this.get(i);
            total += currentValue;
        }
        return total;
    }

    public double average() {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return (double) this.sum() / this.size();
    }

    public void removeOdd() {
        int i = 0;
        while (i < this.size()) {
            int currentValue = (int) this.get(i);
            if (currentValue % 2 != 0) {
                this.remove(i);
            } else {
                i++;
            }
        }
    }

    public void sortHighToLow() {
        int n = size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((int) element[j] < (int) element[j + 1]) {
                    int temp = (int) element[j];
                    element[j] = element[j + 1];
                    element[j + 1] = temp;
                }
            }
        }
    }

    public void sortLowToHigh() {
        int n = size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((int) element[j] > (int) element[j + 1]) {
                    int temp = (int) element[j];
                    element[j] = element[j + 1];
                    element[j + 1] = temp;
                }
            }
        }
    }

    public Object[] toArray() {
        Object[] arr = new Object[size()];
        for (int i = 0; i < size(); i++) {
            arr[i] = element[i];
        }
        return arr;
    }
    
    

}
