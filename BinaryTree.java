import java.util.*;
public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left= null;
            this.right= null;
        }
    }

    static class BinTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }
    }

    //Preorder traversal O(n  )
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //Inorder traversal O(n)
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.data+" ");
        inOrder(root.right);
    }

    //postOrder traversal (O(n))
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    //level order traversal O(n) linear time
    public static void levelOrder(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else{
                    q.add(null);
                }
            } else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                } 
                if(currNode.right!=null){
                    q.add(currNode.right);
                }   
            }
        }
    }

    //count of nodes O(n)
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftNode=countNodes(root.left);
        int rightNode=countNodes(root.right);

        return leftNode+rightNode+1;
    }

    //sum of nodes
     public static int sumNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=sumNodes(root.left);
        int rightSum=sumNodes(root.right);

        return leftSum+rightSum+root.data;
    }

    //height of tree
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        int myHeight=Math.max(leftHeight,rightHeight)+1;

        return myHeight;
    }

    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinTree tree=new BinTree();
        Node root=tree.buildTree(nodes);
        System.out.println(height(root));
        //System.out.println(sumNodes(root));
        //System.out.println(countNodes(root));
        //levelOrder(root);
        //postOrder(root);
        //inOrder(root);
        //preOrder(root);
        //System.out.println(root.right.data);
    }
}
