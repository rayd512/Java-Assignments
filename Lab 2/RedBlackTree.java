import java.util.LinkedList;
import java.util.Queue;
/**
 * Lab 2: Debugging with Eclipse and Red Black Tree) <br />
 * The {@code RedBlackTree} class of integers only <br />
 * Reference: <a href="https://en.wikipedia.org/wiki/Red%E2%80%93black_tree">
 *              https://en.wikipedia.org/wiki/Red%E2%80%93black_tree
 *            </a>
 */
public class RedBlackTree {

	/**
	 * Root node of the red black tree
	 */
	private Node root = null;

	/**
	 * Size of the tree
	 */
	private int size = 0;

	/**
	 * Perform a left rotation on the tree
	 * @param inserted     {@code Node} The node that was just inserted
	 */
	private void leftRotate(Node inserted) {
		// use a temp value to hold rChild
		Node temp = inserted.rChild;
		// Change the rchild
		inserted.rChild = temp.lChild;
		// Check if lchild is null
		if(temp.lChild != null) {
			temp.lChild.parent = inserted;
		}
		// Use temp to hold parent value
		temp.parent = inserted.parent;
		// Check different cases
		if(inserted.parent == null) {
			this.root = temp;
		} else if (inserted == inserted.parent.lChild) {
			inserted.parent.lChild = temp;
		} else {
			inserted.parent.rChild = temp;
		}
		// Set variables appropirately
		temp.lChild = inserted;
		inserted.parent = temp;
	}


	/**
	 * Perform a right rotation on the tree
	 * @param inserted     {@code Node} The node that was just inserted
	 */
	private void rightRotate(Node inserted) {
		// Set temporary values in order to not lose values
		Node temp = inserted.lChild;
		inserted.lChild = temp.rChild;
		temp.rChild.parent = inserted;
		temp.parent = inserted.parent;
		// Check various cases
		if(inserted.parent == null) {
			root = temp;
		} else if (inserted == inserted.parent.rChild) {
			inserted.parent.rChild = temp;
		} else {
			inserted.parent.lChild = temp;
		}
		// Set the rchild and parent
		temp.rChild = inserted;
		inserted.parent = temp;
	}

	/**
	 * Fix any properties violated from the insertion of the new node
	 * @param inserted     {@code Node} The node that was just inserted
	 */
	private void fixInsertion(Node inserted) {
		// Make a new temp variable of type node
		Node temp = new Node(null);
		// This loops until the inserted parents color is red. Each iteration
		// it will check for 4 different cases and perform the appropriate 
		// modifications in order to satisfy the properties of a red black tree
		// after it has been violated by an insertion
		while(inserted.parent.color == Node.RED ) {
			
			if(inserted.parent == inserted.parent.parent.lChild) {
				temp = inserted.parent.parent.rChild;
				if(temp.color == Node.RED) {
					inserted.parent.color = Node.BLACK;
					temp.color = Node.BLACK;
					inserted.parent.parent.color = Node.RED;
					inserted = inserted.parent.parent;
				} else { 
					if (inserted == inserted.parent.rChild) {
					
					inserted = inserted.parent;
					leftRotate(inserted);

					}
					if(inserted.parent.parent == null) {
						break;
					}
					inserted.parent.color = Node.BLACK;
					inserted.parent.parent.color = Node.RED;
					rightRotate(inserted.parent.parent);
				} 
			} else {
				temp = inserted.parent.parent.lChild;
				if(temp.color == Node.RED) {
					inserted.parent.color = Node.BLACK;
					temp.color = Node.BLACK;
					inserted.parent.parent.color = Node.RED;
					inserted = inserted.parent.parent;
				} else {
					if(inserted == inserted.parent.lChild) {
						inserted = inserted.parent;
					}
					if(inserted.parent.parent == null) {
						break;
					}
					inserted.parent.color = Node.BLACK;
					inserted.parent.parent.color = Node.RED;
					leftRotate(inserted.parent.parent);
				}
				
			}
			// Break if there is no parent, or else an exception will be thrown
			if(inserted.parent == null) {
				break;
			}
			
		}
		// Ensure the root node is always black
		this.root.color = Node.BLACK;
	}

