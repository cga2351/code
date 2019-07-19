package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;

public abstract class j
{

  @Element(name="Status", required=false)
  protected String g;

  @Element(name="ErrorMessage", required=false)
  protected String h;

  public boolean f()
  {
    return "1".equals(this.g);
  }

  public String g()
  {
    return this.g;
  }

  public String h()
  {
    return this.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.j
 * JD-Core Version:    0.6.2
 */