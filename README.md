# Learning outcomes
You will learn a variety of sorting and search algorithms, one of which is recursive. If it is algorithm competence that you’re after, this project is definitely for you.

You suddenly remember you need to call your aunt and wish her a happy birthday, but how do you find her number quickly in a giant phonebook? Write a program that will solve this problem once and forever: create a phonebook where you can easily, quickly and efficiently find necessary information. Names and numbers, here we come.

## Stage 1/4: A needle in the hay

#### Description
Have you ever had to use one of those 2000-plus page phone books full of all kinds of organizations and people's names printed in a small font in multiple columns on each page? Finding the information you need in such books can be an ordeal. As a matter of fact, searching through huge data sets may be a challenging task for a computer, too.

In this project, you will create a phone book; you will implement several sorting and searching algorithms and compare their efficiency in dealing with a big dataset. For this, you will need to download the file [directory.txt](https://stepik.org/media/attachments/lesson/197761/directory.txt) that contains the phone numbers of over a million people in multiple cities.

#### Objectives
In this stage, you should implement the simplest possible search to find the numbers of a few people whose names are listed in the file [find.txt](https://stepik.org/media/attachments/lesson/197761/find.txt). The data is randomly sorted, so we should use a Linear Search to look through each of the directory entries until we find our target. While there may be faster ways to do this, avoid using optimizations like Maps in this stage - we'll get to optimizing in later stages.

It takes a time to find all the records from the big file. We recommend you manually test your program with the simplified data: [small_directory.txt](https://stepik.org/media/attachments/lesson/210117/small_directory.txt) and [small_find.txt](https://stepik.org/media/attachments/lesson/210117/small_find.txt). However, to pass all the tests, you will have to work with the big files mentioned above.

Note how long it takes you to do this when using a linear search so that you can compare results with other search methods.

To measure the time difference, you can use `System.currentTimeMillis()`.

Also notice that you don't need to read the file "directory.txt" again and again after each query. You should load all lines into memory and measure only the search process.

Your program should output a message to show it has started searching, followed by a message stating how many entries out of the total number of targets in find.txt you were able to find along with the time taken to search for those entries (see example below).

Please, do not keep the downloaded files inside your project directory because the server can reject large files and you will see the message **"Failed to post submission to the Hyperskill"**.

#### Example
Below is an example of how your output should look:

```java
Start searching...
Found 500 / 500 entries. Time taken: 1 min. 56 sec. 328 ms.
```


## Stage 2/4: Jumping bubbles

#### Description
You have to iterate over each element of the number list every time you want to find someone's number. This is the only way to search if your list contains unordered data. Any number can be anywhere on the list, so you have to check every element.

Now, let's try sorting the contents of the phone list and performing a different kind of search. Let's see if this search algorithm is more efficient.

#### Objectives
In this stage, you should sort the list of numbers alphabetically by the owner’s name. Sort the list using the **bubble sort** algorithm and search in the list using the **jump search** algorithm.

After sorting, search for 500 phone numbers using the list from the previous stage. Note how long it takes to sort the list, and also measure the time the program spends searching. Don't include the sorting time in the searching time, because the list of numbers stays sorted after every search request. If you want to save the sorted list into the file so you don’t have to sort it again, do not override the file that contains the unsorted list of phone numbers. This file will also be required in the next stage.

If the sorting process takes too long (more than 10 times longer than all 500 iterations of the linear search), you should stop sorting and use the linear search.

Output both approaches one after another and see which one is faster.

Look at the examples to see what your output should look like.

#### Example
The output example is shown below. Note that you can get totally different sorting and searching times!

#### Example 1:
```
Start searching (linear search)...
Found 500 / 500 entries. Time taken: 1 min. 56 sec. 328 ms.

Start searching (bubble sort + jump search)...
Found 500 / 500 entries. Time taken: 9 min. 15 sec. 291 ms.
Sorting time: 8 min. 45 sec. 251 ms.
Searching time: 0 min. 30 sec. 40 ms.
```

#### Example 2:
```
Start searching (linear search)...
Found 500 / 500 entries. Time taken: 2 min. 01 sec. 134 ms.

Start searching (bubble sort + jump search)...
Found 500 / 500 entries. Time taken: 22 min. 14 sec. 482 ms.
Sorting time: 20 min. 12 sec. 251 ms. - STOPPED, moved to linear search
Searching time: 2 min. 02 sec. 231 ms.
```


## Stage 3/4: Need for speed

### Description
Now, let's use even faster methods to sort the list of numbers and to search in the list. In this stage, we will compare the efficiency of all three approaches.

### Objectives
Like in the previous stage, you should first sort the list of phone numbers by the owner’s name and then search for the numbers of the 500 people from the list given in the first stage. Remember: to get decent and comparable results, you should put all the algorithms in the same initial conditions.

For sorting, use the quick sort algorithm, and for searching, the binary search algorithm.

Output all three approaches one after another and see which one is faster.

### Example
The output example is shown below. Note that you can get totally different sorting and searching times!

```
Start searching (linear search)...
Found 500 / 500 entries. Time taken: 1 min. 56 sec. 328 ms.

Start searching (bubble sort + jump search)...
Found 500 / 500 entries. Time taken: 9 min. 15 sec. 291 ms.
Sorting time: 8 min. 45 sec. 251 ms.
Searching time: 0 min. 30 sec. 40 ms.

Start searching (quick sort + binary search)...
Found 500 / 500 entries. Time taken: 1 min. 21 sec. 996 ms.
Sorting time: 1 min. 17 sec. 381 ms.
Searching time: 0 min. 4 sec. 615 ms.
```


## Stage 4/4: Instant search

### Description
The search is pretty fast, but is it possible to come up with something even faster? Let's try an algorithm with better complexity.

### Objectives
In the previous stage, you prepared the data using an algorithm with a complexity of `O(n log n)` and found the data using an algorithm with a complexity of `O(log n)`. At this stage, you will implement faster data preparation and a faster search. The preparation will have a complexity of `O(n)`, and the search will have a complexity of `O(1)`. A hash table will help you with this.

You need to add all the elements to the hash table and then find the necessary phone numbers, as in the previous stages. Since the hash table is filled once, you need to measure the hash table creation time separately (just like you did with sorting in the previous stage).

Output all four approaches one after another and see which one is faster.

### Example
The output example is shown below. Note that you can get totally different sorting and searching times!
```
Start searching (linear search)...
Found 500 / 500 entries. Time taken: 1 min. 56 sec. 328 ms.

Start searching (bubble sort + jump search)...
Found 500 / 500 entries. Time taken: 9 min. 15 sec. 291 ms.
Sorting time: 8 min. 45 sec. 251 ms.
Searching time: 0 min. 30 sec. 40 ms.

Start searching (quick sort + binary search)...
Found 500 / 500 entries. Time taken: 1 min. 21 sec. 996 ms.
Sorting time: 1 min. 17 sec. 381 ms.
Searching time: 0 min. 4 sec. 615 ms.

Start searching (hash table)...
Found 500 / 500 entries. Time taken: 0 min. 4 sec. 256 ms.
Creating time: 0 min. 4 sec. 121 ms.
Searching time: 0 min. 0 sec. 135 ms.
```