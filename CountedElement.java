public class CountedElement<E extends Comparable<E>> implements Comparable<CountedElement<E>> {
	private E element;
	private int count;

	public CountedElement(E e, int count){
		//constructor - completed
		e = element; 	
	}
	
	public CountedElement(E e){ 
		// constructor
		e = element;
	}
	
	public void setCount(int c) {
		// setter
		this.count = c; 
	}
	
	public int getCount() {
		// getter
		return this.count; 
	}

	//add getters and setters
	
	//add toString() method
	
	@Override
	public String toString() {
		
		 return this.element + " " + this.count; 
	}
	
	
	public int compareTo(CountedElement<E> sC1) {
    
		//to complete
		
		return 0; // placeholder
	}

}
