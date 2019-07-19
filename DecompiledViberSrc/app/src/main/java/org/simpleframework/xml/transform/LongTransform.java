package org.simpleframework.xml.transform;

class LongTransform
  implements Transform<Long>
{
  public Long read(String paramString)
  {
    return Long.valueOf(paramString);
  }

  public String write(Long paramLong)
  {
    return paramLong.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.LongTransform
 * JD-Core Version:    0.6.2
 */