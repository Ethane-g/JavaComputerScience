package com.company;
// Name: Ethan Garcia
// Id: 112752608
// Summer class, section 1.
public class ItemInfoNode {
    private ItemInfo data;
    private ItemInfoNode next;
    private ItemInfoNode prev;
    public ItemInfoNode(ItemInfo info){
        this.data = info;
    }

    public ItemInfo getData() {
        return data;
    }

    public void setData(ItemInfo data) {
        this.data = data;
    }

    public ItemInfoNode getNext() {
        return next;
    }

    public void setNext(ItemInfoNode next) {
        this.next = next;
    }

    public ItemInfoNode getPrev() {
        return prev;
    }

    public void setPrev(ItemInfoNode prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return ""+data+"";
    }
}
