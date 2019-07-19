package org.simpleframework.xml.stream;

abstract interface EventNode extends Iterable<Attribute>
{
  public abstract int getLine();

  public abstract String getName();

  public abstract String getPrefix();

  public abstract String getReference();

  public abstract Object getSource();

  public abstract String getValue();

  public abstract boolean isEnd();

  public abstract boolean isStart();

  public abstract boolean isText();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.EventNode
 * JD-Core Version:    0.6.2
 */