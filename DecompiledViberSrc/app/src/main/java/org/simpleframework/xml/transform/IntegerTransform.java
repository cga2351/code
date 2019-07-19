package org.simpleframework.xml.transform;

class IntegerTransform
  implements Transform<Integer>
{
  public Integer read(String paramString)
  {
    return Integer.valueOf(paramString);
  }

  public String write(Integer paramInteger)
  {
    return paramInteger.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.IntegerTransform
 * JD-Core Version:    0.6.2
 */