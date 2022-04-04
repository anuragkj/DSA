import java.util.*;
import java.io.*;
class BST_class { 
    class Node { 
        String key; 
        String name;
        float CGPA;
        Node left, right; 
   
        public Node(String data, String n, float c){ 
            key = data; 
            name = n;
            CGPA = c;
            left = right = null; 
        } 
    } 
    Node root; 
  
    BST_class(){ 
        root = null; 
    } 
    
    String minValue(Node root)  { 
        String minval = root.key; 
        while (root.left != null)  { 
            minval = root.left.key; 
            root = root.left; 
        } 
        return minval; 
    } 
   
    void insert(String key, String name, float c)  { 
        root = insert_Recursive(root, key, name, c); 
    } 
   
    Node insert_Recursive(Node root, String key, String name, float c) { 
        if (root == null) { 
            root = new Node(key, name, c); 
            return root; 
        } 
        if (key.compareTo(root.key)<0)     
            root.left = insert_Recursive(root.left, key, name, c); 
        else if (key.compareTo(root.key)>0)    
            root.right = insert_Recursive(root.right, key, name , c); 
        return root; 
    } 
 

    void inorder() { 
        inorder_Recursive(root); 
    } 
   
    void inorder_Recursive(Node root) { 
        if (root != null) { 
            inorder_Recursive(root.left); 
            System.out.print(root.key + " "); 
            System.out.print(root.name + " "); 
            System.out.println(root.CGPA + " "); 
            inorder_Recursive(root.right); 
        } 
    } 
    
    void postorder() { 
        postorder_Recursive(root); 
    } 
   
    void postorder_Recursive(Node root) { 
        if (root != null) { 
            postorder_Recursive(root.left); 
            postorder_Recursive(root.right); 
            System.out.print(root.key + " "); 
            System.out.print(root.name + " "); 
            System.out.println(root.CGPA + " "); 
            
        } 
    }
    
    void preorder() { 
        preorder_Recursive(root); 
    } 
   
    void preorder_Recursive(Node root) { 
        if (root != null) { 
            System.out.print(root.key + " "); 
            System.out.print(root.name + " "); 
            System.out.println(root.CGPA + " "); 
            preorder_Recursive(root.left); 
            preorder_Recursive(root.right); 
        } 
    }
}
class Main{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner readMyFile = new Scanner(new File("source.txt"));
        BST_class bst = new BST_class(); 
        
        while(readMyFile.hasNext()){
		    String key = readMyFile.next();
		    String name = readMyFile.next();
		    float CGPA = readMyFile.nextFloat();
		    bst.insert(key, name, CGPA); 
		}
        System.out.println("\n\nIn order traversal:"); 
        bst.inorder(); 
        System.out.println("\n\nPre order traversal:"); 
        bst.preorder(); 
        System.out.println("\n\nPost order traversal:"); 
        bst.postorder(); 
        
     } 
}