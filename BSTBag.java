/*
 * Giedre Stulgyte 
 * 22856161s
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

import assEx2018.filesForExercise.Bag;

public class  BSTBag<E extends Comparable<E>> implements Bag<E> 
{
	// instance variables
	private Node<E> root;
	private int size;

	// nested class
	private static class Node<E extends Comparable<E>>
	{
		// instance variables
		protected E element;
		protected Node<E> left, right;

		protected Node(E elem)
		{
			this.element = elem;
			this.left = null;
			this.right = null; 
		} 

		private Node<E> deleteTopmost()
		{
			if (this.left == null)
			{
				return this.right; 
			}

			else if (this.right == null)
			{
				return this.left;
			}

			else 
			{
				this.element = (E) this.right.getLeftmost();
				this.right = this.right.deleteLeftmost();
				return this; 
			}
		}

		private Node<E> getLeftmost() 
		{
			return this.left;
		}

		private Node<E> deleteLeftmost() 
		{
			if (this.left == null)
			{
				return this.right; 
			}

			else
			{
				Node<E> parent = this;
				Node<E> curr = this.left;

				while(curr.left!=null)
				{
					parent = curr; 
					curr = curr.left;
				}

				parent.left = curr.right; 
				return this;
			}
		}
	}

	// nested class
	private class InOrderIterator implements Iterator<E>
	{
		private Stack<Node<E>> track;

		@Override
		public boolean hasNext() {

			return (!track.empty());
		}

		@Override
		public E next() {

			if (track.empty())
			{
				throw new NoSuchElementException();
			}

			Node<E> place = track.pop();

			for(Node<E> curr = place.right; curr!= null; curr = curr.left)
			{
				track.push(curr);
			}

			return place.element; 
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

		Iterator<E> iterator = that.iterator();

		while (iterator.hasNext())
		{
			if (this.contains(iterator.next()))
			{
				return true; 
			}
		}

		return false;
	}

	@Override
	public void clear() 
	{
		root = null; 

	}

	@Override
	public void add(E element) 
	{
		// increment the size
		this.size++;

		Node<E> ins = new Node<E> (element);
		if(this.isEmpty()) 
		{
			root = ins;
			return;
		}

		int direction = 0;

		Node<E> parent = null;
		Node<E> curr = root; 

		for (;;) 
		{
			if (curr == null) 
			{	
				if (direction<0) 
				{
					parent.left = ins; 
				}
				else 
				{
					parent.right = ins; 
				}
				return; 
			}

			direction = element.compareTo(curr.element);

			if(direction == 0)
			{
				return;
			}

			parent = curr; 

			if (direction<0)
			{
				curr = curr.left; 
			}

			else 
			{
				curr = curr.right; 
			}
		}
	}

	@Override
	public void remove(E element) 
	{
		this.size--; 

		int direction = 0;

		Node<E> parent = null;
		Node<E> curr = root; 

		// if tree is empty
		if(this.isEmpty()) 
		{ 
			return;
		}

		for (;;) 
		{ 
			direction = element.compareTo(curr.element); 

			if (direction == 0) 
			{
				Node<E> del = curr.deleteTopmost(); 

				if (curr == root)
				{
					root = del; 
				}

				else if(curr == parent.left)
				{
					parent.left = del; 
				}

				else 
				{
					parent.right = del; 
				}

				return; 
			}
			
			parent = curr;
			
			if (direction < 0)
			{
				curr = parent.left; 
			}
			
			else
			{ 
				curr = parent.right;
			}
		}
	}

	@Override
	public Iterator<E> iterator() 
	{
		return new InOrderIterator();
	}

	@Override
	public boolean contains(E element) 
	{
		Node<E> curr = root; 
		int direction = 0;

		if (this.isEmpty())
		{
			return false; 
		}

		while (curr!=null) 
		{
			direction = element.compareTo(curr.element);

			if (direction == 0)
			{
				return true; 
			}

			else if (direction < 0)
			{
				curr = curr.left; 
			}

			else 
			{
				curr = curr.right; 
			}
		}

		return false;
	}

}
