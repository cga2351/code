package org.simpleframework.xml.transform;

class ShortTransform
  implements Transform<Short>
{
  public Short read(String paramString)
  {
    return Short.valueOf(paramString);
  }

  public String write(Short paramShort)
  {
    return paramShort.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.ShortTransform
 * JD-Core Version:    0.6.2
 */