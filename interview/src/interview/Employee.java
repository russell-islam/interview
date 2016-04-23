package interview;

import java.util.ArrayList;

public class Employee {
	int id;
	ArrayList<Employee> reporters = new ArrayList<Employee>();
	public Employee(int id)
	{
		this.id = id;
	}
	public void AddReport(Employee emp)
	{
		reporters.add(emp);
	}
	public Employee CommonManager(Employee ceo, Employee e1, Employee e2)
	{
		if(ceo == null)
		{
			return null;
		}
		for (Employee employee : ceo.reporters) {
			if(employee.id == e1.id || employee.id==e2.id)
				return ceo;
		}
		Employee firstEmployee = null;
        Employee secondEmployee = null;

        for (Employee reporter : ceo.reporters) {
            if (firstEmployee != null) {
                secondEmployee = CommonManager(reporter, e1, e2);
                if (secondEmployee != null) {
                    return reporter;
                }
            } else {
                firstEmployee = CommonManager(reporter, e1, e2);
            }
        }

        return firstEmployee;
	}
	private static Employee CreateCEO()
	{
		Employee ceo = new Employee(1);
		return ceo;
	}
	public static void TestCommonManager()
	{
		
	}

}
