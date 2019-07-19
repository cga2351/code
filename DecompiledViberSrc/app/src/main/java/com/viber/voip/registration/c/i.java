package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;

public abstract class i extends j
{

  @Element(name="DeviceKey", required=false)
  protected String a;

  @Element(name="SkipActivation", required=false)
  protected String b;

  @Element(name="PhoneNumber", required=false)
  protected String c;

  @Element(name="canonizedNumber", required=false)
  protected String d;

  @Element(name="mid", required=false)
  protected String e;

  @Element(name="HangupAutoStop", required=false)
  protected String f;

  public boolean a()
  {
    return "1".equals(this.b);
  }

  public String b()
  {
    return this.c;
  }

  public String c()
  {
    return this.d;
  }

  public String d()
  {
    return this.e;
  }

  public boolean e()
  {
    return "1".equals(this.f);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.i
 * JD-Core Version:    0.6.2
 */