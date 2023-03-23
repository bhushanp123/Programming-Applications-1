import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Path 
{
	private Vehicle v;
	private BoxColour b;
	private int pathCount;
	private ArrayList<String> path_al;
	private HashMap<String, ArrayList<String>> hm;
	private HashMap<String, String> path_vehicle;
	
	
	public Path()
	{
		hm = new HashMap<>();
		path_vehicle = new HashMap<>();
		path_al = new ArrayList<>();
	}
	

	public void addPath()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 0 if you don't want to add path");
		
		System.out.println("Enter the number of paths to be add");
		int pathCount = sc.nextInt();
		
		
		int cnt = pathCount + path_al.size();
		
		for(int i = path_al.size(); i < cnt; i++)
		{
			path_al.add("Path"+(i+1));
		}
		//System.out.println(path_al);
	
	}
	
	public int getPathCount() 
	{
		this.pathCount = path_al.size();
		return pathCount;
	}
	
	public ArrayList<String> getpath_al() 
	{
		return path_al;
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


	public HashMap<String, ArrayList<String>> getHm() 
	{
		return hm;
	}

	
	public void setHm() 
	{
		v.availableVehicles();
		ArrayList<String> vehicle = v.getVehical_al();
	
		for(int i = 0; i < path_al.size(); i++)
		{
			String path = path_al.get(i);
			hm.put(path, vehicle);
		}
		
	}

	public HashMap<String, String> getPathAndVehicle()
	{
		v.availableVehicles();
		ArrayList<String> vehicle = v.getVehical_al();
		
		Collections.shuffle(vehicle);
		Collections.shuffle(path_al);
		
		String path = path_al.get(0);
		String p_vehicle = vehicle.get(0);
		
		path_vehicle.put(path, p_vehicle);
		
		return path_vehicle;
		
	}


}
