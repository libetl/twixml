package org.swixml.technoproxy;

public class Platform {

    public static String NAME = (System.getProperty ("swixml.platform") == null ?
            "swing" : System.getProperty ("swixml.platform"));
}
