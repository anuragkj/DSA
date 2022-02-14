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

class Queue{

    private int size, front, rear; 
    
    
    private ArrayList<student> circular_queue = new ArrayList<student>(); 
    
    Queue(int queue_size) 
    {
    	this.size = queue_size;
    	this.front = this.rear = -1;
    }
    
    public void enQueue(student queue_data) 
    {
    	if((front == 0 && rear == size - 1) ||
    	(rear == (front - 1) % (size - 1))) 
    	{
    		System.out.print("Queue Full!");
    	}
    
    	else if(front == -1) 
    	{
    		front = 0;
    		rear = 0;
    		circular_queue.add(rear, queue_data);
    	}
    	else if(rear == size - 1 && front != 0)
    	{
    		rear = 0;
    		circular_queue.set(rear, queue_data);
    	}
    	else
    	{
    		rear = (rear + 1);
    		if(front <= rear)
    		{
    			circular_queue.add(rear, queue_data);
    		}
    		else
    		{
    			circular_queue.set(rear, queue_data);
    		}
    	}
    }
    
    public student deQueue() 
    {
    	student temp;
    
    	if(front == -1) 
    	{
    		System.out.print("Queue Empty!");
    		throw new EmptyStackException();
    	}
    
    	temp = circular_queue.get(front);
    
    	if(front == rear) 
    	{
    		front = -1;
    		rear = -1;
    	}
    
    	else if(front == size - 1)
    	{
    		front = 0;
    	}
    	else
    	{
    		front = front + 1;
    	}
    	return temp; 
    }
}



class Main
{

  public static void main (String args[]) throws FileNotFoundException
  {

    Scanner readMyFile = new Scanner(new File(args[0]));
    PrintWriter writeToMyFile = new PrintWriter(new File(args[1]));
    Queue obj = new Queue(5);
    while(readMyFile.hasNext()){
        String id = readMyFile.next();
        String name = readMyFile.next();
        String dob = readMyFile.next();
        Float gpa = readMyFile.nextFloat();
        student stu = new student(id, name, dob, gpa);
        obj.enQueue(stu);
    }
    for (int k =1; k<=5; k++)
    {
        student st = obj.deQueue();
        if(st.gpa < 9.0f){
            System.out.println(st.name);
        }
        writeToMyFile.format("%s %s %s %f%n", st.id,st.name,st.dob,st.gpa);
    }
    readMyFile.close();
    writeToMyFile.close();
  }
}