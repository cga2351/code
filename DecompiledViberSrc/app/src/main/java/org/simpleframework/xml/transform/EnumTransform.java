package org.simpleframework.xml.transform;

class EnumTransform
  implements Transform<Enum>
{
  private final Class type;

  public EnumTransform(Class paramClass)
  {
    this.type = paramClass;
  }

  public Enum read(String paramString)
    throws Exception
  {
    return Enum.valueOf(this.type, paramString);
  }

  public String write(Enum paramEnum)
    throws Exception
  {
    return paramEnum.name();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.EnumTransform
 * JD-Core Version:    0.6.2
 */