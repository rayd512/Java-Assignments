import java.util.ArrayList;
import java.lang.Math;

/**
 * Lab 6: Java Collection Framework, Skip List and Apache Maven <br />
 * The {@code SkipList} class
 * @param <K>           {@code K} key of each skip list node
 * @param <V>           {@code V} value of each skip list node
 */
public class SkipList<K extends Comparable<K>, V> {

	/**
	 * The {@code Node} class for {@code SkipList}
	 */
	private class Node {
		public K key;
		public V value;
		public ArrayList<Node> forwards = new ArrayList<Node>();
		public Node(K key, V value, int level) {
			this.key = key;
			this.value = value;
			for (int i = 0; i < level; i++)
				forwards.add(null);
		}
		public String toString() {
			return String.format("%s(%s,%d)", value, key, forwards.size());
		}
	}

	

	/**
	 * Level of the skip list. An empty skip list has a level of 1
	 */
	private int level = 1;

	/**
	 * Max level of the skip list. An empty skip list has a level of 1
	 */
	private int maxLevel = 3;

	/**
	 * Probability for generating a new random level
	 */
	private double p = 0.4;

	/**
	 * Size of the skip list
	 */
	private int size = 0;
	
	
	/**
	 * Head of the skiplist
	 */
	private Node header = new Node(null, null, this.maxLevel);

	/**
	 * Generates a random level for a node
	 * @return 			{@code int} a random level
	 */
	private int randLevel() {
		int currentLvl = 1;
		while (Math.random() < p) {
			currentLvl++;
		}
		
		// Return the min of current and max level
		return Math.min(currentLvl, maxLevel);
	}

	/**
	 * Insert an new element into the skip list
	 * @param key       {@code K} key of the new element
	 * @param value     {@code V} value of the new element
	 */
	public void insert(K key, V value) {
		// Initialize variables
		Node current = this.header;
		ArrayList<Node> update = new ArrayList<Node>();
		for(int i = 0; i < this.maxLevel; i++)
			update.add(null);
		

		// For each level, keep moving forward while current key is less than the search key.
		// Keep an array of updates
		for(int i = this.level-1; i >= 0; i--) {

			while(current.forwards.get(i) != null && current.forwards.get(i).key.compareTo(key) < 0) {
				current = current.forwards.get(i);
			}
			update.set(i, current);
		}
		
		// Current is now where the new key will be inserted
		current = current.forwards.get(0);

		// Check if we found the key and just have to update it
		if (current == null || current.key != key) {
			// Generate a new level for the node
			int newLevel = randLevel();

			// Check if the new node level is higher the the current level of the list
			if(newLevel > this.level) {
				// Update updates array
				for(int i = level; i < newLevel; i++) {
					update.set(i, this.header);
				}
				
				// Update the header
				while(this.header.forwards.size() < this.level)
					this.header.forwards.add(null);
				
				// Increase the level
				this.level = newLevel;
			}
			
			
			// Create the new node
			Node newNode = new Node(key, value, newLevel);

			// Rearrange pointers
			for(int i = 0; i < newLevel; i++) {
				newNode.forwards.set(i, update.get(i).forwards.get(i));
				update.get(i).forwards.set(i, newNode);
			}
			// Increase the size of the list
			this.size++;
		} else {
			// Update the key if the key is already in the list
			current.key = key;
		}

		
	}

	/**
	 * Remove an element by the key
	 * @param key       {@code K} key of the element
	 * @return          {@code V} value of the removed element
	 */
	public V remove(K key) {
		// Initialize variables
		Node current = this.header;
		ArrayList<Node> update = new ArrayList<Node>();
		for(int i = 0; i < this.maxLevel; i++)
			update.add(null);

		// For each level, keep moving forward while current key is less than the search key.
		// Keep an array of updates
		for(int i = this.level-1; i >= 0; i--) {
			while(current.forwards.get(i) != null && current.forwards.get(i).key.compareTo(key) < 0) {
				current = current.forwards.get(i);
			}
			update.set(i, current);
		}

		// Current is now where the new key will be inserted
		current = current.forwards.get(0);

		// Check if the key was found
		if(current != null && current.key.equals(key)) {
			
			// Rearrange pointer
			for (int i = 0; i < level; i++) {
				// break if not the current node, no need to update
				if(update.get(i).forwards.get(i) != current)
					break;

				update.get(i).forwards.set(i, current.forwards.get(i)); 
			}
			// Remove levels
			while (level > 0 && this.header.forwards.get(level-1) == null)
			 	level--;
			return current.value;
		}
		
		// Return null if nothing was found
		return null;
	}

	/**
	 * Search for an element by the key
	 * @param key       {@code K} key of the element
	 * @return          {@code V} value of the target element
	 */
	public V search(K key) {
		// Initialize variables
		Node current = this.header;
			

		// Start at top level and check if we need to move forward. Then go down a level until level 1
		for (int i = level-1; i >= 0; i--) {
			while(current.forwards.get(i) != null && current.forwards.get(i).key.compareTo(key) < 0)
				current = current.forwards.get(i);
		}

		// Get the value
		current = current.forwards.get(0);
		
		// Return the value if it was found
		if(current != null && current.key.equals(key))
			return current.value;
		// Return null if not found
		return null;
	}

	/**
	 * Get the level of the skip list
	 * @return          {@code int} level of the skip list
	 */
	public int level() {
		return level;
	}

	/**
	 * Get the size of the skip list
	 * @return          {@code int} size of the skip list
	 */
	public int size() {
		return size;
	}

	/**
	 * Print the skip list
	 * @return          {@code String} the string format of the skip list
	 */
	public String toString() {

		// Make every node have forwards of size 3
		Node current = this.header.forwards.get(0);
		while(current != null && current.forwards.size() > 0) {
			while(current.forwards.size() != this.level) {
				current.forwards.add(null);
			}
			current = current.forwards.get(0);
		}
		
		// Loop through every level and print out each key
		for(int i = 0; i < this.level; i++) {
			current = this.header.forwards.get(i);
			System.out.print("Level " + (i + 1) + ": ");
			
			while(current != null) {
				System.out.print(current.key + " ");
				current = current.forwards.get(i);
			}
			System.out.println();
		}
		return "Done";



		
	}

	/**
	 * Main entry
	 * @param args      {@code String[]} Command line arguments
	 */
	public static void main(String[] args) {
		SkipList<Integer, String> list = new SkipList<Integer, String>();
		int[] keys = new int[10];
		for (int i = 0; i < 10; i++) {                          // Insert elements
			keys[i] = (int) (Math.random() * 200);
			list.insert(keys[i], "\"" + keys[i] + "\"");
		}

		System.out.println(list);

		for (int i = 0; i < 10; i += 3) {
			int key = keys[i];
			// Search elements
			System.out.println(String.format("Find element             %3d: value=%s", key, list.search(key)));
			// Remove some elements
			System.out.println(String.format("Remove element           %3d: value=%s", key, list.remove(key)));
			// Search the removed elements
			System.out.println(String.format("Find the removed element %3d: value=%s", key, list.search(key)));
		}

		System.out.println(list);
	}

}
