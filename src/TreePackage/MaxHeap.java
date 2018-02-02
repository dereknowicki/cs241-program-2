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
		// TODO Auto-generated method stub
		
	}

	@Override
	public T removeMax() {
		// TODO Auto-generated method stub
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

}














