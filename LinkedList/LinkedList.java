import java.util.*;
import java.io.*;

class student{
    public String id, name, dob;
    public float gpa;
    student(String id, String name, String dob, float gpa){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gpa = gpa;
    }
}

class Node
{
    student data;
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
 
    static void push(student new_data)
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
            student st = temp.data;
            System.out.format("%s %s %s %f%n", st.id,st.name,st.dob,st.gpa);
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
            student st = tail.data;
            System.out.format("%s %s %s %f%n", st.id,st.name,st.dob,st.gpa);
            tail = tail.prev;
        }
        student st = tail.data;
        System.out.format("%s %s %s %f%n", st.id,st.name,st.dob,st.gpa);
    }
 
    public static void main (String args[]) throws FileNotFoundException
    {

        Scanner readMyFile = new Scanner(new File(args[0]));
        while(readMyFile.hasNext()){
            String id = readMyFile.next();
            String name = readMyFile.next();
            String dob = readMyFile.next();
            Float gpa = readMyFile.nextFloat();
            student stu = new student(id, name, dob, gpa);
            push(stu);
        }
 
        System.out.println("Doubly linked "
                           +"list before deletion:");
        printList();
        
        System.out.println("Doubly linked "
                           +"list before deletion(In reverse order):");
        reversePrint();
 
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter node position to delete: ");
        int n = s.nextInt();
         
        deleteNodeAtGivenPos(n);
        System.out.println("Doubly linked "
                           +"list after deletion:");
        printList();
        readMyFile.close();
    }
}