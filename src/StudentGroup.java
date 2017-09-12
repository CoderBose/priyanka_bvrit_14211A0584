import java.util.Date;
import java.util.Scanner;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		if(students.length > 0) 
		{
			for(int i = 0; i<students.length; i++) 
			{
				return students[i];
			}
		}
		else
		    return null;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		try {
			if(students == null)
				throw new IllegalArgumentException;
			else 
			{
				Scanner sc = new Scanner(System.in);
				for(int i=0; i<students.length; i++) 
				{
					students[i].id = sc.nextInt();
					students[i].fullName = sc.next();
					students[i].birthDate = sc.next();
					students[i].avgMark = sc.nextDouble();
				}
			}
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("Caught the exception" + e.getMessage());
		}
	}

	@Override
	public Student getStudent(int index) 
	{
		// Add your implementation here
		try 
		{
			if(index < 0 || index >= students.length)
				throw new IllegalArgumentException;
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("Caught the exception" + e.getMessage());
		}
		return null;
	}

	@Override
	public void setStudent(Student student, int index) 
	{
		// Add your implementation here
		try 
		{
			if(students == null || index < 0 || index > students.length)
				throw new IllegalArgumentException;
			students[index] = student;
		}
		catch(IllegalArgumentException e) 
		{
			System.out.println("Caught the exception" + e.getMessage());
		}
	}

	@Override
	public void addFirst(Student student) 
	{
		// Add your implementation here
		try {
			if(students == null)
				throw new IllegalArgumentException;
			students.length = students.length + 1;
			for(int i = students.length - 1; i>0;i--)
			{
				students[i] = students[i-1];
			}
			students[0] = student;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		try {
			if(students == null)
				throw new IllegalArgumentException;
			students.length = students.length + 1;
			students[length - 1] = student;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		try {
			if(students == null || index < 0 || index > students.length)
				throw new IllegalArgumentException;
			students.length = students.length + 1;
			for(int i = students.length - 1; i>index;i--)
			{
				students[i] = students[i-1];
			}
			students[index] = student;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		try {
			if(index < 0 || index > students.length)
				throw new IllegalArgumentException;
			for(int i = index; i<students.length; i++)
			{
				students[i] = students[i+1];
			}
			students.length--;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}

	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		int count = 0;
		try {
			if(students == null)
				throw new IllegalArgumentException;
			else {
				for(int i = 0; i < students.length ; i++)
				{
					if(students[i] == student)
					{
						for(int j=i; j<students.length ; j++)
							students[j] = students [j+1];
						count++;
						students.length--;
						break;
					}
				}
				if(count == 0)
					throw new IllegalArgumentException("Student does not exist");
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}

	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		try {
			if(index < 0 || index > students.length)
				throw new IllegalArgumentException;
			students.length -= index;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		try {
			if(students == null)
				throw new IllegalArgumentException;
			for(int i=0; i<students.length ;i++) {
				if(students[i] == student) {
					students.length -= i;
					break;
				}
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		try {
			if(index < 0 || index > students.length)
				throw new IllegalArgumentException;
			int temp = index;			
			for(int i =0;i<students.length; i++) {
				students[i] = students[index];
				index++;
			}
			students.length = students.length - temp;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}
		
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int exch = 0, temp = 0;
		for(int i = 0; i<students.length - 1 ; i++) {
			for(int j = 0 ; j<students.length - i - 1; j++) {
				if(students[j].id > students[j+1].id) {
					temp = students[j].id;
					students[j].id = students[j+1].id;
					students[j+1].id = temp;
					exch++;
				}
			}
			if(exch == 0)
				break;
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		try {
			if(date == null)
				throw new IllegalArgumentException;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		try {
			if(firstDate == null || lastDate == null)
				throw new IllegalArgumentException;
			for(int i=0;i<students.length;i++) {
				if(students.birthDate > firstDate && students.birthDate < lastDate)
					return students[i];
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		try {
			if(indexOfStudent == null)
				throw new IllegalArgumentException;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		for(int i = 0; i<students.length ; i++) {
			
		}
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max = 0.0;
		for(int i = 0; i<students.length ; i++) {
			if(students[i].avgMark > students[i+1].avgMark) {
				max = students[i].avgMark;
				return students[i];
			}
			if(students[i].avgMark == max)
				return students[i];
		}
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		try {
			if(students == null)
				throw new IllegalArgumentException;
			for(int i =0; i<students.length; i++) {
				if(students[i] == student) {
					return students[i+1];
				}
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Caught the exception" + e.getMessage());
		}
		return null;
	}
}
