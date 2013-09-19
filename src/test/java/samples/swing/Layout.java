package samples.swing;

import java.awt.Container;

import org.swixml.SwingEngine;

/**
 * The Layout class shows the use of layout managers
 * 
 * @author <a href="mailto:wolf@paulus.com">Wolf Paulus</a>
 * @version $Revision: 1.1 $
 * 
 * @since swixml (#136)
 */
public class Layout {
	private static final String	DESCRIPTOR	= "xml/funlayout.xml";

	public static void main (String [] args) {
		try {
			new Layout ();
		} catch (final Exception e) {
			System.err.println (e.getMessage ());
		}
	}

	private Layout () throws Exception {
		((Container) new SwingEngine (this).render (Layout.DESCRIPTOR))
		        .setVisible (true);
	}
}