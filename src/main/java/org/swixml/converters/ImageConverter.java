/*--
 $Id: ImageConverter.java,v 1.1 2004/03/01 07:56:00 wolfpaulus Exp $

 Copyright (C) 2003-2007 Wolf Paulus.
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:

 1. Redistributions of source code must retain the above copyright
 notice, this list of conditions, and the following disclaimer.

 2. Redistributions in binary form must reproduce the above copyright
 notice, this list of conditions, and the disclaimer that follows
 these conditions in the documentation and/or other materials provided
 with the distribution.

 3. The end-user documentation included with the redistribution,
 if any, must include the following acknowledgment:
        "This product includes software developed by the
         SWIXML Project (http://www.swixml.org/)."
 Alternately, this acknowledgment may appear in the software itself,
 if and wherever such third-party acknowledgments normally appear.

 4. The name "Swixml" must not be used to endorse or promote products
 derived from this software without prior written permission. For
 written permission, please contact <info_AT_swixml_DOT_org>

 5. Products derived from this software may not be called "Swixml",
 nor may "Swixml" appear in their name, without prior written
 permission from the Swixml Project Management.

 THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED.  IN NO EVENT SHALL THE SWIXML PROJECT OR ITS
 CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 SUCH DAMAGE.
 ====================================================================

 This software consists of voluntary contributions made by many
 individuals on behalf of the Swixml Project and was originally
 created by Wolf Paulus <wolf_AT_swixml_DOT_org>. For more information
 on the Swixml Project, please see <http://www.swixml.org/>.
 */

package org.swixml.converters;

import org.swixml.Attribute;
import org.swixml.Converter;
import org.swixml.Localizer;
import org.swixml.technoproxy.CustomCodeProxy;

/**
 * A Converter that turns a Strings in the form of a filename into an Image
 * objects.
 * 
 * @author <a href="mailto:wolf@paulus.com">Wolf Paulus</a>
 * @version $Revision: 1.1 $
 * @see java.awt.Dimension
 * @see org.swixml.ConverterLibrary
 */
public class ImageConverter implements Converter {


    /**
     * Converts a String into an ImageIcon through a Resource lookup
     * 
     * @param type
     *            <code>Class</code> not used
     * @param attr
     *            <code>Attribute</code> attribute provides the value to be
     *            converted
     * @param localizer
     *            <code>Localizer</code> allow the use of resource lookups
     * @return <code>Object</code> - an <code>ImageIcon</code>
     */
    @Override
    public Object convert (final Class<?> type, final Attribute attr,
            Localizer localizer) {
        return CustomCodeProxy.doProxy (this, type, attr, localizer);
    }

    /**
     * A <code>Converters</code> conversTo method informs about the Class<?>
     * type the converter is returning when its <code>convert</code> method is
     * called
     * 
     * @return <code>Class</code> - the Class<?> the converter is returning when
     *         its convert method is called
     */
    @Override
    public Class<?> convertsTo () {
        return CustomCodeProxy.getTypeAnalyser ().getCompatibleClass ("Image");
    }
}
