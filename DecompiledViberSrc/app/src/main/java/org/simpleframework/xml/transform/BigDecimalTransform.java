package org.simpleframework.xml.transform;

import java.math.BigDecimal;

class BigDecimalTransform
  implements Transform<BigDecimal>
{
  public BigDecimal read(String paramString)
  {
    return new BigDecimal(paramString);
  }

  public String write(BigDecimal paramBigDecimal)
  {
    return paramBigDecimal.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.BigDecimalTransform
 * JD-Core Version:    0.6.2
 */