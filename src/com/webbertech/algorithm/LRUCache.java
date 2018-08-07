package com.webbertech.algorithm;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//This is by far the best solution, and simple, should be prepared for interview
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

	private static final long serialVersionUID = -4452066900131894355L;
	private int size;

       private LRUCache(int size) {
           super(size, 0.75f, true);
		   this.size = size;
      }

       public static <K,V> LRUCache<K,V> newInstance(int size) {
            return new LRUCache<K,V>(size);
      }

      public void setMaxSize(int size) {
          this.size = size; 
      }

      @Override
      protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
    	  return size() > size;
      }
      

		@SuppressWarnings("unchecked")
		public void showBufferFrame() {
			Set<Map.Entry<K, V>> m = this.entrySet();
			Iterator<V> it = this.values().iterator();
			while (it.hasNext()) {
				System.out.print (it.next() + "\t");
			}
			
			System.out.println();
		}
		
      
      public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = LRUCache.newInstance(3);
		lruCache.put("7", 7);
		lruCache.put("0", 0);
		lruCache.put("1", 1);
		lruCache.showBufferFrame();
		
		lruCache.put("2", 2);
		lruCache.showBufferFrame();
		lruCache.put("0", 0);
		lruCache.showBufferFrame();
		lruCache.put("3", 3);
		lruCache.showBufferFrame();
		lruCache.put("0", 0);
		lruCache.showBufferFrame();
		lruCache.put("4", 4);
		lruCache.showBufferFrame();
		lruCache.put("2", 2);
		lruCache.showBufferFrame();
		lruCache.put("3", 3);
		lruCache.showBufferFrame();
		lruCache.put("0", 0);
		lruCache.showBufferFrame();
		lruCache.put("3", 3);
		lruCache.showBufferFrame();
		lruCache.put("2", 2);
		lruCache.showBufferFrame();
		lruCache.put("1", 1);
		lruCache.showBufferFrame();
		lruCache.put("2", 2);
		lruCache.showBufferFrame();
		
	
      }
}