//Use Case 14 (Ability to get the Total Wage when queried by company)

import java.util.*;


interface ComputeEmpWage_Interface
{
	 public void addCompany(String companyName, int empRatePerHr, int numberOfWorkingDays, int maxWorkingHrs);
	 public void empComputeWage();
	 public int getEmpTotalWage(String companyName);
}



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
        	empTotalWage = 0;
	}

        public void setTotalEmpWage(int empTotalWage)
        {
                this.empTotalWage = empTotalWage;
        }
}



public class EmpWageComputation_Object_Oriented implements ComputeEmpWage_Interface
{
        public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;

        public LinkedList<CompanyEmpWage> companyEmpWageList;
	public Map<String,CompanyEmpWage> companyToEmpWageMap;

	public int numberOfCompany=0;


	public EmpWageComputation_Object_Oriented()
	{
		companyEmpWageList= new LinkedList<>();
		companyToEmpWageMap = new HashMap<>();
	}


        public void addCompany(String companyName, int empRatePerHr, int numberOfWorkingDays, int maxWorkingHrs)
        {
                CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName, empRatePerHr, numberOfWorkingDays, maxWorkingHrs);

                companyEmpWageList.add(companyEmpWage);
        	companyToEmpWageMap.put(companyName,companyEmpWage);
	}


        public void empComputeWage()
        {
                for(int i=0;i<companyEmpWageList.size();i++)
                {
			CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
                        companyEmpWage.setTotalEmpWage(this.empComputeWage(companyEmpWage));
                }
        }

	
	public int getEmpTotalWage(String companyName)
	{
		return companyToEmpWageMap.get(companyName).empTotalWage;
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

			Dictionary storingEmpDailyWage = new Hashtable();

			String result = empDailyWage + ":" + empTotalWage;

			storingEmpDailyWage.put(totalWorkingDays, result);
			
			for(Enumeration i = storingEmpDailyWage.elements();i.hasMoreElements();)
			{
                        	System.out.println("Value in Dictionary for Day" + totalWorkingDays + ": "+ i.nextElement());
                        	System.out.println();
			}

			System.out.println("Employee's Daily Wage for Day " + totalWorkingDays + " in " + companyEmpWage.companyName + ": " + empDailyWage);
			System.out.println("Employee's Total Wage till Day " + totalWorkingDays + " in " + companyEmpWage.companyName + ": " + empTotalWage);			
			System.out.println();

                }

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
                ComputeEmpWage_Interface list = new EmpWageComputation_Object_Oriented();

                list.addCompany("DMart", 20, 2, 10);
                list.addCompany("BigBasket", 10, 4, 20);

                list.empComputeWage();
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");

		System.out.println("Employee's Total Wage for DMart: " + list.getEmpTotalWage("DMart"));
        }
}
