package xl2app;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

@SuppressWarnings("serial")
public class PercentSpinner extends JSpinner implements FocusListener{
	
	private JFormattedTextField tfEditor;

	public PercentSpinner(){
		super();
		
		SpinnerModel model = new SpinnerNumberModel(0.00, 0.0, 1.0, 0.001);
		this.setModel(model);
		
		this.setPreferredSize(new Dimension(80,20));
		tfEditor = ((JSpinner.NumberEditor) this.getEditor()).getTextField();
		
		NumberFormatter defaultFormatter = new NumberFormatter(new DecimalFormat("0.0%"));
		NumberFormatter displayFormatter = new NumberFormatter(new DecimalFormat("###.##%"));
		DecimalFormat edit= new DecimalFormat("0.0#");
		edit.setMultiplier(100);
		NumberFormatter editFormatter = new NumberFormatter(edit);
		editFormatter.setMinimum(0.0);
		editFormatter.setMaximum(1.0);
		
		defaultFormatter.setValueClass(Double.class);
		displayFormatter.setValueClass(Double.class);
		editFormatter.setValueClass(Double.class);
		
		DefaultFormatterFactory percentFactory = new DefaultFormatterFactory(defaultFormatter,displayFormatter,editFormatter);
		tfEditor.setFormatterFactory(percentFactory);
		
		tfEditor.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		SwingUtilities.invokeLater(new Runnable(){
			  public void run() { tfEditor.selectAll(); }
			  });
				
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
