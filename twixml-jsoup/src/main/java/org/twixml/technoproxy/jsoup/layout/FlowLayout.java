package org.twixml.technoproxy.jsoup.layout;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;

public class FlowLayout extends LayoutManager {

    /**
     * This value indicates that each row of components should be
     * left-justified.
     */
    public static final int LEFT   = 0;

    /**
     * This value indicates that each row of components should be centered.
     */
    public static final int CENTER = 1;

    /**
     * This value indicates that each row of components should be
     * right-justified.
     */
    public static final int RIGHT  = 2;

    private int             align;
    private int             hgap;
    private int             vgap;

    public FlowLayout () {

    }

    public FlowLayout (final String align1) {
        this.align = Integer.parseInt (align1);
    }

    public FlowLayout (final String align1, final String hgap1,
            final String vgap1) {
        this.align = Integer.parseInt (align1);
        this.hgap = Integer.parseInt (hgap1);
        this.vgap = Integer.parseInt (vgap1);
    }

    @Override
    public void addConstraintedElement (final Element parent,
            final Element component) {
        Element target = null;
        if ( (this.align == FlowLayout.LEFT)
                && (parent.getElementsByClass ("LEFT").size () == 1)) {
            target = parent.getElementsByClass ("LEFT").first ();
        } else if ( (this.align == FlowLayout.CENTER)
                && (parent.getElementsByClass ("CENTER").size () == 1)) {
            target = parent.getElementsByClass ("CENTER").first ();
        } else if ( (this.align == FlowLayout.RIGHT)
                && (parent.getElementsByClass ("RIGHT").size () == 1)) {
            target = parent.getElementsByClass ("RIGHT").first ();
        } else {
            target = parent;
        }
        if (target != null){
          target.appendChild (component);
          if (target.attr ("style") != null && target.attr ("style").contains ("width")){
              String s = target.attr ("style");
              String s2 = target.attr ("style");
              Matcher m = Pattern.compile ("width\\s*:\\s*([0-9]+)px\\s;").matcher (s);
              if (m.find ()){
                  int width = Integer.parseInt (m.group (1));
                  width /= 3;
                  s2 = s.substring (0, m.start (1)) + width + s.substring (m.end (1));
              }
              target.attr ("style", s2);
          }
        }

    }

    @Override
    public void apply (final Element e, final Element leaf) {
        super.apply (e, leaf);
        final List<String> regions = Arrays.<String> asList ("LEFT", "CENTER",
                "RIGHT");
        final List<String> aligns = Arrays.<String> asList ("text-left",
                "text-center", "text-right");
        final List<String> sizes = Arrays.<String> asList ("col-md-4",
                "col-md-4 col-md-offset-4", "col-md-offset-8 col-md-4");
        for (int i = 0 ; i < regions.size () ; i++) {
            leaf.append ("<div class=\"" + aligns.get (i) + " " + sizes.get (i)
                    + " " + regions.get (i) + "\"></div>");
        }
    }

    public int getAlign () {
        return this.align;
    }

    public int getHgap () {
        return this.hgap;
    }

    public int getVgap () {
        return this.vgap;
    }

}
