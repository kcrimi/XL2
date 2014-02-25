package xl2app;

import java.util.ArrayList;

/*
 * This is the controller for the panel under the Funding Assumptions tab
 * 
 * Kevin Crimi
 */
public class FundingController {
ProjectController master;
Coordinate[] coords = {
		new Coordinate(66, 7), //PreDev NOI
		new Coordinate(67, 7), //PreDev Equity
		new Coordinate(68, 7), //PreDev Debt
		new Coordinate(66, 8), //Dev NOI
		new Coordinate(67, 8), //Dev Equity
		new Coordinate(68, 8), //Dev Debt
		new Coordinate(66, 9), //Stab NOI
		new Coordinate(67, 9), //Stab Equity
		new Coordinate(68, 9), //Stab Debt
};
	
	public FundingController(ProjectController caller){
		master = caller;
		
	}
	
	public ArrayList<Double> getFunding(int phaseNum){
		ArrayList<Double> funding = new ArrayList<Double>();
		for (Coordinate coord : coords) {
			funding.add(master.xls.readDouble(coord.y, coord.x));
		}
		return funding;
	}
	
	public void setTester (double value){
		master.xls.write(5,7,value);
	}

	public void setIterestRate(double value) {
		master.xls.write(74, 4, value);
		
	}

	public void setLTC(double value) {
		master.xls.write(73,4,value);
		
	}

	public double getInterestRate() {
		return master.xls.readDouble(74, 4);
	}

	public double getLTC() {
		return master.xls.readDouble(73, 4);
	}
}
