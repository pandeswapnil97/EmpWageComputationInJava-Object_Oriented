// Use Case 10 (Ability to manage Employee Wage of multiple companies)

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

        public CompanyEmpWage[] companyEmpWageArray;
        public int numberOfCompany;


        public EmpWageComputation_Object_Oriented()
        {
                companyEmpWageArray = new CompanyEmpWage[4];
        }


        public void addCompany(String companyName, int empRatePerHr, int numberOfWorkingDays, int maxWorkingHrs)
        {
                companyEmpWageArray[numberOfCompany]=new CompanyEmpWage(companyName, empRatePerHr, numberOfWorkingDays, maxWorkingHrs);
                numberOfCompany++;
        }


        public void empComputeWage()
        {
                for(int i=0;i<numberOfCompany;i++)
                {
                        companyEmpWageArray[i].setTotalEmpWage(this.empComputeWage(companyEmpWageArray[i]));
                }
        }


        public int empComputeWage(CompanyEmpWage companyEmpWage)
        {
                int empDailyHrs = 0;
                int empTotalHrs = 0;

                int empDailyWage;
                int empTotalWage = 0;

                int totalWorkingDays=0;

                while(empTotalHrs < companyEmpWage.maxWorkingHrs && totalWorkingDays < companyEmpWage.numberOfWorkingDays)
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

                        empDailyWage = companyEmpWage.empRatePerHr * empDailyHrs;
                        empTotalWage = empTotalWage + empDailyWage;

                        System.out.println("Employee's Daily Hours for Day " + totalWorkingDays + " in " + companyEmpWage.companyName + ": " + empDailyHrs);
                        System.out.println("Employee's Daily Wage for Day " + totalWorkingDays + " in " + companyEmpWage.companyName + ": " + empDailyWage);

                        System.out.println();
                }

                System.out.println();
                System.out.println();
                System.out.println("Employee's Total Hours in " + companyEmpWage.companyName + ": "  + empTotalHrs);
                System.out.println("Employee's Total Wage in " + companyEmpWage.companyName + ": "  + empTotalWage);
                System.out.println();
                System.out.println();
                System.out.println();

                return empTotalWage;
        }



        public static void main(String[] args)
        {
                EmpWageComputation_Object_Oriented array = new EmpWageComputation_Object_Oriented();

                array.addCompany("DMart", 20, 24, 100);
                array.addCompany("BigBasket", 25, 27, 98);

                array.empComputeWage();
        }
}
