package JobSearchingObserverPattern;

public class SalaryMan implements Observer, DisplayJob
{
	private int highSalary = 5000;
	private int wantSalary;
	private JobData jobData;
	
	public SalaryMan(JobData jobData) 
	{
		this.jobData = jobData;
		this.jobData.registerObserver(this);
	}

	@Override
	public void display()
	{
		// TODO Auto-generated method stub
		System.out.println("----- High Salary Job Notice -----");
		if(highSalary > wantSalary)
		{
			System.out.println("The salary is more than you want");
		}
		else if(highSalary == wantSalary)
		{
			System.out.println("Pay is the same as you want");
		}
		else if(highSalary < wantSalary)
		{
			System.out.println("Pay is less than you want");
		}
	}

	@Override
	public void update(String company, int date, int salary)
	{
		// TODO Auto-generated method stub
		wantSalary = highSalary;
		highSalary = salary;
		
		display();
	}
}
