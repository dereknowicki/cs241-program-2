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
	 * purpose: 
	 */
	public T removeMax();
	/**
	 * method: getMax
	 * @return
	 * purpose: 
	 */
	public T getMax();
	/**
	 * method: isEmpty
	 * @return
	 * purpose: 
	 */
	public boolean isEmpty();
	/**
	 * method: getSize
	 * @return
	 * purpose: 
	 */
	public int getSize();
	/**
	 * method: clear
	 * purpose: 
	 */
	public void clear();
	/**
	 * method: add
	 * @param newEntry
	 * purpose: 
	 */
	public void add(T newEntry);
}
