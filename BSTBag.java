import java.util.Iterator;

import assEx2018.filesForExercise.Bag;

public class  BSTBag<E extends Comparable<E>> implements Bag<E> 
{
	// instance variables
	private Node<CountedElement> root;
	private int size;

	// nested class
	private static class Node<E extends CountedElement>
	{
		// instance variables
		protected CountedElement element;
		protected Node<E> left, right;

		protected Node(E elem)
		{
			this.element = elem;
			this.element.setCount(1);

			this.left = null;
			this.right = null; 
		}
	}

	// nested class
	private class InOrderIterator implements Iterator<E>
	{
		private Stack<Node<CountedElement>> track; 
		//contains references to nodes still to be visited

		// Text below is from lecture slides
		// An InOrderIterator object is an object will traverse
		// in in-order, the BSTSet object representing a set
		// iterator is represented by a stack of references to 
		// nodes still to be visited, track

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public BSTBag() {

		this.root = null;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() 
	{

		if(this.root == null) 
		{
			return true;
		}

		else 
		{
			return false;
		}
	}

	@Override
	public int size() 
	{
		return this.size;
	}


	@Override
	public boolean equals(Bag<E> that) 
	{

		if (this.isEmpty())
		{
			return false;
		}

		//not finished

		return false;
	}

	@Override
	public void clear() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void add(E element) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(E element) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<E> iterator() 
	{
		return new InOrderIterator();
	}

	@Override
	public boolean contains(E element) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
