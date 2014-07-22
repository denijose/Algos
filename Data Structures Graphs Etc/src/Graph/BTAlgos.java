package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;



public class BTAlgos {

	/**
	 * @param args
	 */
	
	static int preIndex = 0;
	
	public static void main(String[] args) {
		BTNode root = BinaryTreeTraversal.createBinaryTree();
		printAllPaths(root,"");

	}

	// Given a BST, transform it into sum tree where each node contains sum of all nodes greater than that node.
	public static int gatherSum(BTNode node, int sum){	
		
		if(node.LChild == null && node.RChild == null){
				int temp = (int)node.data;
				node.data = sum;
				return temp + sum;			
		}
		int temp = (int)node.data;
		node.data = gatherSum(node.RChild, sum);
		gatherSum(node.LChild,temp+(int)node.data);
		return (int)node.data;		
	}
	
	//Reverse the alternate level nodes of the binary tree.
	public static void reverseAlternateLevelNodes(BTNode node){
		
	}
	
	
	//print all the nodes k distance from the leaf, the distance measured strictly upward
	public static void printAllNodesKDistanceFromLeaf(BTNode node, String path, int k){
		if(node == null)
			return;
		
		if(node.LChild == null && node.RChild == null){
			String[] array = path.split("");			
			if(array.length > k)
				System.out.println(array[array.length-k]);
			return;
		}
		
		path += node.data;
		printAllNodesKDistanceFromLeaf(node.LChild,path,k);
		printAllNodesKDistanceFromLeaf(node.RChild,path,k);
	}
	
	//print all the nodes k distance from the root
	public static void printAllNodesKDistanceFromRoot(BTNode node, int k, int level){
		if(node==null)
			return;
		// no need to check  if a node is a leaf or not particularly
		
		if(level==k){
			System.out.println(node.data);
			return;
		}
		printAllNodesKDistanceFromRoot(node.LChild,k,++level);
		--level;
		printAllNodesKDistanceFromRoot(node.RChild,k,++level);		
		
	}
	
	//find the height of the BT
	public static double MaxDepth(BTNode node){
		if(node == null)
			return 0;
		else
			return 1 + Math.max(MaxDepth(node.LChild), MaxDepth(node.RChild));
	}
	
	public static double MinDanglingDepth(BTNode node){
		if(node == null)
			return 0;
		else
			return 1 + Math.min(MaxDepth(node.LChild), MaxDepth(node.RChild));
	}
		

	//return the depth of the leaf nearest to the root
	public static double MinDepth(BTNode node){
		if(node.LChild==null && node.RChild==null)
			return 1;
		else if (node.RChild!=null && node.LChild!=null)
			return 1 + Math.min(MinDepth(node.LChild), MinDepth(node.RChild));
		else if(node.RChild==null)
			return 1+ MinDepth(node.LChild);
		else if(node.LChild==null)
			return 1 + MinDepth(node.LChild);
		
		return 0;
    }
	
	//find if the given BT is balanced or not
	public static boolean isBalanced(BTNode root){		
		double maxDepth = MaxDepth(root);
		double minDanglingDepth = MinDanglingDepth(root);
		if(Math.abs(maxDepth - minDanglingDepth) > 1)
			return false;
		else 
			return true;
	}
	
	/*insertion into a binary tree - not taking care of the balanced nature*/
	public static BTNode insertIntoBT(BTNode node, int data ){
		if((int)node.data > data && node.LChild!=null)
			insertIntoBT(node.LChild,data);
		else if((int)node.data < data && node.RChild!=null)
			insertIntoBT(node.RChild, data);
		else if((int)node.data > data && node.LChild==null){
			BTNode newNode = new BTNode(data);
			node.LChild = newNode;
			return node;
		}		
		else if((int)node.data < data && node.RChild==null){
			BTNode newNode = new BTNode(data);
			node.RChild = newNode;
			return node;
		}
		
		return node;		
	}

	/* connect siblings at each levels of a binary tree  */
	public static class Node{
		String data;
		Node LChild;
		Node RChild;
		Node right;
		
