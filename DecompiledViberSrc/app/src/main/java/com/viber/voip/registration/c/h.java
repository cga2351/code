package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;

public abstract class h extends j
{

  @Element(name="DeviceKey", required=false)
  protected String b;

  @Element(name="RUrl", required=false)
  protected String c;

  @Element(name="RToken", required=false)
  protected String d;

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.h
 * JD-Core Version:    0.6.2
 */