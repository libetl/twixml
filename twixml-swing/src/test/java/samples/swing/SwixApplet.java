package samples.swing;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.JApplet;
import javax.swing.JTextField;

import org.twixml.technoproxy.swing.SwingTwiXML;

/**
 * The SwixmlApplet class shows how to use the SwixmlmlEngine to create
 * JApplets. The XML descriptor needs to be referenced with an parameter like
 * this: xml=xml/SwinxmlApplet.xml When ran locally using SUN's AppletViewer,
 * the file needs to be made available here: C:\Temlp\xml\...
 * 
 * @author <a href="mailto:wolf@paulus.com">Wolf Paulus</a>
 * @version $Revision: 1.1 $
 * 
 */

public class SwixApplet extends JApplet {

    /**
	 * 
	 */
    private static final long serialVersionUID = -6405498067196986041L;
    /**
     * JTextField member gets instantiated through Swixml (look for id="tf" in
     * the xml descriptor)
     */
    public JTextField         tf;
    /**
     * Action appends a '#' to the textfields content.
     */
    public AbstractAction     submit           = new AbstractAction () {
                                                   /**
		 * 
		 */
                                                   private static final long serialVersionUID = 6593730401971589010L;

                                                   @Override
                                                   public void actionPerformed (
                                                           final ActionEvent e) {
                                                       SwixApplet.this.tf
                                                               .setText (SwixApplet.this.tf
                                                                       .getText () + '#');
                                                   }
                                               };

    @Override
    public void init () {

        super.init ();
        try {
            String descriptorfile = this.getParameter ("xml");
            if (descriptorfile == null) {
                descriptorfile = "samples/swing/xml/applet.xml";
            }
            new SwingTwiXML (this).insert (new URL ("file://"
                    + new File (this.getCodeBase ().getFile ())
                            .getParentFile ().getParent () + "/src/test/java/"
                    + descriptorfile), this);
            this.setVisible (true);
        } catch (final Exception e) {
            e.printStackTrace ();
        }
    }
}