		Node(String data){
			this.data = data;
		}
	}
	public static  Node createBTForConnectSiblings(){
		Node root = new Node("1");
		root.LChild = new Node("2");
		root.RChild = new Node("3");
		root.LChild.LChild = new Node("4");
		root.LChild.RChild = new Node("5");
		root.RChild.LChild = new Node("6");
		root.RChild.LChild.LChild = new Node("7");
		root.RChild.LChild.LChild.LChild = new Node("8");		
		return root;
	}
	public static void connectSiblings(Node root){
		LinkedList<Node> bfsQ = new LinkedList<Node>();
		root.right=null;
		bfsQ.add(root);
		int gen=1, nextGen=0, depth=0;
		while(!bfsQ.isEmpty()){
			Node curNode =  bfsQ.remove();

			gen--;		
			
			if(gen==1 && curNode!=root)
				curNode.right=null;
			else
				curNode.right = bfsQ.peek();
			
			if(gen<=0 && curNode!=root){
				gen = nextGen;
				nextGen=0;
				depth++;						
			}
			if(curNode.LChild!=null){
				bfsQ.add(curNode.LChild);
				nextGen++;
			}	
			if(curNode.RChild!=null){
				bfsQ.add(curNode.RChild);
				nextGen++;
			}
		}
	}
	
	// 	Print vertical sum of a binary tree
	public static void printVerticalSum(BTNode root){
		int depth = (int) MaxDepth(root);
		int sumArray[] = new int[2*depth];
		findVerticalSum(root,sumArray,0,depth);
		for(int i=0;i<sumArray.length;i++)
			System.out.println(i-depth + "--" + sumArray[i]);
	}
	
	public static void findVerticalSum(BTNode node, int[] sumArray, int dir, int depth){
		if(node==null)
			return;
		int sum = sumArray[depth+dir] + (int)node.data;
		sumArray[depth+dir]=sum;
		findVerticalSum(node.LChild, sumArray,dir-1,depth);
		findVerticalSum(node.RChild, sumArray,dir+1,depth);		
	}
	
	
/*****************
 * ****
 * ****
 * 	Below Algorithms are all on complete binary trees which can easily be represented using arrays
 *  */
	

	//create a complete binary tree using array

	public static int[] createBTree(){
	return new int[]{1,2,3,4,5,6,7,8};
	}
	/*           1
	 *          / \
	 *         2   3
	 *        4 5 6 7
	 *       8 
	 * 
	 */

	// print all the leaves

	public static void printAllLeaves(int[] btree){
		for(int i=btree.length/2;i<btree.length;i++)
			System.out.print(btree[i] + " ");
	}

	//BFS with levels

	//inorder traversal
	public static void inorderOfBTree(int[] btree, int node){
		if(node>=btree.length)
			return;
		inorderOfBTree(btree, 2*node+1);
		System.out.print(btree[node] + " ");
		inorderOfBTree(btree, 2*node+2);	
	}

	// find the depth of the bin tree
	public static void depth(int[] btree){
		int depth=0;
		int length=btree.length;
			while(length>0){
				length>>=1;
				depth++;
			}
		System.out.println(depth-1);	
	}

	//find the nodes k distance from the root
	public static void printAllNodesKDistanceFromRoot2(int[] btree, int node, int k, int distance){
		if(node>=btree.length)
			return;
		if(k==distance)
			System.out.println(btree[node]);
		distance++;
		printAllNodesKDistanceFromRoot2(btree,2*node+1,k,distance);
		printAllNodesKDistanceFromRoot2(btree,2*node+2,k,distance);
		
	}

	//find the nodes k distance from the leaf
	public static void printAllNodeKDistanceFromLeaf2(int[] btree, int node, int[] ancestors,int k, int ancestorIndex){
		if(node>=btree.length)
			return;
		if(node>=btree.length/2){
			if(ancestorIndex>=k)
				System.out.println(ancestors[ancestorIndex-k]);
			return;
		}		
		ancestors[ancestorIndex++]=btree[node];
		printAllNodeKDistanceFromLeaf2(btree,2*node+1,ancestors,k,ancestorIndex);
		printAllNodeKDistanceFromLeaf2(btree,2*node+2,ancestors,k,ancestorIndex);	
		
	}
	/***************** end of algorithms for complete binary trees
	 * ****
	 * ****/
	
