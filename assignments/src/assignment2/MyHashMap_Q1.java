package assignment2;

import java.util.HashMap;
import java.util.LinkedList;

public class MyHashMap_Q1<K, V> {

	private HashMap<K, LinkedList<V> > hashMap;
	
	
	public MyHashMap_Q1() {
		super();
		hashMap = new HashMap<K, LinkedList<V> >();
	}
	
	public void put(K key, V value) {
		if(!hashMap.containsKey(key)) {
			hashMap.put(key, new LinkedList<V>());
			hashMap.get(key).add(value);
		} else {
			hashMap.get(key).add(value);
//			hashMap.get(key).sort(null);
		}
	}
	
	public LinkedList<V> get(K key) {
		return hashMap.get(key);
	}
	
	public void remove(K key, V value) {
		if(hashMap.containsKey(key)) {
			if(hashMap.get(key).contains(value))
				hashMap.get(key).remove(value);
		}
	}
	
	public void remove(K key) {
		hashMap.remove(key);
	}

	@Override
	public String toString() {
		return "MyHashMap [hashMap=" + hashMap + "]";
	}
	
	
	
	public static void main(String[] args) {
		
		MyHashMap_Q1<Character, Integer> hm = new MyHashMap_Q1<Character, Integer>();
		
		hm.put('f', 2);
		hm.put('c', 5);
		hm.put('c', 90);
		hm.put('s', 50);
		hm.put('c', 60);
		hm.put('s', 35);
		
		
		System.out.println(hm);
		System.out.println(hm.get('s'));
		
	}
	
	
}
