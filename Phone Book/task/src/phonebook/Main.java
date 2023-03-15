package phonebook;


import static phonebook.DataProcessing.DataProcessing.run;

public class Main {

    public static final String FIND_TXT = "https://stepik.org/media/attachments/lesson/197761/find.txt";
    public static final String DIRECTORY_TXT = "https://stepik.org/media/attachments/lesson/197761/directory.txt";

    public static void main(String[] args) {
        run(FIND_TXT, DIRECTORY_TXT);
    }
}
