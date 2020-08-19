// Use Case 9 (Ability to save the Total Wage for each company)



class CompanyEmpWage
{
        public final String companyName;
        public final int empRatePerHr;
        public final int numberOfWorkingDays;
        public final int maxWorkingHrs;
        public int empTotalWage;

        public CompanyEmpWage(String companyName, int empRatePerHr, int numberOfWorkingDays, int maxWorkingHrs)
        {
                this.companyName = companyName;
                this.empRatePerHr = empRatePerHr;
                this.numberOfWorkingDays = numberOfWorkingDays;
                this.maxWorkingHrs = maxWorkingHrs;
        }

        public void setTotalEmpWage(int empTotalWage)
        {
                this.empTotalWage = empTotalWage;
        }
}



public class EmpWageComputation_Object_Oriented
{
        public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;
        

        public static void empComputeWage(String companyName, int empRatePerHr, int numberOfWorkingDays, int maxWorkingHrs)
        {
                int empDailyHrs = 0;
                int empTotalHrs = 0;

                int EmpDailyWage;
                int EmpTotalWage = 0;

                int totalWorkingDays=0;

                while(empTotalHrs < maxWorkingHrs && totalWorkingDays < numberOfWorkingDays)
                {
                        totalWorkingDays = totalWorkingDays + 1;

                        int empCheck=(int)(Math.floor(Math.random()*10)%3);

                        switch(empCheck)
                        {
                                case IS_FULL_TIME:
                                {
                                        empDailyHrs=8;
                                        break;
                                }
                                case IS_PART_TIME:
                                {
                                        empDailyHrs=4;
                                        break;
                                }
                        }

                        empTotalHrs = empTotalHrs + empDailyHrs;

                        EmpDailyWage = empRatePerHr * empDailyHrs;
                        EmpTotalWage = EmpTotalWage + EmpDailyWage;

                        System.out.println("Employee's Daily Hours for Day " + totalWorkingDays + " in " + companyName + ": " + empDailyHrs);
                        System.out.println("Employee's Daily Wage for Day " + totalWorkingDays + " in " + companyName + ": " + EmpDailyWage);

                        System.out.println();
                }

                System.out.println();
                System.out.println();
                System.out.println("Employee's Total Hours in " + companyName + ": "  + empTotalHrs);
                System.out.println("Employee's Total Wage in " + companyName + ": "  + EmpTotalWage);
		System.out.println();
                System.out.println();
		System.out.println();
        }
}



public class EmpWageComputation_Object_Oriented
{
	public static void main(String[] args)
	{
		EmpWageComputation dmart = new EmpWageComputation();
		dmart.empComputeWage("DMart", 20, 24, 100);

		EmpWageComputation bigbasket = new EmpWageComputation();
		bigbasket.empComputeWage("BigBasket", 25, 27, 98);
	}
}
