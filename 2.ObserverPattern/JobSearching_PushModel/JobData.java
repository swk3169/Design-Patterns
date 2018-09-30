package JobSearchingObserverPattern;

import java.util.ArrayList;

public class JobData implements Subject
{
	private ArrayList<Observer> observers;
	private String company;	// È¸»ç
	private int date;	// Á¤³âÅðÁ÷ÀÏ
	private int salary;	// ¿¬ºÀ
	
	public JobData() { observers = new ArrayList<Observer>(); }
	
	public void registerObserver(Observer o) 
	{
		observers.add(o);
	}
	
	public void removeObserver(Observer o) 
	{
		int i = observers.indexOf(o);
		if (i >= 0)
		{
			observers.remove(i);
		}
	}
	
	public void notifyObservers() 
	{
		for(Observer observer : observers)
		{
			observer.update(company, date, salary);
		}
	}
	
	public void jobPostingChanged()
	{
		notifyObservers();
	}
	
	public void jobPosting(String company, int date, int salary)
	{
		this.company = company;
		this.date = date;
		this.salary = salary;
		
		jobPostingChanged();
	}
}
