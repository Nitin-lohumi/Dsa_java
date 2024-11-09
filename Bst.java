class Node {
    int value;
    Node left, right;
  
    public Node(int value) {
        this.value = value;
        left = right = null;
    }
  }
  
  public class Bst {
    Node root;
  
    public Bst() {
        root = null;
    }
    public void insertRec(Node current, int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
  
        if (value < current.value) {
            if (current.left == null) {
                current.left = new Node(value);
            } else {
                insertRec(current.left, value);
            }
        } else if (value > current.value) {
            if (current.right == null) {
                current.right = new Node(value);
            } else {
                insertRec(current.right, value); 
            }
        }
    }
    private void inorderRec(Node root) {
        if (root == null) {
           return;
        }
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
    }
    
    Boolean check =false;
    public Boolean findKey(Node node,int key){
        if(root==null){
            return false;
        }
        if(node ==null){
         return false;
        }
        if(node.value==key){
           check = true;
           return check;
        }else if(key<node.value){
           return findKey(node.left, key);
        }else{
            return findKey(node.right, key);
        }
    }
  
    public static void main(String[] args) {
        Bst bst = new Bst();
        bst.insertRec(bst.root,50);
        bst.insertRec(bst.root,30);
        bst.insertRec(bst.root,20);
        bst.insertRec(bst.root,40);
        bst.insertRec(bst.root,70);
        bst.insertRec(bst.root,60);
        bst.insertRec(bst.root,80);
        System.out.println(" Inorder traversal of the BST:");
        bst.inorderRec(bst.root);
       System.out.println( " the key is found : "+ bst.findKey(bst.root, 100));
    }
  }
  