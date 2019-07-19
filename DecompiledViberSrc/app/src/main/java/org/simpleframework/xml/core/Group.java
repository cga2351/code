package org.simpleframework.xml.core;

abstract interface Group
{
  public abstract LabelMap getElements()
    throws Exception;

  public abstract Label getLabel(Class paramClass);

  public abstract Label getText()
    throws Exception;

  public abstract boolean isInline();

  public abstract boolean isTextList();

  public abstract String toString();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Group
 * JD-Core Version:    0.6.2
 */