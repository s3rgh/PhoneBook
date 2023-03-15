package phonebook.search;

import java.util.Hashtable;
import java.util.List;

public class HashSearch {
    private long searchTime = 0;
    private int count = 0;

    public long getSearchTime() {
        return searchTime;
    }

    public int getCount() {
        return count;
    }

    public void search(List<String> find, Hashtable<String, Integer> table) {
        long start = System.currentTimeMillis();

        for (String s : find) {
            if (table.get(s) != null) {
                count++;
            }
        }
        this.searchTime = System.currentTimeMillis() - start;
    }
}
