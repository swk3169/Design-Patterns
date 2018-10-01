package JobSearchingObserverPattern;

public class OldMan implements Observer, DisplayJob
{
	private int maxAge = 70;
	private int minAge = 20;
	private float dateSum = 0;
	private int numReadings;
	
	private JobData jobData;
	
	public OldMan(JobData jobData) 
	{
		this.jobData = jobData;
		this.jobData.registerObserver(this);
	}

	@Override
	public void display()
	{
		// TODO Auto-generated method stub
		System.out.println("----- End Date Job Notice -----");
		System.out.println("Avg : " + (dateSum / numReadings));
		System.out.println("Max : " + maxAge);
		System.out.println("Min : " + minAge);
	}

	@Override
	public void update(String company, int date, int salary)
	{
		// TODO Auto-generated method stub
		dateSum += date;
		numReadings++;
		
		if(date > maxAge)
		{
			maxAge = date;
		}
		
		if(date < minAge)
		{
			minAge = date;
		}
		
		display();
	}
}
