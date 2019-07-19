package org.simpleframework.xml.transform;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicIntegerTransform
  implements Transform<AtomicInteger>
{
  public AtomicInteger read(String paramString)
  {
    return new AtomicInteger(Integer.valueOf(paramString).intValue());
  }

  public String write(AtomicInteger paramAtomicInteger)
  {
    return paramAtomicInteger.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.AtomicIntegerTransform
 * JD-Core Version:    0.6.2
 */