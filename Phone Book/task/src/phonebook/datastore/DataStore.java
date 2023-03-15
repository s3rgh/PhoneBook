package phonebook.datastore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataStore {

    public List<String> getStringList(String stringUrl) {
        List<String> list = new ArrayList<>();
        URL url;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String temp;
            while ((temp = bufferedReader1.readLine()) != null) {
                list.add(temp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
