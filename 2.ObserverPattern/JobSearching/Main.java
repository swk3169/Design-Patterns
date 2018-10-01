package JobSearchingObserverPattern;

public class Main
{
	public static void main(String[] args)
	{
		// subject ����
		JobData jobData = new JobData();
		
		// Observers ����
		JobSeeker jobSeeker = new JobSeeker(jobData);
		SalaryMan salaryMan = new SalaryMan(jobData);
		OldMan oldMan = new OldMan(jobData);
		
		// ���� ����
		jobData.jobPosting("�Ｚ", 45, 5000);
		jobData.jobPosting("������ö", 50, 6000);
		jobData.jobPosting("�����߰���", 60, 4500);
	}
}
