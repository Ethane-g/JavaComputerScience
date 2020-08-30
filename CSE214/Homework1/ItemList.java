package com.company;
// Name: Ethan Garcia
// Id: 112752608
// Summer class, section 1.

public class ItemList {
    private int itemsinlist;
    private ItemInfoNode head;
    private ItemInfoNode tail;

    /**
     * contains references for head and tail of list and the quantity of items in the list
     */
    public ItemList(){
        itemsinlist =0;
    }

    /**
     * Method to insert/create the start of a linked list
     * @param name
     * String name to be used to create a node with name
     * @param rfidtag
     * String rfid to be used to create a node with specified id
     * uses shelfplace function to order nodes
     * @param price
     * double price associated with the item
     * @param intpos
     * inital position for the object
     * @param curpos
     * if utilized from another method in this class, will have a new current location associated with it
     *
     * O(n) efficency as it goes through each element of the list to compare where the new node will be placed
     *
     * checks if a list is new
     * if not, then it will iterate through to determine between which 2 element it will fit between
     * if it is before or at end, it will become new head or tail respectively
     */
    public void Insert(String name, String rfidtag, double price,String intpos,String curpos) {
        ItemInfo newitem = new ItemInfo(name, rfidtag, price, intpos);
        ItemInfoNode insertednode = new ItemInfoNode(newitem);
        if(curpos != null){
            insertednode.getData().setCurlocation(curpos);
        }
        if (itemsinlist == 0) {
            head = insertednode;
            itemsinlist++;
        } else {
            boolean isin = false;
            ItemInfoNode counter;
            counter = head;
            while (!isin) {
                String headcounter = counter.getData().getTagnum();
                int headdouble = hexatodec(headcounter);
                String insertednodecounter = insertednode.getData().getTagnum();
                int insertdouble = hexatodec(insertednodecounter);
                if (counter.getPrev() == null && headdouble > insertdouble) {
                    //LESS THAN HEAD:::::::counter is what the head was. will be replaced with new head
                    counter.setPrev(insertednode);
                    insertednode.setNext(counter);
                    head = insertednode;
                    itemsinlist++;
                    break;
                }
                if (insertdouble < headdouble && insertdouble > counter.getPrev().getData().shelfplace()) {
                    //LESS THAN CURRENT BUT GREATER THAN LAST
                    insertednode.setPrev(counter.getPrev());
                    insertednode.setNext(counter);
                    counter.setPrev(insertednode);
                    itemsinlist++;
                    break;
                }
                if (counter.getNext() == null && insertdouble > headdouble) {
                    //MORE THAN TAIl;
                    counter.setNext(insertednode);
                    insertednode.setPrev(counter);
                    tail = insertednode;
                    itemsinlist++;
                    break;
                }
                if (insertdouble > headdouble && insertdouble < counter.getNext().getData().shelfplace()) {
                    //GREATER THAN CURRENT BUT LESS THAN NEXT
                    insertednode.setNext(counter.getNext());
                    counter.setNext(insertednode);
                    insertednode.setPrev(counter);
                    itemsinlist++;
                    break;
                }
                if(insertdouble == headdouble){
                    insertednode.setNext(counter.getNext());
                    counter.setNext(insertednode);
                    insertednode.setPrev(counter);
                    itemsinlist++;
                    break;
                }
                counter = counter.getNext();
            }
        }
    }

    /**
     * iterates through linked list using a cursor
     * prints all items unconditionally
     * also O(n) as it iterates through every item in the list
     */
    public void printall(){
        ItemInfoNode Counter = head;
        while(Counter!=null) {
            System.out.println(Counter);
            Counter = Counter.getNext();
        }
    }
    /**
     * iterates through linked list using a cursor
     * prints all items associated with a certain place
     * loc is always c or s depending on if its a cart or shelf
     * also O(n) as it iterates through every item in the list
     */
    public void printallbylocation(char loc){
        ItemInfoNode Counter = head;
        while(Counter!=null) {
            if(Counter.getData().getCurlocation().charAt(0)==loc) {
                System.out.println(Counter);
            }
            Counter = Counter.getNext();
        }
    }

