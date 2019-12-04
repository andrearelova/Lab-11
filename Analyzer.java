public class Analyzer {
    public static void main(String args[]) {
        double beginTime;
        double endTime;
        double totalTime;
        StringData myData = new StringData();
        String[] dataSet = myData.getData();
        String[] element = {"not_here", "mzzzz", "aaaaa"};

        for (int i = 0; i < element.length; ++i) {
            //linear search
            beginTime = System.nanoTime();
            linearSearch(dataSet, element[i]);
            endTime = System.nanoTime();
            totalTime = endTime - beginTime;
            System.out.println("\"" + element[i] + "\" linear search time: " + totalTime);

            //binary search
            beginTime = System.nanoTime();
            binarySearch(dataSet, element[i]);
            endTime = System.nanoTime();
            totalTime = endTime - beginTime;
            System.out.println("\"" + element[i] + "\" binary search time: " + totalTime);
        }
    }

    public static int linearSearch(String[] dataSet, String element) {
        int i;
        for (i = 0; i < dataSet.length; ++i) {
            if (dataSet[i].equals(element)) {
                return i;
            }
        }
        return -1; //if not found
        /* Title: <LinearSearch>
           Author: <Lysecky and Lizarraga>
           Date: <Copyright 2019, accessed 11/6/2019>
           Code version: <Java>
           Availability: Zybooks, Programming in Java, Section 9.6
           Link: <https://learn.zybooks.com/zybook/UFLCOP3502ZhouFall2019/chapter/9/section/6>
         */
    }

    public static int binarySearch(String[] dataSet, String element) {
        int mid;
        int low = 0;
        int high = dataSet.length - 1;

        while (high >= low) {
            mid = (high + low) / 2;
            if (dataSet[mid].compareTo(element) < 0) { //if dataSet[mid] is lexicographically smaller than element
                low = mid + 1;
            }
            else if (dataSet[mid].compareTo(element) > 0) { //if dataSet[mid] is lexicographically bigger
                high = mid - 1;
            }
            else { //if found
                return mid;
            }
        }
        return -1; //if not found
        /* Title: <BinarySearch>
           Author: <Lysecky and Lizarraga>
           Date: <Copyright 2019, accessed 11/6/2019>
           Code version: <Java>
           Availability: Zybooks, Programming in Java, Section 9.6
           Link: <https://learn.zybooks.com/zybook/UFLCOP3502ZhouFall2019/chapter/9/section/7>
         */
    }
}
