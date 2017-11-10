package org.denisjos.algos;

import java.util.HashMap;

class LRUCache {
	private int maxSize;
	private int curSize;
	private int counter;
	private HashMap<Integer, Integer> cacheObjects;
	private HashMap<Integer, Integer> cacheCounter;
	 
    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
       maxSize = N;
       curSize = 0;
       counter = 0;
       cacheObjects = new HashMap<Integer,Integer>();
       cacheCounter = new HashMap<Integer,Integer>();
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {
       if (cacheObjects.containsKey(x)) {
    	   cacheCounter.put(x, ++counter);
    	   return cacheObjects.get(x);    	   
       }       
       return -1;
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        if (cacheObjects.containsKey(x)) {
        	cacheObjects.put(x, y);
        	cacheCounter.put(x, ++counter);
        } else if (curSize == maxSize) {
        	// invalidate the least recently used key and insert the new one
    	    int lruKey = getLruKey();
    	    cacheObjects.remove(lruKey);
    	    cacheCounter.remove(lruKey);
    	    cacheObjects.put(x, y);
    	    cacheCounter.put(x, ++counter);
        } else {
            cacheObjects.put(x, y);
     	    cacheCounter.put(x, ++counter);
     	    curSize++;
       }
    }
    
    /**
     * Returns the least recently used key by checking the counters
     * */
    private int getLruKey() {
    	int minCounter = counter;
    	int lruKey = (int)cacheCounter.keySet().toArray()[0];
    	for (int key : cacheCounter.keySet()) {
    		if (minCounter > cacheCounter.get(key)) {
    			minCounter = cacheCounter.get(key);
    		    lruKey = key;
    		}
    	}
    	
    	return lruKey;
    }
    
    public static void main(final String[] args) {
    	LRUCache cache = new LRUCache(2);
    	cache.set(1, 2); cache.set(2, 3); cache.set(1, 5); cache.set(4, 5); cache.set(6, 7);
    	
    	System.out.println(cache.get(4));
    	System.out.println(cache.get(1));
    }
}
