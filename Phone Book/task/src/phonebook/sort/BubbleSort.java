package phonebook.sort;

import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {

    private long sortTime = 0;

    public long getSortTime() {
        return sortTime;
    }

    public List<String> sort(List<String> list, long linearSearchTime) {
        List<String> sortedList = list.stream()
                .map(e -> e.split(" ", 2)[1])
                .collect(Collectors.toList());

        long start = System.currentTimeMillis();
        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (sortedList.get(j).compareTo(sortedList.get(j + 1)) > 0) {
                    sortedList.add(j, sortedList.get(j + 1));
                    sortedList.remove(j + 2);
                    long end = System.currentTimeMillis();
                    this.sortTime = end - start;
                    if (this.sortTime > linearSearchTime * 10) {
                        return list;
                    }
                }
            }
        }
        return sortedList;
    }
}
