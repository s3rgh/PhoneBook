package phonebook.sort;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {

    private long sortTime = 0;

    public long getSortTime() {
        return sortTime;
    }

    public List<String> sort(List<String> source) {
        List<String> sortedList = source.stream()
                .map(e -> e.split(" ", 2)[1])
                .collect(Collectors.toList());

        long start = System.currentTimeMillis();
        quickSort(sortedList, 0, source.size() - 1);
        this.sortTime = System.currentTimeMillis() - start;
        return sortedList;
    }

    private static void quickSort(List<String> source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        String pivot = source.get((leftMarker + rightMarker) / 2);

        do {
            while (source.get(leftMarker).compareTo(pivot) < 0) {
                leftMarker++;
            }
            while (source.get(rightMarker).compareTo(pivot) > 0) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    swap(source, rightMarker, leftMarker);
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }

    private static void swap(List<String> list, int rightIndex, int leftIndex) {
        Collections.swap(list, leftIndex, rightIndex);
    }
}
