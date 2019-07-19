package com.viber.voip.registration.c;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="SetRTokenRequest")
public final class y
{

  @Element(name="UDID", required=false)
  private String a;

  @Element(name="RToken", required=false)
  private String b;

  public y(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public String toString()
  {
    return "SetRTokenRequest{udid='" + this.a + '\'' + ", rToken='" + this.b + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.c.y
 * JD-Core Version:    0.6.2
 */