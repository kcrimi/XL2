package xl2app;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * This is the main controller for the XL2 project. 
 * It calls sub controllers for each tabbedpane in the main projet window
 * 
 * Kevin Crimi
 */
public class ProjectController {
	//App JFrame
	XL2gui appFrame;
	
	//Tab controllers
	PhaseController phase;
	RevenueController revenue;
	CostController cost;
	FundingController funding;
	
	//XLSheet variables
	XLSheet xls;
	File saveFile, openFile, userManual;
	
	
	
	public ProjectController(XL2gui frame){
		//Main XL2gui
		appFrame = frame;
		
		//subcategory controllers
		phase = new PhaseController(this);
		revenue = new RevenueController(this);
		cost = new CostController(this);
		funding = new FundingController(this);
		
		//User Manual File
		userManual = new File("XL2 User Manual.pdf");
	}
	
	//Choose from set of templates to start a new model
	public void newProject(){
		openFile = null;
		Object[] possibilities = {"Hotel"};
		String s = (String)JOptionPane.showInputDialog(
				appFrame, 											//parent container
				"Select desired template to create new project",	//Prompt 
				"Create new Project",								//Dialog Title
				JOptionPane.PLAIN_MESSAGE,							//OptionPane type
				null,												//Icon
				possibilities,										//Drop Down choices
				"Hotel");											//Initial Selection

		switch (s){
		case "Hotel":
			open(new File("Models/Hotel.xls"));
			break;
		}
	}
	
	
	//Save the current XLSheet workbook
	public boolean save(){
		if(saveFile != null){
			if (WindowsUtils.excelOpen()){
				excelNotice();
				return false;
			}else{
				xls.commitChanges(saveFile);
				xls.saved = true;
				updateMenu();
				return xls.saved;
			}
		}else{
			//no saveFile exists
			return saveAs();
		}
	}

	public boolean saveAs(){
		//GUI file selection set selectFile
		boolean saved = false;
		JFileChooser fc = new JFileChooser();
		FileFilter filter1=new FileNameExtensionFilter("xls and xslx",new String[]{"xls","xlsx"});
		fc.setFileFilter(filter1);
		fc.setCurrentDirectory(new File(fc.getCurrentDirectory().getAbsolutePath()+"/XL2 Files"));
		
		int returnVal = fc.showSaveDialog(appFrame);
		if (returnVal == JFileChooser.APPROVE_OPTION){
			saveFile = fc.getSelectedFile();
			if (!(saveFile.getPath().endsWith(".xls") || saveFile.getPath().endsWith(".xlsx"))){
				saveFile = new File(saveFile.getAbsolutePath()+".xls");
			}
			saved = save();
		}
		if (saved){
			openFile = saveFile;
			xls.setTemp();
			updateTitle(openFile.getName());
		}
		return saved;
	}
	
	public void open(File selectedFile){
		boolean closed = true;
		if (xls != null){
			// xls exists
			closed = closeProject();
		}
		if (closed){
			// no xls file is open
			xls = new XLSheet(selectedFile);
			xls.setMaster(this);
			populate();
			appFrame.projectPane.setVisible(true);
			appFrame.lblProjectTitle.setVisible(true);
			updateMenu();
		}
	}
	
	public void open(){
		JFileChooser fc = new JFileChooser();
		FileFilter filter1=new FileNameExtensionFilter("xls and xslx",new String[]{"xls","xlsx"});
		fc.setFileFilter(filter1);
		fc.setCurrentDirectory(new File(fc.getCurrentDirectory().getAbsolutePath()+"/XL2 Files"));
		
		int returnVal = fc.showOpenDialog(appFrame);
		if (returnVal == JFileChooser.APPROVE_OPTION){
			openFile = fc.getSelectedFile();
			open(openFile);
			saveFile=openFile;
			xls.setTemp();
		}
	}
	
	//Populate panels with info from xls
	public void populate() {
		if (openFile != null){
			updateTitle(openFile.getName());
		}else{
			updateTitle("Untitled Document");
		}
		appFrame.phasePanel.populate();
		appFrame.revenuePanel.populate();
		appFrame.costPanel.populate();
		appFrame.fundingPanel.populate();	
	}
	
	//Updates the title of the current project
	private void updateTitle(String name){
		appFrame.lblProjectTitle.setText(name);
	}
	
	//Updates the enabled settings of the menu bar items based on the project status
	public void updateMenu(){
		if (xls != null){
			appFrame.mnReports.setEnabled(true);
			appFrame.mntmViewFullExcel.setEnabled(true);
			appFrame.mntmSaveAs.setEnabled(true);
			appFrame.mntmClose.setEnabled(true);
			if (xls.saved){
				appFrame.mntmSaveCtrls.setEnabled(false);
			}else{
				appFrame.mntmSaveCtrls.setEnabled(true);
			}
		}else{
			appFrame.mnReports.setEnabled(false);
			appFrame.mntmSaveCtrls.setEnabled(false);
			appFrame.mntmSaveAs.setEnabled(false);
			appFrame.mntmClose.setEnabled(false);
		}
	}
	
	//Attempt to close current project and return whether the project has been closed
	public boolean closeProject(){
		boolean close = true;
		boolean closedProject = true;
		if (!xls.saved){
			// Prompt for saving
			Object[] options = {"Save",
                    "Dont Save",
                    "Cancel"};
			int response = JOptionPane.showOptionDialog(appFrame,
					"Do you want to save the changes?",
					"Save Current Project?",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					options,
					options[2]);
			switch (response){
			case 0:	//save
				close = save();
				break;
			case 2: //cancel
				close = false;
				break;
			}
		}
		if (close){
			xls.close();
			xls = null;
			saveFile = null;
			updateMenu();
			appFrame.lblProjectTitle.setVisible(false);
			appFrame.projectPane.setVisible(false);
		}else{
			closedProject = false;
		}
		return closedProject;
	}
	
	//Attempt to exit entire XL2 software
	public void exit() {
		boolean closed = true;
		if(xls != null){
			closed = closeProject();
		}
		if(closed){
			appFrame.dispose();
			System.exit(0);
		}
		
	}
	
	public void cashFlowSummary(){
		xls.workbook.setActiveSheet(2);
		openExcel();
	}
	
	public void budgetSummary(){
		xls.workbook.setActiveSheet(1);
		openExcel();
	}
	
	public void excelView(){
		xls.workbook.setActiveSheet(4);
		openExcel();
	}
	public void openExcel(){
		if(save()){
			try {
				Runtime.getRuntime().exec(new String[]
						{"rundll32",
						"url.dll,FileProtocolHandler",
						saveFile.getAbsolutePath()});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void evaluateOutput() {
		int outputY[] = {53,67, 67, 68, 66, 67};  //Dynamic cells to be updated in gui
		int outputX[] = {10, 7,  8,  8,  9,  9};  //{Interest on loan, pre dev equity, dev equity, dev debt, stab noi, stab equity}
		for (int i=0; i<outputY.length;i++){
			xls.updateCell(outputY[i],outputX[i]);
		}
	}

	public void userManual() {
		try {
			Runtime.getRuntime().exec(new String[]
					{"rundll32",
					"url.dll,FileProtocolHandler",
					userManual.getAbsolutePath()});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void excelNotice() {
		JOptionPane.showMessageDialog(appFrame,
			    "Excel must be closed before project can be Saved",
			    "Please Close Excel",
			    JOptionPane.WARNING_MESSAGE);
	}

}