    /**
     * iterates through list to check if any items are removed
     * checks nodes data to see if curlocation is "out"
     * if they are they are printed and they are removed from the list
     * also O(n) as it iterates through every item in the list
     */
    public void removeallpurchased(){
        ItemInfoNode Counter = head;
        System.out.println("removed items are:");
        System.out.println();
        int removed = 0;
        while(itemsinlist>0&&Counter!=null) {
            if(Counter.getData().getCurlocation().equalsIgnoreCase("out")){
                System.out.println(Counter);
                if(Counter.getPrev()==null){
                    head = Counter.getNext();
                    head.setPrev(null);
                }
                else if (Counter.getNext()==null){
                    tail = Counter.getPrev();
                    tail.setNext(null);
                }
                else{
                    Counter.getPrev().setNext(Counter.getNext());
                    Counter.getNext().setPrev(Counter.getPrev());
                }
                removed++;
            }
            Counter.setNext(Counter.getNext());
        }
        System.out.println("removed " +removed+" items!");
    }

    /**
     * Similar to above, but for specific items via rfid
     * @param rfid
     * The key by which we will be searching each element of the linked list
     * @return ItemInfoNode
     * Returns either null or Iteminfonode when the object is located
     * This goes through every element and checks rfid. O(n) notation since worst case is all elements
     *
     * NOTE: only removes one occurance of the item in question
     */
    public ItemInfoNode removeitem(String rfid){
        ItemInfoNode Counter = head;
        while(Counter!=null) {
            if(Counter.getData().getTagnum().equalsIgnoreCase(rfid)){
                if(Counter.getPrev()==null){
                    head = Counter.getNext();
                    head.setPrev(null);
                    return Counter;
                }
                else if(Counter.getNext()==null){
                    tail = Counter.getPrev();
                    tail.setNext(null);
                    return Counter;
                }
                else{
                    Counter.getPrev().setNext(Counter.getNext());
                    Counter.getNext().setPrev(Counter.getPrev());
                    return Counter;
                }
            }
            Counter = Counter.getNext();
        }
        return null;
    }

    /**
     * Moves a specified item to a certain location
     * @param rfidTag
     * the string we are searching by. String
     * @param source
     * NOT USED (please dont take off points i beg)
     * @param dest
     * The location for the new item to be placed
     *
     * USES REMOVE FROM EARLIER
     * O(n^3) as we use the remove and insert functions (remove is used 2x as we check if element is even in the array)
     *
     * removes from list, inserts it back again but uses dest in insert, to change the location
     */
    public void moveitem(String rfidTag, String source, String dest){
        if(removeitem(rfidTag)==null){
            System.out.println("item could not be found");
        }
        else {
            if(dest.charAt(0) =='s'||dest.charAt(0)=='c') {
                ItemInfoNode removed = removeitem(rfidTag);
                Insert(removed.getData().getProdname(), removed.getData().getTagnum(), removed.getData().getPrice(), removed.getData().getOrilocation(), dest);
            }
            else{
                throw new IllegalArgumentException("invalid destination");
            }
        }
    }

    /**
     * goes through all elements in list to check if they can be checked out if the first char denoted it is in a cart
     * O(n) notation as it goes through all elements
     */
    public void checkout(){
        System.out.println("Items to be checked out");
        System.out.println();
        ItemInfoNode Counter = head;
        while(Counter!=null) {
            if(Counter.getData().getCurlocation().charAt(0)=='c'||Counter.getData().getCurlocation().charAt(0)=='C'){
                Counter.getData().setCurlocation("out");
                System.out.println(Counter);
            }
            Counter = Counter.getNext();
        }
    }

    /**
     * goes through all elements to set curr loc to original loc, if they have not yet been checked out
     * O(n)
     */
    public void Cleanup(){
        ItemInfoNode Counter = head;
        while(Counter!=null) {
            if(Counter.getData().getCurlocation() != Counter.getData().getOrilocation()){
                Counter.getData().setCurlocation(Counter.getData().getOrilocation());
            }
            Counter = Counter.getNext();
        }
    }
    /**
     * goes through all elements to print those with a identical rfid
     * O(n)
     */
    public void printallbyrf(String a){
        ItemInfoNode Counter = head;
        while(Counter!=null) {
            if(Counter.getData().getTagnum().equalsIgnoreCase(a)) {
                System.out.println(Counter);
            }
            Counter = Counter.getNext();
        }
    }
    public static int hexatodec(String in){
        String characters = "0123456789ABCDEF";
        in = in.toUpperCase();
        int value = 0;
        for(int i=0;i<in.length();i++){
            char s = in.charAt(i);
            int a = characters.indexOf(s);
            value = 16*value+a;
        }
        return value;
    }
}
