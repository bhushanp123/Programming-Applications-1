import java.util.Arrays;
import java.util.List;

public class BoxColour 
{
	private String colour;
	private List<String> li;
	
	public BoxColour(String colour)
	{
		this.colour = colour;
	}
	
	public void totalBoxes()
	{
		String boxes[] = {"White-Box","Black-Box","Red-Box","Green-Box","Orange-Box","Blue-Box"};
		
		li = Arrays.asList(boxes);

	}
	
	public boolean chkValidBox(String box)
	{
		boolean flag = true;
		
		for(int i = 0; i < li.size(); i++)
		{
			if(! li.contains(box))
			{
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	
	public void display()
	{
		System.out.println("Your selected box is : "+colour);
	}
	
	public String getColour()
	{
		return colour;
	}
}
