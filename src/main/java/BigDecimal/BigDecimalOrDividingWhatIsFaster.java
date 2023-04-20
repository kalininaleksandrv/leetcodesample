package BigDecimal;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class BigDecimalOrDividingWhatIsFaster {

    public String getCurrencyWithFormat(Double amt, Locale locale) {
        return NumberFormat
                .getCurrencyInstance(locale)
                .format(amt);
    }

    public String exchange (long income, Currency incomeCurrency, Currency outcomeCurrency){
        Integer rate = ExchangeHelper.getRate(incomeCurrency, outcomeCurrency);
        long outcome = income*rate;
        return outcome / 100 + "." + outcome % 100;
    }

    public String exchangeBD (long income, Currency incomeCurrency, Currency outcomeCurrency) {
        BigDecimal amount = BigDecimal.valueOf(income);
        BigDecimal rate = BigDecimal.valueOf(ExchangeHelper.getRateDouble(incomeCurrency, outcomeCurrency));
        return amount.multiply(rate).toPlainString();
    }

    static class ExchangeHelper {
        static Integer getRate(Currency from, Currency to){
            if(from.equals(to)) throw new RuntimeException("currency must be different");
            if(from.equals(Currency.USD) && to.equals(Currency.EUR)) return 95;
            if(from.equals(Currency.EUR) && to.equals(Currency.USD)) return 115;
            else throw new RuntimeException("unable to provide exchange rate");
        }

        static Double getRateDouble(Currency from, Currency to){
            if(from.equals(to)) throw new RuntimeException("currency must be different");
            if(from.equals(Currency.USD) && to.equals(Currency.EUR)) return 0.95;
            if(from.equals(Currency.EUR) && to.equals(Currency.USD)) return 1.15;
            else throw new RuntimeException("unable to provide exchange rate");
        }
    }
}

enum Currency {
    EUR, USD,
}


