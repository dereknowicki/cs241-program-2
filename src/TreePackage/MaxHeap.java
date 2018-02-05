package TreePackage;

public final class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface {
	private T[] heap; //all of the heap entries
	private int lastIndex; //index of the last entry
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}
	
	public MaxHeap(int initialCapacity) {
		if(initialCapacity < DEFAULT_CAPACITY) {
			initialCapacity = DEFAULT_CAPACITY;
		} else {
			checkCapacity(initialCapacity);
			@SuppressWarnings("unchecked")
			T[] tempHeap = (T[]) new Comparable[initialCapacity +1];
			heap = tempHeap;
			lastIndex = 0;
			initialized = true;
		}
	}

	@Override
	public void add(T newEntry) {
		checkInitialization();
		int newIndex = lastIndex + 1;
		int parentIndex = newIndex / 2;
		while((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
		}
		heap[newIndex] = newEntry;
		lastIndex++;
		ensureCapacity();
		
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
		return null;
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
	
	private void reheap(int rootIndex) {
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex;
		
		while(!done && (leftChildIndex <= lastIndex)) {
			int largerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;
			
			boolean rci_gte_li = rightChildIndex <= lastIndex;
			boolean rci_vs_lci = heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0;
			if(rci_gte_li && rci_vs_lci) {
				largerChildIndex = rightChildIndex;
			}
			
			if(orphan.compareTo(heap[largerChildIndex]) < 0) {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex;
			} else {
				done = true;
			}
		}
		heap[rootIndex] = orphan;
	}

}















