/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package edu.neu.coe.info6205.sort.simple;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Config;

public class InsertionSort<X extends Comparable<X>> extends SortWithHelper<X> {

    /**
     * Constructor for any sub-classes to use.
     *
     * @param description the description.
     * @param N           the number of elements expected.
     * @param config      the configuration.
     */
    protected InsertionSort(String description, int N, Config config) {
        super(description, N, config);
    }

    /**
     * Constructor for InsertionSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public InsertionSort(int N, Config config) {
        this(DESCRIPTION, N, config);
    }

    public InsertionSort() {
        this(new BaseHelper<>(DESCRIPTION));
    }

    /**
     * Constructor for InsertionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public InsertionSort(Helper<X> helper) {
        super(helper);
    }

    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public void sort(X[] xs, int from, int to) {
        long startTime = System.nanoTime();
        final Helper<X> helper = getHelper();
        for (from = 0; from < to; from++) {
            X temp = (X) xs[from];
            int leftindex = from - 1;
            while (leftindex >= 0 && ((Integer) xs[leftindex]) > (Integer) temp) {
                helper.swap(xs, leftindex + 1, leftindex);
                leftindex--;
            }
            xs[leftindex + 1] = temp;
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) + "ns");
    }

    public static Integer[] gennerateArray(int len, int max) {
        Integer[] arr = new Integer[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] array = gennerateArray(10, 10);
        Integer[] array1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] array2 = new Integer[]{1, 2, 3, 9, 5, 6, 7, 8, 10,4};
        Integer[] array3 = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        InsertionSort<Integer> sort = new InsertionSort<>();
        System.out.print("random cost :");
        sort.sort(array, 0, array.length);
        InsertionSort<Integer> sort2 = new InsertionSort<>();
        System.out.print("ordered cost :");
        sort2.sort(array1, 0, array1.length);
        InsertionSort<Integer> sort3 = new InsertionSort<>();
        System.out.print("partially-ordered cost :");
        sort3.sort(array2, 0, array2.length);
        InsertionSort<Integer> sort4 = new InsertionSort<>();
        System.out.print("reverse-ordered cost :");
        sort4.sort(array3, 0, array3.length);

    }

    /**
     * This is used by unit tests.
     *
     * @param ys  the array to be sorted.
     * @param <Y> the underlying element type.
     */
    public static <Y extends Comparable<Y>> void mutatingInsertionSort(Y[] ys) {
        new InsertionSort<Y>().mutatingSort(ys);
    }

    public static final String DESCRIPTION = "Insertion sort";

}
