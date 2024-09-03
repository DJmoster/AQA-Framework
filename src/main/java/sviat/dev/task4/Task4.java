package sviat.dev.task4;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
* a) Create a thread pool with a fixed number of threads using Executors and submit a task to the pool.
* b) Create your own custom class with annotations, and make an object for it. Use getAnnotations() to print out all the annotations of the class. Use getMethod() to get a specific method and print out all its annotations.
* c) Create a generic class that can store a list of elements of any type, and add elements to it using List<T> and add().
*/
public class Task4 {

    public static void main(String[] args) {

        System.out.println("Task A:");
        createThreadPoolTask();

        System.out.println("\nTask B:");
        printClassAndMethodAnnotations();

        System.out.println("\nTask C");
        genericList();

    }

    public static void createThreadPoolTask() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> System.out.println(Thread.currentThread().getName()));
        executor.submit(() -> System.out.println(Thread.currentThread().getName()));
        executor.submit(() -> System.out.println(Thread.currentThread().getName()));

        executor.shutdown();
    }

    public static void printClassAndMethodAnnotations() {
        AnnotationsTest annotationsTest = new AnnotationsTest();

        System.out.println(Arrays.toString(annotationsTest.getClass().getAnnotations()));

        try {
            Method method = annotationsTest.getClass().getMethod("foo");
            System.out.println(Arrays.toString(method.getAnnotations()));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void genericList() {
        GenericListTest<String> list1 = new GenericListTest<>();

        list1.add("Test 1");
        list1.add(Arrays.asList("Test 2", "Test 3"));

        System.out.println(list1);

        GenericListTest<Double> list2 = new GenericListTest<>();

        list2.add(22.1);
        list2.add(Arrays.asList(2.0, 3.0));

        System.out.println(list2);
    }
}
