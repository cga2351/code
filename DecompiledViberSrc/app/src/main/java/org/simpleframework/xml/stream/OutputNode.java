package org.simpleframework.xml.stream;

public abstract interface OutputNode extends Node
{
  public abstract void commit()
    throws Exception;

  public abstract NodeMap<OutputNode> getAttributes();

  public abstract OutputNode getChild(String paramString)
    throws Exception;

  public abstract String getComment();

  public abstract Mode getMode();

  public abstract NamespaceMap getNamespaces();

  public abstract OutputNode getParent();

  public abstract String getPrefix();

  public abstract String getPrefix(boolean paramBoolean);

  public abstract String getReference();

  public abstract boolean isCommitted();

  public abstract boolean isRoot();

  public abstract void remove()
    throws Exception;

  public abstract OutputNode setAttribute(String paramString1, String paramString2);

  public abstract void setComment(String paramString);

  public abstract void setData(boolean paramBoolean);

  public abstract void setMode(Mode paramMode);

  public abstract void setName(String paramString);

  public abstract void setReference(String paramString);

  public abstract void setValue(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.OutputNode
 * JD-Core Version:    0.6.2
 */