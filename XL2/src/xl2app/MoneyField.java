package xl2app;

import java.awt.event.FocusEvent;
import java.text.DecimalFormat;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

@SuppressWarnings("serial")
public class MoneyField extends JFormattedTextField {
	public  MoneyField(){
		super();
		this.setValue(0);
		
		NumberFormatter defaultFormatter = new NumberFormatter(new DecimalFormat("#.##"));
		NumberFormatter displayFormatter = new NumberFormatter(new DecimalFormat("$ #,###.##"));
		NumberFormatter editFormatter = new NumberFormatter(new DecimalFormat("#.##"));
		
		editFormatter.setMinimum(0.0);
		
		defaultFormatter.setValueClass(Double.class);
		displayFormatter.setValueClass(Double.class);
		editFormatter.setValueClass(Double.class);
		
		DefaultFormatterFactory moneyFactory = new DefaultFormatterFactory(defaultFormatter,displayFormatter,editFormatter);
		this.setFormatterFactory(moneyFactory);
	}

	@Override
	protected void processFocusEvent(FocusEvent e)
    {
        super.processFocusEvent(e);
        if (e.getID() == FocusEvent.FOCUS_GAINED)
        {
        	this.selectAll();
        }
    }
}
