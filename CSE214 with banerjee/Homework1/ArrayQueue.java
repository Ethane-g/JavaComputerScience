package cse214hw1;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
    private int items;
    T[] array;
    private int first;
    private int last;


    public ArrayQueue(){
        array = (T[]) new Object[1];
        items=0;
    }
    @Override
    public void add(T t) {
        items++;
        if(items>array.length){
            resize(array);
        }
        if(items==1){
            array[first] = t;

        }
        else {
            last=(last+1)%array.length;
            array[last] = t;
        }
        /////printing all items for check
    }

    @Override
    public T remove() {
        T retrieve;
        if(items ==0){
            throw new NoSuchElementException("list is empty, no elements to remove");
        }
        retrieve = array[first];
        array[first]=null;
        first = (first+1)%array.length;
        items--;
        return retrieve;
    }

    @Override
    public T peek() {
        return array[first];
    }




    private void resize(T[] array){
        T[] alpha = (T[]) new Object[this.array.length*2];
        if(first<last) {
            for (int i = 0; i < this.array.length; i++) {
                alpha[i] = this.array[i];
            }
        }
        else{
            int temp = 0;
            for(int i=first;i<array.length;i++){
                alpha[temp]= array[i];
                temp++;
            }
            for(int i=0;i<last;i++){
                alpha[temp] = array[i];
            }
        }
        this.array = alpha;
    }
}
