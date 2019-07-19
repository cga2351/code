package org.simpleframework.xml.core;

abstract class TemplateParameter
  implements Parameter
{
  public boolean isAttribute()
  {
    return false;
  }

  public boolean isText()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TemplateParameter
 * JD-Core Version:    0.6.2
 */