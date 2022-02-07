/**
 * 
 */
package fr.everwin.open.api.model.quotes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Quote line value class
 * @author everwin-team
 */
@XmlRootElement(name = "quoteline-debit-credit")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuoteLineDebitCredit {

	@XmlElement
	private QuoteLineMultiCurrencyValue amount;


	@XmlElement
	private QuoteLineMultiCurrencyValue total;


	public QuoteLineDebitCredit() {
		amount = new QuoteLineMultiCurrencyValue();
		total = new QuoteLineMultiCurrencyValue();
	}

	public QuoteLineMultiCurrencyValue getAmount() {
		return amount;
	}

	public void setAmount(QuoteLineMultiCurrencyValue amount) {
		this.amount = amount;
	}

	public QuoteLineMultiCurrencyValue getTotal() {
		return total;
	}

	public void setTotal(QuoteLineMultiCurrencyValue total) {
		this.total = total;
	}
}
