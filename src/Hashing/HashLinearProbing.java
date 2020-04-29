package Hashing;

public class HashLinearProbing<K,V> {

    int capacity;
    HashArray<K,V> hashArray[];
    HashLinearProbing(int capacity)
    {
        this.capacity=capacity;
        hashArray= new HashArray[capacity];
        for(int i=0;i<capacity;i++)
            hashArray[i]=null;
    }

    class HashArray<K,V>
    {
        K key;
        V value;
        HashArray(K key,V value)
        {
            this.key=key;
            this.value=value;
        }
    }
    public int hash1(K key)
    {
        return key.hashCode() % capacity;
    }
    public void put(K key,V Value)
    {
        int index=hash1(key);
        if(hashArray[index]!=null)
        {
            for(int i=1;i<=capacity;i++)
            {
                index=(index+i) % capacity;
                if(hashArray[index] == null)
                    break;
            }
        }
        hashArray[index]=new HashArray<>(key, Value);
    }

    public V get(K key)
    {

        int index=hash1(key);
        if(hashArray[index]==null)
            return null;
        if(hashArray[index].key.equals(key))
        {
            return hashArray[index].value;
        }
        else
        {
            for(int i=1;i<=capacity;i++)
            {
                index=(index+i) % capacity;
                if(hashArray[index]!=null && hashArray[index].key.equals(key))
                    return hashArray[index].value;
            }
            return null;
        }

    }

    public void delete(K key)
    {
        int index=hash1(key);

        if(hashArray[index]!=null && hashArray[index].key.equals(key))
            hashArray[index]=null;
        else
        {
            for(int i=1;i<=capacity;i++)
            {
                index=(index+i) % capacity;
                if(hashArray[index]!=null && hashArray[index].key.equals(key))
                    hashArray[index]=null;
            }
        }
    }

    public static void main(String[] args) {

        HashLinearProbing<Integer,String> hashLinearProbing = new HashLinearProbing<>(16);
        hashLinearProbing.put(52, "tony");
        hashLinearProbing.put(95, "brad");
        hashLinearProbing.put(55, "john");
        hashLinearProbing.put(60, "denzel");
        hashLinearProbing.put(44, "chris");
        hashLinearProbing.put(35, "will");
        hashLinearProbing.put(66, "abe");
        hashLinearProbing.put(58, "aaron");
        hashLinearProbing.put(63, "barry");
        hashLinearProbing.put(51, "thomas");
        hashLinearProbing.put(78, "brolin");
        hashLinearProbing.put(46, "jack");
        hashLinearProbing.put(27, "mary");
        hashLinearProbing.put(73, "tom");
        hashLinearProbing.put(92, "bob");

        System.out.println("\n");

        System.out.println(hashLinearProbing.get(52));
        System.out.println(hashLinearProbing.get(95));
        System.out.println(hashLinearProbing.get(55));
        System.out.println(hashLinearProbing.get(60));
        System.out.println(hashLinearProbing.get(44));
        System.out.println(hashLinearProbing.get(35));
        System.out.println(hashLinearProbing.get(66));
        System.out.println(hashLinearProbing.get(58));
        System.out.println(hashLinearProbing.get(63));
        System.out.println(hashLinearProbing.get(51));
        System.out.println(hashLinearProbing.get(78));
        System.out.println(hashLinearProbing.get(46));
        System.out.println(hashLinearProbing.get(27));
        System.out.println(hashLinearProbing.get(73));
        System.out.println(hashLinearProbing.get(92));

        System.out.println("\n");

        hashLinearProbing.delete(46);
        hashLinearProbing.put(46, "tomasson");
        hashLinearProbing.put(46, "felix");
        System.out.println("--------------------------");

        System.out.println(hashLinearProbing.get(52));
        System.out.println(hashLinearProbing.get(95));
        System.out.println(hashLinearProbing.get(55));
        System.out.println(hashLinearProbing.get(60));
        System.out.println(hashLinearProbing.get(44));
        System.out.println(hashLinearProbing.get(35));
        System.out.println(hashLinearProbing.get(66));
        System.out.println(hashLinearProbing.get(58));
        System.out.println(hashLinearProbing.get(63));
        System.out.println(hashLinearProbing.get(51));
        System.out.println(hashLinearProbing.get(78));
        System.out.println(hashLinearProbing.get(46));
        System.out.println(hashLinearProbing.get(27));
        System.out.println(hashLinearProbing.get(73));
        System.out.println(hashLinearProbing.get(92));


    }
}