public class CountedElement<E extends Comparable<E>> implements Comparable<CountedElement<E>> {
	private E element;
	private int count;

	public CountedElement(E e, int count){
		//constructor 
		this.element = e; 
		this.count = count;
	}
	
	public CountedElement(E e){ 
		// constructor
		this.element = e;
		this.count = 1; // <-- optional but prevents an exception
		// if the count has not been set and a getter method 
		// is called.
	}
	
	public void setCount(int c) {
		// setter
		this.count = c; 
	}
	
	public int getCount() {
		// getter
		return this.count; 
	}
	
	public void setElement(E e) {
		// setter
		this.element = e; 
	}
	
	public E getElement() {
		// getter
		return this.element;
	}

	@Override
	public String toString() {
		
		 return this.element + " " + this.count; 
	}
	
	public int compareTo(CountedElement<E> sC1) {
    
		return this.element.compareTo(sC1.element);
		
	}

}
