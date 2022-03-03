import java.util.*;
import java.io.*;

class faculty{
    public String facid, facname;
    public int pub, phd;
    faculty(String facid, String facname, int pub, int phd){
        this.facid = facid;
        this.facname = facname;
        this.pub = pub;
        this.phd = phd;
    }
}

class Node
{
    faculty data;
    Node next, prev;
}
 
class LinkedList
{
    static Node head = null;
    static Node deleteNode(Node del)
    {
        if (head == null || del == null)
            return null;
 
        if (head == del)
            head = del.next;
 
        if (del.next != null)
            del.next.prev = del.prev;
 
       if (del.prev != null)
            del.prev.next = del.next;
 
        del = null;
 
        return head;
    }
 
    static void deleteNodeAtGivenPos(int n)
    {
        if (head == null || n <= 0)
            return;
 
        Node current = head;
        int i;
 
        for (i = 1; current != null && i < n; i++)
        {
            current = current.next;
        }
         
        if (current == null)
            return;
 
        deleteNode(current);
    }
 
    static void push(faculty new_data)
    {
        Node new_node = new Node();
 
        new_node.data = new_data;
 
        new_node.prev = null;
 
        new_node.next = head;
 
        if (head != null)
            head.prev = new_node;
 
        head = new_node;
    }
 
    static void printList()
    {
        Node temp = head;
        if (temp == null)
            System.out.print("Doubly Linked list empty");
 
        while (temp != null)
        {
            faculty fac = temp.data;
            System.out.format("%s %s %d %d%n", fac.facid,fac.facname,fac.pub,fac.phd);
            temp = temp.next;
        }
        System.out.println();
    }
    
    static void reversePrint( )
    {
        Node head_ref = head;
        Node tail = head_ref;
     
        while (tail.next != null)
        {
            tail = tail.next;
        }
     
        while (tail != head_ref)
        {
            faculty fac = tail.data;
            System.out.format("%s %s %d %d%n", fac.facid,fac.facname,fac.pub,fac.phd);
            tail = tail.prev;
        }
        faculty fac = tail.data;
        System.out.format("%s %s %d %d%n", fac.facid,fac.facname,fac.pub,fac.phd);
    }
 
    public static void main (String args[]) throws FileNotFoundException
    {

        Scanner readMyFile = new Scanner(new File(args[0]));
        while(readMyFile.hasNext()){
            String facid = readMyFile.next();
            String facname = readMyFile.next();
            int pub = readMyFile.nextInt();
            int phd = readMyFile.nextInt();
            faculty facc = new faculty(facid, facname, pub, phd);
            push(facc);
        }
 
        System.out.println("Doubly linked "
                           +"list before deletion:");
        printList();
        
        
 
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter node position to delete: ");
        int n = s.nextInt();
         
        deleteNodeAtGivenPos(n);
        System.out.println("Doubly linked "
                           +"list after deletion:");
        printList();
	System.out.println("In reverse order:");
        reversePrint();
        readMyFile.close();
    }
}