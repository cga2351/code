package org.simpleframework.xml.stream;

class InputPosition
  implements Position
{
  private EventNode source;

  public InputPosition(EventNode paramEventNode)
  {
    this.source = paramEventNode;
  }

  public int getLine()
  {
    return this.source.getLine();
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(getLine());
    return String.format("line %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.InputPosition
 * JD-Core Version:    0.6.2
 */