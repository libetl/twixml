package samples.swing;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Simple Action to exit a program.
 * 
 * This is intended for usage in twixml xml descriptors and may be instantiated
 * through <code>initclass="ExitAction"</code> for arbitary enclosing
 * {@link javax.swing.AbstractButton} objects.
 */
public class ExitAction extends AbstractAction {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1404305704663546773L;

    @Override
    public void actionPerformed (ActionEvent e) {
        System.exit (0);
    }
}
