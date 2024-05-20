class Bst{
    public static void main(String[] args) {
        run();
    }
    static class Node{
        Node left;
        Node right;
        static int  value;
        @SuppressWarnings("static-access")
        public Node(int value){
            this.value= value;
        }
    }
    public  static void run(){
    Node t = new Node(20);
    System.out.println("building node with root node "+ Node.value);
    insert(t,50);
    insert(t,300);
    }
    @SuppressWarnings("static-access")
    public static void insert(Node node,int value){
     if(value<node.value){
       if(node.left!=null){
         insert(node.left,value);
       }else{
        System.out.println("inserted "+ node + "to left node "+node.value);
        node.left = new Node(value);
       }
     }
     else if(value>node.value){
        if(node.right!=null){
            insert(node.right, value);
        }
        else{
            System.out.println("inserted the "+ value + "to right node "+ node.value);
            node.right= new Node(value);
        }
     }
    }
    }
    