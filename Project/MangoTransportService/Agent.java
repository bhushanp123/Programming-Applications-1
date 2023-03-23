import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Agent 
{
	
	private Path p;
	private Vehicle v;
	private BoxColour b;
	private mangoService m;
	private String selected_path;
	private String selected_vehicle;
	private HashMap<String, String> path_vehicle;
	private HashMap<String, ArrayList<String>> hm;
	
	public Agent()
	{
		hm = new HashMap<>();
	}
	
	public Path getP() 
	{
		return p;
	}

	public void setP(Path p) 
	{
		this.p = p;
	}
	
	public Vehicle getV() 
	{
		return v;
	}


	public void setV(Vehicle v) 
	{
		this.v = v;
	}

	public BoxColour getB() 
	{
		return b;
	}

	public void setB(BoxColour b) 
	{
		this.b = b;
	}
	

	public mangoService getM() 
	{
		return m;
	}

	public void setM(mangoService m) 
	{
		this.m = m;
	}

	
	
	public String getSelected_path() 
	{
		return selected_path;
	}


	public String getSelected_vehicle() 
	{
		return selected_vehicle;
	}


	public void getMangoPathAndVehicle()
	{
		path_vehicle = p.getPathAndVehicle();
		
		Set<Entry<String, String>> s = path_vehicle.entrySet();
		
		for(Entry<String, String> e : s)
		{
			selected_path = e.getKey();
			selected_vehicle = e.getValue();
			
			System.out.println("Selected Path is : "+selected_path);
			System.out.println("Selected Vehicle is : "+selected_vehicle);
		}
		
		//System.out.println(path_vehicle);
	}
}
