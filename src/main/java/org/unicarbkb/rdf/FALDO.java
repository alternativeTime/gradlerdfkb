package org.unicarbkb.rdf;

import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.apache.jena.reasoner.ReasonerException;


public class FALDO {

    protected static final String uri = "http://biohackathon.org/resource/faldo";


    // Return URI for vocabulary elements public static String getURI()
    public static String getURI() {
        return uri;
    }

    // Define the property labels and objects
    static final String nexactPosition = "ExactPosition";
    public static Property ExactPosition = null;

    static final String nlocation = "Location";
    public static Property Location = null;

    static final String nposition = "position";
    public static Property position = null;


    static {
        try {
            // Instantiate the properties
            ExactPosition = new PropertyImpl(uri, nexactPosition);
            Location = new PropertyImpl(uri, nlocation);
            position = new PropertyImpl(uri, nposition);
        } catch (ReasonerException e) {
            //ErrorManager.("POSTCON", 1, e);
        }
    }
}
