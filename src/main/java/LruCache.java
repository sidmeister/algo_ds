import java.util.HashMap;

/**
 * Created by srathi on 3/24/17.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */


class LRUDblLink
{
    LRUDblLink next;
    LRUDblLink prev;
    int value;
    int key;

    public LRUDblLink(int value, int key) {
        this.value = value;
        this.key = key;
    }
}

public class LruCache {

    LRUDblLink head;
    LRUDblLink end;
    int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    HashMap<Integer,LRUDblLink> map = new HashMap<>();

    public void put(int key,int value)
    {


        if(map.containsKey(key))
        {
            LRUDblLink old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);

        }
        else {
            LRUDblLink node = new LRUDblLink(key, value);
            if(map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
            }
            setHead(node);
            map.put(key, node);
        }
    }


    public int get(int key)
    {
        if(map.containsKey(key))
        {
            LRUDblLink temp = map.get(key);
            remove(temp);
            setHead(temp);
            return temp.value;
        }
        else
        return -1;
    }


    public void remove(LRUDblLink node)
    {
          if(node.prev != null)
              node.prev.next = node.next;
          else
              head = node.next;
          if(node.next != null)
              node.next.prev = node.prev;
          else
              end = node.prev;

    }

    public void setHead(LRUDblLink node)
    {
        node.next = head;
        node.prev = null;
        if(head!=null)
            head.prev = node;
        head = node;
        if(end== null)
            end = node;

    }



}
