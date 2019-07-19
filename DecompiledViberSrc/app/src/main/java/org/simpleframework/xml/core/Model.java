package org.simpleframework.xml.core;

abstract interface Model extends Iterable<String>
{
  public abstract LabelMap getAttributes()
    throws Exception;

  public abstract LabelMap getElements()
    throws Exception;

  public abstract Expression getExpression();

  public abstract int getIndex();

  public abstract ModelMap getModels()
    throws Exception;

  public abstract String getName();

  public abstract String getPrefix();

  public abstract Label getText();

  public abstract boolean isAttribute(String paramString);

  public abstract boolean isComposite();

  public abstract boolean isElement(String paramString);

  public abstract boolean isEmpty();

  public abstract boolean isModel(String paramString);

  public abstract Model lookup(String paramString, int paramInt);

  public abstract Model lookup(Expression paramExpression);

  public abstract Model register(String paramString1, String paramString2, int paramInt)
    throws Exception;

  public abstract void register(Label paramLabel)
    throws Exception;

  public abstract void registerAttribute(String paramString)
    throws Exception;

  public abstract void registerAttribute(Label paramLabel)
    throws Exception;

  public abstract void registerElement(String paramString)
    throws Exception;

  public abstract void registerElement(Label paramLabel)
    throws Exception;

  public abstract void registerText(Label paramLabel)
    throws Exception;

  public abstract void validate(Class paramClass)
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Model
 * JD-Core Version:    0.6.2
 */