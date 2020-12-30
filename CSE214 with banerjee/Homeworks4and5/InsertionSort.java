package com.company;
//Ethan Garcia 112752608
import java.util.List;

/**
 * This class provides the implementation of an Insertion sort algo. Insertion sort is a quadratic sorting algo where
 * elements are compared to elements before them, and if they are swapped until the current element is greater than all
 * the elements before it. The time complexity is O(n^2). Best case is O(n). Elements is the list of items that will be
 * in the list, order is whether or not the sort should be in ascending or descending order, and the builder is the
 * string for the steps to be displayed if show() is called.
 * @param <E> is the type of elements in the list, since we use compareTo for comparisons, any comparable type is
 *
compatible.
 */
public class InsertionSort<E extends Comparable<E>> implements Sorter<E> {
    private List<E> elements;
    private Order order;
    private String builder ="";
    /**
     * this is the constructor for the sorter. it has an order and a list, which are both assigned to the object upon
     * creation.
     * @param elements the list of elements in the list
     * @param order is the order of the list, will either be INCREASING or DECREASING
     */
    public InsertionSort(List<E> elements, Order order) {
        this.elements = elements;
        this.order
                = order;
    }
    /**
     *
     * @return returns the backing array
     */
    @Override
    public List<E> getList(
    ) {
        return elements;
    }
    /**
     * Actual sorting for the list, described above. At each step, the builder String is modified such that each step of
     * sorting is shown.
     */
    @Override
    public void sort(
    ) {
        int j;
        E item;
        if(order.equals(Order.INCREASING)
        ){
            for(int i =1;i< elements.size(
            );i++){
                if(builder.equals("")
                ){
                    builder = "\n"+elements.get(i) +":: [";
                }
                else {
                    builder = builder + elements.get(i) + ":: [";
                }
                for(int q =0;q< elements.size(
                );q++){
                    builder = builder + elements.get(q);
                    if(q != elements.size(
                    )-1){
                        builder = builder + ",";
                    }
                }
                builder = builder +"]\n";
                item = elements.get(i);
                j=i;
                while(j>0&&elements.get(j-1)
                        .compareTo(item)==1){
                    elements.set(j,elements.get(j-1)
                    );
                    j--;
                }
                elements.set(j,item);
            }
        }
        else{
            for(int i =1;i< elements.size(
            );i++){
                if(builder.equals("")
                ){
                    builder = "\n"+elements.get(i) +"::[";
                }
                else {
                    builder = builder + elements.get(i) + ":: [";
                }
                for(int q =0;q< elements.size(
                );q++){
                    builder = builder + elements.get(q);
                    if(q != elements.size(
                    )-1){
                        builder = builder + ",";
                    }
                }
                builder = builder +"]\n";
                item = elements.get(i);
                j=i;
                while(j>0&&elements.get(j-1)
                        .compareTo(item)==-1){
                    elements.set(j,elements.get(j-1)
                    );
                    j--;
                }
                elements.set(j,item);
            }
        }
        builder = builder +"[";
        for(int q =0;q< elements.size(
        );q++){
            builder = builder + elements.get(q);
            if(q != elements.size(
            )-1){
                builder = builder + ",";
            }
        }
        builder = builder +"]\n";
    }
/**
 * The method displays the original input (unsorted) list, and then, each step is shown in a new line. For example,
 * if the original list to be sorted in increasing order is [6, 5, 3, 1, 8, 7, 2, 4], calling this method should
 * return the following string (exactly in this format):
 * <p>
 * 5 :: [6, 5, 3, 1, 8, 7, 2, 4]
 * 3 :: [5, 6, 3, 1, 8, 7, 2, 4]
 * 1 :: [3, 5, 6, 1, 8, 7, 2, 4]
 * 8 :: [1, 3, 5, 6, 8, 7, 2, 4]
 * 7 :: [1, 3, 5, 6, 8, 7, 2, 4]
 * 2 :: [1, 3, 5, 6, 7, 8, 2, 4]
 * 4 :: [1, 2, 3, 5, 6, 7, 8, 4]
 * [1, 2, 3, 4, 5, 6, 7, 8]
 * <p>
 * At each step, the element being inspected for insertion is at the start, and the list in its current state is
 * then placed after ::, two colon symbols. Notice the repeated list when the element being inspected for insertion
 * is 8, and the list does not change at all. Such repetitions must be included in the returned string.
 *
 * @return the string representation of the step-wise transformation of the input list, as done with insertion sort
 */
    /**
     * Method for displaying the steps in the sort. If the builder string is empty(ie sort()) has not yet been called,
     * then the sort is called and we print out the steps by returning the builder string.
     * @return
     */
    @Override
    public String show(
    ) {
        if(builder.equals("")
        ){
            sort(
            );
        }
        return builder;
    }
}
