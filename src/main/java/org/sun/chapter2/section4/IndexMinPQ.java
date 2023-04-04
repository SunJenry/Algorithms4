package org.sun.chapter2.section4;

public class IndexMinPQ<Item extends Comparable<Item>> {

    /**
     * create a priority queue of capacity maxN with possible indices between 0 and maxN-1
     *
     * @param maxN
     */
    public IndexMinPQ(int maxN) {
    }

    /**
     * insert item; associate it with k
     *
     * @param k
     * @param item
     */
    public void insert(int k, Item item) {

    }

    /**
     * change the item associated with k to item
     *
     * @param k
     * @param item
     */
    public void change(int k, Item item) {

    }

    /**
     * is k associated with some item?
     *
     * @param k
     * @return
     */
    public boolean contains(int k) {
        return false;
    }

    /**
     * remove k and its associated item
     *
     * @param k
     */
    public void delete(int k) {

    }

    /**
     * return a minimal item
     *
     * @return
     */
    public Item min() {
        return null;
    }

    /**
     * return a minimal item's index
     *
     * @return
     */
    public int minIndex() {
        return -1;
    }

    /**
     * remove a minimal item and return its index
     *
     * @return
     */
    public int delMin() {
        return -1;
    }

    /**
     * is the priority queue empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * number of items in the priority queue
     *
     * @return
     */
    public int size() {
        return 0;
    }
}
