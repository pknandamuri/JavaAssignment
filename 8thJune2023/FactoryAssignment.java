package designpattern.Creationalpattern;

interface IHealthRecord{
	public String GetRecordToCite();
}

class Problem implements IHealthRecord{
	public String GetRecordToCite() {
		return "Get patient problems";
	}
}
class Allergy implements IHealthRecord{
	public String GetRecordToCite() {
		return "Get patient allergies";
	}
}
class Alert implements IHealthRecord{
	public String GetRecordToCite() {
		return "Get patient alerts";
	}
}

class HealthRecordFactory {
	public IHealthRecord GetHealthObject(String HealthObjectType) {
		if(HealthObjectType == null) return null;
		else if (HealthObjectType.equalsIgnoreCase("Problem"))
			return new Problem();
		else if (HealthObjectType.equalsIgnoreCase("Allergy"))
			return new Allergy();
		else if (HealthObjectType.equalsIgnoreCase("Alert"))
			return new Alert();
		return null;
	}
}

public class FactoryAssignment {

	public static void main(String[] args) {
		HealthRecordFactory hrf = new HealthRecordFactory();

		IHealthRecord hr = hrf.GetHealthObject("Problem");
		System.out.println(hr.GetRecordToCite());
		
		hr = hrf.GetHealthObject("Allergy");
		System.out.println(hr.GetRecordToCite());
		
		hr = hrf.GetHealthObject("Alert");
		System.out.println(hr.GetRecordToCite());
	}

}