package org.simpleframework.xml.stream;

import java.util.ArrayList;

abstract class EventElement extends ArrayList<Attribute>
  implements EventNode
{
  public int getLine()
  {
    return -1;
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
    return true;
  }

  public boolean isText()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.EventElement
 * JD-Core Version:    0.6.2
 */