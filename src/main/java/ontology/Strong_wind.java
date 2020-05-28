package ontology;

import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Strong_wind <br>
 * @version generated on Tue May 26 21:59:27 CEST 2020 by Michał Barczyk
 */

public interface Strong_wind extends Weather {

    /* ***************************************************
     * Property http://webprotege.stanford.edu/weather_is
     */
     
    /**
     * Gets all property values for the weather_is property.<p>
     * 
     * @returns a collection of values for the weather_is property.
     */
    Collection<? extends Shower> getWeather_is();

    /**
     * Checks if the class has a weather_is property value.<p>
     * 
     * @return true if there is a weather_is property value.
     */
    boolean hasWeather_is();

    /**
     * Adds a weather_is property value.<p>
     * 
     * @param newWeather_is the weather_is property value to be added
     */
    void addWeather_is(Shower newWeather_is);

    /**
     * Removes a weather_is property value.<p>
     * 
     * @param oldWeather_is the weather_is property value to be removed.
     */
    void removeWeather_is(Shower oldWeather_is);


    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
