/**
 *
 */
package fr.everwin.open.api.model.quotes;


/**
 * Quote line value class
 *
 * @author everwin-team
 */
public class QuoteLineDebitCredit {

    private QuoteLineMultiCurrencyValue amount;
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
