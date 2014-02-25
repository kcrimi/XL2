package xl2app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FundingPanel extends JPanel implements PropertyChangeListener{
	ProjectController controller;
	MoneyField tfEquity1;
	MoneyField tfDebt1;
	MoneyField tfNoi1;
	MoneyField tfEquity2;
	MoneyField tfDebt2;
	MoneyField tfNoi2;
	MoneyField tfEquity3;
	MoneyField tfDebt3;
	MoneyField tfNoi3;
	JTabbedPane tabbedPane;
	PercentSpinner spInterestRate;
	PercentSpinner spLTC;

	/**
	 * Create the panel.
	 */
	public FundingPanel(ProjectController c) {
		controller = c;
		setBackground(new Color(105, 105, 105));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel loanContainerPane = new JPanel();
		loanContainerPane.setBackground(SystemColor.controlDkShadow);
		add(loanContainerPane);
		
		JPanel loanPanel = new JPanel();
		loanPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Loan Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		loanContainerPane.add(loanPanel);
		GridBagLayout gbl_loanPanel = new GridBagLayout();
		gbl_loanPanel.columnWidths = new int[] {30, 30, 30, 0, 30};
		gbl_loanPanel.rowHeights = new int[] {30, 30};
		gbl_loanPanel.columnWeights = new double[]{0.0, 4.9E-324, 0.0, 1.0, 0.0};
		gbl_loanPanel.rowWeights = new double[]{0.0, 4.9E-324};
		loanPanel.setLayout(gbl_loanPanel);
		
		JLabel lblLTC = new JLabel("LTC");
		lblLTC.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLTC = new GridBagConstraints();
		gbc_lblLTC.anchor = GridBagConstraints.WEST;
		gbc_lblLTC.insets = new Insets(0, 0, 5, 5);
		gbc_lblLTC.gridx = 1;
		gbc_lblLTC.gridy = 0;
		loanPanel.add(lblLTC, gbc_lblLTC);
		
		spLTC = new PercentSpinner();
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.anchor = GridBagConstraints.EAST;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 3;
		gbc_spinner.gridy = 0;
		loanPanel.add(spLTC, gbc_spinner);
		
		JLabel lblInterestRate = new JLabel("Interest Rate");
		lblInterestRate.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInterestRate = new GridBagConstraints();
		gbc_lblInterestRate.anchor = GridBagConstraints.WEST;
		gbc_lblInterestRate.insets = new Insets(0, 0, 0, 5);
		gbc_lblInterestRate.gridx = 1;
		gbc_lblInterestRate.gridy = 1;
		loanPanel.add(lblInterestRate, gbc_lblInterestRate);
		
		spInterestRate = new PercentSpinner();
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.insets = new Insets(0, 0, 0, 5);
		gbc_spinner_1.gridx = 3;
		gbc_spinner_1.gridy = 1;
		loanPanel.add(spInterestRate, gbc_spinner_1);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setPreferredSize(new Dimension(5, 350));
		tabbedPane.setFont(new Font("Calibri", Font.PLAIN, 14));
		add(tabbedPane);
		
		JPanel preDevFundTab = new JPanel();
		tabbedPane.addTab("Pre-Development", null, preDevFundTab, null);
		
		JPanel preDevPanel = new JPanel();
		preDevPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Sources", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		preDevFundTab.add(preDevPanel);
		GridBagLayout gbl_preDevPanel = new GridBagLayout();
		gbl_preDevPanel.columnWidths = new int[] {30, 30, 30, 0, 30};
		gbl_preDevPanel.rowHeights = new int[] {30, 30, 30};
		gbl_preDevPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE, 0.0, 1.0};
		gbl_preDevPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		preDevPanel.setLayout(gbl_preDevPanel);
		
		JLabel lblEquity1 = new JLabel("Equity");
		lblEquity1.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEquity1 = new GridBagConstraints();
		gbc_lblEquity1.anchor = GridBagConstraints.WEST;
		gbc_lblEquity1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquity1.gridx = 1;
		gbc_lblEquity1.gridy = 0;
		preDevPanel.add(lblEquity1, gbc_lblEquity1);
		
		tfEquity1 = new MoneyField();
		tfEquity1.setHorizontalAlignment(SwingConstants.RIGHT);
		tfEquity1.setEditable(false);
		GridBagConstraints gbc_tfEquity1 = new GridBagConstraints();
		gbc_tfEquity1.insets = new Insets(0, 0, 5, 0);
		gbc_tfEquity1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEquity1.gridx = 3;
		gbc_tfEquity1.gridy = 0;
		preDevPanel.add(tfEquity1, gbc_tfEquity1);
		tfEquity1.setColumns(10);
		
		JLabel lblDebt1 = new JLabel("Debt");
		lblDebt1.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDebt1 = new GridBagConstraints();
		gbc_lblDebt1.anchor = GridBagConstraints.WEST;
		gbc_lblDebt1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebt1.gridx = 1;
		gbc_lblDebt1.gridy = 1;
		preDevPanel.add(lblDebt1, gbc_lblDebt1);
		
		tfDebt1 = new MoneyField();
		tfDebt1.setHorizontalAlignment(SwingConstants.RIGHT);
		tfDebt1.setEditable(false);
		tfDebt1.setColumns(10);
		GridBagConstraints gbc_tfDebt1 = new GridBagConstraints();
		gbc_tfDebt1.insets = new Insets(0, 0, 5, 0);
		gbc_tfDebt1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDebt1.gridx = 3;
		gbc_tfDebt1.gridy = 1;
		preDevPanel.add(tfDebt1, gbc_tfDebt1);
		
		JLabel lblNoi1 = new JLabel("NOI");
		lblNoi1.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNoi1 = new GridBagConstraints();
		gbc_lblNoi1.anchor = GridBagConstraints.WEST;
		gbc_lblNoi1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNoi1.gridx = 1;
		gbc_lblNoi1.gridy = 2;
		preDevPanel.add(lblNoi1, gbc_lblNoi1);
		
		tfNoi1 = new MoneyField();
		tfNoi1.setHorizontalAlignment(SwingConstants.RIGHT);
		tfNoi1.setEditable(false);
		tfNoi1.setColumns(10);
		GridBagConstraints gbc_tfNoi1 = new GridBagConstraints();
		gbc_tfNoi1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNoi1.gridx = 3;
		gbc_tfNoi1.gridy = 2;
		preDevPanel.add(tfNoi1, gbc_tfNoi1);
		
		JPanel devFundingTab = new JPanel();
		tabbedPane.addTab("Development", null, devFundingTab, null);
		
		JPanel devFundingPanel = new JPanel();
		devFundingPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Sources", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		devFundingTab.add(devFundingPanel);
		GridBagLayout gbl_devFundingPanel = new GridBagLayout();
		gbl_devFundingPanel.columnWidths = new int[] {30, 30, 30, 0, 30};
		gbl_devFundingPanel.rowHeights = new int[] {30, 30, 30};
		gbl_devFundingPanel.columnWeights = new double[]{0.0, 4.9E-324, 0.0, 1.0, Double.MIN_VALUE};
		gbl_devFundingPanel.rowWeights = new double[]{0.0, 4.9E-324, 0.0};
		devFundingPanel.setLayout(gbl_devFundingPanel);
		
		JLabel lblEquity2 = new JLabel("Equity");
		lblEquity2.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEquity2 = new GridBagConstraints();
		gbc_lblEquity2.anchor = GridBagConstraints.WEST;
		gbc_lblEquity2.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquity2.gridx = 1;
		gbc_lblEquity2.gridy = 0;
		devFundingPanel.add(lblEquity2, gbc_lblEquity2);
		
		tfEquity2 = new MoneyField();
		tfEquity2.setHorizontalAlignment(SwingConstants.RIGHT);
		tfEquity2.setEditable(false);
		tfEquity2.setColumns(10);
		GridBagConstraints gbc_tfEquity2 = new GridBagConstraints();
		gbc_tfEquity2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEquity2.insets = new Insets(0, 0, 5, 0);
		gbc_tfEquity2.gridx = 3;
		gbc_tfEquity2.gridy = 0;
		devFundingPanel.add(tfEquity2, gbc_tfEquity2);
		
		JLabel lblDebt2 = new JLabel("Debt");
		lblDebt2.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDebt2 = new GridBagConstraints();
		gbc_lblDebt2.anchor = GridBagConstraints.WEST;
		gbc_lblDebt2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebt2.gridx = 1;
		gbc_lblDebt2.gridy = 1;
		devFundingPanel.add(lblDebt2, gbc_lblDebt2);
		
		tfDebt2 = new MoneyField();
		tfDebt2.setHorizontalAlignment(SwingConstants.RIGHT);
		tfDebt2.setEditable(false);
		tfDebt2.setColumns(10);
		GridBagConstraints gbc_tfDebt2 = new GridBagConstraints();
		gbc_tfDebt2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDebt2.insets = new Insets(0, 0, 5, 0);
		gbc_tfDebt2.gridx = 3;
		gbc_tfDebt2.gridy = 1;
		devFundingPanel.add(tfDebt2, gbc_tfDebt2);
		
		JLabel lblNoi2 = new JLabel("NOI");
		lblNoi2.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNoi2 = new GridBagConstraints();
		gbc_lblNoi2.anchor = GridBagConstraints.WEST;
		gbc_lblNoi2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNoi2.gridx = 1;
		gbc_lblNoi2.gridy = 2;
		devFundingPanel.add(lblNoi2, gbc_lblNoi2);
		
		tfNoi2 = new MoneyField();
		tfNoi2.setHorizontalAlignment(SwingConstants.RIGHT);
		tfNoi2.setEditable(false);
		tfNoi2.setColumns(10);
		GridBagConstraints gbc_tfNoi2 = new GridBagConstraints();
		gbc_tfNoi2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNoi2.gridx = 3;
		gbc_tfNoi2.gridy = 2;
		devFundingPanel.add(tfNoi2, gbc_tfNoi2);
		
		JPanel stabFundTab = new JPanel();
		tabbedPane.addTab("Stabilization", null, stabFundTab, null);
		
		JPanel stabFundPanel = new JPanel();
		stabFundPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Sources", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		stabFundTab.add(stabFundPanel);
		GridBagLayout gbl_stabFundPanel = new GridBagLayout();
		gbl_stabFundPanel.columnWidths = new int[] {30, 30, 30, 0, 30};
		gbl_stabFundPanel.rowHeights = new int[] {30, 30, 30};
		gbl_stabFundPanel.columnWeights = new double[]{0.0, 4.9E-324, 0.0, 1.0, Double.MIN_VALUE};
		gbl_stabFundPanel.rowWeights = new double[]{0.0, 4.9E-324, 0.0};
		stabFundPanel.setLayout(gbl_stabFundPanel);
		
		JLabel lblEquity3 = new JLabel("Equity");
		lblEquity3.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEquity3 = new GridBagConstraints();
		gbc_lblEquity3.anchor = GridBagConstraints.WEST;
		gbc_lblEquity3.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquity3.gridx = 1;
		gbc_lblEquity3.gridy = 0;
		stabFundPanel.add(lblEquity3, gbc_lblEquity3);
		
		tfEquity3 = new MoneyField();
		tfEquity3.setHorizontalAlignment(SwingConstants.RIGHT);
		tfEquity3.setEditable(false);
		tfEquity3.setColumns(10);
		GridBagConstraints gbc_tfEquity3 = new GridBagConstraints();
		gbc_tfEquity3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEquity3.insets = new Insets(0, 0, 5, 0);
		gbc_tfEquity3.gridx = 3;
		gbc_tfEquity3.gridy = 0;
		stabFundPanel.add(tfEquity3, gbc_tfEquity3);
		
		JLabel lblDebt3 = new JLabel("Debt");
		lblDebt3.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDebt3 = new GridBagConstraints();
		gbc_lblDebt3.anchor = GridBagConstraints.WEST;
		gbc_lblDebt3.insets = new Insets(0, 0, 5, 5);
		gbc_lblDebt3.gridx = 1;
		gbc_lblDebt3.gridy = 1;
		stabFundPanel.add(lblDebt3, gbc_lblDebt3);
		
		tfDebt3 = new MoneyField();
		tfDebt3.setHorizontalAlignment(SwingConstants.RIGHT);
		tfDebt3.setEditable(false);
		tfDebt3.setColumns(10);
		GridBagConstraints gbc_tfDebt3 = new GridBagConstraints();
		gbc_tfDebt3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDebt3.insets = new Insets(0, 0, 5, 0);
		gbc_tfDebt3.gridx = 3;
		gbc_tfDebt3.gridy = 1;
		stabFundPanel.add(tfDebt3, gbc_tfDebt3);
		
		JLabel lblNoi3 = new JLabel("NOI");
		lblNoi3.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNoi3 = new GridBagConstraints();
		gbc_lblNoi3.anchor = GridBagConstraints.WEST;
		gbc_lblNoi3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNoi3.gridx = 1;
		gbc_lblNoi3.gridy = 2;
		stabFundPanel.add(lblNoi3, gbc_lblNoi3);
		
		tfNoi3 = new MoneyField();
		tfNoi3.setHorizontalAlignment(SwingConstants.RIGHT);
		tfNoi3.setEditable(false);
		tfNoi3.setColumns(10);
		GridBagConstraints gbc_tfNoi3 = new GridBagConstraints();
		gbc_tfNoi3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNoi3.gridx = 3;
		gbc_tfNoi3.gridy = 2;
		stabFundPanel.add(tfNoi3, gbc_tfNoi3);

	}

	public void populate() {
		ArrayList<Double> funding = controller.funding.getFunding(0);
		MoneyField[] fields = {tfNoi1, tfEquity1, tfDebt1,
			tfNoi2, tfEquity2, tfDebt2,
			tfNoi3, tfEquity3, tfDebt3,
		};
		for (int i = 0; i<fields.length; i++){
			fields[i].setValue(funding.get(i));
		}
		spInterestRate.setValue(controller.funding.getInterestRate());
		spLTC.setValue(controller.funding.getLTC());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getSource()==spInterestRate){
			controller.funding.setIterestRate((double) spInterestRate.getValue());
		}else if(evt.getSource()==spLTC){
			controller.funding.setLTC((double) spLTC.getValue());
		}
		
	}

}
