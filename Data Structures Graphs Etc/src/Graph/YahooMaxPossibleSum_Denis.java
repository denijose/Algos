package Graph;

public class YahooMaxPossibleSum_Denis {

	/**
	 * To find the maximum possible sum from root to any leaf, we can check the maximum of the sum gathered by going down the left sub tree and the right sub tree. This can be
recursively done and at each time returning the maximum of the left sum or the right sum.

YahooMaxPossibleSum is the class that does this. It has an inner class Node which is used to create a binary tree.

Runtime -
Runtime would be O(n) (where n is the number of nodes in the binary tree ) because the algorithm traverses the entire binary tree visiting each node once.
Space complexity would also be O(n) as this would require a stack of the size of the number of nodes for the recursion

	 */
	public static void main(String[] args) {
		// create a binary tree
		//       1
       // -10        10
      // 100  1  20   15
		YahooMaxPossibleSum_Denis obj = new YahooMaxPossibleSum_Denis();
		Node root = obj.new Node(1);
		root.addLeftChild(-10);
		root.addRightChild(10);
		root.left.addLeftChild(100);
		root.left.addRightChild(1);
		root.right.addLeftChild(20);
		root.right.addRightChild(15);

		System.out.println("maximum possible sum from the root to any leaf node is " + obj.findMaxSum(root,0));
	}
	
	public class Node{
		Node left;
		Node right;
		int data;
		
		public Node(int data){
			this.data = data;
		}
		
		public void addLeftChild(Node left){
			this.left = left;
		}
		
		public void addLeftChild(int data){
			this.left =  new Node(data);
		}
		
		public void addRightChild(int data){
			this.right = new Node(data);
		}
		
		public void addRightChild(Node right){
			this.right = right;
		}
	}
	
	public int findMaxSum(Node node, int sum){
		if(node==null)
			return sum;
		int leftSum = findMaxSum(node.left, sum+node.data);
		int rightSum = findMaxSum(node.right, sum+node.data);
		
		return Math.max(leftSum, rightSum);
		
	}

}
