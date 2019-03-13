
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class EnterOrServed 
{
	static final String enter="ENTER";
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		//No. of events
		int events=0;
		events=sc.nextInt();
		String enterOrServed;
		
		//creating PriorityQueue constructor having a StudentCompare instance as its parameter
		PriorityQueue<Student> queue=new PriorityQueue(events,new StudentCompare());
		
		for(int i=0;i<events;i++)
		{
			enterOrServed=sc.next();
			if(enterOrServed.equals(enter))
			{
			     String name;
			     double cgpa;
			     int token;
			     name=sc.next();
			     cgpa=sc.nextDouble();
			     token=sc.nextInt();
			     
			     //Creating user defined class object
			     Student s=new Student(name,cgpa,token);
			     
			     //adding student class object into ArrayList
			     queue.add(s);
			}
			else
			{
				//Removing the head of the queue if SERVED
				queue.poll();
			}
		}
		//printing EMPTY if queue is empty
		if(queue.isEmpty())
		{
			System.out.println("EMPTY");
		}
		//Printing the names of the students who are not served
		while(!queue.isEmpty())
		{
			//retrieving and removing the head of the queue and printing 
			System.out.println(queue.poll().getName());
		}
	}

}
class Student 
{
	String name;
	double cgpa;
	int token;
	//A parameterized Student constructor.
	Student(String name,double cgpa,int token)
	{
		super();
		this.name=name;
		this.cgpa=cgpa;
		this.token=token;
	}
	//Getter 
	public String getName()
	{
		return name;
	}
	public double getCgpa()
	{
		return cgpa;
	}
	public int getToken()
	{
		return token;
	}
}
class StudentCompare implements Comparator<Student> 
{
	//Overriding compare() method of Comparator
	@Override
	public int compare(Student s1, Student s2) {
		//Descending order of CGPA
		if(s1.getCgpa()>s2.getCgpa())
			return -1;
		else if(s1.getCgpa()<s2.getCgpa())
			return 1;
		//Ascending order of name
		if(s1.getName().compareTo(s2.getName())<0)
		{
			return -1;
		}
		else if(s1.getName().compareTo(s2.getName())>0)
		{
			return 1;
		}
		//Ascending order of Token
		if(s1.getToken()<s2.getToken())
		{
			return -1;
		}
		else if(s1.getToken()>s2.getToken())
		{
			return 1;
		}
		return 0;
	}

}


