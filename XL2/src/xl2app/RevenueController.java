package xl2app;


/* 
 * This is the controller for the Revenue Assumption tab's panel
 * 
 * Kevin Crimi
 */
public class RevenueController {
ProjectController master;
Coordinate[] coords = {new Coordinate(8,8), new Coordinate(9,8)};
	
	public RevenueController(ProjectController caller){
		master = caller;
		
	}
	
	//Sets the the values for different years of NOI
	public void setNOI(int year, double value){
		master.xls.write(coords[year-1].y, coords[year-1].x, value);
	}
	
	//Sets the cap rates
	public void setCap(double value){
		master.xls.write(8, 6, value, 10);
	}
	
	//Retrieve NOI 
	public double getNOI(int year){
		return master.xls.readDouble(coords[year-1].y, coords[year-1].x);
	}
	
	//Retrieve cap rate
	public double getCap(){
		return master.xls.readDouble(8, 6);
	}
}
