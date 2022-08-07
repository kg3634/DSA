/*1. You are required to complete the code of our Hashmap class. Please watch the question video carefully. 
The theoretical details of required functionality is explained in detail there. Implement the functions to 
achieve what is explained in the theoretical discussion in question video.
2. Input and Output is managed for you.

Constraints
None */
package DSA.HashmapandHeap;

import java.io.*;
import java.util.*;

public class writeHashmap {

  /*main logic:images/writeHashmap.png, 
  creat array(buckets) of linkedlist,
  hashfuction provides bucker index and loop in a bucket provides data index in LL
  based on di, either we update or insert node. 
  how to check the code:1)check high level of get,containsKey and remove
  2)check hashfuction and getIndexWithinBucket ,then check keyset
  3)check put function, lambda = n/N, if k = 2.0 then we have to keep lambda < k , for this rehashing(images/rehashing.png) 
  needs to be done.
  Average time complexity is O(lambda) and worst TC is O(n) like LL when all elements are in in bucket(hashcode is coming same for all)*/
  public static class HashMap<K, V> {//generic K,V as K and V can be any datatype
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n -- number of key value pairs or nodes in total
    private LinkedList<HMNode>[] buckets; // N = buckets.length -- size of bucket

    public HashMap() {//4 size ki bucket bana li,size 0 rakha and empty LL h sab mn initialy
      initbuckets(4);
      size = 0;
    }


    private void initbuckets(int N) {//creating array of empry LL
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception {
      int bi = hashfn(key);
      int di = getIndexWithinBucket(key, bi);
      
      if(di!=-1){
        HMNode node = buckets[bi].get(di);
        node.value = value;
      }else{
        HMNode node = new HMNode(key, value);
        buckets[bi].add(node);
        size++;//MISTAKE forgot to add this
      }

      //rehashing 
      double lambda = size * 1.0 / buckets.length;
      if( lambda > 2.0){
        rehashing();
      }
    }

    private void rehashing() throws Exception{
      LinkedList<HMNode> [] oba = buckets;//storing old buckets values

      //initializing new bucket with double size
      initbuckets(oba.length*2);
      size = 0;//as need to refill it

      for(int i =0;i<oba.length;i++){//travel in old bucket
        for(HMNode node:oba[i]){
          put(node.key, node.value);//adding all old values in new one - 1 costly operation will make average TC as O(lambda)
        }
      }

    }

    private int hashfn(K key){
      int hc = key.hashCode();//java provides hashcode for respective key
      return Math.abs(hc) % buckets.length;//as hc can be +-but we need it +(so abs) and within bucket(so modulus)
    }

    private int getIndexWithinBucket(K key, int bi){
      int di =0;
      for(HMNode node:buckets[bi]){//loop in respective bucket
        if(node.key.equals(key)){
          return di;//providing repective data index
        }
        di++;
      }
      return -1;
    }
    public V get(K key) throws Exception {
      int bi = hashfn(key);//data index
      int di = getIndexWithinBucket(key,bi);//data index

      if(di != -1){
        HMNode node = buckets[bi].get(di);
        return node.value;
      }else{
        return null;
      }

    }

    public boolean containsKey(K key) {
      int bi = hashfn(key);//data index
      int di = getIndexWithinBucket(key,bi);//data index

      if(di != -1){
        return true;
      }else{
        return false;
      }    
    }

    public V remove(K key) throws Exception {
      int bi = hashfn(key);//data index
      int di = getIndexWithinBucket(key,bi);//data index

      if(di != -1){
        HMNode node = buckets[bi].remove(di);
        size--;//extra
        return node.value;
      }else{
        return null;
      }    
    
    }

    public ArrayList<K> keyset() throws Exception {
      ArrayList<K> keys = new ArrayList<>();
      for(int i =0;i<buckets.length;i++){//travel in each bucket
        for(HMNode node: buckets[i]){//travel in LL
          keys.add(node.key);
        }
      }

      return keys;
    }

    public int size() {
      return size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
/*Sample Input

put India 135
put Aus 5
put Canada 3
display
get China
remove Aus
get Aus
containsKey US
put US 10
put UK 20
remove US
containsKey US
put Pak 80
put China 200
display
put Utopia 0
display
put Nigeria 3
display
put India 138
display
put Sweden 1
display
put finland 20
display
quit

Sample Output
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 .
Bucket3 India@135 Aus@5 .
Display Ends
null
5
null
false
10
false
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 Sweden@1 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Pak@80 finland@20 .
Bucket3 .
Bucket4 Sweden@1 .
Bucket5 .
Bucket6 Canada@3 UK@20 .
Bucket7 India@138 China@200 Nigeria@3 .
Display Ends */