package org.twixml.technoproxy.jsoup;

import java.util.EventListener;

public abstract class ActionListener implements EventListener {

    private boolean b;

    /**
     * Invoked when an action occurs.
     */
    public abstract void actionPerformed (ActionEvent e);

    @Override
    public String toString () {
        StringBuffer bodySB = ActionListenerJSBodies.bodies.get (this
                .getClass ().getName ());
        String body = (bodySB != null ? bodySB.toString () : "");
        return "function " + this.getClass ().getName () + " (e) {"
                + (b ? body : "") + "}";
    }

    public void setEnabled (boolean enabled) {
        this.b = enabled;
    }

    public void windowClosing (WindowEvent e) {

    }

}
