package xl2app;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class RevenuePanel extends JPanel implements PropertyChangeListener
{
	ProjectController controller;
	MoneyField tfYear1;
	MoneyField tfYear2;
	PercentSpinner spHotelNoi;
	
	public RevenuePanel(ProjectController c) {
		controller = c;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {254};
		gbl_panel.rowHeights = new int[] {82, 52};
		gbl_panel.columnWeights = new double[]{0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JPanel noiPanel = new JPanel();
		noiPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "NOI", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_noiPanel = new GridBagConstraints();
		gbc_noiPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_noiPanel.anchor = GridBagConstraints.NORTH;
		gbc_noiPanel.insets = new Insets(0, 0, 5, 5);
		gbc_noiPanel.gridx = 0;
		gbc_noiPanel.gridy = 0;
		panel.add(noiPanel, gbc_noiPanel);
		GridBagLayout gbl_noiPanel = new GridBagLayout();
		gbl_noiPanel.columnWidths = new int[] {30, 30, 30, 0, 30};
		gbl_noiPanel.rowHeights = new int[] {30, 30};
		gbl_noiPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE, 1.0};
		gbl_noiPanel.rowWeights = new double[]{0.0, 0.0};
		noiPanel.setLayout(gbl_noiPanel);
		
		JLabel lblYear1 = new JLabel("Year 1");
		lblYear1.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblYear1 = new GridBagConstraints();
		gbc_lblYear1.insets = new Insets(0, 0, 5, 5);
		gbc_lblYear1.gridx = 1;
		gbc_lblYear1.gridy = 0;
		noiPanel.add(lblYear1, gbc_lblYear1);
		
		tfYear1 = new MoneyField();
		tfYear1.addPropertyChangeListener("value", this);
		tfYear1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_tfYear1 = new GridBagConstraints();
		gbc_tfYear1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfYear1.insets = new Insets(0, 0, 5, 5);
		gbc_tfYear1.gridx = 3;
		gbc_tfYear1.gridy = 0;
		noiPanel.add(tfYear1, gbc_tfYear1);
		tfYear1.setColumns(10);
		
		JLabel lblYear2 = new JLabel("Year 2");
		lblYear2.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblYear2 = new GridBagConstraints();
		gbc_lblYear2.insets = new Insets(0, 0, 5, 5);
		gbc_lblYear2.gridx = 1;
		gbc_lblYear2.gridy = 1;
		noiPanel.add(lblYear2, gbc_lblYear2);
		
		tfYear2 = new MoneyField();
		tfYear2.addPropertyChangeListener("value", this);
		
		tfYear2.setHorizontalAlignment(SwingConstants.RIGHT);
		tfYear2.setColumns(10);
		GridBagConstraints gbc_tfYear2 = new GridBagConstraints();
		gbc_tfYear2.insets = new Insets(0, 0, 5, 5);
		gbc_tfYear2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfYear2.gridx = 3;
		gbc_tfYear2.gridy = 1;
		noiPanel.add(tfYear2, gbc_tfYear2);
		
		JPanel capRatePanel = new JPanel();
		capRatePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Cap Rate", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_capRatePanel = new GridBagConstraints();
		gbc_capRatePanel.insets = new Insets(0, 0, 0, 5);
		gbc_capRatePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_capRatePanel.anchor = GridBagConstraints.NORTH;
		gbc_capRatePanel.gridx = 0;
		gbc_capRatePanel.gridy = 1;
		panel.add(capRatePanel, gbc_capRatePanel);
		GridBagLayout gbl_capRatePanel = new GridBagLayout();
		gbl_capRatePanel.columnWidths = new int[] {30, 30, 30, 30, 30};
		gbl_capRatePanel.rowHeights = new int[] {30};
		gbl_capRatePanel.columnWeights = new double[]{0.0, 0.0, 4.9E-324, 0.0, 0.0};
		gbl_capRatePanel.rowWeights = new double[]{0.0};
		capRatePanel.setLayout(gbl_capRatePanel);
		
		JLabel lblHotelNoi = new JLabel("Hotel NOI\r\n");
		lblHotelNoi.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHotelNoi = new GridBagConstraints();
		gbc_lblHotelNoi.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelNoi.gridx = 1;
		gbc_lblHotelNoi.gridy = 0;
		capRatePanel.add(lblHotelNoi, gbc_lblHotelNoi);
		
		spHotelNoi = new PercentSpinner();
		GridBagConstraints gbc_spHotelNoi = new GridBagConstraints();
		gbc_spHotelNoi.anchor = GridBagConstraints.WEST;
		gbc_spHotelNoi.insets = new Insets(0, 0, 5, 5);
		gbc_spHotelNoi.gridx = 3;
		gbc_spHotelNoi.gridy = 0;
		capRatePanel.add(spHotelNoi, gbc_spHotelNoi);
	}
	
	
	public void populate() {
		tfYear1.setValue(controller.revenue.getNOI(1));
		tfYear2.setValue(controller.revenue.getNOI(2));
		spHotelNoi.setValue(controller.revenue.getCap());
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == tfYear1){
			controller.revenue.setNOI(1, (double) tfYear1.getValue());
		}else if(evt.getSource() == tfYear2){
			controller.revenue.setNOI(2, (double) tfYear2.getValue());
		}else if(evt.getSource() == spHotelNoi){
			controller.revenue.setCap((double) spHotelNoi.getValue());
		}
		
	}
}
