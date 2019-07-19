package org.simpleframework.xml.stream;

class InputAttribute
  implements InputNode
{
  private String name;
  private InputNode parent;
  private String prefix;
  private String reference;
  private Object source;
  private String value;

  public InputAttribute(InputNode paramInputNode, String paramString1, String paramString2)
  {
    this.parent = paramInputNode;
    this.value = paramString2;
    this.name = paramString1;
  }

  public InputAttribute(InputNode paramInputNode, Attribute paramAttribute)
  {
    this.reference = paramAttribute.getReference();
    this.prefix = paramAttribute.getPrefix();
    this.source = paramAttribute.getSource();
    this.value = paramAttribute.getValue();
    this.name = paramAttribute.getName();
    this.parent = paramInputNode;
  }

  public InputNode getAttribute(String paramString)
  {
    return null;
  }

  public NodeMap<InputNode> getAttributes()
  {
    return new InputNodeMap(this);
  }

  public String getName()
  {
    return this.name;
  }

  public InputNode getNext()
  {
    return null;
  }

  public InputNode getNext(String paramString)
  {
    return null;
  }

  public InputNode getParent()
  {
    return this.parent;
  }

  public Position getPosition()
  {
    return this.parent.getPosition();
  }

  public String getPrefix()
  {
    return this.prefix;
  }

  public String getReference()
  {
    return this.reference;
  }

  public Object getSource()
  {
    return this.source;
  }

  public String getValue()
  {
    return this.value;
  }

  public boolean isElement()
  {
    return false;
  }

  public boolean isEmpty()
  {
    return false;
  }

  public boolean isRoot()
  {
    return false;
  }

  public void skip()
  {
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
 * Qualified Name:     org.simpleframework.xml.stream.InputAttribute
 * JD-Core Version:    0.6.2
 */