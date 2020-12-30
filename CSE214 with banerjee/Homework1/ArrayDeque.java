package cse214hw1;

import java.util.NoSuchElementException;

public class ArrayDeque<T> implements Deque<T>{
    private T[] array;
    private int items;
    private int first;
    private int last;
    public ArrayDeque(){
        array = (T[]) new Object[10];
        items =0;
    }
   public ArrayDeque(int a){
       array = (T[]) new Object[a];
       items =0;
   }
    public static <T> ArrayDeque<T> of(T... args){
        Deque<T> mulitems = new ArrayDeque(args.length+1);
        for(int i=0;i<args.length;i++){
            mulitems.addLast(args[i]);
        }
        return (ArrayDeque<T>) mulitems;
        //implement later after other methods are introduced. Needs a way to create a new ArrayDeque object and return it.
    }
    @Override
    public void addFirst(T t) {
        items++;
        if(items>= array.length){
            resize(array);
        }
        T[] temp =(T[]) new Object[array.length];
        for(int i=first;i<array.length;i++){
            temp[(i+1)%array.length] = array[i];
        }
        for(int i=first;i<array.length;i++){
            array[i] = temp[i];
        }
        array[first]= t;
        last = (last+1)% array.length;
            //check all elements

    }

    @Override
    public void addLast(T t) {
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
        for(int i=first;i<last;i++){
            System.out.println(array[i]);
        }
        if(last<first){
            for(int i=0;i<last;i++){
                System.out.println(array[i]);
            }
        }
    }

    @Override
    public T removeFirst() {
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
    public T removeLast() {
        T retrieve;
        if(items ==0){
            throw new NoSuchElementException();
        }
        retrieve=array[last];
        array[last]=null;
        last=(last-1)%array.length;
        items--;
        return retrieve;
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