package samples.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.twixml.technoproxy.swing.SwingTwiXML;

public class HelloList extends WindowAdapter {

    /** Makes the class bootable */
    public static void main (final String [] args) throws Exception {
        new HelloList ();
    }

    private JList<?> mList; /* instantiated by twixml when rendering the UI */

    private HelloList () throws Exception {
        ((JFrame) new SwingTwiXML (this)
                .render ("samples/swing/xml/hellolist.xml")).setVisible (true);
        System.out.println (this.mList.getModel ().getSize ());
        this.mList.addListSelectionListener (new ListSelectionListener () {
            @Override
            public void valueChanged (final ListSelectionEvent e) {
                System.out.println (HelloList.this.mList.getSelectedValue ());
            }
        });
    }

    /**
     * Invoked when a window is in the process of being closed. The close
     * operation can be overridden at this point.
     */
    @Override
    public void windowClosing (final WindowEvent e) {
        super.windowClosing (e);
        System.exit (0);
    }

}