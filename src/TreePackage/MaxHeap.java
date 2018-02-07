/****************************************************************
 * file: MaxHeap.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 2
 * date last modified: 2018-02-07
 * 
 * purpose: This class defines a Max Heap data structure which stores
 * data in an array and provides the necessary interfaces for use in
 * programs
 * 
 ****************************************************************/
package TreePackage;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {
	private T[] heap; //all of the heap entries
	private int lastIndex; //index of the last entry
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	private static int swaps = 0;
	
	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}
	
	public MaxHeap(int initialCapacity) {
		if(initialCapacity < DEFAULT_CAPACITY) {
			log("Setting to default capacity");
			initialCapacity = DEFAULT_CAPACITY;
		}
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
		heap = tempHeap;
		lastIndex = 0;
		initialized = true;
	}
	
	@SuppressWarnings("unchecked")
	public MaxHeap(Object[] entries) {
		this(entries.length);
		assert initialized = true;
		for(int index=0; index < entries.length; index++) {
			heap[index + 1] = (T) entries[index];
			lastIndex++;
		}
		for(int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--) {
			reheap(rootIndex);
		}
	}

	@Override
	public T removeMax() {
		checkInitialization();
		T root = null;
		if(!isEmpty()) {
			root = heap[1];
			heap[1] = heap[lastIndex];
			lastIndex--;
			reheap(1);
		}
		return root;
	}

	@Override
	public T getMax() {
		checkInitialization();
		T root = null;
		if(!isEmpty()) {
			root = heap[1];
		}
		return root;
	}

	@Override
	public boolean isEmpty() {
		return lastIndex < 1;
	}

	@Override
	public int getSize() {
		return lastIndex;
	}

	@Override
	public void clear() {
		checkInitialization();
		while(lastIndex > -1) {
			heap[lastIndex] = null;
			lastIndex--;
		}
		lastIndex = 0;
	}
	
	private void ensureCapacity() {
		if(lastIndex >= heap.length) {
			int newCapacity = 2 * (heap.length - 1);
			checkCapacity(newCapacity);
			heap = Arrays.copyOf(heap, newCapacity);
		}
	}
	
	private void checkCapacity(int capacity) {
		if(capacity > MAX_CAPACITY) {
			throw new IllegalStateException("Capacity exceeds allowed capacity");
		}
		
	}
	
	public void add(T newEntry) {
		checkInitialization();
		int newIndex = lastIndex + 1;
		int parentIndex = newIndex / 2;
		while((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
			swaps++;
		}
		heap[newIndex] = newEntry;
		lastIndex++;
		ensureCapacity();
	}
	
	private void checkInitialization() {
		if(!initialized) {
			throw new SecurityException("Not initialized");
		}
	}
	
	private void reheap(int rootIndex) {
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex + 1;
		
		while(!done && (leftChildIndex < lastIndex)) {
			int largerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;
			
			boolean rci_gte_li = rightChildIndex <= lastIndex;
			boolean rci_vs_lci = heap[rightChildIndex].compareTo(heap[largerChildIndex]) >= 0;
			if(rci_gte_li && rci_vs_lci) {
				largerChildIndex = rightChildIndex;
			}
			
			if(orphan.compareTo(heap[largerChildIndex]) < 0) {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex;
				swaps++;
			} else {
				done = true;
			}
		}
		heap[rootIndex] = orphan;
	}
	
	public int getSwaps() {
		return swaps;
	}
	
	private void log(String text) {
		System.out.println(text);
	}
	
	// returns array list representation of the heap for use outside of the class
	public ArrayList<T> getHeap() {
		ArrayList<T> bart = new ArrayList<T>();
		for(T i : heap) {
			bart.add(i);
		}
		return bart;
	}
}















