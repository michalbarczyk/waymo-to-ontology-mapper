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
 * Source Class: Lightly_injured <br>
 * @version generated on Tue May 26 21:59:27 CEST 2020 by Michał Barczyk
 */

public interface Lightly_injured extends Health_consequence {

    /* ***************************************************
     * Property http://webprotege.stanford.edu/health_consequence_to
     */
     
    /**
     * Gets all property values for the health_consequence_to property.<p>
     * 
     * @returns a collection of values for the health_consequence_to property.
     */
    Collection<? extends Living_entity> getHealth_consequence_to();

    /**
     * Checks if the class has a health_consequence_to property value.<p>
     * 
     * @return true if there is a health_consequence_to property value.
     */
    boolean hasHealth_consequence_to();

    /**
     * Adds a health_consequence_to property value.<p>
     * 
     * @param newHealth_consequence_to the health_consequence_to property value to be added
     */
    void addHealth_consequence_to(Living_entity newHealth_consequence_to);

    /**
     * Removes a health_consequence_to property value.<p>
     * 
     * @param oldHealth_consequence_to the health_consequence_to property value to be removed.
     */
    void removeHealth_consequence_to(Living_entity oldHealth_consequence_to);


    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
