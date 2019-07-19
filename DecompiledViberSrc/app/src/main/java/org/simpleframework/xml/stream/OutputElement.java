package org.simpleframework.xml.stream;

class OutputElement
  implements OutputNode
{
  private String comment;
  private Mode mode;
  private String name;
  private OutputNode parent;
  private String reference;
  private NamespaceMap scope;
  private OutputNodeMap table;
  private String value;
  private NodeWriter writer;

  public OutputElement(OutputNode paramOutputNode, NodeWriter paramNodeWriter, String paramString)
  {
    this.scope = new PrefixResolver(paramOutputNode);
    this.table = new OutputNodeMap(this);
    this.mode = Mode.INHERIT;
    this.writer = paramNodeWriter;
    this.parent = paramOutputNode;
    this.name = paramString;
  }

  public void commit()
    throws Exception
  {
    this.writer.commit(this);
  }

  public OutputNodeMap getAttributes()
  {
    return this.table;
  }

  public OutputNode getChild(String paramString)
    throws Exception
  {
    return this.writer.writeElement(this, paramString);
  }

  public String getComment()
  {
    return this.comment;
  }

  public Mode getMode()
  {
    return this.mode;
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
    return this.parent;
  }

  public String getPrefix()
  {
    return getPrefix(true);
  }

  public String getPrefix(boolean paramBoolean)
  {
    String str = this.scope.getPrefix(this.reference);
    if ((paramBoolean) && (str == null))
      str = this.parent.getPrefix();
    return str;
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
    return this.writer.isCommitted(this);
  }

  public boolean isRoot()
  {
    return this.writer.isRoot(this);
  }

  public void remove()
    throws Exception
  {
    this.writer.remove(this);
  }

  public OutputNode setAttribute(String paramString1, String paramString2)
  {
    return this.table.put(paramString1, paramString2);
  }

  public void setComment(String paramString)
  {
    this.comment = paramString;
  }

  public void setData(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mode = Mode.DATA;
      return;
    }
    this.mode = Mode.ESCAPE;
  }

  public void setMode(Mode paramMode)
  {
    this.mode = paramMode;
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
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.name;
    return String.format("element %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.OutputElement
 * JD-Core Version:    0.6.2
 */