
import java.util.LinkedList;
import java.util.Queue;
class Node {
    Node left;
    Node right;
    int hight;
    int data;

    Node(int data) {
        this.data = data;
        this.hight = 1;
    }
}

public class AvlTree {
    Node root;

    AvlTree() {
        this.root = null;
    }

    public void insertNode(int data) {
        root = insert(root, data);
    }

    private int height(Node node) {
        return (node == null) ? 0 : node.hight;
    }

    public int getBlance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    public Node rightRoation(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.hight = Math.max(height(y.left), height(y.right)) + 1;
        x.hight = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    public Node leftRoation(Node x) {
        Node y = x.right;
        Node t1 = y.left;

        y.left = x;
        x.right = t1;

        x.hight = Math.max(height(x.left), height(x.right)) + 1;
        y.hight = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }

        node.hight = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBlance(node);
        if (balance > 1 && data < node.left.data) {// left heavy
            return rightRoation(node);
        }
        if (balance < -1 && data > node.right.data) {// right heavy
            return leftRoation(node);
        }
        if (balance > 1 && data > node.left.data) {
            node.left = leftRoation(node.left);
            return rightRoation(node);
        }
        if (balance < -1 && data < node.right.data) {
            node.right = rightRoation(node.right);
            return leftRoation(node);
        }
        return node;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public Node Delete(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.data > value) {
            node.left = Delete(node.left, value);
        } else if (value > node.data) {
            node.right = Delete(node.right, value);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }

            if (node.left == null) {
                return node.left;
            } else if (node.right == null) {
                return node.right;
            }

            Node succesorNode = FindLeftleaf(node.right);
            node.data = succesorNode.data;
            node.right = Delete(node.right, succesorNode.data);
        }

        node.hight = Math.max(height(node.left),height(node.right))+1;
        int balance = getBlance(node);
        if (balance > 1 &&  getBlance(node.left) >= 0) {// left heavy
            return rightRoation(node);
        }
        if (balance < -1 &&  getBlance(root.right) <= 0) {// right heavy
            return leftRoation(node);
        }
        if (balance > 1 && getBlance(root.left) < 0) {
            node.left = leftRoation(node.left);
            return rightRoation(node);
        }
        if (balance < -1 &&  getBlance(root.right) > 0) {
            node.right = rightRoation(node.right);
            return leftRoation(node);
        }
        return node;
    }

    public Boolean Search(Node node,int data){
    if(node==null){
        return false;
    }
    if(data==node.data){
        System.out.println("matched"+ node.data);
        return true;
    }
    else if(data<node.data){
        return Search(node.left, data);
    }
    else if(node.data<data){
        return Search(node.right, data);
    }
    return false;
    }

    public void deleteNode(int value){
     root = Delete(root, value);
    }
    public Node FindLeftleaf(Node node) {
        if (node.left == null) {
            return node;
        }
        return FindLeftleaf(node.left);
    }

     public void LevelorderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node frist = q.poll();
           if(frist==null){
            System.out.println("***");
               if(q.isEmpty()){
                break;
               }else{
                q.add(null);
               }
           }else{
            if(frist.left!=null){
                q.add(frist.left);
            }
            if(frist.right!=null){
                q.add(frist.right);
            }
            System.out.print("   "+frist.data);
           }
        }
    }
    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
        tree.insertNode(10);
        tree.insertNode(5);
        tree.insertNode(4);
        tree.insertNode(12);
        tree.insertNode(11);
        tree.insertNode(6);
        tree.insertNode(15);
        tree.insertNode(20);
        System.out.println("In-order Traversal of AVL Tree:");
        tree.LevelorderTraversal(tree.root);
        tree.deleteNode(4);
        tree.deleteNode(6);
        System.out.println("After deletion :");
        tree.LevelorderTraversal(tree.root);
        System.out.println(tree.Search(tree.root, 5));
    }
}
