import java.util.ArrayList;
//Benjamin Chock

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return nodeSearch(root, val);
    }

    public boolean nodeSearch(BSTNode curRoot, int val){
        if (curRoot == null){
            return false;
        }
        else if (curRoot.getVal() == val){
            return true;
        }
        else if (curRoot.getVal() < val){
            return nodeSearch(curRoot.getRight(), val);
        }
        else if (curRoot.getVal() > val){
            return nodeSearch(curRoot.getLeft(), val);
        }
        return true;
    }



    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> inorderHolder = new ArrayList<BSTNode>();
        inorderCreator(root, inorderHolder);
        return inorderHolder;
    }

    public ArrayList<BSTNode> inorderCreator(BSTNode curRoot, ArrayList<BSTNode> inorderHolder){
        if (curRoot == null){
            return  null;
        }
        inorderCreator(curRoot.getLeft(), inorderHolder);
        inorderHolder.add(curRoot);
        inorderCreator(curRoot.getRight(), inorderHolder);

        return inorderHolder;

    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> preorderHolder = new ArrayList<BSTNode>();
        preorderCreator(root, preorderHolder);
        return preorderHolder;
    }
    public ArrayList<BSTNode> preorderCreator(BSTNode curRoot, ArrayList<BSTNode> preorderHolder){
        if (curRoot == null){
            return  null;
        }
        preorderHolder.add(curRoot);
        preorderCreator(curRoot.getLeft(), preorderHolder);
        preorderCreator(curRoot.getRight(),preorderHolder);
        return preorderHolder;

    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> postorderHolder = new ArrayList<BSTNode>();
        postorderCreator(root, postorderHolder);
        return postorderHolder;
    }

    public ArrayList<BSTNode> postorderCreator(BSTNode curRoot, ArrayList<BSTNode> postorderHolder){
        if (curRoot == null){
            return  null;
        }
        postorderCreator(curRoot.getLeft(), postorderHolder);
        postorderCreator(curRoot.getRight(), postorderHolder);
        postorderHolder.add(curRoot);
        return postorderHolder;

    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        nodeInsert(root,val);
    }

    public boolean nodeInsert(BSTNode curRoot, int val){
        if (curRoot.getLeft() == null && curRoot.getVal() < val){
            curRoot.setRight(new BSTNode(val));
            return true;
        }
        else if (curRoot.getLeft() == null && curRoot.getVal() > val){
            curRoot.setLeft(new BSTNode(val));
            return true;
        }

        else if (curRoot.getVal() < val){
            return nodeInsert(curRoot.getRight(), val);
        }
        else if (curRoot.getVal() > val){
            return nodeInsert(curRoot.getLeft(), val);
        }
        return true;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
