package Hashing;

import java.util.ArrayList;

public class HashChaining<K,V> {

    int capacity;
    double loadFactor=0.75;
    ArrayList<HashArray<K,V>> hashArray;
    int size;

    HashChaining(){
        capacity=16;
        size=0;
        hashArray = new ArrayList<>();
        for(int i =0;i<capacity;i++)
            hashArray.add(i,null);
    }
    class HashArray<K,V>{
        K key;
        V value;

        HashArray<K,V> next=null;
        HashArray(K key,V value)
        {
            this.key=key;
            this.value=value;
        }
    }
    public int myHashCode(K key)
    {
        return key.hashCode() % capacity;
    }
    public int getSize()
    {
        return size;
    }
    public void put(K key,V value)
    {
        int index=myHashCode(key);
        HashArray<K,V> head=hashArray.get(index);
        while(head!=null)
        {
            if(head.key.equals(key))
            {
                head.value=value;
                return;
            }
            head=head.next;
        }
        size++;
        head=hashArray.get(index);
        HashArray<K,V> element = new HashArray<>(key,value);
        element.next=head;
        hashArray.set(index, element);

        //if size reaches load factor then double the size
        if(size>=(int)capacity*loadFactor)
        {
            capacity=capacity*2;
            ArrayList<HashArray<K, V>> temp = hashArray;

            for(int i=0;i<capacity;i++)
                hashArray.add(i, null);

            for(HashArray<K,V> ha:temp)
            {
                while(ha!=null)
                {
                    this.put(ha.key, ha.value);
                    ha=ha.next;
                }
            }

        }
    }
    public V get(K key) {
        int index=myHashCode(key);
        if(hashArray.get(index)==null)
            return null;
        HashArray<K,V> head = hashArray.get(index);
        while(head!=null)
        {
            if(head.key.equals(key))
                return head.value;
            head=head.next;
        }
        return null;
    }

    public void traverse(K key)
    {
        int index=myHashCode(key);
        HashArray<K,V> head = hashArray.get(index);
        while(head!=null)
        {
            System.out.println(head.key+" "+head.value);
            head=head.next;
        }

    }
    public V remove(K key)
    {
        int index=myHashCode(key);
        HashArray<K,V> head=hashArray.get(index);
        HashArray<K,V> p=head;
        while(head!=null)
        {
            if(head.key.equals(key))
            {
                if(p==head)
                {
                    hashArray.add(index, hashArray.get(index).next);
                    return head.value;
                }

                p.next=head.next;
                hashArray.add(index, hashArray.get(index));
                return head.value;
            }
            p=head;
            head=head.next;
        }
        return null;
    }

    public static void main(String[] args) {

        HashChaining<Integer,String> hashChain = new HashChaining<>();
        hashChain.put(52, "tony");
        hashChain.put(95, "brad");
        hashChain.put(55, "manny");
        hashChain.put(60, "robert");
        hashChain.put(44, "alberto");
        hashChain.put(35, "luis");
        hashChain.put(66, "jordan");
        hashChain.put(58, "mikel");
        hashChain.put(63, "arteta");
        hashChain.put(51, "tomasson");
        hashChain.put(78, "brolin");
        hashChain.put(46, "goku");
        hashChain.put(27, "gohan");
        hashChain.put(73, "naruto");
        hashChain.put(92, "chris");

        System.out.println(hashChain.get(52));
        System.out.println(hashChain.get(95));
        System.out.println(hashChain.get(55));
        System.out.println(hashChain.get(60));
        System.out.println(hashChain.get(44));
        System.out.println(hashChain.get(35));
        System.out.println(hashChain.get(66));
        System.out.println(hashChain.get(58));
        System.out.println(hashChain.get(63));
        System.out.println(hashChain.get(51));
        System.out.println(hashChain.get(78));
        System.out.println(hashChain.get(46));
        System.out.println(hashChain.get(27));
        System.out.println(hashChain.get(73));
        System.out.println(hashChain.get(92));

        hashChain.remove(55);

        System.out.println("------------------------------------");

        System.out.println(hashChain.get(52));
        System.out.println(hashChain.get(95));
        System.out.println(hashChain.get(55));
        System.out.println(hashChain.get(60));
        System.out.println(hashChain.get(44));
        System.out.println(hashChain.get(35));
        System.out.println(hashChain.get(66));
        System.out.println(hashChain.get(58));
        System.out.println(hashChain.get(63));
        System.out.println(hashChain.get(51));
        System.out.println(hashChain.get(78));
        System.out.println(hashChain.get(46));
        System.out.println(hashChain.get(27));
        System.out.println(hashChain.get(73));
        System.out.println(hashChain.get(92));

    }
}