import java.util.LinkedList;
import java.util.Queue;
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
        this.root = null;
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

    @SuppressWarnings("unused")
    private void inorderRec(Node root) {
        if (root == null) {
            return;
        }
        inorderRec(root.left);
        System.out.print(root.value + " ");
        inorderRec(root.right);
    }

    Boolean check = false;

    public Boolean findKey(Node node, int key) {
        if (root == null) {
            return false;
        }
        if (node == null) {
            return false;
        }
        if (node.value == key) {
            check = true;
            return check;
        } else if (key < node.value) {
            return findKey(node.left, key);
        } else {
            return findKey(node.right, key);
        }
    }

    public Node deleteNode(Node node, int value) {
        if (root == null) {
            return null;
        }
        if (node == null) {
            return null;
        }
        if (node.value < value) {
            node.right = deleteNode(node.right, value);
        } else if (node.value > value) {
            node.left = deleteNode(node.left, value);
        } else {
            // case 1 :
            if (node.left == null && node.right == null) {
                return null;
            }
            // case 2:
            if (node.left == null) {
                return node.left;
            } else if (node.right == null) {
                return node.right;
            }
            // case 3:
            Node succesorNode = FindLeftleaf(node.right);
            node.value = succesorNode.value;
            node.right = deleteNode(node.right, succesorNode.value);
        }
        return node;
    }

    public Node FindLeftleaf(Node node) {
        if (node.left == null) {
            return node;
        }
        return FindLeftleaf(node.left);
    }

    public boolean Search(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (data == root.value) {
            return true;
        } else if (data < root.value) {
            return Search(root.left, data);
        } else if (data > root.value) {
            return Search(root.right, data);
        }
        return false;
    }

    public void LevelorderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        // System.out.println(q);
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
            System.out.print("   "+frist.value);
           }
        }
    }
    public static void main(String[] args) {
        Bst bst = new Bst();
        bst.insertRec(bst.root, 50);
        bst.insertRec(bst.root, 30);
        bst.insertRec(bst.root, 20);
        bst.insertRec(bst.root, 40);
        bst.insertRec(bst.root, 70);
        bst.insertRec(bst.root, 60);
        bst.insertRec(bst.root, 80);
        // System.out.println(" Inorder traversal of the BST:");
        // // bst.inorderRec(bst.root);
        // System.out.println(" the key is found : " + bst.findKey(bst.root, 100));
        // bst.root = bst.deleteNode(bst.root, 30);
        // bst.inorderRec(bst.root);

        // System.out.println("this is a search result");
        // System.out.println(bst.Search(bst.root, 81));
        bst.LevelorderTraversal(bst.root);
    }
}
