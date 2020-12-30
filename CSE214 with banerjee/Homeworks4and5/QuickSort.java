package com.company;
//Ethan Garcia 112752608

import java.util.List;

/**
 * This class provides the algo for Quick sort, a kind of divide-and-conquer sorting. In quicksort, we arbitrarily pick
 * a pivot element, we partition the array such that the pivot element is in the correct position
 * for the sorted array, all the elements to the left of the pivot are less than or equal to the pivot, and
 * all the elements to the right of the pivot are greater than the pivot. We then recursively sort the sublist to the
 * left and right of the array. Builder is used to keep track of steps. Order is the desired order, which will be either
 * INCREASING or DECREASING.
 * @param <E> is the type of elements in the list, since we use compareTo for comparisons, any comparable type is
 *  *           compatible.
 */
public class QuickSort<E extends Comparable<E>> implements Sorter<E> {

    private List<E> elements;
    private Order   order;
    private String builder = "";
    /**
     * this is the constructor for the sorter. it has an order and a list, which are both assigned to the object upon
     * creation.
     * @param elements the list of elements in the list
     * @param order is the order of the list, will either be INCREASING or DECREASING
     */
    public QuickSort(List<E> elements, Order order) {
        this.elements = elements;
        this.order    = order;
    }
    /**
     *
     * @return returns the backing array
     */
    @Override
    public List<E> getList() {
        return elements;
    }

    /**
     * Actual sorting using the above algo. If order is INCREASING, then we call the increasing version of quicksort,
     * aka quick1. Otherwise, quick2
     */
    @Override
    public void sort() {
        if(order == Order.INCREASING) {
            quick1(elements, 0, elements.size()-1);
        }
        else{
            quick2(elements, 0, elements.size()-1);
        }
    }

    /**
     * Increasing version of the quicksort algo. Calls the increasing version of the partition, partition1, which does
     * the actual sorting.
     * @param elements the list of elements to be sorted
     * @param first the index of the first element in the sub-array.
     * @param last the index of the last element in the sub-array
     */
    private void quick1(List<E> elements, int first, int last) {
        if(first<=last){
            int pivot = partition1(elements, first, last);
            quick1(elements,first,pivot-1);
            quick1(elements,pivot+1,last);
        }
    }
    /**
     * Decreasing version of the quicksort algo. Calls the decreasing version of the partition, partition2, which does
     * the actual sorting.
     * @param elements the list of elements to be sorted
     * @param first the index of the first element in the sub-array.
     * @param last the index of the last element in the sub-array
     */
    private void quick2(List<E> elements, int first, int last) {
        if(first<=last){
            int pivot = partition2(elements, first, last);
            quick2(elements,first,pivot-1);
            quick2(elements,pivot+1,last);
        }
    }

    /**
     * Sorts and partitions the array according to the algo above. This is the increasing version of partition
     * @param elements the list of elements to be sorted
     * @param first the index of the first element in the sub-array.
     * @param last the index of the last element in the sub-array
     * @returns the index of the partition
     */
    private int partition1 (List<E> elements, int first, int last) {
        E pivot = elements.get(first);
        int low =  first +1;
        int high = last;
        builder = builder + pivot + " :: "+arrayprint(elements)+"\n";
        while (high > low) {
            while (low <= high && elements.get(low).compareTo(pivot) < 0) {
                low++;
            }
            while (low <= high && elements.get(high).compareTo(pivot) > 0) {
                high--;
            }
            if (high >low) {
                E temp = elements.get(high);
                elements.set(high, elements.get(low));
                elements.set(low, temp);
                builder = builder + pivot + " :: " + arrayprint(elements) + "\n";
            }
        }
        while(high>first&&elements.get(high).compareTo(pivot)>=0){
            high--;
        }
        if(pivot.compareTo(elements.get(high))>0){
            elements.set(first,elements.get(high));
            elements.set(high,pivot);
            builder = builder + "  :: "+arrayprint(elements)+"\n";
            return high;
        }
        else{
            builder = builder + "  :: "+arrayprint(elements)+"\n";
            return first;
        }
    }

    /**
     * Sorts and partitions the array according to the algo above. This is the increasing version of partition
     * @param elements the list of elements to be sorted
     * @param first the index of the first element in the sub-array.
     * @param last the index of the last element in the sub-array
     * @returns the index of the partition
     */
    private int partition2 (List<E> elements, int first, int last) {
        E pivot = elements.get(first);
        int low =  first +1;
        int high = last;
        builder = builder + pivot + " :: "+arrayprint(elements)+"\n";
        while (high > low) {
            while (low <= high && elements.get(low).compareTo(pivot) > 0) {
                low++;
            }
            while (low<= high && elements.get(high).compareTo(pivot) < 0) {
                high--;
            }
            if (high >= low) {
                E temp = elements.get(high);
                elements.set(high, elements.get(low));
                elements.set(low, temp);
                builder = builder + pivot + " :: " + arrayprint(elements) + "\n";
            }
        }
        while(high>first&&elements.get(high).compareTo(pivot)<0){
            high--;
        }
        if(pivot.compareTo(elements.get(high))<0){
            elements.set(first,elements.get(high));
            elements.set(high,pivot);
            builder = builder + "  :: "+arrayprint(elements)+"\n";
            return high;
        }
        else{
            builder = builder + "  :: "+arrayprint(elements)+"\n";
            return first;
        }
    }

    private String arrayprint(List<E> elements){
        String toreturn = "";
        toreturn += "[";
        for(int i=0;i<elements.size();i++){
            toreturn += elements.get(i);
            if(i!=elements.size()-1){
                toreturn += ",";
            }
        }
        toreturn += "]";
        return toreturn;
    }
    /**
     * The method displays the original input (unsorted) list, and then, each step is shown in a new line. For example,
     * if the original list to be sorted in increasing order is [6, 4, 9, 5, 1, 8, 2, 7, 3], calling this method should
     * string as follows, exactly in the format shown:
     * <p>
     * 6 :: [6, 4, 9, 5, 1, 8, 2, 7, 3]
     * 6 :: [6, 4, 3, 5, 1, 8, 2, 7, 9]
     * 6 :: [6, 4, 3, 5, 1, 2, 8, 7, 9]
     *   :: [2, 4, 3, 5, 1, 6, 8, 7, 9]
     * <p>
     * Only the steps with the first pivot are shown above, and NOT the entire output. The last step with a specific
     * pivot does not show the pivot separately in front of the :: separator, to indicate that a different pivot will
     * be used in the next step. At each stage, you must use the first element as the pivot.
     *
     * @return the string representation of the step-wise transformation of the input list, as done with quick sort
     */

    /**
     * Method for displaying the steps in the sort. If the builder string is empty(ie sort()) has not yet been called,
     * then the sort is called and we print out the steps by returning the builder string.
     * @return
     */
    @Override
    public String show() {
        if(builder.equals("")){
            sort();
        }
        return builder;
    }
    }

