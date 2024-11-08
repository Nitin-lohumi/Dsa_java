import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Bt {
    Node root;
    int index = -1;
    int count = 0;

    Bt() {
        this.root = null;
    }

    public Node buildTree(int node[]) {
        index++;
        if (index >= node.length) {
            return null;
        }
        if (node[index] == -1) {
            return null;
        }
        Node newNode = new Node(node[index]);
        newNode.left = buildTree(node);
        newNode.right = buildTree(node);
        return newNode;
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

    public int CountNode(Node root) {
        if (root == null) {
            return 0;
        }
        count = count + 1;
        CountNode(root.left);
        CountNode(root.right);
        return count;
    }

    public void BfS_travasal(Node root) {
        if (root == null) {
            System.out.println("no any elements to show ");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q.isEmpty() == false) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(" " + curr.data);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    int sum = 0;

    public int sumOfNOde(Node root) {
        if (root == null) {
            return 0;
        }
        int leftsum = sumOfNOde(root.left);
        int rightsum = sumOfNOde(root.right);
        sum = leftsum + rightsum + root.data;
        return sum;
    }

    public int FindHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftheight = FindHeight(root.left);// 1
        int rightHeight = FindHeight(root.right);// 1
        int mainheight = Math.max(leftheight, rightHeight) + 1;
        return mainheight;
    }

    public void levelOrderSum(Node root,int level) {
        int trackLevel = 0;
        int sum =0;
        if(root==null){
            System.out.println("root is null");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(null);
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if(curr==null){
                trackLevel++;
                 if(q.isEmpty()){
                    break;
                 }else{
                    q.add(null);
                 }
            }else{
                if(curr.left!=null){
                    q.add(curr.left);
                } 
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if (level == trackLevel) {
                Node nodeval = q.poll();
                while(nodeval!=null){
                    sum = nodeval.data+sum;
                    nodeval = q.poll();
                }
                    System.out.println(sum +" sum of the level");
                break;
              }
              if(FindHeight(root)<level){
                System.out.println("this is not a level of the treee");
                return;
              } 
        }
    }

    public static void main(String[] args) {
        int[] node = { 1, 2, 3, -1, -1, -1, 3, -1, -1, 4 };
        Bt t = new Bt();
        Node root = t.buildTree(node);
        // System.out.println("counting the number of node is " + t.CountNode(root));
        // System.out.println("sum of all nodes are " + t.sumOfNOde(root));
        // System.out.println("the height of tree is " + t.FindHeight(root));
        t.levelOrderSum(root,2);
        // t.BfS_travasal(root);
    }
}