	// inorder traversal using iterationa and stack
	public static void inorderWithoutRec(BTNode root){
		LinkedList<BTNode> stack = new LinkedList<BTNode>();
		//stack.push(root);
		BTNode curNode = root;
		while(curNode!=null || !stack.isEmpty()){
		     while(curNode!=null){
		    	 stack.push(curNode);
		    	 curNode = curNode.LChild;
		     }	 
		     curNode = stack.pop();
		     System.out.print(curNode.data + " ");
		     curNode = curNode.RChild;
		}	

	}
	
	//Construct Tree from given Inorder and Preorder traversals
	public static BTNode BTFromInOPreO(int[] in, int[] pre, int begin, int end){		
		if(begin>end)
        	return null;
		if(begin==end)
			return new BTNode(pre[preIndex++]);    
		
		BTNode root = new BTNode(pre[preIndex]);
		int inIndex=0;
		for(int i=0;i<in.length;i++){
			if(in[i]==pre[preIndex]){
				inIndex=i;
				break;
			}	
		}				
		preIndex++;
		root.LChild = BTFromInOPreO(in, pre, begin, inIndex-1);
		root.RChild = BTFromInOPreO(in, pre, inIndex+1, end);
		return root;
	}	
	
	// Given a binary tree, print all root-to-leaf paths
	public static void printAllPaths(BTNode node, String path){
		if(node==null)
			return;
		if(node.LChild==null && node.RChild==null){
			System.out.println(path+" "+node.data);
			return;
		}
			
		printAllPaths(node.LChild, path+" "+node.data);
		printAllPaths(node.RChild, path+" "+node.data);
	}
	
	//print all nodes at a distance k from a given node
	public static void printAllNodesKDistanceKFromAGivenNode(BTNode node, BTNode root, int k){
		printNodesFromSubTree(node,k,0);
		printOtherNodes(root, node, k);
	}
	public static void printNodesFromSubTree(BTNode node, int k, int distance){
		if(node==null)
			return;
		if(distance==k){
			System.out.println(node.data);
			return;
		}
		distance++;
		printNodesFromSubTree(node.LChild,k,distance);
		printNodesFromSubTree(node.RChild,k,distance);
	}
	
	public static void printOtherNodes(BTNode root, BTNode target, int k){
		LinkedList<String> direction = new LinkedList<String>();
		LinkedList<BTNode> ancestors = new LinkedList<BTNode>();
		getAncestors(root,target,ancestors,direction,false);
		int distance=1;
		while(!ancestors.isEmpty()){
			int remaining = k-distance;
			if(remaining==0){
				System.out.print(ancestors.pop().data + " ");
				break;
			}	
			BTNode curNode;
			if(direction.pop().equalsIgnoreCase("L"))
				curNode=ancestors.pop().RChild;
			else
				curNode=ancestors.pop().LChild;
			printNodesKDistanceFromRoot(curNode,remaining-1,0);
			distance++;
		}
	}
	
	public static boolean getAncestors(BTNode node,BTNode target,LinkedList<BTNode> ancestors, LinkedList<String> direction, boolean isDone){
		if(node==null)
			return isDone;
		if(node==target){
			isDone=true;
			return isDone;
		}
		if(!isDone){	
			ancestors.push(node);
			direction.push("L");
			isDone=getAncestors(node.LChild,target,ancestors,direction,isDone);
		}
		if(!isDone){
			direction.pop();
			direction.push("R");
			isDone=getAncestors(node.RChild,target,ancestors,direction,isDone);
			ancestors.pop();
			direction.pop();	
		}
		return isDone;
	}
	
	public static void printNodesKDistanceFromRoot(BTNode node, int k, int distance){
		if(node==null)
			return;
		if(k==distance)
			System.out.print(node.data + " ");
		distance++;
		printNodesKDistanceFromRoot(node.LChild,k,distance);
		printNodesKDistanceFromRoot(node.RChild,k,distance);
	}
	
