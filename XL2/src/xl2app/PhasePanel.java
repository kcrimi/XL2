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
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PhasePanel extends JPanel implements PropertyChangeListener{
	ProjectController controller;
	WordField tfPhase1;
	WordField tfPhase2;
	WordField tfPhase3;

	/**
	 * Create the panel.
	 */
	public PhasePanel(ProjectController c) {
		controller = c;
		setBorder(null);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Phase Names", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {30, 0, 30, 264, 20};
		gbl_panel.rowHeights = new int[] {30, 30, 30};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblPhase1 = new JLabel("Phase 1");
		lblPhase1.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPhase1 = new GridBagConstraints();
		gbc_lblPhase1.anchor = GridBagConstraints.EAST;
		gbc_lblPhase1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhase1.gridx = 1;
		gbc_lblPhase1.gridy = 0;
		panel.add(lblPhase1, gbc_lblPhase1);
		
		tfPhase1 = new WordField();
		tfPhase1.addPropertyChangeListener("value", this);
		GridBagConstraints gbc_tfPhase1 = new GridBagConstraints();
		gbc_tfPhase1.insets = new Insets(0, 0, 5, 0);
		gbc_tfPhase1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPhase1.gridx = 3;
		gbc_tfPhase1.gridy = 0;
		panel.add(tfPhase1, gbc_tfPhase1);
		tfPhase1.setColumns(10);
		
		JLabel lblPhase2 = new JLabel("Phase 2");
		lblPhase2.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPhase2 = new GridBagConstraints();
		gbc_lblPhase2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhase2.gridx = 1;
		gbc_lblPhase2.gridy = 1;
		panel.add(lblPhase2, gbc_lblPhase2);
		
		tfPhase2 = new WordField();
		tfPhase2.addPropertyChangeListener("value", this);
		tfPhase2.setColumns(10);
		GridBagConstraints gbc_tfPhase2 = new GridBagConstraints();
		gbc_tfPhase2.insets = new Insets(0, 0, 5, 0);
		gbc_tfPhase2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPhase2.gridx = 3;
		gbc_tfPhase2.gridy = 1;
		panel.add(tfPhase2, gbc_tfPhase2);
		
		JLabel lblPhase3 = new JLabel("Phase 3");
		lblPhase3.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPhase3 = new GridBagConstraints();
		gbc_lblPhase3.insets = new Insets(0, 0, 0, 5);
		gbc_lblPhase3.gridx = 1;
		gbc_lblPhase3.gridy = 2;
		panel.add(lblPhase3, gbc_lblPhase3);
		
		tfPhase3 = new WordField();
		tfPhase3.addPropertyChangeListener("value", this);
		tfPhase3.setColumns(10);
		GridBagConstraints gbc_tfPhase3 = new GridBagConstraints();
		gbc_tfPhase3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPhase3.gridx = 3;
		gbc_tfPhase3.gridy = 2;
		panel.add(tfPhase3, gbc_tfPhase3);

	}

	public void populate() {
		tfPhase1.setValue(controller.phase.getPhaseName(1));
		tfPhase2.setValue(controller.phase.getPhaseName(2));
		tfPhase3.setValue(controller.phase.getPhaseName(3));
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == tfPhase1){
			controller.phase.setPhaseName(1,(String) tfPhase1.getValue());
			controller.appFrame.fundingPanel.tabbedPane.setTitleAt(0, (String) tfPhase1.getValue());
		}else if(evt.getSource() == tfPhase2){
			controller.phase.setPhaseName(2, (String) tfPhase2.getValue());
			controller.appFrame.fundingPanel.tabbedPane.setTitleAt(1, (String) tfPhase2.getValue());
		}else if(evt.getSource() == tfPhase3){
			controller.phase.setPhaseName(3, (String) tfPhase3.getValue());
			controller.appFrame.fundingPanel.tabbedPane.setTitleAt(2, (String) tfPhase3.getValue());
		}
	
	}

}
