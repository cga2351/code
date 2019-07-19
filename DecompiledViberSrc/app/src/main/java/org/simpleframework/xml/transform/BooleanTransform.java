package org.simpleframework.xml.transform;

class BooleanTransform
  implements Transform<Boolean>
{
  public Boolean read(String paramString)
  {
    return Boolean.valueOf(paramString);
  }

  public String write(Boolean paramBoolean)
  {
    return paramBoolean.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.BooleanTransform
 * JD-Core Version:    0.6.2
 */