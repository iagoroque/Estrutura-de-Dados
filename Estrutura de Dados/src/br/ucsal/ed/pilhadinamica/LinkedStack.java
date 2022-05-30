package br.ucsal.ed.pilhadinamica;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import br.ucsal.ed.listaencadeada.No;

public class LinkedStack<Item> implements Iterable<Item> {
	private int n; // size of the stack
	private Node first; // top of stack
	private int t = 0;

	// helper linked list class
	private class Node {
		private Item item;
		private Node next;
	}

	/**
	 * Initializes an empty stack.
	 */
	public LinkedStack() {
		first = null;
		n = 0;
		assert check();
	}

	/**
	 * Is this stack empty?
	 * 
	 * @return true if this stack is empty; false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of items in the stack.
	 * 
	 * @return the number of items in the stack
	 */
	public int size() {
		return n;
	}

	/**
	 * Adds the item to this stack.
	 * 
	 * @param item the item to add
	 */
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		n++;
		assert check();
	}

	/**
	 * Removes and returns the item most recently added to this stack.
	 * 
	 * @return the item most recently added
	 * @throws java.util.NoSuchElementException if this stack is empty
	 */
	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = first.item; // save item to return
		first = first.next; // delete first node
		n--;
		assert check();
		return item; // return the saved item
	}

	/**
	 * Returns (but does not remove) the item most recently added to this stack.
	 * 
	 * @return the item most recently added to this stack
	 * @throws java.util.NoSuchElementException if this stack is empty
	 */
	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return first.item;
	}

	/**
	 * Returns a string representation of this stack.
	 * 
	 * @return the sequence of items in the stack in LIFO order, separated by spaces
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Item item : this)
			s.append(item + " ");
		return s.toString();
	}

	/**
	 * Returns an iterator to this stack that iterates through the items in LIFO
	 * order.
	 * 
	 * @return an iterator to this stack that iterates through the items in LIFO
	 *         order.
	 */
	public Iterator<Item> iterator() {
		return new LinkedIterator();
	}

	// an iterator, doesn't implement remove() since it's optional
	private class LinkedIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	// check internal invariants
	private boolean check() {

		// check a few properties of instance variable 'first'
		if (n < 0) {
			return false;
		}
		if (n == 0) {
			if (first != null)
				return false;
		} else if (n == 1) {
			if (first == null)
				return false;
			if (first.next != null)
				return false;
		} else {
			if (first == null)
				return false;
			if (first.next == null)
				return false;
		}

		// check internal consistency of instance variable n
		int numberOfNodes = 0;
		for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
			numberOfNodes++;
		}
		if (numberOfNodes != n)
			return false;

		return true;
	}

	public String pesquisarNome(String nome) {
		StringBuilder s = new StringBuilder();
		for (Item item : this)
			s.append(item + " ");
		String str = s.toString();
		if (str.contains(nome)) {
			str = "Esse elemento esta na pilha.";
		} else {
			str = "Esse elemento nao esta na pilha.";
		}
		return str;
	}

	public String retornarIndice(String nome) {
    	StringBuilder s = new StringBuilder();
    	int i = 0;
    	while (i >=0 ) {
    		i++;
			for (int j = 0; j < array.length; j++) {
				
			}
		}
        for (Item item : this) {
        	t++;
            s.append(item);
            String str = s.toString();
            if (str.contains(nome)) {
				return "Esse elemento esta na posicao " + t + "da pilha.";
			} else {
				return "Elemento nao encontrado";
			}
        }
        return "Saiu aqui";
    }

	/**
	 * Unit tests the {@code LinkedStack} data type.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<String>();
//        while (!StdIn.isEmpty()) {
//            String item = StdIn.readString();
//            if (!item.equals("-"))
//                stack.push(item);
//            else if (!stack.isEmpty())
//                StdOut.print(stack.pop() + " ");
//        }
		String item;
		item = "a";
		stack.push(item);
		item = "brasil";
		stack.push(item);
		item = "c";
		stack.push(item);
		StdOut.println("(" + stack.size() + " left on stack)");
		StdOut.println("Elementos da Pilha: " + stack.toString());
		StdOut.println("Digite o nome de um elemento para busca-lo: ");
		Scanner in = new Scanner(System.in);
		String nome = in.nextLine();
		StdOut.println(stack.pesquisarNome(nome));
		StdOut.println(stack.retornarIndice(nome));
	}
}
