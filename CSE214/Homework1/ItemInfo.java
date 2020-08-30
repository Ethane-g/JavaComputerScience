package com.company;
// Name: Ethan Garcia
// Id: 112752608
// Summer class, section 1.
public class ItemInfo {
    private String prodname;
    private double price;
    private String tagnum;
    private String orilocation;
    private String curlocation;

    /**
     * default constructor for iteminfo datatype
     */
    public ItemInfo(){
        this.prodname = "name not found";
        this.price = 0;
        this.tagnum = "tagnum not found";
        this.orilocation = "no location";
        this.prodname = "no location";
    }

    /**
     * proper constructor for iteminfo
     * @param name
     * String: name of the product
     * @param tagnum
     * String: the rfid to be listed (later translated to decimal);
     * @param price
     * Double: the price for the object
     * @param orilocation
     * original location for the item
     *
     * @throws IllegalArgumentException
     * items being created will always start on shelf with a rfid of 9 characters
     */
    public ItemInfo(String name,String tagnum,double price ,String orilocation){
        this.prodname = name;
        this.price = price;
        this.tagnum = tagnum;
        if(tagnum.length()!=9){
            throw new IllegalArgumentException("invalid rfid");
        }
        this.orilocation = orilocation;
        this.curlocation = orilocation;
    }
///////////////getter////////////////////

    /**
     *
     * @return
     * returns name of object in string
     */
    public String getProdname() {
        return prodname;
    }

    /**
     *
     * @return
     * returns price as double
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return
     * returns rfid as string
     */
    public String getTagnum() {
        return tagnum;
    }

    /**
     *
     * @return
     * returns origin location as string
     */
    public String getOrilocation() {
        return orilocation;
    }

    /**
     *
     * @return
     * returns current location as string
     */
    public String getCurlocation() {
        return curlocation;
    }
///////////////setter////////////////////

    /**
     *
     * @param curlocation
     * the new location to be set
     * @throws IllegalArgumentException
     * new set location can only be set to something with at least 4 chars (cart or shelf pos);
     */
    public void setCurlocation(String curlocation) {
        this.curlocation = curlocation;
        if(!(curlocation!="out"||curlocation.length()<4)){
            throw new IllegalArgumentException("invalid new location set");
        }


    }

    /**
     *
     * @param orilocation
     * Original location string
     * not used
     */
    public void setOrilocation(String orilocation) {
        this.orilocation = orilocation;
    }

    /**
     *
     * @param tagnum
     * original rfid tag num
     * NOT USED
     */
    public void setTagnum(String tagnum) {
        this.tagnum = tagnum;
    }

    /**
     *
     * @param price
     * double price
     * NEVER USED
     * price doesn't change
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @param prodname
     * name of product in string
     * NOT USED
     */
    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    /**
     *
     * @return
     * returns the decimal value of the rfid
     */
    public int shelfplace(){
        String a = this.tagnum;
        int ab = hexatodec(a);
        return ab;
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

    @Override
    public String toString() {
        return "name of product: "+prodname+" RFid tag is: "+tagnum+" the current location is "+curlocation;
    }
}