	/**
	 * Search the tree to find if the value is contained
	 * @param value     {@code int} the value to be checked
	 * @return          {@code boolean} If contains, return {@code true}, otherwise return {@code false}
	 */
	public boolean contains(int value) {
		// Set the current node to the root node
		Node current = this.root;
		// Standard BST search algorithm
		while(current.value != null) {
			if(current.value < value) {
				current = current.rChild;
			}
			else if (current.value > value) {
				current = current.lChild;
			}
			else {
				return true;
			}
		}
		return false;
	}

	/**
	 * Insert an integer to the tree
	 * @param data      {@code int} New element to be inserted
	 */
	public void insert(int value) {
		// TODO: Lab 2 Part 2-2 -- insert an integer into the tree
		// Increase the size of the tree
		this.size++;
		// Instatiate Nodes
		Node newValue = new Node(value);
		newValue.color = Node.RED;
		Node newParent = null;
		Node current = this.root;
		// Go through to check where to insert the new Node
		while(current != null && current.value != null) {
			newParent = current;
			if(value < current.value) {
				current = current.lChild;
			} else {
				current = current.rChild;
			}
		}

		// Set parent to newParent found above, if any
		newValue.parent = newParent;
		// Go through different cases to check what to do
		if(newParent == null || size == 0) {
			newValue.color = Node.BLACK;
			root = newValue;
			return;
		} else if(newValue.value < newParent.value) {
			newParent.lChild = newValue;

		} else {
			newParent.rChild = newValue;
		}
		if(newValue.parent == null) {
			newValue.color = Node.RED;
			return;
		}

		if(newValue.parent.parent == null) {
			return;
		}
		// Call fix insertion to fix the insertion
		fixInsertion(newValue);
		
	}

	/**
	 * Get the size of the tree
	 * @return          {@code int} size of the tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Traverse the tree Inorder and prints the node
	 * @param inserted     {@code Node} The root node
	 */
	public void traverseTree(Node current) {
		if(current.value == null) {
			return;
		}
		// traverseTree(current.lChild);
		// System.out.println(current);
		// traverseTree(current.rChild);

	    Queue<Node> q = new LinkedList<Node>();

	    q.add(current);            
	    while(true)
	    {               
	        int nodeCount = q.size();
	        if(nodeCount == 0)
	            break;

	        while(nodeCount > 0)
	        {    
	            Node node = q.peek();
	            System.out.print(node);

	            q.remove();

	            if(node.lChild != null) {
	                q.add(node.lChild);
	            }

	            if(node.rChild != null) {
	                q.add(node.rChild);
	            }

	            if(nodeCount>1){
	               System.out.print(", ");
	            }
	            nodeCount--;    
	        }     
	        System.out.println();
	    }
		
	}
	/**
	 * Cast the tree into a string
	 * @return          {@code String} Printed format of the tree
	 */
	@Override public String toString() {
		// TODO: Lab 2 Part 2-3 -- print the tree, where each node contains both value and color
		// You can print it by in-order traversal
		traverseTree(this.root);
		return "Red Black Tree Traversal";
	}

	/**
	 * Main entry
	 * @param args      {@code String[]} Command line arguments
	 */
	public static void main(String[] args) {
		RedBlackTree rbt = new RedBlackTree();
		int[] arr = {60, 5, 18, 50, 23};
		for (int i = 0; i < 5; i++) {
			// int temp = (int) (Math.random() * 200)
			rbt.insert(arr[i]);
		}


		assert rbt.root.color == RedBlackTree.Node.BLACK;
		System.out.println(rbt.root);           // This helps to figure out the tree structure
		System.out.println(rbt);
	}


	/**
	 * The {@code Node} class for {@code RedBlackTree}
	 */
	private class Node {
		public static final boolean BLACK = true;
		public static final boolean RED = false;

		public Integer value;
		public boolean color = BLACK;
		public Node parent = null, lChild = null, rChild = null;

		public Node(Integer value) {             // By default, a new node is black with two NIL children
			this.value = value;
			if (value != null) {
				lChild = new Node(null);         // And the NIL children are both black
				lChild.parent = this;
				rChild = new Node(null);
				rChild.parent = this;
			}
		}

		/**
		 * Print the tree node: red node wrapped by "<>"; black node by "[]"
		 * @return          {@code String} The printed string of the tree node
		 */
		@Override public String toString() {
			if (value == null)
				return "null";
			return (color == RED) ? "<" + value + ">" : "[" + value + "]";
		}
	}

}
