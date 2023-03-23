import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		mangoService mobj = new mangoService();
		Thread t = new Thread(mobj);
		
		t.setDaemon(true);
		
		t.start();
		//mobj.start();
	
		System.out.println("Available box colours are : ");
		
		System.out.println("White-Box");
		System.out.println("Black-Box");
		System.out.println("Red-Box");
		System.out.println("Green-Box");
		System.out.println("Orange-Box");
		System.out.println("Blue-Box");
		
		System.out.println("Enter the box you want : ");
		String box_name = sc.next();
		
		BoxColour bobj = new BoxColour(box_name);
		bobj.totalBoxes();
		
		boolean bRet = bobj.chkValidBox(box_name);
		if(bRet == false)
		{
			System.out.println("Sorry, there is no such box available");
			return;
		}
		
		bobj.display();
		
		Vehicle vobj = new Vehicle();
		//v.availableVehicles();
		//ArrayList<String> vehicles = v.getVehical_al();
		//System.out.println(vehicles);
		
		Path pobj = new Path();
		pobj.setV(vobj);
		pobj.addPath();
		ArrayList<String> path = pobj.getpath_al();
		
		System.out.println("Available paths are : ");
		
		Iterator<String> it = path.iterator();
		
		while(it.hasNext())
		{
			String p_name = it.next();
			System.out.println(p_name);
		}
		
		int path_cnt = pobj.getPathCount();
		System.out.println("Total paths are : "+path_cnt);
		
		pobj.setHm();
		
		System.out.println(pobj.getHm());
		
		System.out.println("Your path and vehicle is : ");
		
		//System.out.println(pobj.getPathAndVehicle());
		
		Agent aobj = new Agent();
		
		aobj.setB(bobj);
		aobj.setP(pobj);
		aobj.setM(mobj);
		
		aobj.getMangoPathAndVehicle();
		
		mobj.setB(bobj);
		mobj.setP(pobj);
		mobj.setA(aobj);
		
		mobj.pathCountCheck();
		mobj.boxConstraint();
	}

}
