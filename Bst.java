class Bst{
    static class Node{
        Node left;
        Node right;
        int  value;
        @SuppressWarnings("static-access")
        public Node(int value){
            this.value= value;
        }
    }
    static void inOrder(Node node){
        if(node.left==null){
            System.out.println("empty");
        }
           try{
             inOrder(node.left);
             System.out.print(node.value + " ");  
             inOrder(node.right); 
           }catch(Exception e){
             System.out.println(node.right.value);
             System.out.println(node.value);
             System.err.println(node.left);
           } 
        }
    public  static void run(){
    Node t = new Node(20);
    System.out.println("building node with root node "+ t.value);
    insert(t,50);
    insert(t,30);
    inOrder(t);
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
    public static void main(String[] args) {
        run();
    }
    }
    