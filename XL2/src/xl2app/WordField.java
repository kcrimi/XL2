package xl2app;

import java.awt.event.FocusEvent;

import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class WordField extends JFormattedTextField{
	public WordField(){
		super("");
	}
	@Override
	protected void processFocusEvent(FocusEvent e) {
		super.processFocusEvent(e);
		if (e.getID() == FocusEvent.FOCUS_GAINED)
        {
        	this.selectAll();
        }
	}

}
