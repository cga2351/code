package org.simpleframework.xml.stream;

import java.util.Iterator;

abstract class EventToken
  implements EventNode
{
  public int getLine()
  {
    return -1;
  }

  public String getName()
  {
    return null;
  }

  public String getPrefix()
  {
    return null;
  }

  public String getReference()
  {
    return null;
  }

  public Object getSource()
  {
    return null;
  }

  public String getValue()
  {
    return null;
  }

  public boolean isEnd()
  {
    return false;
  }

  public boolean isStart()
  {
    return false;
  }

  public boolean isText()
  {
    return false;
  }

  public Iterator<Attribute> iterator()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.EventToken
 * JD-Core Version:    0.6.2
 */