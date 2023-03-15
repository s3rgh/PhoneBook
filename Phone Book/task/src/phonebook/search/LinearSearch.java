package phonebook.search;

import java.util.List;
import java.util.stream.Collectors;

public class LinearSearch implements Searchable {

    private long linearSearchTime = 0;
    private int count = 0;

    public long getLinearSearchTime() {
        return linearSearchTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void search(List<String> find, List<String> target) {
        long start = System.currentTimeMillis();

        List<String> sortedList = target.stream()
                .map(e -> e.split(" ", 2)[1])
                .collect(Collectors.toList());

        for (String s : find) {
            for (int j = 0; j < target.size(); j++) {
                if (sortedList.get(j).equals(s)) {
                    this.count++;
                    break;
                }
            }
        }

        long end = System.currentTimeMillis();
        this.linearSearchTime = end - start;
    }
}
