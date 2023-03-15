package phonebook.search;

import java.util.List;

public class JumpSearch implements Searchable {

    private long jumpSearchTime = 0;
    private int count;

    public long getJumpSearchTime() {
        return jumpSearchTime;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void search(List<String> find, List<String> sortedList) {

        long begin = System.currentTimeMillis();
        for (String s : find) {

            if (sortedList.isEmpty()) {
                return;
            }

            int current = 0;
            int prev = 0;
            int jumpSize = (int) Math.floor(Math.sqrt(sortedList.size()));

            while (sortedList.get(current).compareTo(s) < 0) {
                if (current == sortedList.size() - 1) {
                    return;
                }
                prev = current;
                current = Math.min(current + jumpSize, sortedList.size() - 1);
            }

            while (sortedList.get(current).compareTo(s) > 0) {
                current = current - 1;
                if (current <= prev) {
                    return;
                }
            }

            if (s.equals(sortedList.get(current))) {
                this.count = this.count + 1;
            }
        }
        jumpSearchTime = System.currentTimeMillis() - begin;
    }
}
