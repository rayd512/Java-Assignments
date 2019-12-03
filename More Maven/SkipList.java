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

	private int maxLevel = 3;

	private double p = 0.4;

	/**
	 * Size of the skip list
	 */
	private int size = 0;

	private Node header = new Node(null, null, this.maxLevel);

	private int randLevel() {
		int currentLvl = 1;
		while (Math.random() < p) {
			currentLvl++;
		}

		return Math.min(currentLvl, maxLevel);
	}

	/**
	 * Insert an new element into the skip list
	 * @param key       {@code K} key of the new element
	 * @param value     {@code V} value of the new element
	 */
	public void insert(K key, V value) {
		// TODO: Lab 5 Part 1-1 -- skip list insertion
		Node current = this.header;
		ArrayList<Node> update = new ArrayList<Node>();
		for(int i = 0; i < this.maxLevel; i++)
			update.add(null);
		

		
		for(int i = this.level-1; i >= 0; i--) {

			while(current.forwards.get(i) != null && current.forwards.get(i).key.compareTo(key) < 0) {
				current = current.forwards.get(i);
			}
			update.set(i, current);
		}
		

		current = current.forwards.get(0);


		if (current == null || current.key != key) {
			int newLevel = randLevel();

			if(newLevel > this.level) {
				for(int i = level; i < newLevel; i++) {
					update.set(i, this.header);
				}
				while(this.header.forwards.size() < this.level)
					this.header.forwards.add(null);
//				Node temp = this.header.forwards.get(0);
//				for(int i = 0; i < this.size; i++) {
//					for(int j = 0; j < newLevel - level; j++)
//						temp.forwards.add(null);
//					temp = temp.forwards.get(0);
//				}
//				for (int i = 0; i < this.level; i++) {
//					Node node = this.header.forwards.get(0);
//					while(node != null && node.key != null) {
//						for(int j = 0; j < newLevel - level; j++)
//						node.forwards.add(null);
//						node = node.forwards.get(i);
//					}
//				}
				this.level = newLevel;
			}
			
			

			Node newNode = new Node(key, value, newLevel);

			for(int i = 0; i < newLevel; i++) {
				newNode.forwards.set(i, update.get(i).forwards.get(i));
				update.get(i).forwards.set(i, newNode);
			}
			this.size++;
		} else {
			current.key = key;
		}

		
	}

	/**
	 * Remove an element by the key
	 * @param key       {@code K} key of the element
	 * @return          {@code V} value of the removed element
	 */
	public V remove(K key) {
		// TODO: Lab 5 Part 1-2 -- skip list deletion
		Node current = this.header;
		ArrayList<Node> update = new ArrayList<Node>();
		for(int i = 0; i < this.maxLevel; i++)
			update.add(null);

		
//		if (current.key != key) {
			for(int i = this.level-1; i >= 0; i--) {
				while(current.forwards.get(i) != null && current.forwards.get(i).key.compareTo(key) < 0) {
					current = current.forwards.get(i);
				}
				update.set(i, current);
			}
			
//		}
		
		current = current.forwards.get(0);


		if(current != null && current.key.equals(key)) {
			for (int i = 0; i < level; i++) {
				if(update.get(i).forwards.get(i) != current)
					break;

				update.get(i).forwards.set(i, current.forwards.get(i)); 
			}
			 while (level > 0 && this.header.forwards.get(level-1) == null)
			 	level--;
			return current.value;
		}

		return null;
	}

	/**
	 * Search for an element by the key
	 * @param key       {@code K} key of the element
	 * @return          {@code V} value of the target element
	 */
	public V search(K key) {
		// TODO: Lab 5 Part 1-3 -- skip list node search
		Node current = this.header;
			
		if(current.key == key)
			return current.value;
		
		for (int i = level-1; i >= 0; i--) {
			while(current.forwards.get(i) != null && current.forwards.get(i).key.compareTo(key) < 0)
				current = current.forwards.get(i);
		}

		current = current.forwards.get(0);

		if(current != null && current.key.equals(key))
			return current.value;
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
		// TODO: Lab 5 Part 1-4 -- skip list printing
		
		String s = "[";
		Node n = this.header;

		while (n != null && n.forwards.size() > 0) {
			n = n.forwards.get(0);
			s += n + ", ";
		}
		
		System.out.println(s.substring(0, s.length() - 2) + "]");

		
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
//			System.out.println(list);
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

//		System.out.println(list);
	}

}
