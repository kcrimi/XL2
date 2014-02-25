package xl2app;
/*
 * This is the controller for the Costs Assumptions panel tab
 * 
 * Kevin Crimi
 */
public class CostController {
ProjectController master;

	
	public CostController(ProjectController caller){
		master = caller;	
	}
	
	/*
	 * Land Aquisition Costs
	 */
	public void setLandAcq(double value){
		master.xls.write(21, 13, value);
	}
	
	public void setCommissionCost(double value){
		master.xls.write(22, 4, value, 10);
	}
	
	public double getLandAcq(){
		return master.xls.readDouble(21, 13);
	}
	
	public double getCommissionCost(){
		return master.xls.readDouble(22, 4);
	}
	
	
	/*
	 * Pre-Development Costs
	 */
	public void setArchDesignPD(double value){
		master.xls.write(25, 4, value, 10);
	}
	
	public void setEntitlement(double value){
		master.xls.write(26, 10, value);
	}
	
	public void setLegalTitleIns(double value){
		master.xls.write(27, 10, value);
	}
	
	public void setPreconstructionServ(double value){
		master.xls.write(28, 10, value);
	}
	
	public void setContingencyPD(double value){
		master.xls.write(29, 4, value, 10);
	}
	
	public double getArchDesignPD(){
		return master.xls.readDouble(25, 4);
	}
	
	public double getEntitlement(){
		return master.xls.readDouble(26, 10);
	}
	
	public double getLegalTitleIns(){
		return master.xls.readDouble(27, 10);
	}
	
	public double getPreconstructionServ(){
		return master.xls.readDouble(28, 10);
	}
	
	public double getContingencyPD(){
		return master.xls.readDouble(29,4);
	}
	
	/*
	 * Direct Development Costs
	 */
	
	public void setArchDesignDD(double value){
		master.xls.write(32, 4, value, 10);
	}
	
	public void setFeesPermits(double value){
		master.xls.write(33, 4, value, 10);
	}
	
	public void setDirConstructHotel(double value){
		master.xls.write(34, 3, value, 7);
	}
	
	public void setDirConstructTimeshare(double value){
		master.xls.write(34, 5, value, 7);
	}
	
	public void setDirConstructRetail(double value){
		master.xls.write(35, 4, value, 7);
	}
	
	public void setOffsiteUpgrade(double value){
		master.xls.write(36, 10, value);
	}
	
	public void setCommonArea(double value){
		master.xls.write(37, 4, value, 7);
	}
	
	public void setMaintenance(double value){
		master.xls.write(38, 10, value);
	}
	
	public void setTesting(double value){
		master.xls.write(39, 4, value, 10);	
	}
	
	public void setContingencyDD(double value){
		master.xls.write(40, 4, value);
	}
	
	public double getArchDesignDD(){
		return master.xls.readDouble(32, 4);
	}
	
	public double getFeesPermits(){
		return master.xls.readDouble(33, 4);
	}
	
	public double getDirConstructHotel(){
		return master.xls.readDouble(34, 3);
	}
	
	public double getDirConstructTimeshare(){
		return master.xls.readDouble(34, 5);
	}
	
	public double getDirConstructRetail(){
		return master.xls.readDouble(35, 4);
	}
	
	public double getOffsiteUpgrade(){
		return master.xls.readDouble(36, 10);
	}
	
	public double getCommonArea(){
		return master.xls.readDouble(37, 4);
	}
	
	public double getMaintenance(){
		return master.xls.readDouble(38, 10);
	}
	
	public double getTesting(){
		return master.xls.readDouble(39, 4);	
	}
	
	public double getContingencyDD(){
		return master.xls.readDouble(40, 4);
		
	}
	
	/*
	 * Indirect Development Costs
	 */
	
	public void setSalesMarketing(double value){
		master.xls.write(43, 10, value, 7);
	}
	
	public void setConstructManag(double value){
		master.xls.write(44, 4, value, 10);
	}
	
	public void setPropTax(double value){
		master.xls.write(45, 3, value, 10);
	}
	
	public void setAssessment(double value){
		master.xls.write(45, 5, value, 7);
	}
	
	public void setInsuranceRate(double value){
		master.xls.write(46, 3, value, 10);
	}
	
	public void setInsurancePreDev(double value){
		master.xls.write(46, 5, value, 10);
	}
	
	public void setDREHOA(double value){
		master.xls.write(47, 4, value, 7);
	}
	
	public void setDevFee(double value){
		master.xls.write(48, 4, value, 7);
	}
	
	public void setLegalExpens(double value){
		master.xls.write(49, 10, value);
	}
	
	public void setMiscReimburs(double value){
		master.xls.write(50, 10, value);
	}
	
	public void setLeasehold(double value){
		master.xls.write(51, 4, value, 7);
	}
	
	public void setOriginationFee(double value){
		master.xls.write(53, 4, value, 10);
	}
	
	public void setContingencyID(double value){
		master.xls.write(54, 4, value, 10);
	}
	
	public double getSalesMarketing(){
		return master.xls.readDouble(43, 10);
	}
	
	public double getConstructManag(){
		return master.xls.readDouble(44, 4);
	}
	
	public double getPropTax(){
		return master.xls.readDouble(45, 3);
	}
	
	public double getAssessment(){
		return master.xls.readDouble(45, 5);
	}
	
	public double getInsuranceRate(){
		return master.xls.readDouble(46, 3);
	}
	
	public double getInsurancePreDev(){
		return master.xls.readDouble(46, 5);
	}
	
	public double getDREHOA(){
		return master.xls.readDouble(47, 4);
	}
	
	public double getDevFee(){
		return master.xls.readDouble(48, 4);
	}
	
	public double getLegalExpens(){
		return master.xls.readDouble(49, 10);
	}
	
	public double getMiscReimburs(){
		return master.xls.readDouble(50, 10);
	}
	
	public double getLeasehold(){
		return master.xls.readDouble(51, 4);
	}
	
	public double getInterestConstLoan(){
		return master.xls.readDouble(52, 10);
	}
	
	public double getOriginationFee(){
		return master.xls.readDouble(53, 4);
	}
	
	public double getContingencyID(){
		return master.xls.readDouble(54, 4);
	}
}
