package ontology.impl;

import ontology.*;


import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultKilled <br>
 * @version generated on Tue May 26 21:59:27 CEST 2020 by Michał Barczyk
 */
public class DefaultKilled extends WrappedIndividualImpl implements Killed {

    public DefaultKilled(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://webprotege.stanford.edu/health_consequence_to
     */
     
    public Collection<? extends Living_entity> getHealth_consequence_to() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HEALTH_CONSEQUENCE_TO,
                                               DefaultLiving_entity.class);
    }

    public boolean hasHealth_consequence_to() {
	   return !getHealth_consequence_to().isEmpty();
    }

    public void addHealth_consequence_to(Living_entity newHealth_consequence_to) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HEALTH_CONSEQUENCE_TO,
                                       newHealth_consequence_to);
    }

    public void removeHealth_consequence_to(Living_entity oldHealth_consequence_to) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HEALTH_CONSEQUENCE_TO,
                                          oldHealth_consequence_to);
    }


}
