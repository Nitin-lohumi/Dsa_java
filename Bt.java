class Node {
    int data;
    Node left;
    Node right; 
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Bt {
    Node root;
    Bt(){
     this.root = null;
    }
    public void insert(int data){
     Node newnode = new Node(data);
       if(this.root == null){
        this.root = newnode;
       }
       else{
          this.insert_data(this.root, newnode);//helper function 
       }
    }
    public void insert_data(Node node,Node newnode){
     if(newnode.data<node.data){
        if(node.left==null){
            node.left = newnode;
        }
        else{
            this.insert_data(node.left, newnode);
        }
     }else{
        if(node.right==null){
            node.right = newnode;
        }else{
            this.insert_data(node.right, newnode);
        }
     }
    }
    public int FindMini(Node node){
        int value = node.data;
        if(node!=null){
            while(node.left!=null){
                node = node.left;
            }
            value = node.data;
        }
        return value;
    }
    public Node delete(Node node, int value){
     if(node==null){
        return null;
     }
    if(value<node.data){
        node.left = delete(node.left, value);
    }else if(value>node.data){
        node.right = delete(node.right, value);
    }else{
        //case 1: 
        if(node.left==null && node.right==null){
            return null;
        }
        //case 2
        if(node.left==null){
             return node.right;
        }
        else if(node.right==null){
            return node.left;
        }
        //case 3: 
        node.data = FindMini(node.right);
        node.right= delete(node.right, node.data);
    }
    return node;
    }
    public void inorder(Node node){
        if(node!=null){
          inorder(node.left);
          System.out.println(node.data);
          inorder(node.right);
        }
    }
    public static void main(String[] args) {
        Bt t = new Bt();
        t.insert(10); 
        t.insert(20);   
        t.insert(30);   
        t.insert(40); 
        t.inorder(t.root);
        System.out.println("this is root "+t.root.data);
        t.root = t.delete(t.root,30);
        System.out.println("after delete ");
        t.inorder(t.root);
        System.out.println("this is root "+t.root.data);

    }
}
