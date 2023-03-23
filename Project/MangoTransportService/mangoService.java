import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.time.LocalTime;

public class mangoService implements Runnable
{
	private Path p;
	private Agent a;
	private BoxColour b;
	private ArrayList<String> al;
	private LocalTime currentTime1 = null;
	private LocalTime currentTime2 = null;
	private HashMap<String, HashMap<String, String>> booking;
	
	public mangoService()
	{
		al = new ArrayList<>();
		booking = new HashMap<>();
	}
	
	public void run() 
	{
		
	}
	
	public Path getP() 
	{
		return p;
	}

	public void setP(Path p) 
	{
		this.p = p;
	}

	public Agent getA() 
	{
		return a;
	}

	public void setA(Agent a) 
	{
		this.a = a;
	}

	public BoxColour getB() 
	{
		return b;
	}

	public void setB(BoxColour b) 
	{
		this.b = b;
	}
	
	public void pathCountCheck()
	{
		if(p.getPathCount() < 10 || p.getPathCount() > 1000)
		{
			System.out.println("Invalid number of paths");
			return;
		}
	}
	
	public void boxConstraint()
	{
		
		HashMap<String, String>  hm = p.getPathAndVehicle();
		String b_colour = b.getColour();
		
		booking.put(b_colour, hm);
		
		Set<Entry<String, HashMap<String, String>>> s = booking.entrySet();
		
		for(Entry<String, HashMap<String, String>> e : s)
		{
			HashMap<String, String> hm_old = e.getValue();
			
			if(b_colour.equals("White-Box"))
			{
				if(p.getPathCount() < 10)
				{
					booking.put(b_colour, hm);
				}
			}
			
			if(booking.containsKey(b_colour))
			{
					currentTime1 = LocalTime.now();
					System.out.println("booking time is : "+currentTime1);
					
				
				this.chkDuration();
			}
			else
			{
				booking.put(b_colour, hm);
			}
			
		}

	}
	
	public void chkDuration()
	{
		currentTime2 = LocalTime.now();
		
		if(currentTime2.compareTo(currentTime1) < 45)
		{
			try 
			{
				Thread.sleep(45*60*1000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

	
	
	
}

