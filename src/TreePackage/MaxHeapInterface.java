/****************************************************************
 * file: MaxHeapInterface.java 
 * author: Derek Nowicki
 * class: CS 241 – Data Structures and Algorithms II
 * 
 * assignment: program 2
 * date last modified: 2018-02-07
 * 
 * purpose: This interface defines abstract methods for a Max Heap
 * data structure
 * 
 ****************************************************************/

package TreePackage;

public interface MaxHeapInterface<T extends Comparable<? super T>> {
	/**
	 * method: removeMax
	 * @return
	 * purpose: removes the highest value node of the heap
	 */
	public T removeMax();
	
	/**
	 * method: getMax
	 * @return
	 * purpose: returns the max value of the heap
	 */
	public T getMax();
	
	/**
	 * method: isEmpty
	 * @return
	 * purpose: returns true if the heap is empty
	 */
	public boolean isEmpty();
	
	/**
	 * method: getSize
	 * @return
	 * purpose: returns the size of the heap
	 */
	public int getSize();
	
	/**
	 * method: clear
	 * purpose: clears all entries of the heap
	 */
	public void clear();
	
	/**
	 * method: add
	 * @param newEntry
	 * purpose: adds a single entry to the heap
	 */
	public void add(T newEntry);
}
