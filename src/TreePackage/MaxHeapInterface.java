package TreePackage;

public interface MaxHeapInterface<T extends Comparable<? super T>> {
	public T removeMax();
	public T getMax();
	public boolean isEmpty();
	public int getSize();
	public void clear();
	public void add(T newEntry);
}
