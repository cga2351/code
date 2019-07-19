package org.simpleframework.xml.transform;

import java.util.concurrent.atomic.AtomicLong;

class AtomicLongTransform
  implements Transform<AtomicLong>
{
  public AtomicLong read(String paramString)
  {
    return new AtomicLong(Long.valueOf(paramString).longValue());
  }

  public String write(AtomicLong paramAtomicLong)
  {
    return paramAtomicLong.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.AtomicLongTransform
 * JD-Core Version:    0.6.2
 */