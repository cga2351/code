package org.simpleframework.xml.stream;

class OutputAttribute
  implements OutputNode
{
  private String name;
  private String reference;
  private NamespaceMap scope;
  private OutputNode source;
  private String value;

  public OutputAttribute(OutputNode paramOutputNode, String paramString1, String paramString2)
  {
    this.scope = paramOutputNode.getNamespaces();
    this.source = paramOutputNode;
    this.value = paramString2;
    this.name = paramString1;
  }

  public void commit()
  {
  }

  public NodeMap<OutputNode> getAttributes()
  {
    return new OutputNodeMap(this);
  }

  public OutputNode getChild(String paramString)
  {
    return null;
  }

  public String getComment()
  {
    return null;
  }

  public Mode getMode()
  {
    return Mode.INHERIT;
  }

  public String getName()
  {
    return this.name;
  }

  public NamespaceMap getNamespaces()
  {
    return this.scope;
  }

  public OutputNode getParent()
  {
    return this.source;
  }

  public String getPrefix()
  {
    return this.scope.getPrefix(this.reference);
  }

  public String getPrefix(boolean paramBoolean)
  {
    return this.scope.getPrefix(this.reference);
  }

  public String getReference()
  {
    return this.reference;
  }

  public String getValue()
  {
    return this.value;
  }

  public boolean isCommitted()
  {
    return true;
  }

  public boolean isRoot()
  {
    return false;
  }

  public void remove()
  {
  }

  public OutputNode setAttribute(String paramString1, String paramString2)
  {
    return null;
  }

  public void setComment(String paramString)
  {
  }

  public void setData(boolean paramBoolean)
  {
  }

  public void setMode(Mode paramMode)
  {
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setReference(String paramString)
  {
    this.reference = paramString;
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.name;
    arrayOfObject[1] = this.value;
    return String.format("attribute %s='%s'", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.OutputAttribute
 * JD-Core Version:    0.6.2
 */