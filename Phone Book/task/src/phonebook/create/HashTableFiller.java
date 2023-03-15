package phonebook.create;

import java.util.Hashtable;
import java.util.List;

public class HashTableFiller {
    private long createTime = 0;

    public long getCreateTime() {
        return createTime;
    }

    public Hashtable<String, Integer> create(List<String> directory) {
        long start = System.currentTimeMillis();
        Hashtable<String, Integer> table = new Hashtable<>(directory.size() * 2);

        for (String s : directory) {
            table.put(s.split(" ", 2)[1], Integer.parseInt(s.split(" ", 2)[0]));
        }

        this.createTime = System.currentTimeMillis() - start;
        return table;
    }
}
