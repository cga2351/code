package org.simpleframework.xml.transform;

import java.math.BigInteger;

class BigIntegerTransform
  implements Transform<BigInteger>
{
  public BigInteger read(String paramString)
  {
    return new BigInteger(paramString);
  }

  public String write(BigInteger paramBigInteger)
  {
    return paramBigInteger.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.BigIntegerTransform
 * JD-Core Version:    0.6.2
 */