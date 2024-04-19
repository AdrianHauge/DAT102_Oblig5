package Oppgave1;
import java.util.*;


public class hashing<K, B> {

	private int strl;
	private int maxstrl;
	private Entry<K, B>[] hashtable;
	
	
	@SuppressWarnings("unchecked")
	public hashing(int maxstrl) {
		
		this.maxstrl = maxstrl;
		this.hashtable = new Entry[strl];
		this.strl = 0;
		
		
	}
	
	public void put(K key, B bil) {
		
		if(strl == maxstrl) {
			System.out.println("Max størrelse");
			return;
		}
		
		int i = hash(key);
		while (hashtable[i] != null ) {
			i = (i + 1) % maxstrl;
		}
		hashtable[i] = new Entry<>(key, bil);
		strl++;	
	}
	
	public B get(K key) {
		
		int i  = hash(key);
		while(hashtable[i] != null && !hashtable[i].key.equals(key)) {
			i = (i + 1) % maxstrl;
		}
		if(hashtable[i] != null) {
			return hashtable[i].bil;
		}
		return null;
		
	}
	
	private int hash(K key) {
		return Math.abs(key.hashCode()) % maxstrl;
	}
	
	
	@Override
	public String toString() {
	    String result = "{";
	    for (int i = 0; i < maxstrl; i++) {
	        if (hashtable[i] != null) {
	            result += hashtable[i].key + "=" + hashtable[i].bil + ", ";
	        }
	    }
	    if (result.length() > 1) {
	        result = result.substring(0, result.length() - 2); // Remove the trailing comma and space
	    }
	    result += "}";
	    return result;
	}

	 private static class Entry<K, B> {
	        K key;
	        B bil;

	        Entry(K key, B bil) {
	            this.key = key;
	            this.bil = bil;
	        }
	    }

	
	public static void main(String[] args) {
		
	hashing<Integer, String> hashtable = new hashing<>(10);
		
		hashtable.put(1, "EL65431");
		hashtable.put(4, "TA14374");
		hashtable.put(1, "ZX87181");
		hashtable.put(7, "EL47007");
		hashtable.put(0, "VV50000");
		hashtable.put(4, "UV14544");
		hashtable.put(4, "EL32944");
		
		

	}	 

}
