package JobSearchingObserverPattern;

public class JobSeeker implements Observer, DisplayJob
{
	private String company;
	private int date;
	private int salary;
	private Subject jobData;
	
	public JobSeeker(Subject jobData) 
	{
		this.jobData = jobData;
		this.jobData.registerObserver(this);
	}

	@Override
	public void display()
	{
		// TODO Auto-generated method stub
		System.out.println("----- Current Job Notice -----");
		System.out.println("Company : " + company);
		System.out.println("Date : " + date);
		System.out.println("Salary : " + salary);
	}

	@Override
	public void update(String company, int date, int salary)
	{
		// TODO Auto-generated method stub
		this.company = company;
		this.date = date;
		this.salary = salary;
		
		display();
	}
}
