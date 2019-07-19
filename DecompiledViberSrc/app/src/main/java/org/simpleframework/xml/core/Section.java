package org.simpleframework.xml.core;

abstract interface Section extends Iterable<String>
{
  public abstract String getAttribute(String paramString)
    throws Exception;

  public abstract LabelMap getAttributes()
    throws Exception;

  public abstract Label getElement(String paramString)
    throws Exception;

  public abstract LabelMap getElements()
    throws Exception;

  public abstract String getName();

  public abstract String getPath(String paramString)
    throws Exception;

  public abstract String getPrefix();

  public abstract Section getSection(String paramString)
    throws Exception;

  public abstract Label getText()
    throws Exception;

  public abstract boolean isSection(String paramString)
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Section
 * JD-Core Version:    0.6.2
 */