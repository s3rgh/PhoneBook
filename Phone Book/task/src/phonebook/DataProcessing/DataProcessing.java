package phonebook.DataProcessing;

import phonebook.create.HashTableFiller;
import phonebook.datastore.DataStore;
import phonebook.search.BinarySearch;
import phonebook.search.HashSearch;
import phonebook.search.JumpSearch;
import phonebook.search.LinearSearch;
import phonebook.sort.BubbleSort;
import phonebook.sort.QuickSort;

import java.util.Hashtable;
import java.util.List;

public class DataProcessing {

    private DataProcessing() {
    }

    public static void run(String findTxt, String directoryTxt) {
        String search = "Searching";
        String sort = "Sorting";
        String create = "Creating";
        DataStore dataStore = new DataStore();
        LinearSearch linearSearch = new LinearSearch();
        BubbleSort bubbleSort = new BubbleSort();
        JumpSearch jumpSearch = new JumpSearch();
        BinarySearch binarySearch = new BinarySearch();
        QuickSort quickSort = new QuickSort();
        HashTableFiller filler = new HashTableFiller();
        HashSearch hashSearch = new HashSearch();
        List<String> find = dataStore.getStringList(findTxt);
        List<String> directory = dataStore.getStringList(directoryTxt);

        System.out.println("\nStart searching (linear search)...");
        linearSearch.search(find, directory);
        long linearSearchTime = linearSearch.getLinearSearchTime();
        printResults(linearSearch.getCount(), find, linearSearchTime);

        System.out.println("\nStart searching (bubble sort + jump search)...");

        List<String> bubbleSortedList = bubbleSort.sort(directory, linearSearchTime);
        long bubbleSortTime = bubbleSort.getSortTime();

        if (bubbleSortTime > linearSearchTime * 10) {
            linearSearch.setCount(0);
            linearSearch.search(find, bubbleSortedList);
            long newLinearSearchTime = linearSearch.getLinearSearchTime();
            printResults(linearSearch.getCount(), find, newLinearSearchTime + bubbleSortTime);
            System.out.printf("Sorting time: %d min. %d sec. %d ms. - STOPPED, moved to linear search\n",
                    bubbleSortTime / 60000,
                    (bubbleSortTime % 60000) / 1000,
                    bubbleSortTime % 1000);

            printAction(search, newLinearSearchTime);

        } else {

            jumpSearch.search(find, bubbleSortedList);
            long jumpSearchTime = jumpSearch.getJumpSearchTime();
            printResults(jumpSearch.getCount(), find, jumpSearchTime + bubbleSortTime);
            printAction(sort, bubbleSortTime);
            printAction(search, jumpSearchTime);
        }

        System.out.println("\nStart searching (quick sort + binary search)...");
        List<String> quickSortedList = quickSort.sort(directory);
        long quickSortTime = quickSort.getSortTime();
        binarySearch.search(find, quickSortedList);
        long binarySearchTime = binarySearch.getBinarySearchTime();
        printResults(binarySearch.getCount(), find, binarySearchTime + quickSortTime);
        printAction(sort, quickSortTime);
        printAction(search, binarySearchTime);

        System.out.println("\nStart searching (hash table)...");
        Hashtable<String, Integer> table = filler.create(directory);
        long createTime = filler.getCreateTime();
        hashSearch.search(find, table);
        long hashSearchTime = hashSearch.getSearchTime();
        printResults(hashSearch.getCount(), find, createTime + hashSearchTime);
        printAction(create, createTime);
        printAction(search, hashSearchTime);
    }

    private static void printAction(String action, long binarySearchTime) {
        System.out.printf("%s time: %d min. %d sec. %d ms.\n",
                action,
                binarySearchTime / 60000,
                (binarySearchTime % 60000) / 1000,
                binarySearchTime % 1000);
    }

    private static void printResults(int count, List<String> list, long millis) {
        System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.\n",
                count,
                list.size(), 
                millis / 60000,
                (millis % 60000) / 1000,
                millis % 1000);
    }
}
