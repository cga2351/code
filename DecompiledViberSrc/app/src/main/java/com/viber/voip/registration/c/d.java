package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="ActivateUserResponse")
public final class d extends h
{

  @Element(name="MID", required=false)
  protected String a;

  public String a()
  {
    return this.a;
  }

  public String toString()
  {
    return "ActivateUserResponse{status='" + this.g + '\'' + ", deviceKey='" + this.b + '\'' + ", mid='" + this.a + '\'' + ", errorMessage='" + this.h + '\'' + ", rUrl='" + this.c + '\'' + ", rToken='" + this.d + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.d
 * JD-Core Version:    0.6.2
 */