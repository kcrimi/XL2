package xl2app;

/*
 * This is the controller for the Phase panel in XL2
 * 
 * Kevin Crimi
 */

public class PhaseController {
	ProjectController master;
	Coordinate[] coords = {
			new Coordinate(1,13),	//phase 1
			new Coordinate(1,56), 	//phase 2
			new Coordinate(1,71) 	//phase 3
			};
	
	public PhaseController(ProjectController caller){
		master = caller;		
	}

	//Renames the phase # phaseNum to phaseName
	public void setPhaseName(int phaseNum, String phaseName){
		master.xls.write(coords[phaseNum-1].y, coords[phaseNum-1].x, phaseName);
		master.appFrame.fundingPanel.tabbedPane.setTitleAt(phaseNum-1, phaseName);
	}
	
	public String getPhaseName(int phaseNum){
		String s = master.xls.readString(coords[phaseNum-1].y, coords[phaseNum-1].x);
		return s;
	}
}
