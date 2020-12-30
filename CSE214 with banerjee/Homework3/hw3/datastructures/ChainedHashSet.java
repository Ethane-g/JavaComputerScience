package com.company.hw3.hw3.datastructures;

import java.util.LinkedList;

/**
 * This class implements the {@link Set} interface. It offers constant time performance (on average) for the basic
 * operations <code>add</code>, <code>remove</code>, <code>containt</code>, and <code>size</code>, under the simple
 * uniform hashing assumption (i.e., the hash function distributes elements uniformly across the slots in the backing
 * table).
 * There are two constructors given to you. You can modify them, or add new constructors. However, the signature of
 * these two constructors must not be changed. That is, the user must be able to create an instance of this class by
 * invoking <code>new ChainedHashSet()</code> and <code>new ChainedHashSet(int k)</code>.
 *
 * @param <E> the type of elements stored in this set
 */
public class ChainedHashSet<E> implements Set<E> {

    /**
     * Once an instance is created, this table size cannot change
     */
    private final int tablesize;
    private LinkedList<E>[] hash;


    // DO NOT MODIFY THIS METHOD
    public final int tablesize() { return this.tablesize; }

    // DO NOT MODIFY THIS METHOD
    public final double loadfactor() { return size() / (double) tablesize; }

    public ChainedHashSet(){
        this(10);
    }

    public ChainedHashSet(int tablesize) {
        this.tablesize = tablesize;
        hash = new LinkedList[tablesize];
        for(int i=0;i<hash.length;i++){
            hash[i] = new LinkedList<E>();
        }
    }

    @Override public int size() {
        int temp = 0;
        for(int i =0;i<hash.length;i++){
            temp += hash[i].size();
        }
        return temp;
    }

    @Override public boolean isEmpty() {
        return size()==0;
    }

    @Override public boolean contains(E element) {
        for(int i =0;i<hash.length;i++){
            if(!isEmpty()&&hash[i].contains(element)){
                return true;
            }
        }
        return false;
    }

    @Override public boolean add(E e) {
        int where = Math.abs(e.hashCode()%tablesize);
        if(this.contains(e)){
            return false;
        }
        else{
            hash[where].add(e);
            return true;
        }
    }

    @Override public boolean remove(E e) {
        if(!this.contains(e)){
            return false;
        }
        else{
            for(int i=0;i<hash.length;i++){
                if(hash[i].contains(e)){
                    hash[i].remove(e);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method returns a string showing the entire hash table structure of this set. The format must be as follows:
     * Suppose a table has four slots, with three elements 'a', 'b', 'c', hashed to the first slot and 'z' hashed to the
     * third slot. Printing out the returned string should show the following:
     *
     * 1 || a -> b -> c
     * 2 ||
     * 3 || z
     *
     * Note that the elements 'a', 'b', 'c', and 'z' must also be human-readable.
     *
     * @return a string representation of the entire set, showing the underlying hash table structure
     */
    @Override
    public String toString() {
        String total = null;
        for(int i=0;i<tablesize;i++){
            total=total + i+ " // ";
            if(!hash[i].isEmpty()){
                for (int j = 0; i < hash[i].size()-1; j++) {
                    total = total + hash[i].get(j) + " ->";
                }
                total = total + hash[i].get(hash[i].size()-1);
            }
            total = total + "\n";
        }
        return total;
    }
}
