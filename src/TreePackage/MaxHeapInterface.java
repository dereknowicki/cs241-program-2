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
	public T removeMax();
	public T getMax();
	public boolean isEmpty();
	public int getSize();
	public void clear();
	public void add(T newEntry);
}
