package JobSearchingObserverPattern;

public class Main
{
	public static void main(String[] args)
	{
		// subject 생성
		JobData jobData = new JobData();
		
		// Observers 생성
		JobSeeker jobSeeker = new JobSeeker(jobData);
		SalaryMan salaryMan = new SalaryMan(jobData);
		OldMan oldMan = new OldMan(jobData);
		
		// 구인 공고
		jobData.jobPosting("삼성", 45, 5000);
		jobData.jobPosting("포항제철", 50, 6000);
		jobData.jobPosting("현대중공업", 60, 4500);
	}
}
