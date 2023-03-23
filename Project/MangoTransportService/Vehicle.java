import java.util.ArrayList;

public class Vehicle 
{
	private ArrayList<String> vehical_al;
	
	public Vehicle()
	{
		vehical_al = new ArrayList<>();
	}
	
	public void availableVehicles()
	{
		for(int i = 0; i < 5; i++)
		{
			vehical_al.add("Vehicle" +(i+1));
		}
	}

	public ArrayList<String> getVehical_al() 
	{
		return vehical_al;
	}

}
