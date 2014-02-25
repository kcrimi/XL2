package xl2app;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/*
* 
* This class loads a file (.xls or .xlsx) and allows other classes to write or read from it
* 
* Kevin Crimi
* 
*/
public class XLSheet {
	File tempFile;
	Sheet fullCashFlow;
	Workbook workbook;
	boolean saved;
	FormulaEvaluator evaluator;
	ProjectController master;
	
	//Constructor for new projects
	public XLSheet(File selectedFile){
		try {
			// Load template workbook
			InputStream input = new FileInputStream(selectedFile);
			new WorkbookFactory();
			workbook = WorkbookFactory.create(input);
			workbook.setForceFormulaRecalculation(true);
			workbook.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);
			evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			fullCashFlow = workbook.getSheetAt(4);
			
			//set output file
			tempFile = new File("Temp/Untitled"+System.currentTimeMillis()+".xls");
			saved = false;
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	//Write information to cell
	/*
	 * Takes in y (row) and x (column) and writes the value to the cell.
	 * TO-DO: Currenty writes only Strings. Need to adapt this to accomodate ints and doubles 
	 */
	public void write(int y, int x, String value){
		try {
			Row row = fullCashFlow.getRow(y);
			Cell cell = row.getCell(x);
			
			if (cell == null){
				cell = row.createCell(x);
			}
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(value);
			commitChanges(tempFile);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	// write value to cell x,y with the selected style (7=currency, 10=percentage, 43=accounting) 
	public void write(int y, int x, double value,int selectStyle){
		try {
			Row row = fullCashFlow.getRow(y);
			Cell cell = row.getCell(x);
			
			if (cell == null){
				cell = row.createCell(x);
			}
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			
			//set style by number
			//CellStyle style = workbook.createCellStyle();
			//style.setDataFormat((short) selectStyle);
			//cell.setCellStyle(style);
			CellStyle style = cell.getCellStyle();
			
			cell.setCellValue(value);
			cell.setCellStyle(style);
			
			commitChanges(tempFile);
			
			
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	// Write to cell (y, x) with the default accounting style (only needed when writing specific formats
	public void write(int y, int x, double value){
		write(y, x, value, 43);
	}
	
	/*
	 * Retrieve information from cell
	 * returns value at y (row) and x (column)
	 * 
	 */
	public String readString(int y, int x){
		Row row = fullCashFlow.getRow(y);
		Cell cell = row.getCell(x);
		String a =  cell.getStringCellValue();
		return a;
	}
	
	public double readDouble(int y, int x){
		Row row = fullCashFlow.getRow(y);
		Cell cell = row.getCell(x);
		if (cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
			double a =  cell.getNumericCellValue();
			return a;
		}
		return 0.0;
	}
	
	// Use this to find the cell type of the cell
	public int getType(int y, int x){
		Row row = fullCashFlow.getRow(y);
		Cell cell = row.getCell(x);
		int a =  cell.getCellType();
		return a;
	}
	
	//Listing All Cells in a row. (Used for testing)
	public void listCells(int y){
		Row row = fullCashFlow.getRow(y);
		Iterator<Cell> it = row.cellIterator();
		while (it.hasNext()){
			Cell cell = it.next();
			System.out.println(cell.toString());
			//cell.setCellValue(i);
		}
		commitChanges(tempFile);
	}
	
	//Commit all changes to selected output file
	/*
	 * called by writes in order to save the data to the output file
	 */
	void commitChanges(File outputFile){
		FileOutputStream fileOut;
		try {
			//TODO Implement xls updating, evaluating all the formula cells and populate the dynamic fields in the GUI
			//Update Formulasand Dynamic Fields 
			//evaluator.clearAllCachedResultValues();
			//evaluator.evaluateAll();
			//master.populate();
			
			//Write Files
			fileOut = new FileOutputStream(outputFile);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();

			//Set "save" to enabled in menubar
			saved = false;
			master.updateMenu();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	
	//Delete Tempfile (for close of app)
	public void close(){
		tempFile.delete();
	}

	public void setMaster(ProjectController projectController) {
		master = projectController;
	}

	public void updateCell(int y, int x) {
		Row row = fullCashFlow.getRow(y);
		Cell cell = row.getCell(x);
		evaluator.evaluateFormulaCell(cell);
	}

	public void setTemp() {
		String s = master.saveFile.getName();
		s = s.substring(0, s.length()-4);
		tempFile.delete();
		tempFile = new File("Temp/"+s+System.currentTimeMillis()+".xls");
	}

}
