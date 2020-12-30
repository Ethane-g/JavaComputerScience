package cse214hw1;

public class ArrayUtils {
    /**
     * Creates a merged array c such that c.length = a.length + b.length, and all the elements of b
     * appear in c in the original order, but only after all elements of a (again, in the original
     * order). For example, merge([1,2,3], [4,5]) yields the array [1,2,3,4,5].
     * @param a: the first of the two arrays to be merged
     * @param b: the second of the two arrays to be merged
     * @return c: the merged array
     */
    public static int[] merge(int[]a,int[]b){
        int[] c = new int[a.length+b.length];
        for(int i=0;i<a.length;i++)
        {
            c[i]=a[i];
        }
        for(int i=0;i<b.length;i++){
            c[a.length+i] = b[i];
        }
        return c;
    }
    /**
     * Rotates the array given array by r number of elements to the left, i.e., for each index i, a[i]
     * moves to a[(i+r) mod a.length].
     * @param a: the input array of <code>int</code>s
     */
    public static void rotate(int[] a, int r){
        int[] temp = new int[a.length];
        for(int i=0;i<a.length;i++){
            temp[(i+r)%a.length] = a[i];
        }
        for(int i=0;i<a.length;i++){
            a[i] = temp[i];
        }
    }
    /**
     * Rotates the array given array by r number of elements to the left, i.e., for each index i, a[i]
     * moves to a[(i+r) mod a.length].
     * @param a: the input array of <code>char</code>s
     */
    public static void rotate(char[] a, int r){
        char[] temp = new char[a.length];
        for(int i=0;i<a.length;i++){
            temp[(i+r)%a.length] = a[i];
        }
        for(int i=0;i<a.length;i++){
            a[i] = temp[i];
        }
    }
}
