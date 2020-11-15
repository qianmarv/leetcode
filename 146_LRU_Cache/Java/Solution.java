import java.util.*;

//Runtime: 12 ms, faster than 95.07%
//Memory Usage: 47.5 MB, less than 36.11%
public class Solution {
    // class LRUCache{
    private int capacity;
    private Map<Integer, DoublyLinkedNode> dict;
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public Solution(int capacity){
        this.capacity = capacity;
        this.dict = new HashMap<>();
    }

    public int get(int key){
        if(!dict.containsKey(key)){
            return -1;
        }
        DoublyLinkedNode node = dict.get(key);
        shiftNodeToFirst(node);
        return node.val;
    }

    public void put(int key, int value){
        DoublyLinkedNode node;
        if(dict.containsKey(key)){
            node = dict.get(key);
            node.val = value;
            shiftNodeToFirst(node);
        }else{
            if(dict.size() == capacity){
                dict.remove(tail.key);
                removeTailNode();
            }
            node = new DoublyLinkedNode(key, value);
            dict.put(key, node);
            
            node.next = head;
            if(head != null) head.prev = node;
            head = node;
            if(tail == null) tail = head;
        }
        // System.out.println("Put: " + key);
        // System.out.println("Dict: " + dict);
        // System.out.println("After Put Node");
        // System.out.println("Head: " + head.key);
        // System.out.println("Tail: " + tail.key);
    }

    private void removeTailNode(){
        if(tail.prev == null){
            head = tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        // System.out.println("\nAfter Remove Node");
        // System.out.println("Head: " + head.key);
        // System.out.println("Tail: " + tail.key);
    }

    private void shiftNodeToFirst(DoublyLinkedNode node){
        if(node.prev != null){
            node.prev.next = node.next;
            if(node.next == null) tail = node.prev;
            else node.next.prev = node.prev;
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }

        // System.out.println("\nAfter Shift Node to Head");
        // System.out.println("Head: " + head.key);
        // System.out.println("Tail: " + tail.key);
    }

    class DoublyLinkedNode{
        int key;
        int val;
        DoublyLinkedNode prev;
        DoublyLinkedNode next;

        DoublyLinkedNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    //    }


    public static void test(){
        //LRUCache lRUCache = new LRUCache(2);
        Solution lRUCache = new Solution(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println("1:" + lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println("-1:" + lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        System.out.println("4:" + lRUCache.get(4));    // return 4
    }

    public static void main(String[] args) {
        //    Solution so = new Solution();
        //        so.test();
        test();
    }
}
