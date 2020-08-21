package binarysearch;

public class BinarySearchDemo {
    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();

        /*int[] arr = {1, 3, 10, 50, 70, 100};
        int resultIndex = binarySearch(arr, 5, 0, arr.length - 1);
        System.out.println(resultIndex);*/

        /*int[] arr2 = {1, 3, 3, 3, 10, 50, 70, 100};;
        ArrayList<Integer> resultList = binarySearch.binarySearch2(arr2, 3, 0, arr2.length - 1);
        if (resultList != null) {
            for (Integer i: resultList) {
                System.out.println(i);
            }
        } else {
            System.out.println("没找到");
        }*/

        int[] arr = {1, 3, 10, 33, 50, 70, 100};
        int index = binarySearch.binarySearch(arr, 200);
        System.out.println(index);


    }
}