	public static void printAncestors(BTNode node, int data, LinkedList<BTNode> ancestors){
		if(node==null)
			return;
		if((int)node.data==data){
			for(BTNode n:ancestors)
				System.out.print(n.data + " ");
			return;
		}
		ancestors.push(node);
		printAncestors(node.LChild, data, ancestors);
		printAncestors(node.RChild, data, ancestors);
		ancestors.pop();	
	}
	
	public static BTNode inorderSuccessor(BTNode root,BTNode node){
		if(node.RChild!=null){
			BTNode temp = node.RChild;
			while(temp.LChild!=null){
				temp=temp.LChild;
			}
			return temp;
	}		
		BTNode succ=root;
		while(root!=null){
			if(node.data<root.data){
				succ=root;
				root=root.LChild;
			}
			else
				root=root.RChild;
		}
		return succ;	
	}
	
	public static int NoOfLeaves(BTNode node){
		if(node==null)
			return 0;
		if((node.LChild==null && node.RChild==null))
			return 1;
		return NoOfLeaves(node.LChild) + NoOfLeaves(node.RChild);
	}
	
	public static void convertToChildrenSumProperty(BTNode node){
		if(node.LChild==null && node.RChild==null)
			return;
		if(node.LChild==null)
			return;	
		convertToChildrenSumProperty(node.LChild);
		convertToChildrenSumProperty(node.RChild);
		int left=0,right=0;
		if(node.LChild!=null)
			left=node.LChild.data;
		if(node.RChild!=null)
			right=node.RChild.data;
		int diff = left + right - node.data;
		if(diff>0)
			node.data=node.data+diff;
		else if(diff<0){
			if(node.LChild!=null)
				addDiff(node.LChild,-diff);	
			else
				addDiff(node.RChild,-diff);
		}
		else
			return;	
	}
	
	public static void addDiff(BTNode node, int diff){
		if(node==null)
			return;
		node.data+=diff;
		if(node.LChild!=null)
			addDiff(node.LChild,diff);
		else
			addDiff(node.RChild,diff);	
		}
	
	    public static double findDiameter(BTNode node){
	    	if(node==null)
	    		return 0;
	    	if(node.LChild==null && node.RChild==null)
	    		return 1;  	
	   
	    	double leftDiam=findDiameter(node.LChild);
	    	double rightDiam=findDiameter(node.RChild);
	    	double diamThruRoot = MaxDepth(node.LChild) + MaxDepth(node.RChild);
	    	if(leftDiam>rightDiam)
	    		return Math.max(leftDiam, diamThruRoot);
	    	else
	    		return Math.max(rightDiam, diamThruRoot);  
	   
	    }
	    
	    //inorder traversal without rec and stack
	    public static void inorderWithoutRecAndStack(BTNode root){
	    	BTNode cur = root;
	    	while(cur!=null){
	    		if(cur.LChild==null){
	    			System.out.print(cur.data + " ");
	    			cur = cur.RChild;
	        }
	        else{
	        	BTNode pre = cur.LChild;
	        	while(pre.RChild!=null && pre.RChild!=cur)
	        		pre=pre.RChild;
	        	if(pre.RChild==null){
	        		pre.RChild = cur;
	        		cur = cur.LChild;	
	        	}
	        	else{
	        		pre.RChild = null;
	        		System.out.print(cur.data + " ");
	        		cur = cur.RChild;	       
	        	}
	        }
	       
	        }
	   	
	    }
	    
	    /* Given a binary tree and a number, return true if the tree has a root-to-leaf path 
	     * such that adding up all the values along the path equals the given number.
	     *  Return false if no such path can be found */
	    
