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
 * Source Class: Moral_dilemma <br>
 * @version generated on Tue May 26 21:59:27 CEST 2020 by Michał Barczyk
 */

public interface Moral_dilemma extends WrappedIndividual {

    /* ***************************************************
     * Property http://webprotege.stanford.edu/moral_dilemma_presence
     */
     
    /**
     * Gets all property values for the moral_dilemma_presence property.<p>
     * 
     * @returns a collection of values for the moral_dilemma_presence property.
     */
    Collection<? extends WrappedIndividual> getMoral_dilemma_presence();

    /**
     * Checks if the class has a moral_dilemma_presence property value.<p>
     * 
     * @return true if there is a moral_dilemma_presence property value.
     */
    boolean hasMoral_dilemma_presence();

    /**
     * Adds a moral_dilemma_presence property value.<p>
     * 
     * @param newMoral_dilemma_presence the moral_dilemma_presence property value to be added
     */
    void addMoral_dilemma_presence(WrappedIndividual newMoral_dilemma_presence);

    /**
     * Removes a moral_dilemma_presence property value.<p>
     * 
     * @param oldMoral_dilemma_presence the moral_dilemma_presence property value to be removed.
     */
    void removeMoral_dilemma_presence(WrappedIndividual oldMoral_dilemma_presence);


    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
