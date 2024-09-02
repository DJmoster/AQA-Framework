package sviat.dev.task3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
* V6.
* Array Intersection: Write a Java program that takes two arrays of integers and finds their intersection.
* Your program should prompt the user to enter the size and the elements of both arrays and then output the common elements between them.
* Make HashSet of doubles from the result array and perform the following operations:
* a)Add an element to the end of the list;
* b)Remove an element from the list;
* c)Replace an element in the list;
* d)Sort the list in alphabetical order;
* e)Print the elements of the list;
* Make up the situation for NumberFormatException.
* Catch it and display the explanation for your custom case.
* */
public class Task3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter size of first array: ");
        int arr1Size = 0;

        // NumberFormatException situation
        try {
            // If user entered string that contains
            // numbers with letters or other chars
            // it will cause error NumberFormatException
            arr1Size = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        System.out.println("Enter size of second array: ");
        int arr2Size = in.nextInt();

        System.out.println("Enter elements for first array: ");
        Integer[] arr1 = getArraysFromUser(in, arr1Size);

        System.out.println("Enter elements for second array: ");
        Integer[] arr2 = getArraysFromUser(in, arr2Size);

        Set<Double> result = Stream.of(findArraysIntersection(arr1, arr2))
                .map(Integer::doubleValue)
                .collect(Collectors.toCollection(HashSet::new));

        result.add(3.6);
        result.remove(3.6);

        // Replace element
        result.add(10.1);
        if(result.remove(10.1))
            result.add(1.1);

        // Sort in alphabetical order
        TreeSet<Double> resultSorted = new TreeSet<>(result);

        System.out.println(resultSorted);
    }

    public static Integer[] getArraysFromUser(Scanner in, int arrSize) {
        Integer[] arr = new Integer[arrSize];
        for(int i = 0; i < arrSize; i++) {
            System.out.println("Arr[" + i + "]: ");
            arr[i] = in.nextInt();
        }

        return arr;
    }

    public static Integer[] findArraysIntersection(Integer[] arr1, Integer[] arr2) {
        return Stream.of(arr1)
                .filter(Arrays.asList(arr2)::contains)
                .toArray(Integer[]::new);
    }
}
