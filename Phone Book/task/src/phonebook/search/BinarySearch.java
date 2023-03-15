package phonebook.search;

import java.util.List;

public class BinarySearch implements Searchable {
    private long binarySearchTime = 0;
    private int count;

    public long getBinarySearchTime() {
        return binarySearchTime;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void search(List<String> find, List<String> sortedList) {
        long start = System.currentTimeMillis();

        for (String s : find) {
            int left = 0;
            int right = sortedList.size() - 1;

            while (left <= right) {
                int middle = (left + right) / 2;
                if (sortedList.get(middle).equals(s)) {
                    count++;
                    break;
                } else if (sortedList.get(middle).compareTo(s) > 0) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        long end = System.currentTimeMillis();
        this.binarySearchTime = end - start;
    }
}
