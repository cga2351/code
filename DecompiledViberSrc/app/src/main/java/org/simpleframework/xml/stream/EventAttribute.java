package org.simpleframework.xml.stream;

abstract class EventAttribute
  implements Attribute
{
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

  public boolean isReserved()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.EventAttribute
 * JD-Core Version:    0.6.2
 */