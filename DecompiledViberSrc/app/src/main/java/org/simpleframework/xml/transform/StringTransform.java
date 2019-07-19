package org.simpleframework.xml.transform;

class StringTransform
  implements Transform<String>
{
  public String read(String paramString)
  {
    return paramString;
  }

  public String write(String paramString)
  {
    return paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.StringTransform
 * JD-Core Version:    0.6.2
 */