package fr.everwin.open.api.model.quotes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.everwin.open.api.model.core.MultiCurrencyValue;

/**
 * Quote line multicurrency value class
 * @author everwin-team
 */
@XmlRootElement(name = "quoteline-multi-currency")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuoteLineMultiCurrencyValue extends MultiCurrencyValue {

}