	    public static boolean rootToLeafPathSum(BTNode node, int sum, int n){
	    	if(node==null)
	    		return false;
	    	if(node.LChild==null && node.RChild==null){
	    		if(node.data+sum == n)
	    			return true;
	    		else return false;
	    }	   
	    return rootToLeafPathSum(node.LChild, sum+node.data, n) || rootToLeafPathSum(node.RChild, sum+node.data, n); 	
	    }
	    
	    
	//  //Construct Tree from given Inorder and Preorder traversals
//	    public static BTNode creatBTFromInoPreo(int[] inOrder, int[] preOrder, int leftBegin, int leftEnd, 
//	    	int rightBegin, int right End,
//	    	int preIndex){
//	    	if(leftBegin==-1 || leftEnd==-1 || rightBegin==-1 || rightEnd==-1)
//	    	return null;
//	    	if(leftBegin==leftEnd)
//	    	return BTNode(inOrde[leftBegin]);
//	    	if(rightBegin==rightEnd)
//	    	return BTNode(inOrder[rightBegin]);
//	    	
//	    	BTNode root = new BTNode(preOrder[preIndex]);
//	    	for(int )
//	    	rightEnd = leftEnd;
//	    	root.LChild = creatBTFromInoPreo(inOrder, preOrder, );
//	    	root.RChild = creatBTFromInoPreo()
//	    	
//	    }
	    
	    // find the maximum width of a binary tree
	    public static int maxWidthOfBT(BTNode root){
	    	int depth = (int)MaxDepth(root);
	    	int[] arr = new int[depth];
	        inOrder(root,arr,0);
	        for(int i=0;i<arr.length;i++)
	        	System.out.print(arr[i] + " ");
	        	return 0;
	    }
	    public static void preOrder(BTNode node, int[] arr, int level){
	    	if(node==null)
	    		return;
	    	arr[level] = arr[level] + 1;
	    	preOrder(node.LChild,arr,level+1);
	    	preOrder(node.RChild,arr,level+1);    	
	    }
	    
	    public static void postOrder(BTNode node, int[] arr, int level){
	    	if(node==null)
	    		return;
	    	postOrder(node.LChild,arr,level+1);
	    	postOrder(node.RChild,arr,level+1); 
	    	arr[level] = arr[level] + 1;
	     
	    }
	    
	    public static void inOrder(BTNode node, int[] arr, int level){
	    	if(node==null)
	    		return;
	    	inOrder(node.LChild,arr,level+1);
	    	arr[level] = arr[level] + 1;
	    	inOrder(node.RChild,arr,level+1);      
	    }
	    
	    
	    //level order traversal with depth
	    public static void levelOrderTraversal(BTNode root){
	    	HashMap<Integer,ArrayList<BTNode>> levelMap = new HashMap<Integer,ArrayList<BTNode>>();
	    	preOrderForLevelOrderTraversal(root,levelMap,0);
	    	for(Integer level : levelMap.keySet()){
	    		System.out.print(level + " - ");
	    		for(BTNode node : levelMap.get(level))
	    			System.out.print(node.data + " ");
	    		System.out.println();
	    	}
	    }
	    
	    public static void preOrderForLevelOrderTraversal(BTNode node, HashMap<Integer,ArrayList<BTNode>> levelMap, int level){
	    	if(node==null)
	    		return;
	    	if(levelMap.containsKey(level)){
	    		ArrayList<BTNode> list = levelMap.get(level);
	    		list.add(node);
	    		levelMap.put(level, list);
	    	}
	    	else{
	    		ArrayList<BTNode> list = new ArrayList<BTNode>();
	    		list.add(node);
	    		levelMap.put(level,list);
	    	}
	    	preOrderForLevelOrderTraversal(node.LChild,levelMap,level+1);
	    	preOrderForLevelOrderTraversal(node.RChild,levelMap,level+1);
	    
	    }
	    
	    
	//create a mirror of a binary tree
	public static BTNode createMirror(BTNode node){
		if(node==null)
			return null;
		BTNode newNode = new BTNode(node.data);
		newNode.RChild = createMirror(node.LChild);
		newNode.LChild = createMirror(node.RChild);
		return newNode;	
	}
	
	//convert a binary tree to its mirror image
	public static BTNode convertToMirror(BTNode node){
		if(node==null)
			return null;
		BTNode temp = node.LChild;
		node.LChild =  node.RChild;
		node.RChild = temp;
		convertToMirror(node.LChild);
		convertToMirror(node.RChild);
		return node;
	}
	
}
