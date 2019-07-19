package org.simpleframework.xml.transform;

import java.util.Currency;

class CurrencyTransform
  implements Transform<Currency>
{
  public Currency read(String paramString)
  {
    return Currency.getInstance(paramString);
  }

  public String write(Currency paramCurrency)
  {
    return paramCurrency.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.CurrencyTransform
 * JD-Core Version:    0.6.2
 */