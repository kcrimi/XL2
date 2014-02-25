package xl2app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class CostPanel extends JPanel implements PropertyChangeListener{
	ProjectController controller;
	MoneyField tfLandAcquisition;
	MoneyField tfEntitlementCosts;
	MoneyField tfLegalTitleIns;
	MoneyField tfPreconstructionServices;
	MoneyField tfDirConstructionHotel;
	MoneyField tfDirectConstructionTimeshare;
	MoneyField tfDirConstructionRetail;
	MoneyField tfOffsiteUpgrades;
	MoneyField tfCommonArea;
	MoneyField tfSalesMarketing;
	MoneyField tfConstructionManagent;
	MoneyField tfDreHoaMaintenance;
	MoneyField tfDevelopmentFee;
	MoneyField tfLegalExpense;
	MoneyField tfAssessedValue;
	MoneyField tfMiscExpReimbursements;
	MoneyField tfLeaseholdPayments;
	MoneyField tfPredevInsurance;
	MoneyField tfInterestConstLoan;
	PercentSpinner spOriginationFee;
	PercentSpinner spContingencyID;
	PercentSpinner spArchitectureDesignDD;
	PercentSpinner spContingencyPD;
	PercentSpinner spArchitectureDesignPD;
	PercentSpinner spCommissionAndClosing;
	PercentSpinner spFeesAndPermits;
	PercentSpinner spTestingInspection;
	PercentSpinner spInsuranceRate;
	PercentSpinner spPropertTaxes;
	MoneyField tfMaintenanceRepairs;
	PercentSpinner spContingencyDD;

	/**
	 * Create the panel.
	 */
	public CostPanel(ProjectController c) {
		controller = c;
		setBackground(new Color(105, 105, 105));
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Calibri", Font.PLAIN, 14));
		add(tabbedPane);
		
		JPanel landAcqTab = new JPanel();
		tabbedPane.addTab("Land Acquisition", null, landAcqTab, null);
		
		JPanel landAcqPanel = new JPanel();
		landAcqPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Land Aquisition Costs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		landAcqTab.add(landAcqPanel);
		GridBagLayout gbl_landAcqPanel = new GridBagLayout();
		gbl_landAcqPanel.columnWidths = new int[] {30, 0, 30, 30, 30};
		gbl_landAcqPanel.rowHeights = new int[] {40, 40};
		gbl_landAcqPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0};
		gbl_landAcqPanel.rowWeights = new double[]{0.0, 0.0};
		landAcqPanel.setLayout(gbl_landAcqPanel);
		
		JLabel lblLandAcquisition = new JLabel("Land Acquisition");
		lblLandAcquisition.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLandAcquisition = new GridBagConstraints();
		gbc_lblLandAcquisition.anchor = GridBagConstraints.WEST;
		gbc_lblLandAcquisition.insets = new Insets(0, 0, 5, 5);
		gbc_lblLandAcquisition.gridx = 1;
		gbc_lblLandAcquisition.gridy = 0;
		landAcqPanel.add(lblLandAcquisition, gbc_lblLandAcquisition);
		
		tfLandAcquisition = new MoneyField();
		tfLandAcquisition.addPropertyChangeListener("value", this);
		tfLandAcquisition.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_tfLandAcquisition = new GridBagConstraints();
		gbc_tfLandAcquisition.insets = new Insets(0, 0, 5, 5);
		gbc_tfLandAcquisition.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfLandAcquisition.gridx = 2;
		gbc_tfLandAcquisition.gridy = 0;
		landAcqPanel.add(tfLandAcquisition, gbc_tfLandAcquisition);
		tfLandAcquisition.setColumns(10);
		
		JLabel lblCommissionAndClosing = new JLabel("Commission and Closing Costs");
		lblCommissionAndClosing.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCommissionAndClosing = new GridBagConstraints();
		gbc_lblCommissionAndClosing.insets = new Insets(0, 0, 0, 5);
		gbc_lblCommissionAndClosing.anchor = GridBagConstraints.WEST;
		gbc_lblCommissionAndClosing.gridx = 1;
		gbc_lblCommissionAndClosing.gridy = 1;
		landAcqPanel.add(lblCommissionAndClosing, gbc_lblCommissionAndClosing);
		
		spCommissionAndClosing = new PercentSpinner();
		GridBagConstraints gbc_spCommissionAndClosing = new GridBagConstraints();
		gbc_spCommissionAndClosing.anchor = GridBagConstraints.EAST;
		gbc_spCommissionAndClosing.insets = new Insets(0, 0, 0, 5);
		gbc_spCommissionAndClosing.gridx = 2;
		gbc_spCommissionAndClosing.gridy = 1;
		landAcqPanel.add(spCommissionAndClosing, gbc_spCommissionAndClosing);
		
		JLabel lbl2CommissionAndClosing = new JLabel("of Land");
		lbl2CommissionAndClosing.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2CommissionAndClosing = new GridBagConstraints();
		gbc_lbl2CommissionAndClosing.insets = new Insets(0, 0, 0, 5);
		gbc_lbl2CommissionAndClosing.gridx = 3;
		gbc_lbl2CommissionAndClosing.gridy = 1;
		landAcqPanel.add(lbl2CommissionAndClosing, gbc_lbl2CommissionAndClosing);
		
		JPanel preDevCostTab = new JPanel();
		tabbedPane.addTab("Pre-Development", null, preDevCostTab, null);
		
		JPanel preDevCostPanel = new JPanel();
		preDevCostPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Pre-Development Costs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		preDevCostTab.add(preDevCostPanel);
		GridBagLayout gbl_preDevCostPanel = new GridBagLayout();
		gbl_preDevCostPanel.columnWidths = new int[] {30, 0, 30, 30, 30};
		gbl_preDevCostPanel.rowHeights = new int[] {30, 30, 30, 30, 30};
		gbl_preDevCostPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		gbl_preDevCostPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		preDevCostPanel.setLayout(gbl_preDevCostPanel);
		
		JLabel lblArchitectureDesignPD = new JLabel("Architecture, Design & Engineering");
		lblArchitectureDesignPD.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblArchitectureDesignPD = new GridBagConstraints();
		gbc_lblArchitectureDesignPD.anchor = GridBagConstraints.WEST;
		gbc_lblArchitectureDesignPD.insets = new Insets(0, 0, 5, 5);
		gbc_lblArchitectureDesignPD.gridx = 1;
		gbc_lblArchitectureDesignPD.gridy = 0;
		preDevCostPanel.add(lblArchitectureDesignPD, gbc_lblArchitectureDesignPD);
		
		spArchitectureDesignPD = new PercentSpinner();
		GridBagConstraints gbc_spArchitectureDesignPD = new GridBagConstraints();
		gbc_spArchitectureDesignPD.anchor = GridBagConstraints.EAST;
		gbc_spArchitectureDesignPD.insets = new Insets(0, 0, 5, 5);
		gbc_spArchitectureDesignPD.gridx = 2;
		gbc_spArchitectureDesignPD.gridy = 0;
		preDevCostPanel.add(spArchitectureDesignPD, gbc_spArchitectureDesignPD);
		
		JLabel lbl2ArchitectureDesignPD = new JLabel("of Directs");
		lbl2ArchitectureDesignPD.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2ArchitectureDesignPD = new GridBagConstraints();
		gbc_lbl2ArchitectureDesignPD.anchor = GridBagConstraints.WEST;
		gbc_lbl2ArchitectureDesignPD.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2ArchitectureDesignPD.gridx = 3;
		gbc_lbl2ArchitectureDesignPD.gridy = 0;
		preDevCostPanel.add(lbl2ArchitectureDesignPD, gbc_lbl2ArchitectureDesignPD);
		
		JLabel lblEntitlementCosts = new JLabel("Entitlement Costs");
		lblEntitlementCosts.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEntitlementCosts = new GridBagConstraints();
		gbc_lblEntitlementCosts.anchor = GridBagConstraints.WEST;
		gbc_lblEntitlementCosts.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntitlementCosts.gridx = 1;
		gbc_lblEntitlementCosts.gridy = 1;
		preDevCostPanel.add(lblEntitlementCosts, gbc_lblEntitlementCosts);
		
		tfEntitlementCosts = new MoneyField();
		tfEntitlementCosts.addPropertyChangeListener("value", this);
		
		tfEntitlementCosts.setHorizontalAlignment(SwingConstants.RIGHT);
		tfEntitlementCosts.setColumns(10);
		GridBagConstraints gbc_tfEntitlementCosts = new GridBagConstraints();
		gbc_tfEntitlementCosts.anchor = GridBagConstraints.EAST;
		gbc_tfEntitlementCosts.insets = new Insets(0, 0, 5, 5);
		gbc_tfEntitlementCosts.gridx = 2;
		gbc_tfEntitlementCosts.gridy = 1;
		preDevCostPanel.add(tfEntitlementCosts, gbc_tfEntitlementCosts);
		
		JLabel lblLegalTitleIns = new JLabel("Legal, Title, Ins., & Misc. Expense ");
		lblLegalTitleIns.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLegalTitleIns = new GridBagConstraints();
		gbc_lblLegalTitleIns.anchor = GridBagConstraints.WEST;
		gbc_lblLegalTitleIns.insets = new Insets(0, 0, 5, 5);
		gbc_lblLegalTitleIns.gridx = 1;
		gbc_lblLegalTitleIns.gridy = 2;
		preDevCostPanel.add(lblLegalTitleIns, gbc_lblLegalTitleIns);
		
		tfLegalTitleIns = new MoneyField();
		tfLegalTitleIns.addPropertyChangeListener("value", this);
		
		tfLegalTitleIns.setHorizontalAlignment(SwingConstants.RIGHT);
		tfLegalTitleIns.setColumns(10);
		GridBagConstraints gbc_tfLegalTitleIns = new GridBagConstraints();
		gbc_tfLegalTitleIns.insets = new Insets(0, 0, 5, 5);
		gbc_tfLegalTitleIns.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfLegalTitleIns.gridx = 2;
		gbc_tfLegalTitleIns.gridy = 2;
		preDevCostPanel.add(tfLegalTitleIns, gbc_tfLegalTitleIns);
		
		JLabel lblPreconstructionServices = new JLabel("Preconstruction Services");
		lblPreconstructionServices.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPreconstructionServices = new GridBagConstraints();
		gbc_lblPreconstructionServices.anchor = GridBagConstraints.WEST;
		gbc_lblPreconstructionServices.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreconstructionServices.gridx = 1;
		gbc_lblPreconstructionServices.gridy = 3;
		preDevCostPanel.add(lblPreconstructionServices, gbc_lblPreconstructionServices);
		
		tfPreconstructionServices = new MoneyField();
		tfPreconstructionServices.addPropertyChangeListener("value", this);
		
		tfPreconstructionServices.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPreconstructionServices.setColumns(10);
		GridBagConstraints gbc_tfPreconstructionServices = new GridBagConstraints();
		gbc_tfPreconstructionServices.insets = new Insets(0, 0, 5, 5);
		gbc_tfPreconstructionServices.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPreconstructionServices.gridx = 2;
		gbc_tfPreconstructionServices.gridy = 3;
		preDevCostPanel.add(tfPreconstructionServices, gbc_tfPreconstructionServices);
		
		JLabel lblContingencyPD = new JLabel("Contingency");
		lblContingencyPD.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblContingencyPD = new GridBagConstraints();
		gbc_lblContingencyPD.anchor = GridBagConstraints.WEST;
		gbc_lblContingencyPD.insets = new Insets(0, 0, 0, 5);
		gbc_lblContingencyPD.gridx = 1;
		gbc_lblContingencyPD.gridy = 4;
		preDevCostPanel.add(lblContingencyPD, gbc_lblContingencyPD);
		
		spContingencyPD = new PercentSpinner();
		GridBagConstraints gbc_spContingencyPD = new GridBagConstraints();
		gbc_spContingencyPD.anchor = GridBagConstraints.EAST;
		gbc_spContingencyPD.insets = new Insets(0, 0, 0, 5);
		gbc_spContingencyPD.gridx = 2;
		gbc_spContingencyPD.gridy = 4;
		preDevCostPanel.add(spContingencyPD, gbc_spContingencyPD);
		
		JLabel lbl2ContingencyPD = new JLabel("of Pre-Dev");
		lbl2ContingencyPD.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2ContingencyPD = new GridBagConstraints();
		gbc_lbl2ContingencyPD.insets = new Insets(0, 0, 0, 5);
		gbc_lbl2ContingencyPD.gridx = 3;
		gbc_lbl2ContingencyPD.gridy = 4;
		preDevCostPanel.add(lbl2ContingencyPD, gbc_lbl2ContingencyPD);
		
		JPanel dirDevTab = new JPanel();
		tabbedPane.addTab("Direct Development", null, dirDevTab, null);
		
		JPanel dirDevPanel = new JPanel();
		dirDevPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Direct Development Costs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dirDevTab.add(dirDevPanel);
		GridBagLayout gbl_dirDevPanel = new GridBagLayout();
		gbl_dirDevPanel.columnWidths = new int[] {30, 0, 30, 30, 30};
		gbl_dirDevPanel.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_dirDevPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		gbl_dirDevPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		dirDevPanel.setLayout(gbl_dirDevPanel);
		
		JLabel lblArchitectureDesignDD = new JLabel("Architecture, Design & Engineering");
		lblArchitectureDesignDD.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblArchitectureDesignDD = new GridBagConstraints();
		gbc_lblArchitectureDesignDD.anchor = GridBagConstraints.WEST;
		gbc_lblArchitectureDesignDD.insets = new Insets(0, 0, 5, 5);
		gbc_lblArchitectureDesignDD.gridx = 1;
		gbc_lblArchitectureDesignDD.gridy = 0;
		dirDevPanel.add(lblArchitectureDesignDD, gbc_lblArchitectureDesignDD);
		
		spArchitectureDesignDD = new PercentSpinner();
		GridBagConstraints gbc_spArchitectureDesignDD = new GridBagConstraints();
		gbc_spArchitectureDesignDD.anchor = GridBagConstraints.EAST;
		gbc_spArchitectureDesignDD.insets = new Insets(0, 0, 5, 5);
		gbc_spArchitectureDesignDD.gridx = 2;
		gbc_spArchitectureDesignDD.gridy = 0;
		dirDevPanel.add(spArchitectureDesignDD, gbc_spArchitectureDesignDD);
		
		JLabel lbl2ArchitectureDesignDD = new JLabel("of Directs");
		lbl2ArchitectureDesignDD.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2ArchitectureDesignDD = new GridBagConstraints();
		gbc_lbl2ArchitectureDesignDD.anchor = GridBagConstraints.WEST;
		gbc_lbl2ArchitectureDesignDD.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2ArchitectureDesignDD.gridx = 3;
		gbc_lbl2ArchitectureDesignDD.gridy = 0;
		dirDevPanel.add(lbl2ArchitectureDesignDD, gbc_lbl2ArchitectureDesignDD);
		
		JLabel lblFeesAndPermits = new JLabel("Fees and Permits");
		lblFeesAndPermits.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFeesAndPermits = new GridBagConstraints();
		gbc_lblFeesAndPermits.anchor = GridBagConstraints.WEST;
		gbc_lblFeesAndPermits.insets = new Insets(0, 0, 5, 5);
		gbc_lblFeesAndPermits.gridx = 1;
		gbc_lblFeesAndPermits.gridy = 1;
		dirDevPanel.add(lblFeesAndPermits, gbc_lblFeesAndPermits);
		
		spFeesAndPermits = new PercentSpinner();
		GridBagConstraints gbc_spFeesAndPermits = new GridBagConstraints();
		gbc_spFeesAndPermits.anchor = GridBagConstraints.EAST;
		gbc_spFeesAndPermits.insets = new Insets(0, 0, 5, 5);
		gbc_spFeesAndPermits.gridx = 2;
		gbc_spFeesAndPermits.gridy = 1;
		dirDevPanel.add(spFeesAndPermits, gbc_spFeesAndPermits);
		
		JLabel lbl2FeesAndPermits = new JLabel("of Directs");
		lbl2FeesAndPermits.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2FeesAndPermits = new GridBagConstraints();
		gbc_lbl2FeesAndPermits.anchor = GridBagConstraints.WEST;
		gbc_lbl2FeesAndPermits.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2FeesAndPermits.gridx = 3;
		gbc_lbl2FeesAndPermits.gridy = 1;
		dirDevPanel.add(lbl2FeesAndPermits, gbc_lbl2FeesAndPermits);
		
		JLabel lblDirConstructionHotel = new JLabel("Direct Construction (Hotel)");
		lblDirConstructionHotel.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDirConstructionHotel = new GridBagConstraints();
		gbc_lblDirConstructionHotel.anchor = GridBagConstraints.WEST;
		gbc_lblDirConstructionHotel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirConstructionHotel.gridx = 1;
		gbc_lblDirConstructionHotel.gridy = 2;
		dirDevPanel.add(lblDirConstructionHotel, gbc_lblDirConstructionHotel);
		
		tfDirConstructionHotel = new MoneyField();
		tfDirConstructionHotel.addPropertyChangeListener("value", this);
		
		tfDirConstructionHotel.setHorizontalAlignment(SwingConstants.RIGHT);
		tfDirConstructionHotel.setColumns(10);
		GridBagConstraints gbc_tfDirConstructionHotel = new GridBagConstraints();
		gbc_tfDirConstructionHotel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDirConstructionHotel.insets = new Insets(0, 0, 5, 5);
		gbc_tfDirConstructionHotel.gridx = 2;
		gbc_tfDirConstructionHotel.gridy = 2;
		dirDevPanel.add(tfDirConstructionHotel, gbc_tfDirConstructionHotel);
		
		JLabel lbl2DirConstructionHotel = new JLabel("per Room");
		lbl2DirConstructionHotel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2DirConstructionHotel = new GridBagConstraints();
		gbc_lbl2DirConstructionHotel.anchor = GridBagConstraints.WEST;
		gbc_lbl2DirConstructionHotel.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2DirConstructionHotel.gridx = 3;
		gbc_lbl2DirConstructionHotel.gridy = 2;
		dirDevPanel.add(lbl2DirConstructionHotel, gbc_lbl2DirConstructionHotel);
		
		JLabel lblDirConstructionTimeshare = new JLabel("Direct Construction (Timeshare)");
		lblDirConstructionTimeshare.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDirConstructionTimeshare = new GridBagConstraints();
		gbc_lblDirConstructionTimeshare.anchor = GridBagConstraints.WEST;
		gbc_lblDirConstructionTimeshare.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirConstructionTimeshare.gridx = 1;
		gbc_lblDirConstructionTimeshare.gridy = 3;
		dirDevPanel.add(lblDirConstructionTimeshare, gbc_lblDirConstructionTimeshare);
		
		tfDirectConstructionTimeshare = new MoneyField();
		tfDirectConstructionTimeshare.addPropertyChangeListener("value", this);
		
		tfDirectConstructionTimeshare.setHorizontalAlignment(SwingConstants.RIGHT);
		tfDirectConstructionTimeshare.setColumns(10);
		GridBagConstraints gbc_tfDirectConstructionTimeshare = new GridBagConstraints();
		gbc_tfDirectConstructionTimeshare.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDirectConstructionTimeshare.insets = new Insets(0, 0, 5, 5);
		gbc_tfDirectConstructionTimeshare.gridx = 2;
		gbc_tfDirectConstructionTimeshare.gridy = 3;
		dirDevPanel.add(tfDirectConstructionTimeshare, gbc_tfDirectConstructionTimeshare);
		
		JLabel lbl2DirConstructionTimeshare = new JLabel("per Timeshare");
		lbl2DirConstructionTimeshare.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2DirConstructionTimeshare = new GridBagConstraints();
		gbc_lbl2DirConstructionTimeshare.anchor = GridBagConstraints.WEST;
		gbc_lbl2DirConstructionTimeshare.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2DirConstructionTimeshare.gridx = 3;
		gbc_lbl2DirConstructionTimeshare.gridy = 3;
		dirDevPanel.add(lbl2DirConstructionTimeshare, gbc_lbl2DirConstructionTimeshare);
		
		JLabel lblDirConstructionRetail = new JLabel("Direct Construction (Retail)");
		lblDirConstructionRetail.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDirConstructionRetail = new GridBagConstraints();
		gbc_lblDirConstructionRetail.anchor = GridBagConstraints.WEST;
		gbc_lblDirConstructionRetail.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirConstructionRetail.gridx = 1;
		gbc_lblDirConstructionRetail.gridy = 4;
		dirDevPanel.add(lblDirConstructionRetail, gbc_lblDirConstructionRetail);
		
		tfDirConstructionRetail = new MoneyField();
		tfDirConstructionRetail.addPropertyChangeListener("value", this);
		
		tfDirConstructionRetail.setHorizontalAlignment(SwingConstants.RIGHT);
		tfDirConstructionRetail.setColumns(10);
		GridBagConstraints gbc_tfDirConstructionRetail = new GridBagConstraints();
		gbc_tfDirConstructionRetail.insets = new Insets(0, 0, 5, 5);
		gbc_tfDirConstructionRetail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDirConstructionRetail.gridx = 2;
		gbc_tfDirConstructionRetail.gridy = 4;
		dirDevPanel.add(tfDirConstructionRetail, gbc_tfDirConstructionRetail);
		
		JLabel lbl2DirConstructionRetail = new JLabel("per sq ft.");
		lbl2DirConstructionRetail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2DirConstructionRetail = new GridBagConstraints();
		gbc_lbl2DirConstructionRetail.anchor = GridBagConstraints.WEST;
		gbc_lbl2DirConstructionRetail.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2DirConstructionRetail.gridx = 3;
		gbc_lbl2DirConstructionRetail.gridy = 4;
		dirDevPanel.add(lbl2DirConstructionRetail, gbc_lbl2DirConstructionRetail);
		
		JLabel lblOffsiteUpgrades = new JLabel("Offsite Upgrades");
		lblOffsiteUpgrades.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblOffsiteUpgrades = new GridBagConstraints();
		gbc_lblOffsiteUpgrades.anchor = GridBagConstraints.WEST;
		gbc_lblOffsiteUpgrades.insets = new Insets(0, 0, 5, 5);
		gbc_lblOffsiteUpgrades.gridx = 1;
		gbc_lblOffsiteUpgrades.gridy = 5;
		dirDevPanel.add(lblOffsiteUpgrades, gbc_lblOffsiteUpgrades);
		
		tfOffsiteUpgrades = new MoneyField();
		tfOffsiteUpgrades.addPropertyChangeListener("value", this);
		
		tfOffsiteUpgrades.setHorizontalAlignment(SwingConstants.RIGHT);
		tfOffsiteUpgrades.setColumns(10);
		GridBagConstraints gbc_tfOffsiteUpgrades = new GridBagConstraints();
		gbc_tfOffsiteUpgrades.insets = new Insets(0, 0, 5, 5);
		gbc_tfOffsiteUpgrades.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfOffsiteUpgrades.gridx = 2;
		gbc_tfOffsiteUpgrades.gridy = 5;
		dirDevPanel.add(tfOffsiteUpgrades, gbc_tfOffsiteUpgrades);
		
		JLabel lblCommonArea = new JLabel("Common Area FF&E & OSE ");
		lblCommonArea.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCommonArea = new GridBagConstraints();
		gbc_lblCommonArea.anchor = GridBagConstraints.WEST;
		gbc_lblCommonArea.insets = new Insets(0, 0, 5, 5);
		gbc_lblCommonArea.gridx = 1;
		gbc_lblCommonArea.gridy = 6;
		dirDevPanel.add(lblCommonArea, gbc_lblCommonArea);
		
		tfCommonArea = new MoneyField();
		tfCommonArea.addPropertyChangeListener("value", this);
		
		tfCommonArea.setHorizontalAlignment(SwingConstants.RIGHT);
		tfCommonArea.setColumns(10);
		GridBagConstraints gbc_tfCommonArea = new GridBagConstraints();
		gbc_tfCommonArea.insets = new Insets(0, 0, 5, 5);
		gbc_tfCommonArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCommonArea.gridx = 2;
		gbc_tfCommonArea.gridy = 6;
		dirDevPanel.add(tfCommonArea, gbc_tfCommonArea);
		
		JLabel lbl2CommonArea = new JLabel("per key");
		lbl2CommonArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2CommonArea = new GridBagConstraints();
		gbc_lbl2CommonArea.anchor = GridBagConstraints.WEST;
		gbc_lbl2CommonArea.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2CommonArea.gridx = 3;
		gbc_lbl2CommonArea.gridy = 6;
		dirDevPanel.add(lbl2CommonArea, gbc_lbl2CommonArea);
		
		JLabel lblMaintenance = new JLabel("Maintenance/Hotel Repairs");
		lblMaintenance.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMaintenance = new GridBagConstraints();
		gbc_lblMaintenance.anchor = GridBagConstraints.WEST;
		gbc_lblMaintenance.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaintenance.gridx = 1;
		gbc_lblMaintenance.gridy = 7;
		dirDevPanel.add(lblMaintenance, gbc_lblMaintenance);
		
		tfMaintenanceRepairs = new MoneyField();
		tfMaintenanceRepairs.addPropertyChangeListener("value", this);
		
		tfMaintenanceRepairs.setHorizontalAlignment(SwingConstants.RIGHT);
		tfMaintenanceRepairs.setColumns(10);
		GridBagConstraints gbc_tfMaintenanceRepairs = new GridBagConstraints();
		gbc_tfMaintenanceRepairs.insets = new Insets(0, 0, 5, 5);
		gbc_tfMaintenanceRepairs.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMaintenanceRepairs.gridx = 2;
		gbc_tfMaintenanceRepairs.gridy = 7;
		dirDevPanel.add(tfMaintenanceRepairs, gbc_tfMaintenanceRepairs);
		
		JLabel lblTestingInspection = new JLabel("Testing & Inspection");
		lblTestingInspection.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTestingInspection = new GridBagConstraints();
		gbc_lblTestingInspection.anchor = GridBagConstraints.WEST;
		gbc_lblTestingInspection.insets = new Insets(0, 0, 5, 5);
		gbc_lblTestingInspection.gridx = 1;
		gbc_lblTestingInspection.gridy = 8;
		dirDevPanel.add(lblTestingInspection, gbc_lblTestingInspection);
		
		spTestingInspection = new PercentSpinner();
		GridBagConstraints gbc_spTestingInspection = new GridBagConstraints();
		gbc_spTestingInspection.anchor = GridBagConstraints.EAST;
		gbc_spTestingInspection.insets = new Insets(0, 0, 5, 5);
		gbc_spTestingInspection.gridx = 2;
		gbc_spTestingInspection.gridy = 8;
		dirDevPanel.add(spTestingInspection, gbc_spTestingInspection);
		
		JLabel lbl2TestingInspection = new JLabel("of Directs");
		lbl2TestingInspection.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2TestingInspection = new GridBagConstraints();
		gbc_lbl2TestingInspection.anchor = GridBagConstraints.WEST;
		gbc_lbl2TestingInspection.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2TestingInspection.gridx = 3;
		gbc_lbl2TestingInspection.gridy = 8;
		dirDevPanel.add(lbl2TestingInspection, gbc_lbl2TestingInspection);
		
		JLabel lblContingencyDD = new JLabel("Contingency");
		lblContingencyDD.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblContingencyDD = new GridBagConstraints();
		gbc_lblContingencyDD.anchor = GridBagConstraints.WEST;
		gbc_lblContingencyDD.insets = new Insets(0, 0, 0, 5);
		gbc_lblContingencyDD.gridx = 1;
		gbc_lblContingencyDD.gridy = 9;
		dirDevPanel.add(lblContingencyDD, gbc_lblContingencyDD);
		
		spContingencyDD = new PercentSpinner();
		GridBagConstraints gbc_spContingencyDD = new GridBagConstraints();
		gbc_spContingencyDD.anchor = GridBagConstraints.EAST;
		gbc_spContingencyDD.insets = new Insets(0, 0, 0, 5);
		gbc_spContingencyDD.gridx = 2;
		gbc_spContingencyDD.gridy = 9;
		dirDevPanel.add(spContingencyDD, gbc_spContingencyDD);
		
		JScrollPane indirDevScrollTab = new JScrollPane();
		tabbedPane.addTab("Indirect Development", null, indirDevScrollTab, null);
		
		JPanel indirDevContentPanel = new JPanel();
		indirDevScrollTab.setViewportView(indirDevContentPanel);
		
		JPanel indirDevPanel = new JPanel();
		indirDevPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Indirect Development Costs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		indirDevContentPanel.add(indirDevPanel);
		GridBagLayout gbl_indirDevPanel = new GridBagLayout();
		gbl_indirDevPanel.columnWidths = new int[] {30, 0, 30, 0, 30};
		gbl_indirDevPanel.rowHeights = new int[] {30, 30, 30, 0, 0, 30, 30, 30, 30, 30, 30, 30};
		gbl_indirDevPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0};
		gbl_indirDevPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 4.9E-324, 0.0, 0.0, 0.0, 0.0};
		indirDevPanel.setLayout(gbl_indirDevPanel);
		
		JLabel lblSalesMarketing = new JLabel("Sales, Marketing & Models");
		lblSalesMarketing.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSalesMarketing = new GridBagConstraints();
		gbc_lblSalesMarketing.anchor = GridBagConstraints.WEST;
		gbc_lblSalesMarketing.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalesMarketing.gridx = 1;
		gbc_lblSalesMarketing.gridy = 0;
		indirDevPanel.add(lblSalesMarketing, gbc_lblSalesMarketing);
		
		tfSalesMarketing = new MoneyField();
		tfSalesMarketing.addPropertyChangeListener("value", this);
		
		tfSalesMarketing.setHorizontalAlignment(SwingConstants.RIGHT);
		tfSalesMarketing.setColumns(10);
		GridBagConstraints gbc_tfSalesMarketing = new GridBagConstraints();
		gbc_tfSalesMarketing.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSalesMarketing.insets = new Insets(0, 0, 5, 5);
		gbc_tfSalesMarketing.gridx = 2;
		gbc_tfSalesMarketing.gridy = 0;
		indirDevPanel.add(tfSalesMarketing, gbc_tfSalesMarketing);
		
		JLabel lblConstructionManagement = new JLabel("Construction Management");
		lblConstructionManagement.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConstructionManagement = new GridBagConstraints();
		gbc_lblConstructionManagement.anchor = GridBagConstraints.WEST;
		gbc_lblConstructionManagement.insets = new Insets(0, 0, 5, 5);
		gbc_lblConstructionManagement.gridx = 1;
		gbc_lblConstructionManagement.gridy = 1;
		indirDevPanel.add(lblConstructionManagement, gbc_lblConstructionManagement);
		
		tfConstructionManagent = new MoneyField();
		tfConstructionManagent.addPropertyChangeListener("value", this);
		
		tfConstructionManagent.setHorizontalAlignment(SwingConstants.RIGHT);
		tfConstructionManagent.setColumns(10);
		GridBagConstraints gbc_tfConstructionManageent = new GridBagConstraints();
		gbc_tfConstructionManageent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfConstructionManageent.insets = new Insets(0, 0, 5, 5);
		gbc_tfConstructionManageent.gridx = 2;
		gbc_tfConstructionManageent.gridy = 1;
		indirDevPanel.add(tfConstructionManagent, gbc_tfConstructionManageent);
		
		JLabel lbl2ConstructionManagement = new JLabel("per Room");
		lbl2ConstructionManagement.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2ConstructionManagement = new GridBagConstraints();
		gbc_lbl2ConstructionManagement.anchor = GridBagConstraints.WEST;
		gbc_lbl2ConstructionManagement.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2ConstructionManagement.gridx = 3;
		gbc_lbl2ConstructionManagement.gridy = 1;
		indirDevPanel.add(lbl2ConstructionManagement, gbc_lbl2ConstructionManagement);
		
		JPanel propTaxSubpanel = new JPanel();
		propTaxSubpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Property Taxes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_propTaxSubpanel = new GridBagConstraints();
		gbc_propTaxSubpanel.gridwidth = 5;
		gbc_propTaxSubpanel.insets = new Insets(0, 0, 5, 0);
		gbc_propTaxSubpanel.fill = GridBagConstraints.BOTH;
		gbc_propTaxSubpanel.gridx = 0;
		gbc_propTaxSubpanel.gridy = 2;
		indirDevPanel.add(propTaxSubpanel, gbc_propTaxSubpanel);
		GridBagLayout gbl_propTaxSubpanel = new GridBagLayout();
		gbl_propTaxSubpanel.columnWidths = new int[] {30, 130, 145, 0, 30};
		gbl_propTaxSubpanel.rowHeights = new int[] {30, 30};
		gbl_propTaxSubpanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_propTaxSubpanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		propTaxSubpanel.setLayout(gbl_propTaxSubpanel);
		
		JLabel lblPropertyTaxes = new JLabel("Property Taxes");
		GridBagConstraints gbc_lblPropertyTaxes = new GridBagConstraints();
		gbc_lblPropertyTaxes.insets = new Insets(0, 0, 5, 5);
		gbc_lblPropertyTaxes.anchor = GridBagConstraints.WEST;
		gbc_lblPropertyTaxes.gridx = 1;
		gbc_lblPropertyTaxes.gridy = 0;
		propTaxSubpanel.add(lblPropertyTaxes, gbc_lblPropertyTaxes);
		lblPropertyTaxes.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		spPropertTaxes = new PercentSpinner();
		GridBagConstraints gbc_spPropertTaxes = new GridBagConstraints();
		gbc_spPropertTaxes.insets = new Insets(0, 0, 5, 5);
		gbc_spPropertTaxes.anchor = GridBagConstraints.EAST;
		gbc_spPropertTaxes.gridx = 2;
		gbc_spPropertTaxes.gridy = 0;
		propTaxSubpanel.add(spPropertTaxes, gbc_spPropertTaxes);
		
		JLabel lblAssessedValue = new JLabel("Assessed Value");
		lblAssessedValue.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAssessedValue = new GridBagConstraints();
		gbc_lblAssessedValue.anchor = GridBagConstraints.WEST;
		gbc_lblAssessedValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssessedValue.gridx = 1;
		gbc_lblAssessedValue.gridy = 1;
		propTaxSubpanel.add(lblAssessedValue, gbc_lblAssessedValue);
		
		tfAssessedValue = new MoneyField();
		tfAssessedValue.addPropertyChangeListener("value", this);
		
		tfAssessedValue.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_tfAssessedValue = new GridBagConstraints();
		gbc_tfAssessedValue.anchor = GridBagConstraints.EAST;
		gbc_tfAssessedValue.insets = new Insets(0, 0, 5, 5);
		gbc_tfAssessedValue.gridx = 2;
		gbc_tfAssessedValue.gridy = 1;
		propTaxSubpanel.add(tfAssessedValue, gbc_tfAssessedValue);
		tfAssessedValue.setColumns(11);
		
		JPanel insuranceSubpanel = new JPanel();
		insuranceSubpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Insurance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_insuranceSubpanel = new GridBagConstraints();
		gbc_insuranceSubpanel.gridwidth = 5;
		gbc_insuranceSubpanel.insets = new Insets(0, 0, 5, 0);
		gbc_insuranceSubpanel.fill = GridBagConstraints.BOTH;
		gbc_insuranceSubpanel.gridx = 0;
		gbc_insuranceSubpanel.gridy = 3;
		indirDevPanel.add(insuranceSubpanel, gbc_insuranceSubpanel);
		GridBagLayout gbl_insuranceSubpanel = new GridBagLayout();
		gbl_insuranceSubpanel.columnWidths = new int[] {30, 130, 145, 30, 30};
		gbl_insuranceSubpanel.rowHeights = new int[] {30, 30};
		gbl_insuranceSubpanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_insuranceSubpanel.rowWeights = new double[]{0.0, 4.9E-324};
		insuranceSubpanel.setLayout(gbl_insuranceSubpanel);
		
		JLabel lblInsuranceRate = new JLabel("Insurance Rate");
		lblInsuranceRate.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInsuranceRate = new GridBagConstraints();
		gbc_lblInsuranceRate.anchor = GridBagConstraints.WEST;
		gbc_lblInsuranceRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsuranceRate.gridx = 1;
		gbc_lblInsuranceRate.gridy = 0;
		insuranceSubpanel.add(lblInsuranceRate, gbc_lblInsuranceRate);
		
		spInsuranceRate = new PercentSpinner();
		GridBagConstraints gbc_spInsuranceRate = new GridBagConstraints();
		gbc_spInsuranceRate.anchor = GridBagConstraints.EAST;
		gbc_spInsuranceRate.insets = new Insets(0, 0, 5, 5);
		gbc_spInsuranceRate.gridx = 2;
		gbc_spInsuranceRate.gridy = 0;
		insuranceSubpanel.add(spInsuranceRate, gbc_spInsuranceRate);
		
		JLabel lbl2InsuranceRate = new JLabel("of Directs");
		lbl2InsuranceRate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2InsuranceRate = new GridBagConstraints();
		gbc_lbl2InsuranceRate.anchor = GridBagConstraints.WEST;
		gbc_lbl2InsuranceRate.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2InsuranceRate.gridx = 3;
		gbc_lbl2InsuranceRate.gridy = 0;
		insuranceSubpanel.add(lbl2InsuranceRate, gbc_lbl2InsuranceRate);
		
		JLabel lblPredevInsurance = new JLabel("Pre-Dev Insurance");
		lblPredevInsurance.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPredevInsurance = new GridBagConstraints();
		gbc_lblPredevInsurance.anchor = GridBagConstraints.WEST;
		gbc_lblPredevInsurance.insets = new Insets(0, 0, 0, 5);
		gbc_lblPredevInsurance.gridx = 1;
		gbc_lblPredevInsurance.gridy = 1;
		insuranceSubpanel.add(lblPredevInsurance, gbc_lblPredevInsurance);
		
		tfPredevInsurance = new MoneyField();
		tfPredevInsurance.addPropertyChangeListener("value", this);
		
		tfPredevInsurance.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPredevInsurance.setColumns(11);
		GridBagConstraints gbc_tfPredevInsurance = new GridBagConstraints();
		gbc_tfPredevInsurance.anchor = GridBagConstraints.EAST;
		gbc_tfPredevInsurance.insets = new Insets(0, 0, 0, 5);
		gbc_tfPredevInsurance.gridx = 2;
		gbc_tfPredevInsurance.gridy = 1;
		insuranceSubpanel.add(tfPredevInsurance, gbc_tfPredevInsurance);
		
		JLabel lbl2PredevInsurance = new JLabel("per month");
		lbl2PredevInsurance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2PredevInsurance = new GridBagConstraints();
		gbc_lbl2PredevInsurance.anchor = GridBagConstraints.WEST;
		gbc_lbl2PredevInsurance.insets = new Insets(0, 0, 0, 5);
		gbc_lbl2PredevInsurance.gridx = 3;
		gbc_lbl2PredevInsurance.gridy = 1;
		insuranceSubpanel.add(lbl2PredevInsurance, gbc_lbl2PredevInsurance);
		
		JLabel lblDreHoaMaintenance = new JLabel("DRE / HOA Maintenance");
		lblDreHoaMaintenance.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDreHoaMaintenance = new GridBagConstraints();
		gbc_lblDreHoaMaintenance.anchor = GridBagConstraints.WEST;
		gbc_lblDreHoaMaintenance.insets = new Insets(0, 0, 5, 5);
		gbc_lblDreHoaMaintenance.gridx = 1;
		gbc_lblDreHoaMaintenance.gridy = 4;
		indirDevPanel.add(lblDreHoaMaintenance, gbc_lblDreHoaMaintenance);
		
		tfDreHoaMaintenance = new MoneyField();
		tfDreHoaMaintenance.addPropertyChangeListener("value", this);
		
		tfDreHoaMaintenance.setHorizontalAlignment(SwingConstants.RIGHT);
		tfDreHoaMaintenance.setColumns(10);
		GridBagConstraints gbc_tfDreHoaMaintenance = new GridBagConstraints();
		gbc_tfDreHoaMaintenance.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDreHoaMaintenance.insets = new Insets(0, 0, 5, 5);
		gbc_tfDreHoaMaintenance.gridx = 2;
		gbc_tfDreHoaMaintenance.gridy = 4;
		indirDevPanel.add(tfDreHoaMaintenance, gbc_tfDreHoaMaintenance);
		
		JLabel lbl2DreHoaMaintenance = new JLabel("per sq ft.");
		lbl2DreHoaMaintenance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2DreHoaMaintenance = new GridBagConstraints();
		gbc_lbl2DreHoaMaintenance.anchor = GridBagConstraints.WEST;
		gbc_lbl2DreHoaMaintenance.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2DreHoaMaintenance.gridx = 3;
		gbc_lbl2DreHoaMaintenance.gridy = 4;
		indirDevPanel.add(lbl2DreHoaMaintenance, gbc_lbl2DreHoaMaintenance);
		
		JLabel lblDevelopmentFee = new JLabel("Development Fee");
		lblDevelopmentFee.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDevelopmentFee = new GridBagConstraints();
		gbc_lblDevelopmentFee.anchor = GridBagConstraints.WEST;
		gbc_lblDevelopmentFee.insets = new Insets(0, 0, 5, 5);
		gbc_lblDevelopmentFee.gridx = 1;
		gbc_lblDevelopmentFee.gridy = 5;
		indirDevPanel.add(lblDevelopmentFee, gbc_lblDevelopmentFee);
		
		tfDevelopmentFee = new MoneyField();
		tfDevelopmentFee.addPropertyChangeListener("value", this);
		
		tfDevelopmentFee.setHorizontalAlignment(SwingConstants.RIGHT);
		tfDevelopmentFee.setColumns(10);
		GridBagConstraints gbc_tfDevelopmentFee = new GridBagConstraints();
		gbc_tfDevelopmentFee.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDevelopmentFee.insets = new Insets(0, 0, 5, 5);
		gbc_tfDevelopmentFee.gridx = 2;
		gbc_tfDevelopmentFee.gridy = 5;
		indirDevPanel.add(tfDevelopmentFee, gbc_tfDevelopmentFee);
		
		JLabel lbl2DevelopmentFee = new JLabel("per month");
		lbl2DevelopmentFee.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2DevelopmentFee = new GridBagConstraints();
		gbc_lbl2DevelopmentFee.anchor = GridBagConstraints.WEST;
		gbc_lbl2DevelopmentFee.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2DevelopmentFee.gridx = 3;
		gbc_lbl2DevelopmentFee.gridy = 5;
		indirDevPanel.add(lbl2DevelopmentFee, gbc_lbl2DevelopmentFee);
		
		JLabel lblLegalExpense = new JLabel("Legal Expense");
		lblLegalExpense.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLegalExpense = new GridBagConstraints();
		gbc_lblLegalExpense.anchor = GridBagConstraints.WEST;
		gbc_lblLegalExpense.insets = new Insets(0, 0, 5, 5);
		gbc_lblLegalExpense.gridx = 1;
		gbc_lblLegalExpense.gridy = 6;
		indirDevPanel.add(lblLegalExpense, gbc_lblLegalExpense);
		
		tfLegalExpense = new MoneyField();
		tfLegalExpense.addPropertyChangeListener("value", this);
		
		tfLegalExpense.setHorizontalAlignment(SwingConstants.RIGHT);
		tfLegalExpense.setColumns(10);
		GridBagConstraints gbc_tfLegalExpense = new GridBagConstraints();
		gbc_tfLegalExpense.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfLegalExpense.insets = new Insets(0, 0, 5, 5);
		gbc_tfLegalExpense.gridx = 2;
		gbc_tfLegalExpense.gridy = 6;
		indirDevPanel.add(tfLegalExpense, gbc_tfLegalExpense);
		
		JLabel lblMiscExpReimbursements = new JLabel("Misc. Exp. Reimbursements");
		lblMiscExpReimbursements.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMiscExpReimbursements = new GridBagConstraints();
		gbc_lblMiscExpReimbursements.anchor = GridBagConstraints.EAST;
		gbc_lblMiscExpReimbursements.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiscExpReimbursements.gridx = 1;
		gbc_lblMiscExpReimbursements.gridy = 7;
		indirDevPanel.add(lblMiscExpReimbursements, gbc_lblMiscExpReimbursements);
		
		tfMiscExpReimbursements = new MoneyField();
		tfMiscExpReimbursements.addPropertyChangeListener("value", this);
		
		tfMiscExpReimbursements.setHorizontalAlignment(SwingConstants.RIGHT);
		tfMiscExpReimbursements.setColumns(10);
		GridBagConstraints gbc_tfMiscExpReimbursements = new GridBagConstraints();
		gbc_tfMiscExpReimbursements.insets = new Insets(0, 0, 5, 5);
		gbc_tfMiscExpReimbursements.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMiscExpReimbursements.gridx = 2;
		gbc_tfMiscExpReimbursements.gridy = 7;
		indirDevPanel.add(tfMiscExpReimbursements, gbc_tfMiscExpReimbursements);
		
		JLabel lblLeaseholdPayments = new JLabel("Leasehold Payments");
		lblLeaseholdPayments.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLeaseholdPayments = new GridBagConstraints();
		gbc_lblLeaseholdPayments.anchor = GridBagConstraints.WEST;
		gbc_lblLeaseholdPayments.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeaseholdPayments.gridx = 1;
		gbc_lblLeaseholdPayments.gridy = 8;
		indirDevPanel.add(lblLeaseholdPayments, gbc_lblLeaseholdPayments);
		
		tfLeaseholdPayments = new MoneyField();
		tfLeaseholdPayments.addPropertyChangeListener("value", this);
		
		tfLeaseholdPayments.setHorizontalAlignment(SwingConstants.RIGHT);
		tfLeaseholdPayments.setColumns(10);
		GridBagConstraints gbc_tfLeaseholdPayments = new GridBagConstraints();
		gbc_tfLeaseholdPayments.insets = new Insets(0, 0, 5, 5);
		gbc_tfLeaseholdPayments.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfLeaseholdPayments.gridx = 2;
		gbc_tfLeaseholdPayments.gridy = 8;
		indirDevPanel.add(tfLeaseholdPayments, gbc_tfLeaseholdPayments);
		
		JLabel lbl2LeaseholdPayments = new JLabel("per month");
		lbl2LeaseholdPayments.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2LeaseholdPayments = new GridBagConstraints();
		gbc_lbl2LeaseholdPayments.anchor = GridBagConstraints.WEST;
		gbc_lbl2LeaseholdPayments.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2LeaseholdPayments.gridx = 3;
		gbc_lbl2LeaseholdPayments.gridy = 8;
		indirDevPanel.add(lbl2LeaseholdPayments, gbc_lbl2LeaseholdPayments);
		
		JLabel lblInterestConstLoan = new JLabel("Interest - Construction Loan");
		lblInterestConstLoan.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInterestConstLoan = new GridBagConstraints();
		gbc_lblInterestConstLoan.anchor = GridBagConstraints.EAST;
		gbc_lblInterestConstLoan.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterestConstLoan.gridx = 1;
		gbc_lblInterestConstLoan.gridy = 9;
		indirDevPanel.add(lblInterestConstLoan, gbc_lblInterestConstLoan);
		
		tfInterestConstLoan = new MoneyField();
		tfInterestConstLoan.setEditable(false);
		tfInterestConstLoan.setHorizontalAlignment(SwingConstants.RIGHT);
		tfInterestConstLoan.setColumns(10);
		GridBagConstraints gbc_tfInterestConstLoan = new GridBagConstraints();
		gbc_tfInterestConstLoan.insets = new Insets(0, 0, 5, 5);
		gbc_tfInterestConstLoan.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfInterestConstLoan.gridx = 2;
		gbc_tfInterestConstLoan.gridy = 9;
		indirDevPanel.add(tfInterestConstLoan, gbc_tfInterestConstLoan);
		
		JLabel lblOriginationFee = new JLabel("Origination Fee");
		lblOriginationFee.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblOriginationFee = new GridBagConstraints();
		gbc_lblOriginationFee.anchor = GridBagConstraints.WEST;
		gbc_lblOriginationFee.insets = new Insets(0, 0, 5, 5);
		gbc_lblOriginationFee.gridx = 1;
		gbc_lblOriginationFee.gridy = 10;
		indirDevPanel.add(lblOriginationFee, gbc_lblOriginationFee);
		
		spOriginationFee = new PercentSpinner();
		GridBagConstraints gbc_spOriginationFee = new GridBagConstraints();
		gbc_spOriginationFee.anchor = GridBagConstraints.EAST;
		gbc_spOriginationFee.insets = new Insets(0, 0, 5, 5);
		gbc_spOriginationFee.gridx = 2;
		gbc_spOriginationFee.gridy = 10;
		indirDevPanel.add(spOriginationFee, gbc_spOriginationFee);
		
		JLabel lblContingencyID = new JLabel("Contingency");
		lblContingencyID.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblContingencyID = new GridBagConstraints();
		gbc_lblContingencyID.anchor = GridBagConstraints.WEST;
		gbc_lblContingencyID.insets = new Insets(0, 0, 5, 5);
		gbc_lblContingencyID.gridx = 1;
		gbc_lblContingencyID.gridy = 11;
		indirDevPanel.add(lblContingencyID, gbc_lblContingencyID);
		
		spContingencyID = new PercentSpinner();
		GridBagConstraints gbc_spContingencyID = new GridBagConstraints();
		gbc_spContingencyID.anchor = GridBagConstraints.EAST;
		gbc_spContingencyID.insets = new Insets(0, 0, 5, 5);
		gbc_spContingencyID.gridx = 2;
		gbc_spContingencyID.gridy = 11;
		indirDevPanel.add(spContingencyID, gbc_spContingencyID);
		
		JLabel lbl2ContingencyID = new JLabel("per month");
		lbl2ContingencyID.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lbl2ContingencyID = new GridBagConstraints();
		gbc_lbl2ContingencyID.anchor = GridBagConstraints.WEST;
		gbc_lbl2ContingencyID.insets = new Insets(0, 0, 5, 5);
		gbc_lbl2ContingencyID.gridx = 3;
		gbc_lbl2ContingencyID.gridy = 11;
		indirDevPanel.add(lbl2ContingencyID, gbc_lbl2ContingencyID);

	}

	public void populate() {
		//Land Acquisitions
		tfLandAcquisition.setValue((double) controller.cost.getLandAcq());
		spCommissionAndClosing.setValue(controller.cost.getCommissionCost());
		
		//Pre-Development
		spArchitectureDesignPD.setValue(controller.cost.getArchDesignPD());
		tfEntitlementCosts.setValue((double) controller.cost.getEntitlement());
		tfLegalTitleIns.setValue((double) controller.cost.getLegalTitleIns());
		tfPreconstructionServices.setValue((double) controller.cost.getPreconstructionServ());
		spContingencyPD.setValue(controller.cost.getContingencyPD());
		
		//Direct Development
		spArchitectureDesignDD.setValue(controller.cost.getArchDesignDD());
		spFeesAndPermits.setValue(controller.cost.getFeesPermits());
		tfDirConstructionHotel.setValue((double) controller.cost.getDirConstructHotel());
		tfDirectConstructionTimeshare.setValue((double) controller.cost.getDirConstructTimeshare());
		tfDirConstructionRetail.setValue((double) controller.cost.getDirConstructRetail());
		tfOffsiteUpgrades.setValue((double) controller.cost.getOffsiteUpgrade());
		tfCommonArea.setValue((double) controller.cost.getCommonArea());
		spTestingInspection.setValue(controller.cost.getTesting());
		
		//Indirect Development
		tfSalesMarketing.setValue((double) controller.cost.getSalesMarketing());
		tfConstructionManagent.setValue((double) controller.cost.getConstructManag());
		spPropertTaxes.setValue(controller.cost.getPropTax());
		tfAssessedValue.setValue((double) controller.cost.getAssessment());
		spInsuranceRate.setValue(controller.cost.getInsuranceRate());
		tfPredevInsurance.setValue((double) controller.cost.getInsurancePreDev());
		tfDreHoaMaintenance.setValue((double) controller.cost.getDREHOA());
		tfDevelopmentFee.setValue((double) controller.cost.getDevFee());
		tfLegalExpense.setValue((double) controller.cost.getLegalExpens());
		tfMiscExpReimbursements.setValue((double) controller.cost.getMiscReimburs());
		tfLeaseholdPayments.setValue((double) controller.cost.getLeasehold());
		tfInterestConstLoan.setValue((double) controller.cost.getInterestConstLoan());
		spOriginationFee.setValue(controller.cost.getOriginationFee());
		spContingencyID.setValue(controller.cost.getContingencyID());
		
	}
	
	//Action Listeners for accepted field change
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getSource()==tfLandAcquisition){
			controller.cost.setLandAcq((double) tfLandAcquisition.getValue());
		}else if(evt.getSource()==tfEntitlementCosts){
			controller.cost.setEntitlement((double) tfEntitlementCosts.getValue());
		}else if(evt.getSource()==tfLegalTitleIns){
			controller.cost.setLegalTitleIns((double) tfLegalTitleIns.getValue());
		}else if(evt.getSource()==tfPreconstructionServices){
			controller.cost.setPreconstructionServ((double) tfPreconstructionServices.getValue());
		}else if(evt.getSource()==tfDirConstructionHotel){
			controller.cost.setDirConstructHotel((double) tfDirConstructionHotel.getValue());
		}else if(evt.getSource()==tfDirectConstructionTimeshare){
			controller.cost.setDirConstructTimeshare((double) tfDirectConstructionTimeshare.getValue());
		}else if(evt.getSource()==tfDirConstructionRetail){
			controller.cost.setDirConstructRetail((double) tfDirConstructionRetail.getValue());
		}else if(evt.getSource()==tfOffsiteUpgrades){
			controller.cost.setOffsiteUpgrade((double) tfOffsiteUpgrades.getValue());
		}else if(evt.getSource()==tfCommonArea){
			controller.cost.setCommonArea((double) tfCommonArea.getValue());
		}else if(evt.getSource()==tfSalesMarketing){
			controller.cost.setSalesMarketing((double) tfSalesMarketing.getValue());
		}else if(evt.getSource()==tfConstructionManagent){
			controller.cost.setConstructManag((double) tfConstructionManagent.getValue());
		}else if(evt.getSource()==tfDreHoaMaintenance){
			controller.cost.setDREHOA((double) tfDreHoaMaintenance.getValue());
		}else if(evt.getSource()==tfDevelopmentFee){
			controller.cost.setDevFee((double) tfDevelopmentFee.getValue());
		}else if(evt.getSource()==tfLegalExpense){
			controller.cost.setLegalExpens((double) tfLegalExpense.getValue());
		}else if(evt.getSource()==tfAssessedValue){
			controller.cost.setAssessment((double) tfAssessedValue.getValue());
		}else if(evt.getSource()==tfMiscExpReimbursements){
			controller.cost.setMiscReimburs((double) tfMiscExpReimbursements.getValue());
		}else if(evt.getSource()==tfLeaseholdPayments){
			controller.cost.setLeasehold((double) tfLeaseholdPayments.getValue());
		}else if(evt.getSource()==tfPredevInsurance){
			controller.cost.setInsurancePreDev((double) tfPredevInsurance.getValue());
		}else if(evt.getSource()==spOriginationFee){
			controller.cost.setOriginationFee((double) spOriginationFee.getValue());
		}else if(evt.getSource()==spContingencyID){
			controller.cost.setContingencyID((double) spContingencyID.getValue());
		}else if(evt.getSource()==spArchitectureDesignDD){
			controller.cost.setArchDesignDD((double) spArchitectureDesignDD.getValue());
		}else if(evt.getSource()==spContingencyPD){
			controller.cost.setContingencyPD((double) spContingencyPD.getValue());
		}else if(evt.getSource()==spArchitectureDesignPD){
			controller.cost.setArchDesignPD((double) spArchitectureDesignPD.getValue());
		}else if(evt.getSource()==spCommissionAndClosing){
			controller.cost.setCommissionCost((double) spCommissionAndClosing.getValue());
		}else if(evt.getSource()==spFeesAndPermits){
			controller.cost.setFeesPermits((double) spFeesAndPermits.getValue());
		}else if(evt.getSource()==spTestingInspection){
			controller.cost.setTesting((double) spTestingInspection.getValue());
		}else if(evt.getSource()==spInsuranceRate){
			controller.cost.setInsuranceRate((double) spInsuranceRate.getValue());
		}else if(evt.getSource()==spPropertTaxes){
			controller.cost.setPropTax((double) spPropertTaxes.getValue());
		}else if(evt.getSource()==spContingencyDD){
			controller.cost.setContingencyDD((double) spContingencyDD.getValue());
		}
	}

}
